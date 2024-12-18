package Selenium.S_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class landingOnwebsite {
    
	@Test
	public void Homepage()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.javatpoint.com/");
		driver.findElement(By.linkText("HTML")).click();
		
		
		
	}
	

	}


