package com.browserstack.assignment.browserstackassignment.Assignment2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import bsh.ParseException;

public class JsonReader
{

	public static Map<String, String> getMapOfJson(String jsonFileLocation) throws org.json.simple.parser.ParseException
	{
		Map<String, String> dataMap = new HashMap<String, String>();
		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();

		try
		{

			FileReader reader = new FileReader(jsonFileLocation);
			// Read JSON file
			Object obj = jsonParser.parse(reader);

			JSONObject jsonObject = (JSONObject) obj;
			Set<String> keySet=jsonObject.keySet();
			for(String key:keySet)
			{
				dataMap.put(key, (String) jsonObject.get(key));
			}

		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return dataMap;
	}

}
