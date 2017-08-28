package automationFramework;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageObjects.Home_Page;
import pageObjects.Login_Page;
import utility.Constant;
import utility.ExcelUtils;

public class TestCases {
	public static WebDriver driver = null;

	public int User_cell_num;
	public int Password_cell_num;
	public int MessageDisplay_cell_num;
	static String result;
	int index_var = 0;

	public static Logger log = Logger.getLogger(TestCases.class.getName());

	@BeforeSuite
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", "C:/Users/dkeshav/workspace/selenium/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		log.info("Current browser is" + driver.getClass());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {// Load excel file
			ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User_cell_num = ExcelUtils.getCellNum("sheet1", "Username");
		Password_cell_num = ExcelUtils.getCellNum("sheet1", "Password");
		MessageDisplay_cell_num = ExcelUtils.getCellNum("sheet1", "Message Displayed");
	}

	@Test(priority = 0)
	public void InvalidUsername() throws Exception {
		// Launch website
		driver.get(Constant.URL);

		Home_Page.lnk_MyAccount(driver).click();
		Thread.sleep(2000);

		Home_Page.lnk_Login(driver).click();

		Thread.sleep(2000);
		String username = ExcelUtils.Row.getCell(User_cell_num).getStringCellValue();
		log.info("username :" + username);
		Login_Page.txtbx_UserName(driver).sendKeys(username);

		String password = ExcelUtils.Row.getCell(Password_cell_num).getStringCellValue();
		log.info("password :" + password);
		Login_Page.txtbx_Password(driver).sendKeys(password);

		Thread.sleep(2000);

		Login_Page.btn_LogIn(driver).click();
		System.out.println("Login is pressed: " + Login_Page.btn_LogIn(driver).isSelected());
		Thread.sleep(2000);

		result = driver.findElement(By.xpath("//*[@id='loginfrm']/div[1]/div")).getText();
		log.info("result :" + result);
		// set excel cell
		ExcelUtils.setCellData(result, index_var, MessageDisplay_cell_num);
		// ExcelUtils.Cell = ExcelUtils.Row.getCell(MessageDisplay_cell_num);
		// ExcelUtils.Cell.setCellValue(result);
		Assert.assertEquals(result, "Invalid Email or Password");
	}

	@Test(priority = 1)
	public void InvalidPassword() throws Exception {
		driver.get(Constant.URL);
		Home_Page.lnk_MyAccount(driver).click();
		Thread.sleep(4000);

		Home_Page.lnk_Login(driver).click();

		Thread.sleep(4000);
		String username = ExcelUtils.Row.getCell(User_cell_num).getStringCellValue();
		Login_Page.txtbx_UserName(driver).sendKeys(username);

		String password = ExcelUtils.Row.getCell(Password_cell_num).getStringCellValue();
		Login_Page.txtbx_Password(driver).sendKeys(password);
		// Login_Page.txtbx_UserName(driver).sendKeys("user@phptravels.com");
		// Login_Page.txtbx_Password(driver).sendKeys(" ");
		Thread.sleep(2000);

		Login_Page.btn_LogIn(driver).click();
		Thread.sleep(2000);

		result = driver.findElement(By.xpath("//*[@id='loginfrm']/div[1]/div")).getText();

		System.out.println(result);

		ExcelUtils.setCellData(result, index_var, MessageDisplay_cell_num);

		Assert.assertEquals(result, "Invalid Email or Password");
	}

	@Test(priority = 2)
	public void InvalidUserPass() throws Exception {
		driver.get(Constant.URL);
		Home_Page.lnk_MyAccount(driver).click();
		Thread.sleep(4000);

		Home_Page.lnk_Login(driver).click();

		Thread.sleep(4000);
		String username = ExcelUtils.Row.getCell(User_cell_num).getStringCellValue();
		Login_Page.txtbx_UserName(driver).sendKeys(username);

		String password = ExcelUtils.Row.getCell(Password_cell_num).getStringCellValue();
		Login_Page.txtbx_Password(driver).sendKeys(password);
		// Login_Page.txtbx_UserName(driver).sendKeys(" ");
		// Login_Page.txtbx_Password(driver).sendKeys(" ");
		Thread.sleep(2000);

		Login_Page.btn_LogIn(driver).click();
		Thread.sleep(2000);

		result = driver.findElement(By.xpath("//*[@id='loginfrm']/div[1]/div")).getText();
		System.out.println(result);

		ExcelUtils.setCellData(result, index_var, MessageDisplay_cell_num);

		Assert.assertEquals(result, "Invalid Email or Password");
	}

	@Test(priority = 3)
	public void ValidCredential() throws Exception {
		driver.get(Constant.URL);
		Home_Page.lnk_MyAccount(driver).click();
		Thread.sleep(4000);

		Home_Page.lnk_Login(driver).click();

		Thread.sleep(4000);
		String username = ExcelUtils.Row.getCell(User_cell_num).getStringCellValue();
		Login_Page.txtbx_UserName(driver).sendKeys(username);

		String password = ExcelUtils.Row.getCell(Password_cell_num).getStringCellValue();
		Login_Page.txtbx_Password(driver).sendKeys(password);
		// Login_Page.txtbx_UserName(driver).sendKeys("user@phptravels.com");
		// Login_Page.txtbx_Password(driver).sendKeys("demouser");
		Thread.sleep(2000);

		Login_Page.btn_LogIn(driver).click();
		Thread.sleep(3000);

		result = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/h3")).getText();
		System.out.println(result);

		ExcelUtils.setCellData(result, index_var, MessageDisplay_cell_num);

		Assert.assertEquals(result, "Hi, John Smith");

	}

	@BeforeMethod
	public void AssertResult() {
		// System.out.println("After Test in method");
		if (index_var <= ExcelUtils.ExcelWSheet.getLastRowNum()) {
			index_var++;
			ExcelUtils.Row = ExcelUtils.ExcelWSheet.getRow(index_var);
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}

// @Parameters({ "browser" })
// @BeforeTest
// public void launchapp(String browser) throws MalformedURLException {
//
// System.setProperty("webdriver.gecko.driver",
// "C:/Users/dkeshav/workspace/selenium/drivers/geckodriver.exe");
// driver = new FirefoxDriver();
// log.info("Current browser is" + driver.getClass());
// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// if (browser.equalsIgnoreCase("firefox")) {
// log.info("Executing on FireFox");
// // String Node = "http://10.188.11.52:8082/wd/hub";
// // DesiredCapabilities cap = DesiredCapabilities.firefox();
// // cap.setBrowserName("firefox");
// // driver = new RemoteWebDriver(new URL(Node), cap);
// // Puts an Implicit wait, Will wait for 10 seconds before throwing
// // exception
//
// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
// }
// // else if (browser.equalsIgnoreCase("chrome")) {
// // System.out.println(" Executing on CHROME");
// // DesiredCapabilities cap = DesiredCapabilities.chrome();
// // cap.setBrowserName("chrome");
// // String Node = "http://10.188.11.52:5555/wd/hub";
// // driver = new RemoteWebDriver(new URL(Node), cap);
// // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// // }
// // else if (browser.equalsIgnoreCase("ie"))
// // {
// // System.out.println(" Executing on IE");
// // DesiredCapabilities cap = DesiredCapabilities.chrome();
// // cap.setBrowserName("ie");
// // String Node = "http://10.112.66.52:5558/wd/hub";
// // driver = new RemoteWebDriver(new URL(Node), cap);
// // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// //
// // }
// // else {
// // throw new IllegalArgumentException("The Browser Type is Undefined");
// // }
// }
