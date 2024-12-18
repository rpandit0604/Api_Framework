package Selenium.S_project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VerifyIfHomepageLoadSuccessfully {

	@Test
	public void HomePage()
	{
	//navigate to gopro website	
	WebDriver driver = new ChromeDriver();
	driver.get("https://gopro.com/en/us/?srsltid=AfmBOop3Z984Shfae0GL1IYMpU-iu1yVz1lCHkAjK4rpaZM92YhCnXzk");
	
	//title of page
	String pageTitle= driver.getTitle();
	System.out.println(pageTitle);
	
	if(pageTitle.contains("GoPro"))
	{
		System.out.println("testpassed: Homepage loaded successfully");
	}
	else
	{
		System.out.println("testFailed: Homepage did not loaded successfully");
	}
	
	
	}
	
	
	
	
}
