package OrangeHRM.Web.Base;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import OrangeHRM.Web.Base.Locater.SideNavigationBarLocater;

public class Page {
	public static WebDriver driver;
	public static Logger log = Logger.getLogger("devpinoyLogger");

public static void initConfiguration(){
		
		if(Constent.browser.equals("firefox")){
			
			driver = new FirefoxDriver();
			log.debug("Launching Firefox");
		}
		else if(Constent.browser.equals("chrome"))
		{
			driver = new ChromeDriver();
			log.debug("Launching chrome");
		}
			
		driver.get(Constent.testsiteurl);
}

   public static void click(WebElement element) {

	    element.click();
	    log.debug("Clicking on an Element : "+element);
	
    }
  
  public static void type(WebElement element, String value) {

	   element.sendKeys(value);

	  log.debug("Typing in an Element : "+element+" entered value as : "+value);
  }
  
  public static String getText(WebElement element )
  {
	return element.getText().trim();
	  
  }
  
  public static void clear(WebElement element )
  {
	 element.clear();
	  
  }
  public static void excplictWait(WebElement e)
  {
	     WebDriverWait wait = new WebDriverWait(Page.driver, Duration.ofSeconds(1));
	     wait.until(ExpectedConditions.elementToBeClickable(e));
  }
}
