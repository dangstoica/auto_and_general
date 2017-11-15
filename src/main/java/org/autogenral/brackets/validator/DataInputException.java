package org.autogenral.brackets.validator;

/**
 * @author dan.stoica
 *
 */
public class DataInputException extends Exception
{
	private static final long serialVersionUID = 1L;

	private final String input;

	private final String details;

	public DataInputException(String message, String details, String input)
	{
		super(message);
		this.input = input;
		this.details = details;
	}

	public DataInputException(String message, int lenght, String input)
	{
		super(message);
		this.input = input;
		this.details = String.valueOf(lenght);
	}

	public String getInput()
	{
		return input;
	}

	public String getDetails()
	{
		return details;
	}

	@Override
	public String toString()
	{
		return "DataInputException [input=" + input + ", details=" + details + "]";
	}

}
