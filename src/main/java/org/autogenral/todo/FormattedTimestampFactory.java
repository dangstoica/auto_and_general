/**
 * 
 */
package org.autogenral.todo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author dan.stoica
 *
 */
public class FormattedTimestampFactory
{

	private static final String TIMESTAMP_FORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

	public static String createFormattedTimestamp()
	{
		SimpleDateFormat sdf = new SimpleDateFormat(TIMESTAMP_FORMAT_PATTERN);
		Date date = Calendar.getInstance().getTime();
		String formatedDate = sdf.format(date);
		return formatedDate;
	}

}
