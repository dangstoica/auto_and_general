package org.autogenral;

import org.autogenral.todo.ToDoItemPersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dan.stoica
 *
 */
@RestController
public class UtilsController
{

	@Autowired
	ToDoItemPersistenceService persistenceService;

	@RequestMapping(value = "/status", method =	{ RequestMethod.POST, RequestMethod.GET }, produces = "application/json; charset=UTF-8")
	public ResponseEntity<StatusResponse> status()
	{
		StatusResponse result = new StatusResponse();
		return new ResponseEntity<StatusResponse>(result, HttpStatus.OK);
	}

}
