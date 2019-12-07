package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage 
{
	public WebDriver driver;
	
	public AddNewCustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@id='Email'][@type='email']")
	WebElement email_txt;
	
	@FindBy(xpath="//input[@id='Password'][@type='password']")
	WebElement password_txt ;
	
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement firstName_txt;
	
	@FindBy(xpath="//input[@id='LastName']")
	WebElement lastName_txt;
	
	@FindBy(xpath="//input[@name='Gender']")
	WebElement Malegender_radio;
	
	@FindBy(xpath="//input[@id='Gender_Male']")
	WebElement femaleGender_radio;
	
	@FindBy(xpath="//input[@id='Company']")
	WebElement companyName_txt;
	
	@FindBy(xpath="//textarea[@id='AdminComment']")
	WebElement adminComment_txt;
	
	@FindBy(xpath="//button[@name='save']")
	WebElement save_btn;
	
	public void setEmailId()
	{
		email_txt.sendKeys("sachin@gmail.com");
	}
	public void setPasword()
	{
		password_txt.sendKeys("123456789");
	}
	public void setName()
	{
		firstName_txt.sendKeys("sachin");
	}
	public void setLastName()
	{
		lastName_txt.sendKeys("zagade");
	}
	
	public void setGender(String gender)
	{
		if(gender.equals("Male"))
		{
			Malegender_radio.click();
		}
		else if(gender.equals("Female"))
		{
			femaleGender_radio.click();
		}
		
	}
	public void setCompanyName()
	{
		companyName_txt.sendKeys("info");
	}
	public void setAdmincomment()
	{
		adminComment_txt.sendKeys("adding new customer");
	}
	
	public void clickonSavebtn()
	{
		save_btn.click();
	}
	
	
	

}
