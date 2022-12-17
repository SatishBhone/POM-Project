package utilityClasses;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilClass {

	
	// Screenshoots code
    
		  public void getScreenShot(WebDriver driver) throws IOException
	       {
		{
		           SimpleDateFormat frmt = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		           String date = frmt.format(new Date());
		           System.out.println(date);
		           
	               File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	               File dest = new File("D:\\Screenshot\\satish"+date+".jpg");
	               FileHandler.copy(source, dest);
		}
		}
	     // Implicit Wait
	     public static void ImplicitWait( WebDriver driver)
	     {
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	     }
	     
		// Explicit wait code
		public static WebElement explicitWait(WebDriver driver,WebElement element)
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			WebElement element1 = wait.until(ExpectedConditions.visibilityOf(element));
			return element1;	
		}
		
		public static void main(WebDriver driver ) 
		{
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	         WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));

	           element.click();

		}
}
