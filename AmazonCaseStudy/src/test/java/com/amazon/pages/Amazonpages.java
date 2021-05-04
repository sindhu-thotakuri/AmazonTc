package com.amazon.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazonpages {
	  WebDriver driver;
	     
	     public  Amazonpages(WebDriver driver)
	     {
	    	 this.driver = driver;
	    	 PageFactory.initElements(driver, this);
	     }
	 
		
		@FindBy(xpath="//*[@id=\"searchDropdownBox\"]")
		WebElement dropDown;
		
		public WebElement getDropDown()
		{
			return dropDown;

		}

		@FindBy(xpath="//*[@id=\"twotabsearchtextbox\"]")
		WebElement searchBox;
		
		public WebElement getSearchBox()
		{
			return searchBox;

			

		}
		
		@FindAll(@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[3]/div[2]/div/div[1]/span[1]/div[1]/div[1]"))
		List <WebElement> itemNames;
		
		@FindAll(@FindBy(className="a-price-whole"))
		List <WebElement> itemPrices;
		
		
public List <WebElement> getItemNames() {
	return itemNames;
}

public List <WebElement> getItemprices() {
	return itemPrices;
}
}