package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	//private static WebElement element = null;
	public Home_Page(WebDriver driver) {
		this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
	}

	
	
	WebDriver driver;
	
	@FindBy(xpath="//ul[@class='nav navbar-nav navbar-right']//ul[@class='nav navbar-nav navbar-side navbar-right sidebar go-left']//li[@id='li_myaccount']")
	public WebElement lnk_MyAccount;
	//click on my account
	
	@FindBy(xpath="//html//nav[@class='navbar navbar-default']//li[@id='li_myaccount']//li[1]/a[1]")
	public WebElement lnk_Login;		
	
	@FindBy(xpath="//div[@id='select2-drop']//div[@class='select2-search']//input[@type='text']")
	public WebElement hotel_city;
	
	@FindBy(xpath="//div[@id='dpd1']//div[@class='row']//input[@type='text']")
	public WebElement check_In_Date;
	
	
	@FindBy(xpath="//div[@id='dpd2']//div[@class='row']//input[@type='text']")
	public WebElement check_Out_Date;
		
	@FindBy(xpath="//div[@id='dpd2']//div[@class='row']//input[@type='text']")
	public WebElement travellers_Input;
		
	@FindBy(xpath="//input[@id='adultInput']")
	public WebElement tra_In_Adult_In;
	
	@FindBy(xpath="//input[@id='childInput']")
	public WebElement tra_In_Child_In;
		
	@FindBy(xpath="//form[@name='fCustomHotelSearch']//div[@class='col-md-2 form-group go-right col-xs-12 search-button']//button[@type='submit']")
	public WebElement search; 
	
	

}
