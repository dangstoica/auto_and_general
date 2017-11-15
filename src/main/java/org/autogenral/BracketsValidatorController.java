package org.autogenral;

import org.autogenral.brackets.results.TestResult;
import org.autogenral.brackets.results.ToDoItemValidationError;
import org.autogenral.brackets.validator.BalanceTestResult;
import org.autogenral.brackets.validator.BracketsValidatorService;
import org.autogenral.brackets.validator.DataInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dan.stoica
 *
 */
@RestController
public class BracketsValidatorController
{

	private static final String INPUT_REQ_PARAM = "input";

	@Autowired
	private BracketsValidatorService validator;

	@RequestMapping("/tasks/validateBrackets")
	public ResponseEntity<TestResult> validateBrackets(@RequestParam(value = INPUT_REQ_PARAM, required = true) String input)
	{
		try
		{
			BalanceTestResult result = validator.validate(input);
			return new ResponseEntity<TestResult>(result, HttpStatus.OK);
		}
		catch (DataInputException e)
		{
			ToDoItemValidationError error = new ToDoItemValidationError();
			error.addError(e);
			return new ResponseEntity<TestResult>(error, HttpStatus.BAD_REQUEST);
		}
	}
}
