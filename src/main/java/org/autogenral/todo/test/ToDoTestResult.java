package org.autogenral.todo.test;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.autogenral.todo.ToDoItem;

/**
 * @author dan.stoica
 *
 */
public class ToDoTestResult
{

	private String input;
	private ToDoItem result;

	public String getInput()
	{
		return input;
	}

	public void setInput(String input)
	{
		this.input = input;
	}

	public ToDoItem getResult()
	{
		return result;
	}

	public void setResult(ToDoItem result)
	{
		this.result = result;
	}

	@Override
	public String toString()
	{
		return new ToStringBuilder(this).append("input", input).append("result", result).toString();
	}

}