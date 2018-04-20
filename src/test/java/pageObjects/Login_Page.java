package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page {
	// WebElement login_element=null;

	public WebElement txtbx_UserName(WebDriver driver) {
		// TODO Auto-generated method stub
		return driver.findElement(By.xpath("//div[@class='form-group']//input[@type='email']"));
	}

	public WebElement txtbx_Password(WebDriver driver) {
		// TODO Auto-generated method stub
		return driver.findElement(By.xpath("//input[@type='password']"));
	}

	public WebElement btn_LogIn(WebDriver driver) {
		// TODO Auto-generated method stub
		return driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'Login')]"));
	}

}
