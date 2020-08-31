package tutorialSelenium;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FindLinks {
	private WebDriver driver;
	private String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseURL = "https://www.fly4free.pl/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	
	@Test
	public void test() {
		driver.get(baseURL);
		 List<WebElement> linksList = clickableLinks(driver);
		 for (WebElement link : linksList) {
			 String href = link.getAttribute("href");
			 try {
				 System.out.println("URL " + href + " is " + linkStatus(new URL(href)));
			 }
			 catch (Exception e) {
				 System.out.println(e.getMessage());
			 }
			 System.out.println("Number of links: " + linksList.indexOf(link));
		 }
		 
	}
	
	public static List<WebElement> clickableLinks(WebDriver driver) {
		List<WebElement> linksToClick = new ArrayList<WebElement>();
		List<WebElement> allElements = driver.findElements(By.tagName("a"));
		allElements.addAll(driver.findElements(By.tagName("img")));
		
		for (WebElement we : allElements) {
			if(we.getAttribute("href") !=null) {
				linksToClick.add(we);
			}
		}
		return linksToClick;
	}
	
	public static String linkStatus(URL url) {
		try {
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.connect();
			String responseMessage = http.getResponseMessage();
			http.disconnect();
			return responseMessage;
		}
		catch (Exception e) {
			return e.getMessage();
		}
	}
	
	
	@After
	public void tearDown() throws Exception {
	}

}
