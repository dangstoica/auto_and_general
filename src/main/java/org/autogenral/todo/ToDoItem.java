package org.autogenral.todo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author dan.stoica
 *
 */
@Entity
@Table(name = "users")
public class ToDoItem
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "text")
	private String text;

	@Column(name = "isCompleted")
	private Boolean isCompleted = Boolean.FALSE;

	@Column(name = "createdAt")
	private String createdAt;

	public ToDoItem()
	{
		this.createdAt = FormattedTimestampFactory.createFormattedTimestamp();
	}

	public ToDoItem(String text)
	{
		this();
		this.text = text;
	}

	public ToDoItem(Long id, String text)
	{
		this(text);
		this.id = id;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

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

	public String getCreatedAt()
	{
		return createdAt;
	}

	public void setCreatedAt(String createdAt)
	{
		this.createdAt = createdAt;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		ToDoItem other = (ToDoItem) obj;
		if (id == null)
		{
			if (other.id != null) return false;
		}
		else if (!id.equals(other.id)) return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "ToDoItem [id=" + id + ", text=" + text + ", isCompleted=" + isCompleted + ", createdAt=" + createdAt + "]";
	}

}