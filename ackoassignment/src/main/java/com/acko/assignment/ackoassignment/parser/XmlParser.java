package com.acko.assignment.ackoassignment.parser;

import java.io.ByteArrayInputStream;

import java.io.InputStream;
import java.util.ArrayList;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class XmlParser
{
	public static Map<String, List<Object>> parseXml(String xml) throws XMLStreamException
	{
		StringBuilder content = null;
		Map<String, List<Object>> dataMap = new LinkedHashMap<String, List<Object>>();
		XMLInputFactory factory = XMLInputFactory.newInstance();
		InputStream stream = new ByteArrayInputStream(xml.getBytes());
		XMLStreamReader reader = factory.createXMLStreamReader(stream);
		String immediateParent = "";
		String keyName = "";

		while (reader.hasNext())
		{
			int event = reader.next();

			switch (event)
			{
			case XMLStreamConstants.START_ELEMENT:
			{
				content = new StringBuilder();
				keyName = reader.getLocalName();
				break;
			}

			case XMLStreamConstants.CHARACTERS:
				if (content != null)
				{

					if (content != null)
					{
						content.append(reader.getText().trim());
					}
					if (reader.getText().trim().equalsIgnoreCase(""))
					{
						immediateParent = keyName;
					}
				}
				break;

			case XMLStreamConstants.END_ELEMENT:
				if (content != null)
				{
					String leafText = content.toString();
					if (dataMap.get(immediateParent + "." + reader.getLocalName()) == null)
					{
						List<Object> values = new ArrayList<Object>();
						values.add(leafText);
						dataMap.put(immediateParent + "." + reader.getLocalName(), values);
					}
					else
					{
						dataMap.get(immediateParent + "." + reader.getLocalName()).add(leafText);
					}
				}
				content = null;
				break;

			case XMLStreamConstants.START_DOCUMENT:
				break;
			}
		}
		return dataMap;
	}
}
