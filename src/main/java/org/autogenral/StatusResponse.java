package org.autogenral;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author dan.stoica
 *
 */
public class StatusResponse
{
	private String status = "healthy";

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	@Override
	public String toString()
	{
		return new ToStringBuilder(this).append("status", status).toString();
	}

}