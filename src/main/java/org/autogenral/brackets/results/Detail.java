package org.autogenral.brackets.results;

import org.autogenral.brackets.validator.DataInputException;

/**
 * @author dan.stoica
 *
 */
public class Detail
{
	public final static String DEFAULT_MSG = "Original Input string.";

	private String location = "params";
	private String param = "text";
	private String msg;

	private String value = "";

	public Detail()
	{
		super();
	}

	public Detail(String value)
	{
		this(value, DEFAULT_MSG);
	}

	public Detail(String value, String msg)
	{
		this();
		this.value = value;
		this.msg = msg;
	}

	public Detail(String param, String value, String msg)
	{
		this(value, msg);
		this.param = param;
	}

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}

	public String getParam()
	{
		return param;
	}

	public void setParam(String param)
	{
		this.param = param;
	}

	public String getMsg()
	{
		return msg;
	}

	public void setMsg(String msg)
	{
		this.msg = msg;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public final static Detail create(DataInputException ex)
	{
		Detail detail = new Detail(ex.getDetails(), ex.getMessage());
		return detail;
	}

	@Override
	public String toString()
	{
		return "Detail [location=" + location + ", param=" + param + ", msg=" + msg + ", value=" + value + "]";
	}

}
