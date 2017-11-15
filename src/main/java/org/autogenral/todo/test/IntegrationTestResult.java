package org.autogenral.todo.test;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author dan.stoica
 *
 */
public class IntegrationTestResult
{
	private List<BracersTestResult> bracers = null;
	private List<ToDoTestResult> todo = null;
	private boolean isCorrect;

	public List<BracersTestResult> getBracers()
	{
		return bracers;
	}

	public void setBracers(List<BracersTestResult> bracers)
	{
		this.bracers = bracers;
	}

	public List<ToDoTestResult> getTodo()
	{
		return todo;
	}

	public void setTodo(List<ToDoTestResult> todo)
	{
		this.todo = todo;
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
		return new ToStringBuilder(this).append("bracers", bracers).append("todo", todo).append("isCorrect", isCorrect).toString();
	}

}