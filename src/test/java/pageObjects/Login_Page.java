package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	WebDriver driver;

	public Login_Page(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='form-group']//input[@type='email']")
	public WebElement txtbx_UserName;

	@FindBy(xpath = "//input[@type='password']")
	public WebElement txtbx_Password;

	@FindBy(xpath="//button[@type='submit'][contains(text(),'Login')]")
	public WebElement btn_LogIn;
	
}
