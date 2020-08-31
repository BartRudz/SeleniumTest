package tutorialSelenium;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageClasses.SearchPageFactory;

public class FrameworkTest {
	private WebDriver driver;
	private String baseURL;
	SearchPageFactory searchPage;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseURL = "https://www.fly4free.pl/";
		
		searchPage = new SearchPageFactory(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseURL);
		searchPage.expandSearchBox();
		searchPage.setDepartureAirport("London");
		Thread.sleep(1000);
		searchPage.setArrivalAirport("Warsaw");
		Thread.sleep(1000);
		searchPage.setDepartureDate(26);
		searchPage.setArrivalDate(28);
		Thread.sleep(1000);
		searchPage.clickSearchBtn();
		
	}

	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		
	}
}
