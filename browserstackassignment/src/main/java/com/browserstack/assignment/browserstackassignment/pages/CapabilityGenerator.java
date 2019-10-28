package com.browserstack.assignment.browserstackassignment.pages;

import org.openqa.selenium.WebDriver;

public interface CapabilityGenerator
{
   public static String osXpath="//a[@id='doc-os-trigger']";
   public static String osSelectionXpath="(//a[@class='icon-browser-sprite icon-win10 active'])";//[contains(text(),'Windows 10')]";
   public static String browserXpath="//a[@id='doc-browser-trigger']";
   public static String broserSelectionXpath="(//div[@class='doc-options-title icon-browser-sprite icon-chrome'])";//[contains(text(),'Chrome')]";
   public static String browserVersionSelectionXpath="//div[@class='doc-options-lists doc-browser-lists']";//a[contains(text(),'75')]";
   
   public static String generatedOsVersionXpath="//span[contains(text(),'\"os_version\"')]/following-sibling::span[@class='value']";
   public static String generatedBrowserXpath="//span[contains(text(),'\"browser\"')]/following-sibling::span[@class='value']";
   public static String generatedBrowserVersionXpath="//span[contains(text(),'\"browser_version\"')]/following-sibling::span[@class='value']";
   
   public void clickOnOsSelectionDropdown(WebDriver driver);
   public void selectOsFromDropdown(String osName,WebDriver driver);
   public void clickOnBrowserSelectionDropdown(WebDriver driver);
   public void selectBrowser(String browser,WebDriver driver);
   public void selectBroserVersion(String version,WebDriver driver);
   
   public String getOsversion(WebDriver driver);
   public String getBrowserType(WebDriver driver);
   public String getBrowserVersion(WebDriver driver);
   
}
