package org.autogenral.todo;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author dan.stoica
 *
 */
public class ToDoItemUpdateRequest
{

	private String text;
	private Boolean isCompleted;

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public Boolean getIsCompleted()
	{
		return isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted)
	{
		this.isCompleted = isCompleted;
	}

	public boolean isValidRequest()
	{
		return this.text == null || (StringUtils.isNotBlank(this.text) && this.text.length() <= 50);
	}

	@Override
	public String toString()
	{
		return new ToStringBuilder(this).append("text", text).append("isCompleted", isCompleted).toString();
	}

}