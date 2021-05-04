package com.amazon.testbase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

public class Testbase {
	public WebDriver driver;
//	public SoftAssert softAssertion;
//	Actions act;
	//JavascriptExecutor jse;
	   
	   @BeforeClass
	   @Parameters({"url"})
	   public void setup(String url)
	   {
		   
		   System.setProperty("webdriver.chrome.driver","C:\\Users\\thota\\Desktop\\Documents\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		//	act = new Actions(driver);
			//jse = (JavascriptExecutor)driver;
			driver.get(url);
			
	   }
		
		@AfterClass
		public void TearDown() {
			driver.close();
		}

}
