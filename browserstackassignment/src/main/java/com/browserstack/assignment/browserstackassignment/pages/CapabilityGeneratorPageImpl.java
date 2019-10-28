package com.browserstack.assignment.browserstackassignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CapabilityGeneratorPageImpl implements CapabilityGenerator
{

	public void clickOnOsSelectionDropdown(WebDriver driver)
	{
	
		WebElement OsSelectionElement=driver.findElement(By.xpath(osXpath));
		OsSelectionElement.click();
	}

	public void selectOsFromDropdown(String osName,WebDriver driver)
	{
		WebElement osElement=driver.findElement(By.xpath(osSelectionXpath+"[contains(text(),'"+osName+"')]"));
		osElement.click();
		
	}

	public void clickOnBrowserSelectionDropdown(WebDriver driver)
	{
		WebElement browserSelectionElement=driver.findElement(By.xpath(browserXpath));
		browserSelectionElement.click();
		
	}
	public void selectBroserVersion(String version, WebDriver driver)
	{
		WebElement broserVersionElement=driver.findElement(By.xpath(browserVersionSelectionXpath+"//a[contains(text(),'"+version+"')]"));
		broserVersionElement.click();
		
	}

	public void selectBrowser(String browser,WebDriver driver)
	{
		
		WebElement browserElement=driver.findElement(By.xpath(broserSelectionXpath+"//[contains(text(),'"+browser+"')]"));
		browserElement.click();
	}

	public String getOsversion(WebDriver driver)
	{
		WebElement generatedOsVersionEle=driver.findElement(By.xpath(generatedOsVersionXpath));
		String generatedVersion=generatedOsVersionEle.getText();
		return generatedVersion;
		
	}

	public String getBrowserType(WebDriver driver)
	{
		WebElement generatedBroserTypeEle=driver.findElement(By.xpath(generatedBrowserXpath));
		return generatedBroserTypeEle.getText();
		
	}

	public String getBrowserVersion(WebDriver driver)
	{
		WebElement generatedBroserVersionEle=driver.findElement(By.xpath(generatedBrowserVersionXpath));
		return generatedBroserVersionEle.getText();
		
	}

	

}
