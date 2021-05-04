package com.amazon.testcase;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.TestNG;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.pages.Amazonpages;
import com.amazon.testbase.Testbase;

public class Testcase extends Testbase {
	@Test(dataProvider = "getData")
	public void getItems(String inp) throws InterruptedException
	{
		Amazonpages amazon = new Amazonpages(driver);
		amazon.getDropDown().click();
		amazon.getSearchBox().clear();
		Select catergoryDropDown = new Select(amazon.getDropDown());
		catergoryDropDown.selectByVisibleText("Books");
		
		amazon.getSearchBox().sendKeys(inp,Keys.ENTER);
		Thread.sleep(5000);
	
		
		List<WebElement> itemNames = amazon.getItemNames();
		List<WebElement> itemPrices = amazon.getItemprices();
	
		for (WebElement item : itemNames) 
        {
			List<WebElement> itemNameTags = item.findElements(By.tagName("h2"));
			int i =0;
			for (WebElement itemNameTag : itemNameTags) {
				Reporter.log("Price of "+ itemNameTag.getText() + " is Rs. "+itemPrices.get(i).getText(), true);
				i++;
			}
			
        }	
	
	
    }
	@DataProvider
	public String[][] getData() throws IOException {
		String path ="D:\\virtusaiat\\AmazonCaseStudy\\src\\test\\java\\com\\amazon\\testdata\\Booknames.xlsx";
		String sheet = "Sheet1";
		int rowCount = com.amazon.utility.ExcelUtility.getRowCount(path, sheet);
		int cellCount = com.amazon.utility.ExcelUtility.getCellCount(path, sheet, rowCount);
		System.out.println("rowcount : "+rowCount);
		System.out.println("cellCount : "+cellCount);
		String[][] data = new String[rowCount][cellCount];
		for  (int i = 1; i<= rowCount; i++) {
			for(int j = 0; j< cellCount ; j++) {
				System.out.println("In loop Value of I : "+ i +"Value of J: "+j);
				data[i-1][j] =  com.amazon.utility.ExcelUtility.getCellData(path, sheet, i, j);
			}	
		}	
		return data;
	}	
}
