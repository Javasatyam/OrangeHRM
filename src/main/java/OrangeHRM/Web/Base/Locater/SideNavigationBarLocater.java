package OrangeHRM.Web.Base.Locater;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideNavigationBarLocater {
	
	@FindBy(xpath = "//span[text()='Admin']")
	public static WebElement Adminpage;
	
	@FindBy(xpath = "//span[text()='PIM']")
	public static WebElement PIMpage;
	
	@FindBy(xpath = "//span[text()='Leave']")
	public static WebElement Leavepage;
	

}
