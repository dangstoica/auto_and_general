package org.autogenral.brackets.validator;

import org.autogenral.brackets.validator.validators.AbstractBracketsValidator;
import org.autogenral.brackets.validator.validators.BracketsBalanceValidator;
import org.autogenral.brackets.validator.validators.InputBracketsSizeValidator;
import org.autogenral.brackets.validator.validators.NullValidator;
import org.autogenral.brackets.validator.validators.UnbalancedBracketsException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author dan.stoica
 *
 */
@Service
@Scope("singleton")
public class BracketsValidatorService
{
	AbstractBracketsValidator validators = new BracketsBalanceValidator(new InputBracketsSizeValidator(new NullValidator()));

	public BalanceTestResult validate(String input) throws DataInputException
	{
		try
		{
			validators.validate(input);
			return new BalanceTestResult(input, true);
		}
		catch (UnbalancedBracketsException e)
		{
			return new BalanceTestResult(input, false);
		}
	}
}
