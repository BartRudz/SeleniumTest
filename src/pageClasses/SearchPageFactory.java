package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageFactory {
	WebDriver driver;
	
	@FindBy(xpath="//a[@href='https://kayak.fly4free.pl/']")
	WebElement flightsTab;
	
	@FindBy(xpath="//a[@href='https://www.fly4free.pl/forum/']")
	WebElement forum;
	
	@FindBy(xpath="//a[@href='https://spolecznosc.fly4free.pl/']")
	WebElement travelReports;
	
	@FindBy(xpath="//a[@href='/tanie-loty/promocje/']")
	WebElement cheapFlights;
	
	@FindBy(xpath="//a[@href='/o-nas/']")
	WebElement aboutUs;
	
	@FindBy(xpath="//a[@href='/kontakt/']")
	WebElement contactUs;
	
	@FindBy(xpath="//a[@href='polityka-prywatnosci/']")
	WebElement privacy;
	
	@FindBy(xpath="//a[@href='/kodeks-dobrych-praktyk/']")
	WebElement guide;
	
	@FindBy(id="tr_0_d")
	WebElement departAiport;
	
	@FindBy(id="tr_0_a")
	WebElement arrivalAirport;
	
	@FindBy(id="tr_0_dd")
	WebElement departureDate;
	
	@FindBy(id="tr_1_dd")
	WebElement arrivalDate;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement searchBtn;
	
	@FindBy(xpath="//div[@class='search__expand']")
	WebElement expandBtn;
	
	public SearchPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	public void expandSearchBox() {
		expandBtn.click();
	}
	
	public void clickSearchBtn() {
		searchBtn.click();
	}
	
	public void setDepartureAirport(String departure) {
		departAiport.sendKeys(departure);
	}
	
	public void setArrivalAirport(String arrival) {
		arrivalAirport.sendKeys(arrival);
	}
	
	public void setDepartureDate(int day) {
		departureDate.click();
		driver.findElement(By.xpath("//div[@class='SBCSS-calendar-container-start SBCSS-flights SBCSS-open']//table[@class='SBCSS-calendar'][position()=1]//td[text()=" + day + "]")).click();
	}
	
	public void setArrivalDate(int day) {
		arrivalDate.click();
		driver.findElement(By.xpath("//div[@class='SBCSS-calendar-container-end SBCSS-flights SBCSS-open']//table[@class='SBCSS-calendar'][position()=1]//td[text()=" + day + "]")).click();	
	}
	
	public void clickFlightsTab() {
		flightsTab.click();
	}
	
	public void clickForum() {
		forum.click();
	}
}
