/*package com.amar.UIElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class UIElementGenerator
{

	public static WebElement getUIElement(String elementName)
	{
		WebElement element = null;
		return element;
	}
	
    public static Map<String,WebElement> getListOfElement(String fileName)
    {
    	List<WebElement> webElementList=new ArrayList<WebElement>();
    	
    	List<UI_Element> uiElementList=getListOfUIElement(fileName);
    	for(UI_Element element:uiElementList)
		{
			String elemntValue=element.getElementValue();
		}
    	
    	return webElementList;
    	
    }

	public static List<UI_Element> getListOfUIElement(String fileName)
	{
		List<UI_Element> uiElementList = new ArrayList<UI_Element>();
		XSSFWorkbook workbook = null;

		try
		{
			FileInputStream file = new FileInputStream(new File("LoginPage.xlsx"));

			// Create Workbook instance holding reference to .xlsx file
			workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext())
			{
				Row row = rowIterator.next();
				UI_Element element=new UI_Element();
				
				Cell elementNameCell=row.getCell(0);
				String elementName=elementNameCell.getStringCellValue();
				element.setElementName(elementName);
				
				Cell elementValueCell=row.getCell(1);
				String elementValue=elementValueCell.getStringCellValue();
				element.setElementValue(elementValue);
				
				Cell elementTypeCell=row.getCell(2);
				String elementType=elementTypeCell.getStringCellValue();
				element.setElementType(elementType);
				
				uiElementList.add(element);
			}
			file.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (workbook != null)
			{
				try
				{
					workbook.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}

		return uiElementList;
	}
	
	public static void main(String str[])
	{
		List<UI_Element> uiElementList=getListOfUIElement("LoginPage.xlsx");
		for(UI_Element element:uiElementList)
		{
			System.out.println(element.getElementName()+"--"+element.getElementValue()+"----"+element.getElementType());
		}
	}
}
*/