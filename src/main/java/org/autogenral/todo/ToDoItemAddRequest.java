package org.autogenral.todo;

import javax.validation.constraints.Size;

import org.apache.commons.lang3.StringUtils;

/**
 * @author dan.stoica
 *
 */
public class ToDoItemAddRequest
{
	@Size(min = 1, max = 50)
	private String text;

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public boolean isValidRequest(){
		return StringUtils.isNotBlank(text);
	}
	
	@Override
	public String toString()
	{
		return "ToDoItemAddRequest [text=" + text + "]";
	}

}
