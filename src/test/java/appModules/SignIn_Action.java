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
		Thread.sleep(3000);
		Home_Page hp = new Home_Page(driver);
		hp.lnk_MyAccount.click();

		hp.lnk_Login.click();
		
		Login_Page lp = new Login_Page(driver);
		lp.txtbx_UserName.sendKeys(sUserName);
		lp.txtbx_Password.sendKeys(sPassword);
		
		lp.btn_LogIn.click();
		Thread.sleep(6000);
	}

}