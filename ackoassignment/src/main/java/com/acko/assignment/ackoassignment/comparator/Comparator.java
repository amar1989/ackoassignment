package com.acko.assignment.ackoassignment.comparator;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.xml.stream.XMLStreamException;

import com.acko.assignment.ackoassignment.exceptions.AssignInputOutputException;

public class Comparator
{

	public void compareApiResponse(String fileName1, String fileName2)
	{
		int maxSize = 0;

		List<String> urlList1 = null;
		List<String> urlList2 = null;
		try
		{
			// List of all Urls specified in input files
			urlList1 = WorkerComparator.getUrlListFromFile(fileName1);
			urlList2 = WorkerComparator.getUrlListFromFile(fileName2);
		}
		catch (AssignInputOutputException aioe)
		{
			aioe.printStackTrace();
		}

		// considering size of both list may not be same

		if (urlList1 != null && urlList2 != null)
		{
			maxSize = urlList1.size() > urlList2.size() ? urlList1.size() : urlList2.size();
		}
        
		//For Multithreaded execution
		ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		for (int i = 0; i < maxSize; i++)
		{

			if (urlList1.size() > i && urlList2.size() > i)
			{

				Runnable worker = new WorkerComparator(urlList1.get(i).trim(), urlList2.get(i).trim());
				executor.execute(worker);

			}

		}
		executor.shutdown();
		while (!executor.isTerminated())
		{
		}
		System.out.println("Finished all threads");

	}

}
