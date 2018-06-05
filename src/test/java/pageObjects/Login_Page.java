package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	WebDriver driver;
	public Login_Page(WebDriver driver) {
		this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
	}

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
