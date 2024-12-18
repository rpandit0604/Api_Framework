package FLight;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class dynamicDropdown {

	
	@Test
	public static void wikiDynamic() throws InterruptedException
	{
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		
		//locate element and type any keyword
		WebElement searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys("Selenium");
        Thread.sleep(2000);
		
        //capture all dynamic suggestion in list
        List<WebElement> suggestion = driver.findElements(By.xpath("//div[@class='suggestions-results']//a"));
        
        
        // Search for a specific suggestion
        String search = "Selenium (software)";
        boolean found = false;

        for (WebElement w: suggestion) {
            if (w.getText().toLowerCase().contains(search.toLowerCase())) {
                found = true;
                w.click(); // Click on the option
                break;
            }
        }

        // Print result
        if (found) 
        {
            System.out.println(search + " is present in the suggestions.");
        } else 
        {
            System.out.println(search + " is NOT present in the suggestions.");
        }

		
	}
}