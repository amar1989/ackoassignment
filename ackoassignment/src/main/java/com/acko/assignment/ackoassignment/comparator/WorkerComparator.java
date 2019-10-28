package com.acko.assignment.ackoassignment.comparator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLStreamException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import com.acko.assignment.ackoassignment.exceptions.AssignInputOutputException;
import com.acko.assignment.ackoassignment.exceptions.InvalidUrlException;
import com.acko.assignment.ackoassignment.parser.JsonReader;
import com.acko.assignment.ackoassignment.parser.XmlParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WorkerComparator implements Runnable
{

	String url1 = "";
	String url2 = "";

	public WorkerComparator(String url1, String url2)
	{
		this.url1 = url1;
		this.url2 = url2;

	}

	public void run()
	{
		try
		{
			boolean isSimmilar = compareResponse(url1, url2);
			if (isSimmilar)
			{
				// Logger can be implemented
				System.out.println(url1 + " equals " + url2);
			}
			else
			{
				System.out.println(url1 + " not equals " + url2);
			}

		}
		catch (InvalidUrlException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{

			e.printStackTrace();
		}
		catch (XMLStreamException e)
		{

			e.printStackTrace();
		}

	}

	public static List<String> getUrlListFromFile(String fileName) throws AssignInputOutputException
	{
		String st;
		List<String> fileNameList = new LinkedList<String>();

		File file = new File(fileName);
		try
		{

			BufferedReader br = new BufferedReader(new FileReader(file));

			while ((st = br.readLine()) != null)
				fileNameList.add(st);
		}
		catch (IOException ioe)
		{
			throw new AssignInputOutputException("Please check file and its content,it should be readable.", ioe);
		}

		return fileNameList;
	}

	public boolean compareResponse(String url1, String url2) throws InvalidUrlException, IOException, XMLStreamException
	{
		boolean isSimmilar = false;

		String response1 = getResponse(url1, "Get");

		String response2 = getResponse(url2, "Get");

		Map<String, List<Object>> dataMap1 = getDataMap(response1);

		Map<String, List<Object>> dataMap2 = getDataMap(response2);

		isSimmilar = compareResponseMap(dataMap1, dataMap2);

		return isSimmilar;
	}

	public String getResponse(String url, String methodType) throws IOException, InvalidUrlException
	{
		String response = "";
		HttpRequestBase requestBase = null;
		
		// Creating HttpGet object with URl-1
		if (methodType.equalsIgnoreCase("get"))
		{
			requestBase = new HttpGet(url);

		}
		else if (methodType.equalsIgnoreCase("post"))
		{
			requestBase = new HttpPost(url);

		}
		else if (methodType.equalsIgnoreCase("put"))
		{
			requestBase = new HttpPut(url);

		}
		// We can specify Delete or Other Http methods.
		else
		{
			System.out.println("Please specify valid Http method..");
		}
		response = makeApiCall(requestBase);
		return response;
	}

	public String makeApiCall(HttpRequestBase requestBase) throws IOException, InvalidUrlException
	{
		String response = "";
		HttpClient client = new DefaultHttpClient();
		ResponseHandler<String> responseHandler = new BasicResponseHandler();
		try
		{
			response = client.execute(requestBase, responseHandler);
		}
		catch (ClientProtocolException cpe)
		{
			throw new InvalidUrlException("Please check the url,It should be as per the Http Protocol.", cpe);
		}
		return response;
	}

	public Map<String, List<Object>> getDataMap(String responseJson) throws IOException, XMLStreamException
	{
		Map<String, List<Object>> dataMap = null;
		//For Json Response
		if (responseJson.startsWith("{") || responseJson.startsWith("["))
		{
			ObjectMapper mapper = new ObjectMapper();

			JsonNode rootNode1 = mapper.readTree(responseJson);

			Map<String, List<Object>> tempDataMap = new LinkedHashMap<String, List<Object>>();
			// iterateObject is a recursion that write data in a map so sending empty map as
			// parameter.
			dataMap = JsonReader.parseJson(rootNode1, "", tempDataMap);

		}
		//For XML response.
		else if (responseJson.startsWith("<"))
		{
			dataMap = XmlParser.parseXml(responseJson);
		}
		return dataMap;

	}

	public boolean compareResponseMap(Map<String, List<Object>> compareMap1, Map<String, List<Object>> compareMap2)
	{
		try
		{
			for (String key : compareMap1.keySet())
			{
				if (!compareMap1.get(key).equals(compareMap2.get(key)))
				{
					return false;
				}
			}
			for (String y : compareMap1.keySet())
			{
				if (!compareMap2.containsKey(y))
				{
					return false;
				}
			}
		}
		catch (NullPointerException np)
		{
			return false;
		}
		return true;
	}

}
