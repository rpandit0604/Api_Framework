package Selenium.S_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OkTA {

	@Test
	public void login() throws InterruptedException
	{
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://gopro.okta.com/app/UserHome");
		driver.findElement(By.id("okta-signin-username")).sendKeys("roshanpandit");
		driver.findElement(By.id("okta-signin-password")).sendKeys("leavemealone@1");
		driver.findElement(By.className("button-primary")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.className("button-primary")).click();
	}
}
