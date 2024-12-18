package Selenium.S_project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class getVsNavigate {
	@Test
	public void exception()
	{
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	@Test
	public void get_Navigate()

	{
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		exception();
		driver.navigate().to("https://www.gmail.com");
		exception();
		driver.navigate().back();
		exception();
		driver.navigate().forward();
		exception();
		driver.navigate().refresh();
		
		
		
	}
}
