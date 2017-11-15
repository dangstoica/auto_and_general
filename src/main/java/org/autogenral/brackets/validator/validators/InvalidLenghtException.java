package org.autogenral.brackets.validator.validators;

import org.autogenral.brackets.validator.DataInputException;

/**
 * @author dan.stoica
 *
 */
public class InvalidLenghtException extends DataInputException
{
	private static final long serialVersionUID = 1L;
	
	public static final String LENGTH_EXCEPTION_MSG = "Must be between 1 and 50 chars long.";

	public InvalidLenghtException(int lenght, String value)
	{
		super(LENGTH_EXCEPTION_MSG, lenght, value);
	}

}
