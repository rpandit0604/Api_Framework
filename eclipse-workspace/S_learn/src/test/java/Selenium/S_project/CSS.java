package Selenium.S_project;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CSS {
@Test
	public void Css_selector()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.findElement(By.cssSelector("div[class='product']:nth-child(4) div[class='product-action'] button")).click();
		driver.findElement(By.xpath("//div[@class='product'][3]//div[@class='product-action']//button")).click();
		//wait lagao
		
		//cart pe jao
		driver.findElement(By.cssSelector("div[class='cart'] a[class='cart-icon']")).click();
		//driver.findElement(By.cssSelector("//div[@class='cart']//a[@class='cart-icon']")).click();
		//wait lgao
		
		//proceed to checkoiut pe click kro
		driver.findElement(By.cssSelector("div[class='action-block'] button")).click();
		driver.findElement(By.cssSelector("//div[@class='action-block']//button")).click();
		
	}
 	@Test
	public void Add_carrot_brinjal() throws InterruptedException
	{
		WebDriver driver1=new ChromeDriver();
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver1.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		//incrementing the carrot value
		for(int i=0;i<10;i++)
		{
			driver1.findElement(By.cssSelector("div[class='product']:nth-child(5) div[class='stepper-input'] a[class='increment']")).click();

		}
		
		//decrementing the carrot value
		for(int j=0;j<5;j++)
		{
			driver1.findElement(By.cssSelector("div[class='product']:nth-child(5) div[class='stepper-input'] a[class='decrement']")).click();

		}

		driver1.findElement(By.cssSelector("div[class='product']:nth-child(5) div[class='product-action'] button")).click();

		for(int i=0;i<10;i++)
		{
			driver1.findElement(By.cssSelector("div[class='product']:nth-child(8) div[class='stepper-input'] a[class='increment']")).click();

		}

		for(int j=0;j<5;j++)
		{
			driver1.findElement(By.cssSelector("div[class='product']:nth-child(8) div[class='stepper-input'] a[class='decrement']")).click();

		}
		
		driver1.findElement(By.cssSelector("div[class='product']:nth-child(8) div[class='product-action'] button")).click();

		
		
		driver1.findElement(By.cssSelector("div[class='cart'] a[class='cart-icon']")).click();
		

		driver1.findElement(By.cssSelector("div[class='action-block'] button")).click();
		

		driver1.findElement(By.xpath("//button[text()='Place Order']")).click();
		
		Thread.sleep(5000);
		
		driver1.findElement(By.xpath("//select/option[@value='India']")).click();

		Thread.sleep(5000);
		driver1.findElement(By.xpath("//div//input[@type='checkbox']")).click();
		
		driver1.findElement(By.xpath("//div//button[text()='Proceed']")).click();
	}
}
