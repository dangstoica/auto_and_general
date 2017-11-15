package org.autogenral.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.autogenral.todo.ToDoItem;
import org.autogenral.todo.ToDoItemAddRequest;
import org.autogenral.todo.ToDoItemUpdateRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author dan.stoica
 *
 */
@Service
@Scope("singleton")
@Transactional
public class ToDoItemPersistenceService
{
	Logger log = LoggerFactory.getLogger(getClass());

	@PersistenceContext
	private EntityManager em;

	// private final AtomicLong idGenerator = new AtomicLong();
	// Map<Long, ToDoItem> items = new HashMap<>();

	public ToDoItem find(Long itemId) throws ItemNotFoundException
	{
		ToDoItem item = em.find(ToDoItem.class, itemId);
		if (item != null)
		{
			log.trace("Lookup Item {} succesfull", item);
			return item;
		}
		log.error("fail to find Item {} ", item);
		throw new ItemNotFoundException();
	}

	public ToDoItem create(ToDoItemAddRequest itemReq)
	{
		log.debug("Create new Item request : {}", itemReq);

		ToDoItem item = new ToDoItem(itemReq.getText());
		em.persist(item);
		em.flush();
		return item;
	}

	public ToDoItem update(Long id, ToDoItemUpdateRequest itemRequest) throws ItemNotFoundException
	{
		log.debug("Update request for item with id:{}", id);
		ToDoItem item = em.find(ToDoItem.class, id);
		if (item != null)
		{
			if (itemRequest.getText() != null)
			{
				item.setText(itemRequest.getText());
			}
			if (itemRequest.getIsCompleted() != null)
			{
				item.setIsCompleted(itemRequest.getIsCompleted());
			}
			em.merge(item);
			em.flush();
			return item;
		}
		throw new ItemNotFoundException();
	}

	public void delete(Long itemId)
	{
		try
		{
			ToDoItem item = em.getReference(ToDoItem.class, itemId);
			em.remove(item);
		}
		catch (EntityNotFoundException e)
		{
			log.error("Item already removed for id:{}", itemId);
		}
	}
}
