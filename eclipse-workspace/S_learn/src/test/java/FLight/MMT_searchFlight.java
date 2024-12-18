package FLight;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MMT_searchFlight {

	 @Test
	public void Flight() throws InterruptedException
	{
		
		//ChromeOptions options=new ChromeOptions();
		
		//EdgeOptions options = new EdgeOptions();
	
        //options.addArguments("-inprivate");
        
		//WebDriver driver = new EdgeDriver();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Explicit wait
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//handling cookies
		try {
		    // Wait for the "ACCEPT" button to be visible
		    WebElement cookie = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='ACCEPT']")));
		    cookie.click(); // Click the "ACCEPT" button
		    System.out.println("Cookies consent dismissed successfully.");
		} catch (Exception e) {
		    System.out.println("Cookies consent button not found or not clickable. Exception: " + e.getMessage());
		}
		//driver.navigate().refresh();
		
		//closing the login popup
		

		WebElement popup=  driver.findElement(By.xpath("//span[@class='commonModal__close']"));
		
		try {
			popup.click();
		}
		catch(Exception e)
		{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", popup);
		}	
		
		driver.manage().deleteAllCookies();
		
		
		//fromcity
		driver.findElement(By.xpath("//input[@id='fromCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("DEL");
		
		//with down key i am selecting the city
		Actions actions =new Actions(driver);
		actions.pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform(); 
		System.out.println("FromCity Delhi selected properly");

		
		//tocity
		driver.findElement(By.xpath("//input[@id='toCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("MUM");
		
		//with down key i am selecting the city
		actions.pause(Duration.ofSeconds(3)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		System.out.println("ToCity Mumbai selected properly");
			
		//driver.findElement(By.xpath("//input[@data-cy='departure']")).click();
		
		String date= "Sat Dec 14 2024";
		driver.findElement(By.xpath("//div[@aria-label='"+date+"']")).click();
		System.out.println(date+ ": selected successfully.");
		
		
		WebElement travelClass = driver.findElement(By.xpath("//span[@class='lbl_input appendBottom5']"));
        travelClass.click();
        
        Thread.sleep(2000);
        
        WebElement premiumEconomyOption = driver.findElement(By.xpath("//li[@data-cy='travelClass-1']"));
        premiumEconomyOption.click();
        
        System.out.println("Travel class selected: Premium Economy.");
        
        // Click on Apply button
        WebElement applyButton = driver.findElement(By.xpath("//button[text()='APPLY']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", applyButton);
        System.out.println("Travel class applied successfully.");
        
        
		//click on search
		WebElement search=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(@class,'primaryBtn')] "))));
		search.click();
		System.out.println("search successfully");
		
	
	}

		
	}
	
