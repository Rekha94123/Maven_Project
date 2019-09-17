package com.model;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class MercuryTsToursTest 
{
	public WebDriver driver;
  @Test(priority=1,description="Verify that valid user1 able to login into Mercury tours application by using valid username and password")
  public void loginwithValidds1() 
  {
	  System.out.println("In loginwithValidds1 MUT");
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Suvidyap1");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("P@ssword1");
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  
	     boolean flag=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
	       System.out.println("Flight Finder image is display:"+flag);
	       
	       driver.findElement(By.linkText("SIGN-OFF")).click();
  }
  
  @Test(priority=2,description="Verify that valid user1 able to login into Mercury tours application by using valid username and password")
  public void loginwithValidds2() 
  {
	  System.out.println("In loginwithValidds1 method under Test");
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Suvidyap2");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("P@ssword2");
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  
	     boolean flag=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
	       System.out.println("Flight Finder image is display:"+flag);
	       
	       driver.findElement(By.linkText("SIGN-OFF")).click();
  }
  @Test(priority=3,description="Verify that valid user1 able to login into Mercury tours application by using valid username and password")
  public void loginwithInvalidds3() 
  {
	  System.out.println("In login");
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Suvidyap");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("P@ssword");
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  
	     boolean flag=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
	       System.out.println("Flight Finder image is display:"+flag);
	       
	       driver.findElement(By.linkText("SIGN-OFF")).click();
  }
  @BeforeMethod
  public void getCookies() 
  {
	  Set<Cookie> cookies=driver.manage().getCookies();
	      for(Cookie cookie:cookies) 
	      {
	    	  System.out.println(cookie.getName());
	      }
  }

  @AfterMethod
  public void captureScreenshot() throws IOException 
  {
	  File src= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	      FileUtils.copyFileToDirectory(src, new File("C:\\Users\\user\\eclipse-workspace\\Maven_Project\\src\\test\\resource\\Screenshot\\"));
	        System.out.println("SSHCS");
  }

  @BeforeClass
  public void maximizeBrowser() 
  {
	  System.out.println("In maximizeBrowser method under BeforeClass ");
	  driver.manage().window().maximize();
  }

  @AfterClass
  public void deleteAllCookie() 
  {
	  driver.manage().deleteAllCookies();
  }

  @BeforeTest
  public void enterApplicationUrl()
  {
	  driver.get("http://newtours.demoaut.com/mercurywelcome.php");
  }

  @AfterTest
  public void dbConnectionClose()
  {
	  System.out.println("In dbConnectionClose method under AfterTest");
  }

  @BeforeSuite
  public void openBrowser()
  {
	  System.out.println("In openBrowser method under BeforeSuite ");
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium_Task\\chrome 65version\\chromedriver.exe");
	     driver=new ChromeDriver();
	     System.out.println("Chrome browser is open successfully");
  }

  @AfterSuite
  public void closeBrowser() 
  {
	  driver.close();
  }

}
