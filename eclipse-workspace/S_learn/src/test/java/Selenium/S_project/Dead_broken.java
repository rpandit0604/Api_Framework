package Selenium.S_project;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Dead_broken {
	@Test
	public void URL_DEAD_2() {

		
		WebDriver driver = new ChromeDriver();

		// maximize browser
		driver.manage().window().maximize();

		// wait 10s so that all element get loaded

		// Open the URL
		driver.get("http://www.deadlinkcity.com");
		
		HttpURLConnection h = null; //HttpURLConnection is a class

		// collected all finded hyperlinks in allLink
		List<WebElement> allLink = driver.findElements(By.tagName("a"));

		for (WebElement element : allLink) //foreachloop we will try to get url of each link
		{
			// got the url of the particular link and stores in string format
			String url = element.getAttribute("href"); 
			
			// Get the text (name) of the hyperlink
            String linkText = element.getText();
			
			try 
			{
				//URL is a class for converting string url into actual URL format
				URL actualUrl = new URL(url); //
				
				//openconnection helps us to connect to that parituclar url
				//as it is http method so we typecasted into HttpURLConnection 
				h = (HttpURLConnection) actualUrl.openConnection(); //return Http/url connection
				
				h.setRequestMethod("HEAD"); //it will request for response code
				
				h.connect(); //actually connect to server  for getting response

				int resCode = h.getResponseCode(); //stores the response code
				if (resCode >= 400)
				{
					System.out.println("BROKEN LINK" +linkText+ url);
				} else 
				{
					System.out.println("valid link"+ linkText + url);
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
