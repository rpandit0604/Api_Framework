package FLight;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DuplicatesDropdown {
	
	@Test
	public static void duplicate()
	{
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		
		WebElement dropdownElement = driver.findElement(By.id("searchLanguage"));
		Select dropdown = new Select(dropdownElement);
		
		 // Get all dropdown options in list
        List<WebElement> option = dropdown.getOptions();
        
        //Use a Set to store unique values
        Set<String> unique = new HashSet<>();
        
        // Loop through options and add to Set
        for (WebElement w : option) 
        {
            unique.add(w.getText().trim()); // Add text to the Set
        }
        
        //Print unique options
        System.out.println("Unique options in the dropdown:");
        for (String w : unique) 
        {
            System.out.println(w);
        }
		
		
	}
}
	

	