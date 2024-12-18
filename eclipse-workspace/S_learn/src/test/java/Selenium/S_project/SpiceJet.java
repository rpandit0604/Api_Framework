package Selenium.S_project;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SpiceJet {

	@Test
	public static void Bookticket() throws InterruptedException, AWTException
	{
		WebDriver driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(6000);
		//WebElement ele= driver.findElement(By.xpath("//span[text='From']"));
//		Actions act=new Actions(driver);
//		act.moveToElement(ele).click();
		driver.findElement(By.className("commonModal__close")).click();
		
//		Robot rb=new Robot();
//		rb.delay(2000);
//		rb.keyPress(KeyEvent.VK_ESCAPE);
//		rb.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(2000);
		
	
		//select departure city
		driver.findElement(By.xpath("//span[text='From']")).click();
		driver.findElement(By.xpath("//p[text()='Kolkata, India']")).click();
		Thread.sleep(2000);
		/*
		//Select target city
		driver.findElement(By.xpath("//div[text='To']")).click();
		driver.findElement(By.xpath("//div[text='Ranchi']")).click();
		Thread.sleep(2000);
		//select date
		driver.findElement(By.xpath("//div[contains(text(),'Departure Date')]")).click();
		driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-ubezar r-16dba41'][contains(text(),11)]")).click();
		Thread.sleep(2000);
		//select 2 adult passenger
		driver.findElement(By.xpath("//div[text()='Passengers']")).click();
		driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
		Thread.sleep(2000);
		//search
		driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();
		
		Thread.sleep(5000);
		*/
		


		
		
		
		
		
		
		
		
	}
	
	
	
}
