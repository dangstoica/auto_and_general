package org.autogenral.brackets.validator.validators;

import org.autogenral.brackets.validator.DataInputException;

/**
 * @author dan.stoica
 *
 */
public abstract class AbstractBracketsValidator
{
	private final AbstractBracketsValidator next;

	public AbstractBracketsValidator(AbstractBracketsValidator next)
	{
		this.next = next;
	}

	public void validate(String input) throws DataInputException
	{
		isValid(input);
		if (next != null)
		{
			next.validate(input);
		}
	}

	protected abstract void isValid(String input) throws DataInputException;
}
