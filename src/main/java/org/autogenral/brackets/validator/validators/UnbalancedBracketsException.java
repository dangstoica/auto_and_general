package org.autogenral.brackets.validator.validators;

import org.autogenral.brackets.validator.DataInputException;

/**
 * @author dan.stoica
 *
 */
public class UnbalancedBracketsException extends DataInputException
{
	private static final long serialVersionUID = 1L;
	
	public static final String UNBALANCED_BRACKETS_MSG = "You must balance all open brackets.";

	public UnbalancedBracketsException(String openBrackets, String input)
	{
		super(UNBALANCED_BRACKETS_MSG, openBrackets, input);
	}

}
