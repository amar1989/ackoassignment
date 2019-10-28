package com.acko.assignment.ackoassignment.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.node.JsonNodeType;

public class JsonReader
{

	public static Map<String, List<Object>> parseJson(JsonNode node, String parentName,
			Map<String, List<Object>> dataMap) throws IOException
	{

		Iterator<Map.Entry<String, JsonNode>> fieldsIterator = node.fields();
		while (fieldsIterator.hasNext())
		{

			Map.Entry<String, JsonNode> field = fieldsIterator.next();

			String fieldKey = field.getKey();
			JsonNode jsonNode = field.getValue();
			if (jsonNode.getNodeType() == JsonNodeType.OBJECT)
			{
				parseJson(jsonNode, fieldKey, dataMap);
			}
			else if (jsonNode.getNodeType() == JsonNodeType.ARRAY)
			{
				if (jsonNode.get(0) != null)
				{
					if (jsonNode.get(0).getNodeType() == JsonNodeType.OBJECT
							|| jsonNode.get(0).getNodeType() == JsonNodeType.ARRAY)
					{
						for (int i = 0; i < jsonNode.size(); i++)
						{
							parseJson(jsonNode.get(i), fieldKey, dataMap);
						}
					}
					else
					{
						List<Object> valueList = new ArrayList<Object>();
						for (int i = 0; i < jsonNode.size(); i++)
						{
							valueList.add(jsonNode.get(i));
						}
						dataMap.put(fieldKey, valueList);
					}
				}
			}

			else
			{
				if (parentName == "")
				{
					if (dataMap.get(parentName) == null)
					{
						List<Object> nodeList = new ArrayList<Object>();
						nodeList.add(jsonNode);
						dataMap.put(fieldKey, nodeList);
					}
					else
					{
						dataMap.get(parentName).add(jsonNode);
					}

				}
				else
				{

					if (dataMap.get(parentName + "." + fieldKey) == null)
					{
						List<Object> nodeList = new ArrayList<Object>();
						nodeList.add(jsonNode);
						dataMap.put(parentName + "." + fieldKey, nodeList);
					}
					else
					{
						dataMap.get(parentName + "." + fieldKey).add(jsonNode);
					}

				}

			}
		}
		return dataMap;

	}
}
