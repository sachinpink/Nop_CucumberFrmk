package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@type='submit' and @value='Log in']")
	WebElement btnLogin;
	
	@FindBy(xpath="//li[contains(text(),'John Smith')]")
	WebElement loggedUserName;
	
	public void login()
	{
		txtEmail.sendKeys("admin@yourstore.com");
		txtPassword.sendKeys("admin");
		btnLogin.click();
		
	}
	
	public String userName()
	{
		 return loggedUserName.getText();
	}
	
	public HomePage homepage()
	{
		return new HomePage(driver);
	}

}
