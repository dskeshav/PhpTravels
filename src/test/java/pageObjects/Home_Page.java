package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_Page {
	//private static WebElement element = null;

	//click on my account
	public WebElement lnk_MyAccount(WebDriver driver) {
		// TODO Auto-generated method stub
		return driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']//ul[@class='nav navbar-nav navbar-side navbar-right sidebar go-left']//li[@id='li_myaccount']"));
	}
	
	public WebElement lnk_Login(WebDriver driver){
		return driver.findElement(By.xpath("//html//nav[@class='navbar navbar-default']//li[@id='li_myaccount']//li[1]/a[1]"));
	}

	// public static WebElement lnk_LogOut(WebDriver driver) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	public WebElement hotel_city(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@id='select2-drop']//div[@class='select2-search']//input[@type='text']"));
	}
	
	public WebElement check_In_Date(WebDriver driver) {
		return driver.findElement((By.xpath("//div[@id='dpd1']//div[@class='row']//input[@type='text']")));
	}
	
	public WebElement check_Out_Date(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@id='dpd2']//div[@class='row']//input[@type='text']"));
	}
	
	public WebElement travellers_Input(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@id='dpd2']//div[@class='row']//input[@type='text']"));
	}
	
	public WebElement tra_In_Adult_In(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='adultInput']"));
	}
	public WebElement tra_In_Child_In(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='childInput']"));
	}
	
	public WebElement search(WebDriver driver) {
		return driver.findElement(By.xpath("//form[@name='fCustomHotelSearch']//div[@class='col-md-2 form-group go-right col-xs-12 search-button']//button[@type='submit']"));
	}
	
	
	public WebElement flights(WebDriver driver) {
		return driver.findElement(By.xpath(""));
	}

}
