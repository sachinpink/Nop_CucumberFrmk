package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilites.WaitHelper;

public class AddNewProductPage 
{
	public WebDriver driver;
	public WaitHelper wait;
	public AddNewProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Product info')]")
	WebElement productInfo_link;
	
	@FindBy(id="Name")
	WebElement productName_txt;
	
	@FindBy(id="ShortDescription")
	WebElement ShortDescription_txt; 
	
	@FindBy(id="tinymce")
	WebElement fulltDescription_txt;
	
	@FindBy(xpath="//button[@name='save']")
	WebElement save_btn;
	
	public void clickonProductInfo() throws InterruptedException
	{
		if(productName_txt.isDisplayed())
		{
			this.setProductName();
			System.out.println("product name txtbox is displyed ");
	
		}
		else
		{
			System.out.println("product name txtbox is not displyed ");
			productInfo_link.click();
			this.setProductName();
		}
		
	}
	
	public void setProductName() throws InterruptedException
	{
		wait= new WaitHelper(driver);
		wait.waitForElement(productName_txt);
		productName_txt.sendKeys("Dell laptop");	
	}
	
	public void setShortDesc() throws InterruptedException
	{
		ShortDescription_txt.sendKeys("Fun-filled, colorful laptops and 2-in-1s featuring  Intel®");
		
	}
	public void setFullDesc()
	{
		driver.switchTo().frame("FullDescription_ifr");
		fulltDescription_txt.sendKeys("\n 10th Generation Intel® Core™ i5-1035G1 Processor"+
                                       "\n Windows 10 Pro (64bit) English"+
                                       "\n 4 GB, 1 x 4 GB, DDR4, 2666 MHz"+
                                       "\n 512GB M.2 PCIe NVMe Solid State Drive");	
		driver.switchTo().defaultContent();
	}
	
	public void clickOnSave()
	{
		save_btn.click();
	}
	
	public String getConfirmationMsg()
	{
		String msg=driver.getPageSource();
		return msg;
	}
	// this method designed to click on any menu to add product info
	public void fillProductDetails(String info)
	{
		driver.findElement(By.xpath("//span[contains(text(),'"+info+"')]")).click();     
	}

}
