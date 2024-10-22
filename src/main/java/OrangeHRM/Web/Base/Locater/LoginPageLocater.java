package OrangeHRM.Web.Base.Locater;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocater {
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	public static WebElement username;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	public static WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement loginbutton;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	public static WebElement errorMassgae;
	
	@FindBy(xpath = "//span[text()='Required']")
	public static WebElement blankuserNameerrorMassgae;
	
	
	@FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
	public static WebElement dashboardHeader;
	
	
     
}
