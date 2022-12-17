package baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass1 {

   public static WebDriver getDriver(String browser) 
   {
	   
	   WebDriver driver = null;
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\satis\\Driver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if (browser.equals(" Edge"))
			
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\satis\\Driver\\edgedriver_win64\\msedgedriver.exe");	
			
			 driver = new EdgeDriver();
			
			
			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\satis\\Driver\\geckodriver-v0.32.0-win-aarch64\\geckodriver.exe");
			//driver = new FirefoxDriver();
		}
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		return driver;
	}
   }
	


