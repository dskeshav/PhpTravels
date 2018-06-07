package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageObjects.Home_Page;
import utility.Constant;

public class HotelBooking {
	Home_Page hp;
	
	WebDriver driver;
	@BeforeSuite
	public void setup() {
		System.out.println("HotelBooking");
		System.setProperty("webdriver.gecko.driver",
				"E:\\keshav\\PhpTravels\\src\\test\\resource\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	@Test
	public void searchHotel() {
		driver.get(Constant.URL);
		hp.hotel_city.sendKeys("Singapore");
		hp.check_In_Date.sendKeys("08/06/2018");
		hp.check_Out_Date.sendKeys("10/06/2018");
		hp.search.click();
	}
	
	
	@AfterSuite
	public void teardown() {
		System.out.println("HotelBookingteardown");
		driver.quit();
	}
}

