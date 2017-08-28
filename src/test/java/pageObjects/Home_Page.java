package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_Page {
	//private static WebElement element = null;

	//click on my account
	public static WebElement lnk_MyAccount(WebDriver driver) {
		// TODO Auto-generated method stub
		return driver.findElement(By.xpath("html/body/div[2]/div/div/div[2]/ul/li[2]/a"));
	}
	
	public static WebElement lnk_Login(WebDriver driver){
		return driver.findElement(By.linkText("Login"));
	}

	// public static WebElement lnk_LogOut(WebDriver driver) {
	// // TODO Auto-generated method stub
	// return null;
	// }

}
