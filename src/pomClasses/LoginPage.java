package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClasses.UtilClass;

public class LoginPage extends UtilClass{


	WebDriver driver;
	@FindBy(xpath=("(//input[@type='text'])[2]"))
     private WebElement email;
	
	@FindBy(xpath=("//input[@type='password']"))
    private WebElement password;
	
	@FindBy(xpath=("(//button[@type='submit'])[2]"))
    private WebElement loginButton;
	
	public LoginPage(WebDriver driver)
	
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
		
	public void putEmail()
	{
		email.sendKeys("7030357457");
	}
	public void putPassword()
	{
		password.sendKeys("Satish@2534");
	}
	
	public void clickLoginBtn()
	{
		loginButton.click();
	}
}
