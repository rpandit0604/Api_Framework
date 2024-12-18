package FLight;
import java.time.Duration;
import java.util.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class MMTT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize(); //window maximize
				driver.get("https://www.makemytrip.com/");//get  url
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
//		      Use Actions to move to the coordinates and click
				int x = 1204; // X-coordinate
		        int y = 178; // Y-coordinate
		         Actions actions = new Actions(driver);
		         actions.moveByOffset(x, y).click().perform();
		 
		         //Enter FROM Name :: Delhi
				driver.findElement(By.id("fromCity")).click();
				driver.findElement(By.cssSelector("input[placeholder='From']")).sendKeys("Del");
				List<WebElement> sourceElements = driver.findElements(By.xpath("//ul/li[contains(@id,\"react-autowhatever-1-section\")]/div/div/p/span[contains(@class,'makeFlex flexOne spaceBetween')]"));
				for(WebElement sourceElement: sourceElements) {
					if(sourceElement.getText().equalsIgnoreCase("New Delhi")) {
						sourceElement.click();	
					}
					break;
				}
				//Enter Destination name :: Mumbai
						driver.findElement(By.id("toCity")).click();
						driver.findElement(By.cssSelector("input[placeholder='To']")).sendKeys("Mum");
						List<WebElement> destinationElements = driver.findElements(By.xpath("//ul/li[contains(@id,\"react-autowhatever-1-section\")]/div/div/div/div/div/p"));
						for(WebElement destElement: destinationElements) {
							if(destElement.getText().equalsIgnoreCase("Mumbai, India")) {
								destElement.click();
							}
							break;
						}
						
							
//		 				Selecting Departure Date
						driver.findElement(By.xpath("(//div[@class='dateInnerCell']/p[text()='14'])[1]")).click();
						
//		 		 		Selecting Travells and class
						driver.findElement(By.cssSelector("span[class='lbl_input appendBottom5']")).click();
						
//		 				Select two adults
						driver.findElement(By.xpath("//ul/li[@data-cy='adults-2']")).click();
						
//		 				To scroll page
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("window.scrollBy(900, 640);");
						
						System.out.println("hero");
						
//		 				Choose Travel class
						driver.findElement(By.xpath("//ul/li[text()='Premium Economy']")).click();
						
//		 				Apply changes according to User
						driver.findElement(By.cssSelector(".btnApply")).click();
						
						WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
//		 				Finding flights from Delhi to Mumbai
						WebElement w= wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".primaryBtn"))));
								
						w.click();
						
						System.out.println("Successfully...");
						}
		}
	


