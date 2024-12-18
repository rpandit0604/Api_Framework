package FLight;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MMTtt
{
		    
	public static void main(String[] args) throws InterruptedException
	
	{
		        // Setup ChromeDriver with options
		        ChromeOptions options = new ChromeOptions();
		        options.addArguments("--disable-notifications");
		        WebDriver driver = new ChromeDriver(options);

		        try {
		            // Navigate to MakeMyTrip
		            driver.manage().window().maximize();
		            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		            driver.get("https://www.makemytrip.com/");
		            
		            // Handle potential cookies or initial popups
		            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		            try {
		                WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='ACCEPT']")));
		                cookieButton.click();
		            } catch (Exception e) {
		                System.out.println("Cookie consent button not found.");
		            }
		            
		            try {
		                WebElement popupClose = driver.findElement(By.xpath("//span[@class='commonModal__close']"));
		                popupClose.click();
		            } catch (Exception e) {
		                System.out.println("No initial popup displayed.");
		            }

		            // Enter "From" city: Delhi
		            WebElement fromCity = driver.findElement(By.id("fromCity"));
		            fromCity.click();
		            WebElement fromInput = driver.findElement(By.xpath("//input[@placeholder='From']"));
		            fromInput.sendKeys("DEL");
		            Thread.sleep(2000); // Wait for suggestions to appear
		            new Actions(driver).sendKeys(Keys.ARROW_DOWN, Keys.ENTER).perform();

		            // Enter "To" city: Mumbai
		            WebElement toCity = driver.findElement(By.id("toCity"));
		            toCity.click();
		            WebElement toInput = driver.findElement(By.xpath("//input[@placeholder='To']"));
		            toInput.sendKeys("MUM");
		            Thread.sleep(2000); // Wait for suggestions to appear
		            new Actions(driver).sendKeys(Keys.ARROW_DOWN, Keys.ENTER).perform();

		            // Select Departure Date
		            String date = "Fri Dec 13 2024"; // Example date
		            WebElement dateElement = driver.findElement(By.xpath("//div[@aria-label='" + date + "']"));
		            dateElement.click();

		            // Click on the search button
		            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'primaryBtn')]")));
		            searchButton.click();

		            System.out.println("Flight search completed successfully!");

		        } catch (Exception e) {
		            System.out.println("An error occurred: " + e.getMessage());
		        } finally {
		            // Cleanup
		            Thread.sleep(5000); // Observe the results
		            driver.quit();
		        }
		    }
		

		
		
	}


