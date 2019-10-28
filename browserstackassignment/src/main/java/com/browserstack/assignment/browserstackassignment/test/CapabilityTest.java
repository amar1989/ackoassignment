package com.browserstack.assignment.browserstackassignment.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.browserstack.assignment.browserstackassignment.configimpl.ConfigBO;
import com.browserstack.assignment.browserstackassignment.pages.CapabilityGeneratorPageImpl;

public class CapabilityTest
{

	@Test
	public void testCapability()
	{
		String osName="Windows 10";
		String browserName="Chrome";
		String broserVersion="75";
		
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get(ConfigBO.getUrl());
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		
		CapabilityGeneratorPageImpl capabilityGenImpl=new CapabilityGeneratorPageImpl();
		capabilityGenImpl.clickOnOsSelectionDropdown(driver);
		capabilityGenImpl.selectOsFromDropdown(osName,driver);
		capabilityGenImpl.clickOnBrowserSelectionDropdown(driver);
		capabilityGenImpl.selectBrowser(browserName, driver);
		capabilityGenImpl.selectBroserVersion(broserVersion, driver);
		
		String generatedOs=capabilityGenImpl.getOsversion(driver);
		Assert.assertEquals(generatedOs, osName);
		String generatedBrowser=capabilityGenImpl.getBrowserType(driver);
		Assert.assertEquals(generatedBrowser, browserName);
		String generatedBrowserVersion=capabilityGenImpl.getBrowserVersion(driver);
		Assert.assertEquals(generatedBrowserVersion, broserVersion);
		
	}
}
