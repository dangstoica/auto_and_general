package org.autogenral.todo;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author dan.stoica
 *
 */
public class ToDoItemNotFoundDetail
{
	private String message;

	public ToDoItemNotFoundDetail(String message)
	{
		this.message = message;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	@Override
	public String toString()
	{
		return new ToStringBuilder(this).append("message", message).toString();
	}

}
