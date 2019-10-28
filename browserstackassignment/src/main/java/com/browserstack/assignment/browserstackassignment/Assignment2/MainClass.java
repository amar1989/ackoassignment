package com.browserstack.assignment.browserstackassignment.Assignment2;

import java.io.IOException;
import java.util.Map;

import org.json.simple.parser.ParseException;

public class MainClass
{
  public static void main(String str[]) throws ParseException, IOException
  {
	  Map<String,String> dataMap=JsonReader.getMapOfJson("drive_map.json");
	  String htmlString=TextFileReader.replaceValue(dataMap,"drive_input.txt");
	  System.out.println(htmlString);
  }
}
