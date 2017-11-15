package org.autogenral.brackets.validator.validators;

import org.apache.commons.lang3.StringUtils;
import org.autogenral.brackets.validator.DataInputException;

/**
 * @author dan.stoica
 *
 */
public class InputBracketsSizeValidator extends AbstractBracketsValidator
{

	public InputBracketsSizeValidator(AbstractBracketsValidator next)
	{
		super(next);
	}

	@Override
	protected void isValid(String input) throws DataInputException
	{
		int length = StringUtils.length(input);

		if (1 > length || length > 250)
		{
			throw new InvalidLenghtException(length, input);
		}
	}

}
