package com.browserstack.assignment.browserstackassignment.configimpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigImpl
{
	public static void loadProperties()
	{
		try
		{
			InputStream input = new FileInputStream("config.properties");

			Properties prop = new Properties();

			prop.load(input);
			
			ConfigBO.setUrl(prop.getProperty("url"));

		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}
}
