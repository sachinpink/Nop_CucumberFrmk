package com.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersPage
{
	public WebDriver driver;
	
	public CustomersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@href='/Admin/Customer/Create']")
	WebElement AddNewCustomer_link;
	
	@FindBy(xpath="//input[@id='SearchFirstName']")
	WebElement firstName_txt ;
	
	@FindBy(xpath="//button[@id='search-customers']")
	WebElement search_button;
	
	public  void clickOnAddnewCust()
	{
		AddNewCustomer_link.click();
	}
		
	public void enterFirstName(String name)
	{
		firstName_txt.sendKeys(name);
	}
	public void clickOnSearch()
	{
		search_button.click();
	}
	
	public String getDisplyedcustomer()
	{
		WebElement customers=driver.findElement(By.xpath("//table/tbody/tr/td[3]"));
		String custName=customers.getText();
		return custName;
	}
}


