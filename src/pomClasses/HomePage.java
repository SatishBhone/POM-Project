package pomClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClasses.UtilClass;

public class HomePage extends UtilClass{

WebDriver driver;
	
	@FindBy(xpath=("//input[@name='q']"))
    private WebElement SearchField;
	
	@FindBy(xpath=("//button[@type='submit']"))
   private WebElement SearchButton;
	
	@FindBy(xpath=("//div[@class='YUhWwv']"))
   private WebElement cartBtn;
	
	@FindBy(xpath=("//div[text()='SATISH']")) 
	private WebElement profileName;
	
	@FindBy(xpath=("//div[@class='_3pLy-c row']"))
	private WebElement ProductList;
	 
	@FindBy(xpath=("//div[text()='Logout']"))
	private WebElement Logout;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void enterSearchText(String search)
	{
		SearchField.sendKeys(search);
	}
	
	public void clickSearchButton()
	{
		SearchButton.click();
	}
	
	public void clickCartButton()
	{
		cartBtn.click();
	}
	
	public boolean isProfileNameVisible()
	{
		try {
			WebElement element = explicitWait(driver,profileName);
				return true;	
		}catch(Exception e)
	
	{
		return false;
	}
	}
	
	public boolean isProductListAppeares() 
	{

		try {
			WebElement element = explicitWait(driver,ProductList);
				return true;	
		}catch(Exception e)
	
	{
		return false;
	}
	}
	
	public void ClearSearchField(String SearchData)
	{    
		for(int i=0; i<SearchData.length(); i++) 
		{
			SearchField.sendKeys(Keys.BACK_SPACE);
			
		}
		
	}
    public void LogOutprofile() 
    {
    	Logout.clear();
    }
}
