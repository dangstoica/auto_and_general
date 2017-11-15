package org.autogenral.brackets.validator.validators;

import org.autogenral.brackets.validator.DataInputException;

/**
 * @author dan.stoica
 *
 */
public class NullValidator extends AbstractBracketsValidator
{

	public NullValidator()
	{
		super(null);
	}

	@Override
	protected void isValid(String input) throws DataInputException
	{
		// Do nothing. Is always valid
	}

}
