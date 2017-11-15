package org.autogenral.brackets.validator;

import org.autogenral.brackets.results.TestResult;

public class BalanceTestResult extends TestResult
{

	private final Boolean isBalanced;
	private final String input;

	public BalanceTestResult(String input, Boolean isBalanced)
	{
		this.isBalanced = isBalanced;
		this.input = input;
	}

	public Boolean getIsBalanced()
	{
		return isBalanced;
	}

	public String getInput()
	{
		return input;
	}

	@Override
	public String toString()
	{
		return "BalanceTestResult [balanced=" + isBalanced + ", input=" + input + "]";
	}

}
