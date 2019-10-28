package com.acko.assignment.ackoassignment.startup;

import com.acko.assignment.ackoassignment.comparator.Comparator;

public class Startup
{
	private static Comparator comparator = new Comparator();

	public static void main(String Str[])
	{

		String fileName1 = "UrlFile1.txt";
		String fileName2 = "UrlFile2.txt";
		comparator.compareApiResponse(fileName1, fileName2);
	}
}
