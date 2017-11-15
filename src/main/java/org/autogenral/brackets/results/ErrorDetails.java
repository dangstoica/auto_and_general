package org.autogenral.brackets.results;

import java.util.ArrayList;

import org.autogenral.brackets.validator.DataInputException;

/**
 * @author dan.stoica
 *
 */
public class ErrorDetails extends ArrayList<Detail>
{
	private static final long serialVersionUID = 1L;

	public void addFromError(DataInputException ex)
	{
		add(Detail.create(ex));
		add(new Detail(ex.getInput()));
	}
}
