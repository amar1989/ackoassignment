package com.browserstack.assignment.browserstackassignment.Assignment2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class TextFileReader
{

	public static String replaceValue(Map<String, String> dataMap, String fileName) throws IOException
	{
		File file = new File(fileName);

		// File file = new File("C:\\Users\\pankaj\\Desktop\\test.txt");

		BufferedReader br = new BufferedReader(new FileReader(file));

		String st;
		String key = "";
		String originalString = "";
		while ((st = br.readLine()) != null)
		{
			originalString = originalString + "<p>" + st + "<br>";
			while (st.contains("&"))
			{
				if (st.contains("&"))
				{
					if (st.charAt(st.indexOf("&") + 1) == '&')
					{
						String subStr = st.substring(st.indexOf("&") + 2);
						for (char ch : subStr.toCharArray())
						{
							if (ch == '&')
							{
								// System.out.println("key:::" + key);
								if (dataMap.get(key) != null)
								{
									originalString = originalString.replace("&" + key + "&", dataMap.get(key));
								}
								st = st.substring(st.indexOf(key) + key.length() + 2);
								key = "";
								break;
							}
							else
							{
								key = key + "" + ch;

							}
						}
					}
					else if (st.charAt(st.indexOf("&") + 1) >= 97 && st.charAt(st.indexOf("&") + 1) <= 122
							|| st.charAt(st.indexOf("&") + 1) >= 65 && st.charAt(st.indexOf("&") + 1) <= 90)
					{
						String subStr = st.substring(st.indexOf("&") + 1);
						for (char ch : subStr.toCharArray())
						{
							if (ch == '&')
							{
								// System.out.println("key:::" + key);
								if (dataMap.get(key) != null)
								{
									originalString = originalString.replace("&" + key + "&", dataMap.get(key));
								}
								st = st.substring(st.indexOf(key) + key.length() + 1);
								key = "";
								break;
							}
							else
							{

								key = key + "" + ch;

							}
						}
					}
				}
			}

		}
		// System.out.println(originalString);

		return originalString;
	}
}
