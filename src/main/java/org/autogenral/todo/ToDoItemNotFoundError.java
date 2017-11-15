package org.autogenral.todo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author dan.stoica
 *
 */
public class ToDoItemNotFoundError
{

	private static final String NOT_FOUND_ERROR = "NotFoundError";
	
	private List<ToDoItemNotFoundDetail> details = new ArrayList<>();
	
	private String name = NOT_FOUND_ERROR;

	public List<ToDoItemNotFoundDetail> getDetails()
	{
		return details;
	}

	public void setDetails(List<ToDoItemNotFoundDetail> details)
	{
		this.details = details;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public static ToDoItemNotFoundError create(Long itemId)
	{
		ToDoItemNotFoundError error = new ToDoItemNotFoundError();
		error.details.add(new ToDoItemNotFoundDetail("Item with id '" + itemId + "' not found"));
		return error;
	}

	@Override
	public String toString()
	{
		return new ToStringBuilder(this).append("details", details).append("name", name).toString();
	}
}
