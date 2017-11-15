package org.autogenral;

import javax.validation.Valid;

import org.autogenral.brackets.results.Detail;
import org.autogenral.brackets.results.TestResult;
import org.autogenral.brackets.results.ToDoItemValidationError;
import org.autogenral.brackets.validator.BracketsValidatorService;
import org.autogenral.persistence.ItemNotFoundException;
import org.autogenral.todo.ToDoItem;
import org.autogenral.todo.ToDoItemAddRequest;
import org.autogenral.todo.ToDoItemNotFoundError;
import org.autogenral.todo.ToDoItemPersistenceService;
import org.autogenral.todo.ToDoItemUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dan.stoica
 *
 */
@RestController
public class ToDoItemController
{

	private static final String ID_PARAM = "id";

	private static final String TEXT_PARAM = "text";

	private static final String NOT_A_VALID_ITEM_ID_MSG = "Not a Valid item ID";

	private static final String LENGTH_1_TO_50_MSG = "Must be between 1 and 50 chars long.";

	BracketsValidatorService validator = new BracketsValidatorService();

	@Autowired
	ToDoItemPersistenceService persistenceService;

	@RequestMapping(value = "/todo", method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody ToDoItemAddRequest itemRequest)
	{
		if (itemRequest.isValidRequest())
		{
			ToDoItem item = persistenceService.create(itemRequest);
			return new ResponseEntity<ToDoItem>(item, HttpStatus.OK);
		}

		ToDoItemValidationError error = new ToDoItemValidationError();
		error.getDetails().add(new Detail(TEXT_PARAM, itemRequest.getText(), LENGTH_1_TO_50_MSG));
		return new ResponseEntity<TestResult>(error, HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getItem(@PathVariable(ID_PARAM) long itemId)
	{
		try
		{
			if (isValidId(itemId))
			{
				ToDoItem item = persistenceService.find(itemId);
				return new ResponseEntity<ToDoItem>(item, HttpStatus.OK);
			}

			ToDoItemValidationError error = new ToDoItemValidationError("ValidationError");
			error.getDetails().add(new Detail("" + itemId, NOT_A_VALID_ITEM_ID_MSG));
			return new ResponseEntity<ToDoItemValidationError>(error, HttpStatus.BAD_REQUEST);
		}
		catch (ItemNotFoundException e)
		{
			return new ResponseEntity<ToDoItemNotFoundError>(ToDoItemNotFoundError.create(itemId), HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/todo/{id}", method = RequestMethod.PATCH)
	@ResponseBody
	public ResponseEntity<?> updateItem(@PathVariable(ID_PARAM) Long itemId, @Valid @RequestBody ToDoItemUpdateRequest itemUpdateRequest)
	{
		try
		{
			if (!isValidId(itemId))
			{
				ToDoItemValidationError error = ToDoItemValidationError.create(ID_PARAM, NOT_A_VALID_ITEM_ID_MSG, "" + itemId);
				return new ResponseEntity<ToDoItemValidationError>(error, HttpStatus.BAD_REQUEST);
			}
			else if (!itemUpdateRequest.isValidRequest())
			{
				ToDoItemValidationError error = ToDoItemValidationError.create(TEXT_PARAM, itemUpdateRequest.getText(), LENGTH_1_TO_50_MSG);
				return new ResponseEntity<ToDoItemValidationError>(error, HttpStatus.BAD_REQUEST);
			}
			ToDoItem item = persistenceService.update(itemId, itemUpdateRequest);
			return new ResponseEntity<ToDoItem>(item, HttpStatus.OK);

		}
		catch (ItemNotFoundException e)
		{
			return new ResponseEntity<ToDoItemNotFoundError>(ToDoItemNotFoundError.create(itemId), HttpStatus.NOT_FOUND);
		}
	}

	private boolean isValidId(Long id)
	{
		return id != null & id >= 0;
	}

}
