package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	
	public static WebElement element = null;
	
	// Return the flight origin text box element
	public static WebElement originTextBox(WebDriver driver) {
		element = driver.findElement(By.id("tr_0_d"));
		return element;
		}
	
	// Return the flight destination text box element
	public static WebElement destinationTextBox(WebDriver driver) {
		element = driver.findElement(By.id("tr_0_a"));
		return element;		
		}
	
	// Return the departure date text box element
	public static void departureDateTextBox(WebDriver driver, int day) {
		element = driver.findElement(By.id("tr_0_dd"));
		element.click();
		element = driver.findElement(By.xpath("//div[@class='SBCSS-calendar-container-start SBCSS-flights SBCSS-open']//table[@class='SBCSS-calendar'][position()=1]//td[text()=" + day + "]"));
		element.click();	
		}
	
	// Return the return date text box element
		public static void returnDateTextBox(WebDriver driver, int day) {
			element = driver.findElement(By.id("tr_1_dd"));
			element.click();
			element = driver.findElement(By.xpath("//div[@class='SBCSS-calendar-container-end SBCSS-flights SBCSS-open']//table[@class='SBCSS-calendar'][position()=1]//td[text()=" + day + "]"));
			element.click();	
		}
		
	// Return the search button element
		public static WebElement searchButton(WebDriver driver) {
			element = driver.findElement(By.xpath("//button[@type='submit']"));
			return element;	
		}
		
		public static void clickOnSearchButton(WebDriver driver) {
			element = searchButton(driver);
			element.click();
		}
		
		// Return click on expand button
		public static void clickOnExpandButton(WebDriver driver) {
			element = driver.findElement(By.xpath("//div[@class='search__expand']"));
			element.click();
		}
		
		

		
		
		
		
		
		
}
