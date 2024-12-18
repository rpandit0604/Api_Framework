package FLight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class staticDropdown {

	@Test
	public static void wikiStatic()
	{
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		
		//locate the element
		WebElement dropdown = driver.findElement(By.id("searchLanguage"));
		
        Select select = new Select(dropdown);

        // Search for a specified option 
        String search = "Deutsch"; 
        boolean found = false;

        // Check if the option is present in the dropdown
        for (WebElement w : select.getOptions()) 
        {
            if (w.getText().equals(search))
            {
                found = true;
                break;
            }
        }

        // Print result:
        if (found) 
        {
            System.out.println(search + " is present in the dropdown.");
        }
        else
        {
            System.out.println(search + " is NOT present in the dropdown.");
        }
		
		
	}
}
