package com.zestmoney.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zestmoney.qa.base.TestBase;
import com.zestmoney.qa.util.TestUtil;

public class FlipkartPage extends TestBase{
	

	@FindBy(xpath="//button[text()='✕']")
	WebElement popup;
	@FindBy(xpath = "//input[@title='Search for products, brands and more']")
	WebElement searchBox;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement searchBtn;
	
	@FindBy(xpath="//div[text()='APPLE iPhone 12 (Black, 64 GB)']")
	WebElement selectProduct;
	
	@FindBy(xpath="//div[@class='CEmiEU']//div/div")
	WebElement getPrice;
	

	public FlipkartPage(){
		PageFactory.initElements(driver, this);
		driver.get(prop.getProperty("flipkartUrl"));
	}
	

	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	
	public int searchProductAndGetPrice(String productName) throws InterruptedException{
		//Close login popup
		if(popup.isDisplayed())
	    {
	    	popup.click();
	    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	    }
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
		
		String getPriceString= getPrice.getText();
		String getPriceStringwithout$=getPriceString.substring(1, 7);
		String getPrice=getPriceStringwithout$.replace(",", "");
		int flipkartPrice=Integer.parseInt(getPrice);
		return flipkartPrice;
		
	}
	
}