package testClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseClass.BaseClass1;
import pomClasses.CartPage;
import pomClasses.HomePage;
import pomClasses.LoginPage;

public class TestClass1 {


    WebDriver driver;  // Global variables
    LoginPage lp;
    HomePage hp;
    CartPage cp;
    
    @Parameters("browser")
    
	@BeforeClass
	public void beforeclass(String k) 
	{

         driver = BaseClass1.getDriver(k);
	}
	
	@BeforeMethod
	public void beforeMethod() 
	{// Ue are initialize all the  pom pages in this method 
		
		 lp = new LoginPage(driver);
			
	     hp = new HomePage(driver);
	     cp = new CartPage(driver);
	}
	
	
	@Test(enabled = true)
	public void Test1() 
	{

		lp.putEmail();
		lp.putPassword();
		lp.clickLoginBtn();
		// if profile name is visible it gives true value otherwise false 
		// its return type is boolean that is true or false
		Assert.assertTrue(hp.isProfileNameVisible());
		
		//Reporter.log("Test1 Run Successfull",true);
		
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(hp.isProfileNameVisible());
		
		soft.assertAll();
		Reporter.log("SoftAssert is Apply Successful",true);
	
			
		
		
		
//	
//		if(hp.isProfileNameVisible())
//			
//		{
//			System.out.println("logged in");
//			
//			hp.enterSearchText();
//			hp.clickSearchButton();  
//			hp.clickCartButton();	 
//		}
//		
//		else 
//		{
//			System.out.println("Not logged in");
//			Assert.fail();
//		}
//		Reporter.log("Test1 Run Successfull",true);
	}
	
	@DataProvider(name="ProductData")
	public String[][] Dataproviders() 
	{
		String [] []a = {{"realmi","10000","black"}, {"samsung","20000","white"}, {"oppo","40000",""}};
		
		return a;
	} 
	
	@Test(dataProvider="ProductData")
	public void test2(String productname, String productPrize, String colour) throws InterruptedException 
	{
		String SearchTest = productname+" "+productPrize+" "+colour;
		
		
		hp.enterSearchText(SearchTest);
		hp.clickSearchButton();  
		
		
		hp.isProductListAppeares();
		
		Thread.sleep(20000);
		
		hp.ClearSearchField(SearchTest);
	
		
		Reporter.log("hi i am Test2",true);
		Reporter.log("Test2 Run Successfull",true);
	}
	
	@AfterMethod
	public void afterMethod() throws IOException 
	{
		// wecan used here log out code
		cp.getScreenShot(driver);
		cp.checkLoginButtonAvailable();	
	}

	@AfterClass
	public void afterclass() 
	{

		System.out.println("All is well");
		//driver.close();
		//driver.quit();
	
	}
	
	
}
