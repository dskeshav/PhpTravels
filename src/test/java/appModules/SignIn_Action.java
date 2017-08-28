package appModules;

import org.openqa.selenium.WebDriver;
import pageObjects.Home_Page;
import pageObjects.Login_Page;
import utility.ExcelUtils;

// Now this method does not need any arguments

public class SignIn_Action {

	public SignIn_Action() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void Execute(WebDriver driver) throws Exception {

		// This is to get the values from Excel sheet, passing parameters (Row
		// num &amp; Col num)to getCellData method

		String sUserName = ExcelUtils.getCellDataasString(1, 1);

		String sPassword = ExcelUtils.getCellDataasString(1, 2);
		System.out.println("username:" + sUserName);
		System.out.println("pasword:" + sPassword);
		Thread.sleep(4000);
		Home_Page.lnk_MyAccount(driver).click();
		Thread.sleep(4000);

		Home_Page.lnk_Login(driver).click();

		Thread.sleep(4000);
		// driver.navigate().forward();

		Login_Page.txtbx_UserName(driver).sendKeys(sUserName);

		Login_Page.txtbx_Password(driver).sendKeys(sPassword);
		Thread.sleep(6000);
		Login_Page.btn_LogIn(driver).click();
		

	}

}