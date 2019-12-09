package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilites.WaitHelper;

public class HomePage 
{
	public WebDriver driver;
	public WaitHelper wait;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span[contains(text(),'Customers')]/ancestor::a[1]")
	WebElement Customers_Menu;
	
	@FindBy(xpath="//a[@href='/Admin/Customer/List']")
	WebElement Customer_Link;
	
	@FindBy(xpath="//span[contains(text(),'Sales')]")
	WebElement Sales_Menu;

	public void ClickonCustomerMenu()
	{
		wait= new WaitHelper(driver);
		wait.waitForElement(Customers_Menu);
		Customers_Menu.click();
	}
	public void clickOnCustomerLink()
	{
		wait.waitForElement(Customer_Link);
		Customer_Link.click();
	}
	
	public void clickonSalesMenu()
	{
		Sales_Menu.click();
	}
}

