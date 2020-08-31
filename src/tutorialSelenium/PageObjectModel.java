package tutorialSelenium;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageClasses.SearchPage;

public class PageObjectModel {
	private WebDriver driver;
	private String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseURL = "https://www.fly4free.pl";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	
	@Test
	public void test() throws InterruptedException {
		driver.get(baseURL);
		SearchPage.clickOnExpandButton(driver);
		Thread.sleep(2000);
		SearchPage.originTextBox(driver).sendKeys("Stockholm");
		Thread.sleep(2000);
		SearchPage.destinationTextBox(driver).sendKeys("London");
		Thread.sleep(1000);
		SearchPage.departureDateTextBox(driver, 15);
		Thread.sleep(1000);
		SearchPage.returnDateTextBox(driver, 25);
		Thread.sleep(1000);
		SearchPage.clickOnSearchButton(driver);
		
		
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
	//	driver.quit();
	}


}
