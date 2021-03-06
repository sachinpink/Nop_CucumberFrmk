package com.StepDefinations;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Pages.AddNewCustomerPage;
import com.Pages.AddNewProductPage;
import com.Pages.CustomersPage;
import com.Pages.HomePage;
import com.Pages.LoginPage;
import com.Pages.ProductsPage;
import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import utilites.ConfigFileReader;


public class StepDeifination
{
	 public WebDriver driver;
	 public LoginPage lp;
	 public HomePage hp;
	 public CustomersPage cust;
	 public AddNewCustomerPage addcust;
	 public ProductsPage product;
	 public AddNewProductPage addNewProdt;
	 public static Logger log;
	 public ConfigFileReader reader;
	 
	 @Before
	 public void setup()
	 {
		 //log4j - used getLogger method of Logger class
		 log=Logger.getLogger("Nop Cucumber");
		 
		 //log4j- specified the location log4j properties file
		 PropertyConfigurator.configure("log4j.properties"); 
		 
		 //creating object "reader" of ConfigFilereader class to read config.properties file
		  reader= new ConfigFileReader();
		 
			if(reader.getBrowser().equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
				driver= new ChromeDriver();
			}
			else if(reader.getBrowser().equals("firefox"))
			{
				
				//System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
				driver = new FirefoxDriver();
			}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 }
	
	// ------------------Login function  ------------------------------------------------
	 
	 @Given("^User is on Login Page$")
	 public void user_is_on_Login_Page() throws Throwable
	{
		 driver.get(reader.getURL());
 	    //driver.get("https://admin-demo.nopcommerce.com/");
	    //System.out.println("browser launched");
	    log.info("browser launched");
	}

	@When("^User enters UserName and Password and click on login$")
    public void user_enters_UserName_and_Password_and_click_on_login() throws Throwable 
	{
	    lp = new LoginPage(driver);
	    log.info("entering user name and password");
	    
		lp.login();
		
		log.info("clicking on login button");
		
		// It used add log in extend report
		Reporter.addStepLog("entered user name and password and clicked on login");
		
	}

	@Then("^user should Login Successfully$")
	public void user_should_Login_Successfully() throws Throwable
	{
		log.info("checking user name and printing it");
		Assert.assertEquals(lp.userName(), "John Smith");
		System.out.println("User Name is "+ lp.userName());
		log.info("closing the browser");
		
	}
	
	// ------------------Add customer Scenario ------------------------------------------------
	
	@Given("^User on home page$")
	public void user_on_home_page() throws Throwable 
	{   log.info("opening browser and navigating to app");
	
        driver.get(reader.getURL());
	    lp = new LoginPage(driver);
	    log.info("entering login credentials and clicking login button");
		lp.login();   
	}

	@When("^user click on Customers dropdown link$")
	public void user_click_on_Customers_dropdown_link() throws Throwable 
	{
		hp=new HomePage(driver);
		Thread.sleep(9000);
		log.info("clicking on Customers menu");
		hp.ClickonCustomerMenu();
	}

	@When("^User click on Customers link$")
	public void user_click_on_Customers_link() throws Throwable
	{
		log.info("clicking on Customers link");
		hp.clickOnCustomerLink();
	}

	@When("^User click on AddNew link$")
	public void user_click_on_AddNew_link() throws Throwable
	{
	  cust= new CustomersPage(driver);
	  log.info("clicking on Add new customer button");
	  cust.clickOnAddnewCust();
	}

	@When("^User fill Customer info and click on save button$")
	public void user_fill_Customer_info_and_click_on_save_button() throws Throwable
	{
		  addcust = new AddNewCustomerPage(driver);
		  log.info("filling customer details");
		  addcust.setEmailId();
		  addcust.setPasword();
		  addcust.setName();
		  addcust.setLastName();
		  addcust.setGender("Male");
		  addcust.setDOB("November 2018", "7");
		  addcust.setCompanyName();
		  addcust.setAdmincomment();
		  log.info("clicking on save button");
		  addcust.clickonSavebtn();
	}

	@Then("^messge should be displayed as Customer added sucessfully$")
	public void messge_should_be_displayed_as_Customer_added_sucessfully() throws Throwable
	{
		log.info("checking confirmation message");
		
		if(addcust.verifyCustAddStatus()==true)
		{
			System.out.println("new customer has been added");
			
			//Assert.assertEquals(addcust.verifyCustAddStatus(),"The new customer has been added successfully.");

		}
		else
		{
			System.out.println("user already registred");
		}
		
		
	}
	

	// ------------------Search customer Scenario ------------------------------------------------
	
	@When("^Enter name to search customer$")
	public void enter_name_to_search_customer() throws Throwable 
	{
		hp=new HomePage(driver);
		Thread.sleep(5000);
		log.info("clicking on customer menu");
		hp.ClickonCustomerMenu();
		log.info("clicking on customer link");
		hp.clickOnCustomerLink();
		cust = new CustomersPage(driver);
		log.info("entering name to search");
	    cust.enterFirstName("John");
	}

	@When("^Click on search button$")
	public void click_on_search_button() throws Throwable 
	{
		log.info("clicking on search button");
	    cust.clickOnSearch();
	    Thread.sleep(3000);
	}

	@Then("^Customer list should be displayed in table$")
	public void customer_list_should_be_displayed_in_table() throws Throwable
	{
		log.info("Checking customer name is displayed in table");
	   String name=cust.getDisplyedcustomer();
	   Assert.assertTrue(name.contains("John"));
	   
	}
	
	//-------- Add new products --------------------------
	
	@When("^User click on Catlog Menu$")
	public void user_click_on_Catlog_Menu() throws Throwable 
	{
		hp=new HomePage(driver);
		log.info("clicking on catlog menu");
	    hp.clickonCatlogMenu();
	}

	@When("^User click on products link$")
	public void user_click_on_products_link() throws Throwable
	{
		log.info("clicking on product link");
	    hp.clickonProductLink();
	}

	@When("^User click on Add new button$")
	public void user_click_on_Add_new_button() throws Throwable
	{
		product= new ProductsPage(driver);
		log.info("clicking on add new button ");
		product.clickOnAddNew();
	}

	@When("^User fill the product details$")
	public void user_fill_the_product_details() throws Throwable
	{
		addNewProdt= new AddNewProductPage(driver);
		addNewProdt.clickonProductInfo();
		log.info("entering product name");
		//addNewProdt.setProductName();
		log.info("entering short description of product");
		addNewProdt.setShortDesc();
		log.info("entering full description of product");
		addNewProdt.setFullDesc();
		log.info("clicking on save button");
		addNewProdt.clickOnSave();	
	}

	@Then("^confirmation message should be displyed$")
	public void confirmation_message_should_be_displyed() throws Throwable
	{
		Assert.assertTrue(addNewProdt.getConfirmationMsg().contains("The new product has been added successfully.")); 
		log.info("product added sussesfully");
	}


	@After(order=1)
	public void takeScreenShot(Scenario scenario) throws IOException 
	{
	    if (scenario.isFailed())
	    {
	      File  screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	      FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir")+"//ScreenShots//"+scenario.getName()+".jpg"));
	    }
	}
	@After(order=0)
	public void close()
	{
		driver.close();
	}

}
