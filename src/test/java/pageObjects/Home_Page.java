package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_Page {
	//private static WebElement element = null;

	//click on my account
	public WebElement lnk_MyAccount(WebDriver driver) {
		// TODO Auto-generated method stub
		return driver.findElement(By.xpath("//div[@class='col-md-6 col-sm-8 col-xs-5 go-left']//ul[@class='nav navbar-nav navbar-side navbar-right sidebar go-left']//li[@id='li_myaccount']//a[@href='javascript:void(0);']"));
	}
	
	public WebElement lnk_Login(WebDriver driver){
		return driver.findElement(By.xpath("//html//div[@class='tbar-top hidden-sm hidden-xs']//li[@id='li_myaccount']//li[1]/a[1]"));
	}

	// public static WebElement lnk_LogOut(WebDriver driver) {
	// // TODO Auto-generated method stub
	// return null;
	// }

}
