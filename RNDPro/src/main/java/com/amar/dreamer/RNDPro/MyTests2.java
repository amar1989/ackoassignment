package com.amar.dreamer.RNDPro;

import org.testng.annotations.Test;

public class MyTests2
{
	@Test(priority=1)
	public void test1()
	{
		System.out.println("hello test21");
	}
	@Test(priority=0)
	public void test2()
	{
		System.out.println("hello test22");
	}
	@Test(priority=2)
	public void test3()
	{
		System.out.println("hello test23");
	}
}
