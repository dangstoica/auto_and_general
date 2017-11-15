package org.autogenral.todo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.autogenral.persistence.ItemNotFoundException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author dan.stoica
 *
 */
@Service
@Scope("singleton")
public class ToDoItemPersistenceService
{
	private final AtomicLong idGenerator = new AtomicLong();
	Map<Long, ToDoItem> items = new HashMap<>();

	public ToDoItem find(Long itemId) throws ItemNotFoundException
	{
		if (items.containsKey(itemId))
		{
			return items.get(itemId);
		}
		throw new ItemNotFoundException();
	}

	public ToDoItem create(ToDoItemAddRequest itemReq)
	{
		ToDoItem item = new ToDoItem(idGenerator.getAndIncrement(), itemReq.getText());
		items.put(item.getId(), item);
		return item;
	}

	public ToDoItem update(Long id, ToDoItemUpdateRequest itemRequest) throws ItemNotFoundException
	{
		if (items.containsKey(id))
		{
			ToDoItem item = items.get(id);
			if (itemRequest.getText() != null)
			{
				item.setText(itemRequest.getText());
			}
			if (itemRequest.getIsCompleted() != null)
			{
				item.setIsCompleted(itemRequest.getIsCompleted());
			}

			return item;
		}
		throw new ItemNotFoundException();
	}

	public ToDoItem delete(Long itemId)
	{
		return new ToDoItem();
	}
}
