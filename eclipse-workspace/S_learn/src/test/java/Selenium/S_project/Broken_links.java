package Selenium.S_project;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Broken_links {

	@Test
	public void Test1_Url()
	{
		WebDriver driver = new ChromeDriver();

		// maximize browser
		driver.manage().window().maximize();

		// wait 10s so that all element get loaded

		// Open the URL
		driver.get("http://www.deadlinkcity.com/");
		HttpURLConnection h = null;

		// find hyperlinks
		List<WebElement> allLink = driver.findElements(By.tagName("a"));

		for (WebElement element : allLink) 
		{
			String url = element.getAttribute("href"); // get the url

			try 
			{
				URL actualUrl = new URL(url);
				h = (HttpURLConnection) actualUrl.openConnection();
				h.setRequestMethod("HEAD");
				h.connect();

				int resCode = h.getResponseCode();
				if (resCode >= 400)
				{
					System.out.println("BROKEN LINK" + url);
				} else 
				{
					System.out.println("valid link" + url);
				}
			}
			catch (Exception e){
				System.out.println("Exception for URL: " + url);
				e.printStackTrace();
			}
			
			}
		driver.quit();
		}

		}
	

