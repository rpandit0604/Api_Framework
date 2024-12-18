package Selenium.S_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

//https://gopro.okta.com/app/UserHome

public class TitleVerify {
	@Test 
	public void Verify_Title()
	{
		//WebDriver driver = new ChromeDriver();
		WebDriver driver1 = new EdgeDriver();
		
		driver1.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver1.findElement(By.xpath("//*[text()='Top Deals']")).click();
//		String title= driver.getTitle();
//		if (title.equals("GreenKart - veg and fruits kart"))
//		{
//			System.out.println("Success: Title is Google");
//		}
//		else
//		{
//			System.out.println("FAIL: "+ title);
//		}
//		String url= driver.getCurrentUrl();
//		if(url.contains("rahulshettyacademy.com"))
//		{
//			System.out.println("Success");
//		}
//		else
//		{
//			System.out.println("FAIL: "+url);
//		}
		
		
	}
	
}
