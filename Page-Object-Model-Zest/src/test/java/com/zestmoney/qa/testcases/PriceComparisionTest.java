package com.zestmoney.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.zestmoney.qa.base.TestBase;
import com.zestmoney.qa.pages.AmazonPage;
import com.zestmoney.qa.pages.FlipkartPage;

public class PriceComparisionTest extends TestBase{
	AmazonPage amazonPage;
	FlipkartPage flipkartPage;
	int amazonPrice;
	int flipkartPrice;
	
	public PriceComparisionTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();

	}
	
	@Test(priority=1)
	public void amazonLoginPageTitleTest(){
		amazonPage = new AmazonPage();
		String title = amazonPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}
	@Test(priority=2)
	public void amazonSelectProductTest() throws InterruptedException{
		amazonPage = new AmazonPage();
		amazonPrice=amazonPage.searchProductAndGetPrice("New Apple iPhone 12 (64GB) - Black");
		
		
	}
	@Test(priority=3)
	public void flipkartLoginPageTitleTest(){
		flipkartPage=new FlipkartPage();
		String title = flipkartPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}
	@Test(priority=4)
	public void flipkartSelectProductTest() throws InterruptedException{
		flipkartPage=new FlipkartPage();
		flipkartPrice=flipkartPage.searchProductAndGetPrice("APPLE iPhone 12 (Black, 64 GB)");
		
		
	}
	@Test(priority=5)
	public void comparePriceTest() throws InterruptedException{
		System.out.println("amazonp Price Rs "+amazonPrice);
		System.out.println("Flipkart Price Rs "+flipkartPrice);
		
		if(amazonPrice==flipkartPrice)
		{
			System.out.println("Both Prece are same"+amazonPrice);
		}
		if(amazonPrice>flipkartPrice)
		{
			System.out.println("Amazon Price More Than Flipkart "+amazonPrice);
		}
		else {
			System.out.println("Flipkart Price More Than Amazon  "+flipkartPrice);
		}
	}
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
