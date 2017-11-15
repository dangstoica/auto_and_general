/**
 * 
 */
package org.autogenral.brackets.validator;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author dan.stoica
 *
 */
@ConfigurationProperties(prefix = "server")
@Configuration
//@SpringBootConfiguration
public class ApplicationConfigProperties
{
//	@Value("${server.port}")
	private int port = 8811;

	public int getPort()
	{
		return port;
	}

	public void setPort(Integer port)
	{
		this.port = port;
	}

	private Host host;

	private static class Host
	{

		private String ip;

		private int port = 8812;

		public String getIp()
		{
			return ip;
		}

		public void setIp(String ip)
		{
			this.ip = ip;
		}

		public int getPort()
		{
			return port;
		}

		public void setPort(int port)
		{
			this.port = port;
		}

	}

}
