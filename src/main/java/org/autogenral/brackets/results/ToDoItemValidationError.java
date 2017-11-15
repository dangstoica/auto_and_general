package org.autogenral.brackets.results;

import org.autogenral.brackets.validator.DataInputException;

/**
 * @author dan.stoica
 *
 */
public class ToDoItemValidationError extends TestResult
{
	public static final String VALIDATION_ERROR = "ValidationError";

	private ErrorDetails details = new ErrorDetails();

	private String name = "ValidationError";

	public ToDoItemValidationError()
	{
		this(VALIDATION_ERROR);
	}

	public ToDoItemValidationError(String name)
	{
		super();
		this.name = name;
	}

	public static ToDoItemValidationError create(String param, String msg)
	{
		return create(param, msg, null);
	}

	public static ToDoItemValidationError create(String param, String msg, String value)
	{
		ToDoItemValidationError error = new ToDoItemValidationError();
		error.details.add(new Detail(param, value, msg));
		return error;
	}

	public static ToDoItemValidationError create(DataInputException e)
	{
		ToDoItemValidationError error = new ToDoItemValidationError();
		error.addError(e);
		return error;
	}

	public ErrorDetails getDetails()
	{
		return details;
	}

	public void setDetails(ErrorDetails details)
	{
		this.details = details;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void addError(DataInputException ex)
	{
		details.addFromError(ex);
	}

	@Override
	public String toString()
	{
		return "ToDoItemValidationError [details=" + details + ", name=" + name + "]";
	}

}
