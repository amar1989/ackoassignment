package com.browserstack.assignment.browserstackassignment.configimpl;

public class ConfigBO
{
	private static String url = "";
	static
	{
		ConfigImpl.loadProperties();
	}

	public static String getUrl()
	{
		return url;
	}

	public static void setUrl(String myurl)
	{
		url = myurl;
	}

}
