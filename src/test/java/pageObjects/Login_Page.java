package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page {
	// WebElement login_element=null;

	public static WebElement txtbx_UserName(WebDriver driver) {
		// TODO Auto-generated method stub

		return driver.findElement(By.xpath(".//*[@id='loginfrm']/div[4]/div/div[1]/input"));
	}

	public static WebElement txtbx_Password(WebDriver driver) {
		// TODO Auto-generated method stub
		return driver.findElement(By.xpath(".//*[@id='loginfrm']/div[4]/div/div[2]/input"));
	}

	public static WebElement btn_LogIn(WebDriver driver) {
		// TODO Auto-generated method stub
		return driver.findElement(By.xpath(".//*[@class='btn btn-action btn-block loginbtn']"));
	}

}
