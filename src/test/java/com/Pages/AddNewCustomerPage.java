package com.Pages;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
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
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissable']")
	WebElement cust_added_msg;
	
	@FindBy(xpath="//span[@class='k-select']")
	WebElement datePicker;
	
	public void setEmailId()
	{
		// here we generating random string apace.lang package 
		
		String random=RandomStringUtils.randomAlphanumeric(5);
		email_txt.sendKeys(random+"@gmail.com");
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
	
	public void setDOB(String MonthYear, String day) throws InterruptedException
	{
		datePicker.click();
		while(true)
		{
			String currentMMYYYY=driver.findElement(By.xpath("//div[@class='k-header']/a[2]")).getText();
			
			//System.out.println(currentMonth);
			
			if(currentMMYYYY.equals(MonthYear))
			{
				break;
			}
			else
			{
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@class='k-header']/a[1]")).click();
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
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
	
	public boolean verifyCustAddStatus()
	{
		return cust_added_msg.isDisplayed();
	}
	
	

}
