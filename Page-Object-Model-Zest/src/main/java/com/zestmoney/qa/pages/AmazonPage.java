package com.zestmoney.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zestmoney.qa.base.TestBase;
import com.zestmoney.qa.util.TestUtil;

public class AmazonPage extends TestBase{
	
TestUtil util;

	//Amazon search bar locator
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBox;
	
	//Search button locator
	@FindBy(xpath="(//input[@type='submit'])[1]")
	WebElement searchBtn;
	
	//Select product
	@FindBy(xpath="//a[@class='a-link-normal a-text-normal']/span[text()='New Apple iPhone 12 (64GB) - Black']")
	WebElement selectProduct;
	
	//Get price
	@FindBy(xpath="//span[@id='priceblock_ourprice']")
	WebElement getPrice;
	
	//Get url from propties file
	public AmazonPage(){
		PageFactory.initElements(driver, this);
		driver.get(prop.getProperty("amazonUrl"));
	}
	
	//Actions
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	
	public int searchProductAndGetPrice(String productName) throws InterruptedException{
		//Search product
		searchBox.sendKeys(productName);
		searchBtn.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		//Select product
		selectProduct.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		//Switch to another tab
		TestUtil.switchToTab();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//Get price as String and remove unnecessary character and convert to integer
		String price= getPrice.getText();
		String price2=price.substring(2, 8);
		String price3=price2.replace(",", "");
		int amazonpPrice=Integer.parseInt(price3);
		return amazonpPrice;
		
	}
	
}