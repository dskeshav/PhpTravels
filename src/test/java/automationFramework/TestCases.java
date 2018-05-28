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
	public int Result_cell_num;
	static String result;

	int index_var = 0;

	public static Logger log = Logger.getLogger(TestCases.class.getName());

	@BeforeSuite
	public void beforeTest() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",
				"E:\\keshav\\PhpTravels\\src\\test\\resource\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		log.info("Current browser is" + driver.getClass());
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try {// Load excel file
			ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(3000);
		User_cell_num = ExcelUtils.getCellNum("sheet1", "Username");
		Password_cell_num = ExcelUtils.getCellNum("sheet1", "Password");
		MessageDisplay_cell_num = ExcelUtils.getCellNum("sheet1", "Message Displayed");
		Result_cell_num = ExcelUtils.getCellNum("sheet1", "Result");
	}

	@Test(priority = 0)
	public void InvalidUsername() throws Exception {
		// Launch website
		driver.get(Constant.URL);
		Home_Page hp = new Home_Page();
		hp.lnk_MyAccount(driver).click();

		hp.lnk_Login(driver).click();

		Thread.sleep(4000);
		String username = ExcelUtils.Row.getCell(User_cell_num).getStringCellValue();

		log.info("username :" + username);
		Login_Page lp = new Login_Page();
		lp.txtbx_UserName(driver).sendKeys(username);

		String password = ExcelUtils.Row.getCell(Password_cell_num).getStringCellValue();
		log.info("password :" + password);
		lp.txtbx_Password(driver).sendKeys(password);

		// Thread.sleep(2000);

		lp.btn_LogIn(driver).click();

		result = driver.findElement(By.xpath("//div[@class='resultlogin']/div[@class='alert alert-danger']")).getText();

		Assert.assertEquals(result, "Invalid Email or Password");

		// set excel cell
		ExcelUtils.setCellData(result, index_var, MessageDisplay_cell_num);
		ExcelUtils.Cell = ExcelUtils.Row.getCell(MessageDisplay_cell_num);
		ExcelUtils.Cell.setCellValue(result);

		if (result == "Invalid Email or Password") {
			ExcelUtils.setCellData("Pass", index_var, Result_cell_num);
			ExcelUtils.Cell = ExcelUtils.Row.getCell(Result_cell_num);
			ExcelUtils.Cell.setCellValue("Pass");
		}
	}

	@Test(priority = 1)
	public void InvalidPassword() throws Exception {
		driver.get(Constant.URL);
		Home_Page hp = new Home_Page();

		hp.lnk_MyAccount(driver).click();

		Thread.sleep(2000);
		hp.lnk_Login(driver).click();

		Thread.sleep(4000);
		String username = ExcelUtils.Row.getCell(User_cell_num).getStringCellValue();
		Login_Page lp = new Login_Page();
		lp.txtbx_UserName(driver).sendKeys(username);
		log.info("username :" + username);

		String password = ExcelUtils.Row.getCell(Password_cell_num).getStringCellValue();
		lp.txtbx_Password(driver).sendKeys(password);

		lp.btn_LogIn(driver).click();
		Thread.sleep(2000);

		result = driver.findElement(By.xpath("//div[@class='resultlogin']/div[@class='alert alert-danger']")).getText();

		System.out.println(result);

		ExcelUtils.setCellData(result, index_var, MessageDisplay_cell_num);

		Assert.assertEquals(result, "Invalid Email or Password");
	}

	@Test(priority = 2)
	public void InvalidUserPass() throws Exception {
		driver.get(Constant.URL);
		Home_Page hp = new Home_Page();

		hp.lnk_MyAccount(driver).click();
		hp.lnk_Login(driver).click();

		Thread.sleep(2000);
		Login_Page lp = new Login_Page();
		String username = ExcelUtils.Row.getCell(User_cell_num).getStringCellValue();
		lp.txtbx_UserName(driver).sendKeys(username);
		log.info("username :" + username);

		String password = ExcelUtils.Row.getCell(Password_cell_num).getStringCellValue();
		lp.txtbx_Password(driver).sendKeys(password);

		lp.btn_LogIn(driver).click();
		Thread.sleep(2000);

		result = driver.findElement(By.xpath("//div[@class='resultlogin']/div[@class='alert alert-danger']")).getText();
		System.out.println(result);

		ExcelUtils.setCellData(result, index_var, MessageDisplay_cell_num);

		Assert.assertEquals(result, "Invalid Email or Password");
	}

	@Test(priority = 3)
	public void ValidCredential() throws Exception {
		driver.get(Constant.URL);
		Home_Page hp = new Home_Page();
		hp.lnk_MyAccount(driver).click();

		Thread.sleep(2000);
		hp.lnk_Login(driver).click();

		Thread.sleep(2000);
		String username = ExcelUtils.Row.getCell(User_cell_num).getStringCellValue();
		Login_Page lp = new Login_Page();
		lp.txtbx_UserName(driver).sendKeys(username);
		log.info("username :" + username);

		String password = ExcelUtils.Row.getCell(Password_cell_num).getStringCellValue();
		lp.txtbx_Password(driver).sendKeys(password);

		Thread.sleep(2000);

		lp.btn_LogIn(driver).click();
		Thread.sleep(5000);

		result = driver.findElement(By.xpath("//h3[@class='RTL']")).getText();
		System.out.println(result);

		ExcelUtils.setCellData(result, index_var, MessageDisplay_cell_num);

		Assert.assertEquals(result, "Hi, Johny Smith");
		Thread.sleep(6000);
	}

	@Test(priority = 4)
	public void logout() throws InterruptedException {
//		driver.get(Constant.URL);
//		Home_Page hp = new Home_Page();
//
//		hp.lnk_MyAccount(driver).click();
//		Thread.sleep(2000);
//		hp.lnk_Login(driver).click();
//		Thread.sleep(2000);
		//Login_Page lp = new Login_Page();
//
//		lp.txtbx_UserName(driver).sendKeys("user@phptravels.com");
		// log.info("username :" + username);

		// String password =
		// ExcelUtils.Row.getCell(Password_cell_num).getStringCellValue();
		//lp.txtbx_Password(driver).sendKeys("demouser");

		//lp.btn_LogIn(driver).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//*[@id=\"collapse\"]/ul[2]/ul/li[1]/a"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"collapse\"]/ul[2]/ul/li[1]/ul/li[2]/a")).click();

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
