/**
 * 
 */
package org.autogenral.todo.test;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author dan.stoica
 *
 */
public class BracersTestResult
{

	private String input;
	private boolean result;
	private boolean expected;
	private boolean isCorrect;

	public String getInput()
	{
		return input;
	}

	public void setInput(String input)
	{
		this.input = input;
	}

	public boolean isResult()
	{
		return result;
	}

	public void setResult(boolean result)
	{
		this.result = result;
	}

	public boolean isExpected()
	{
		return expected;
	}

	public void setExpected(boolean expected)
	{
		this.expected = expected;
	}

	public boolean isIsCorrect()
	{
		return isCorrect;
	}

	public void setIsCorrect(boolean isCorrect)
	{
		this.isCorrect = isCorrect;
	}

	@Override
	public String toString()
	{
		return new ToStringBuilder(this).append("input", input).append("result", result).append("expected", expected).append("isCorrect", isCorrect)
			.toString();
	}
}
