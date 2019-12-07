package com.StepDefinations;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Pages.AddNewCustomerPage;
import com.Pages.CustomersPage;
import com.Pages.HomePage;
import com.Pages.LoginPage;

import cucumber.api.java.en.*;


public class StepDeifination
{
	 public WebDriver driver;
	 public LoginPage lp;
	 public HomePage hp;
	 public CustomersPage cust;
	 public AddNewCustomerPage addcust;
	 
	// ------------------Login function  ------------------------------------------------
	 
	 @Given("^User is on Login Page$")
	 public void user_is_on_Login_Page() throws Throwable
	{
		System.setProperty("webdriver.chrome.driver", "E://Selenium//selenium setup//chromedriver_win32//chromedriver.exe ");
	    driver= new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get("https://admin-demo.nopcommerce.com/");
	    System.out.println("browser launched");
	}

	@When("^User enters UserName and Password and click on login$")
    public void user_enters_UserName_and_Password_and_click_on_login() throws Throwable 
	{
	    lp = new LoginPage(driver);
		lp.login();
		System.out.println("entered user name and password and clicked on login");
		
	}

	@Then("^user should Login Successfully$")
	public void user_should_Login_Successfully() throws Throwable
	{
		
		Assert.assertEquals(lp.userName(), "John Smith");
		System.out.println("User Name is "+ lp.userName());
		System.out.println("closed the browser");
		driver.close();
	}
	
	// ------------------Add customer Scenario ------------------------------------------------
	
	@Given("^User on home page$")
	public void user_on_home_page() throws Throwable 
	{
		System.setProperty("webdriver.chrome.driver", "E://Selenium//selenium setup//chromedriver_win32//chromedriver.exe ");
	    driver= new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get("https://admin-demo.nopcommerce.com/");
	    lp = new LoginPage(driver);
		lp.login();   
	}

	@When("^user click on Customers dropdown link$")
	public void user_click_on_Customers_dropdown_link() throws Throwable 
	{
		hp=new HomePage(driver);
		Thread.sleep(9000);
		hp.ClickonCustomerMenu();
	}

	@When("^User click on Customers link$")
	public void user_click_on_Customers_link() throws Throwable
	{
		hp.clickOnCustomerLink();
	}

	@When("^User click on AddNew link$")
	public void user_click_on_AddNew_link() throws Throwable
	{
	  cust= new CustomersPage(driver);
	  cust.clickOnAddnewCust();
	}

	@When("^User fill Customer info and click on save button$")
	public void user_fill_Customer_info_and_click_on_save_button() throws Throwable
	{
		  addcust = new AddNewCustomerPage(driver);
		  addcust.setEmailId();
		  addcust.setPasword();
		  addcust.setName();
		  addcust.setLastName();
		  addcust.setGender("Male");
		  addcust.setCompanyName();
		  addcust.setAdmincomment();
		  addcust.clickonSavebtn();
	}

	@Then("^messge should be displayed as Customer added sucessfully$")
	public void messge_should_be_displayed_as_Customer_added_sucessfully() throws Throwable
	{
	  Assert.assertTrue(driver.getPageSource().contains("Email is already registered")); 
	  System.out.println("user already  registred");
	  Thread.sleep(5000);
	  driver.close();
	}
	
	// ------------------Search customer Scenario ------------------------------------------------
	
	@When("^Enter name to search customer$")
	public void enter_name_to_search_customer() throws Throwable 
	{
		hp=new HomePage(driver);
		Thread.sleep(5000);
		hp.ClickonCustomerMenu();
		hp.clickOnCustomerLink();
		cust = new CustomersPage(driver);
	    cust.enterFirstName("John");
	}

	@When("^Click on search button$")
	public void click_on_search_button() throws Throwable 
	{
	    cust.clickOnSearch();
	    Thread.sleep(3000);
	}

	@Then("^Customer list should be displayed in table$")
	public void customer_list_should_be_displayed_in_table() throws Throwable
	{
	   String name=cust.getDisplyedcustomer();
	   
	   Assert.assertTrue(name.contains("John"));
	   driver.quit();
	}


}
