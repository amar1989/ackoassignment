package com.amar.UIElement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGTest
{
	
    @Test
	public void test1()
	{
    	System.out.println(" test1");
	}
    @Test
	public void test2()
	{
    	System.out.println(" test2");
	}
    @Test
	public void test3()
	{
    	System.out.println(" test2");	
	}
    @BeforeTest
	public void beforeTest()
	{
		System.out.println("before test");
	}
    @BeforeMethod
	public void beforeMethod()
	{
    	System.out.println("before Method");
	}
	
}
