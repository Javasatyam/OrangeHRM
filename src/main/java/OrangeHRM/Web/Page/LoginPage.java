package OrangeHRM.Web.Page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.annotations.Listeners;

import OrangeHRM.Web.Base.Page;
import OrangeHRM.Web.Base.Locater.LoginPageLocater;
import OrangeHRM.Web.Listener.TestListener;

@Listeners(TestListener.class)
public class LoginPage extends Page {
	
	
	LoginPageLocater log;
	public LoginPage()
	{
		this.log = new 	LoginPageLocater();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this.log);
	}
	
    
    public LoginPage enterUserName(String uname) throws InterruptedException
    {
    	 Page.excplictWait(LoginPageLocater.username);
//    	 LoginPageLocater.username.sendKeys(uname);
    	Page.type(LoginPageLocater.username, uname);
    	return this;
    }
    
    public LoginPage enterPassword(String password) throws InterruptedException
    {
    	Page.excplictWait(LoginPageLocater.username);
        Page.type(LoginPageLocater.password, password);
    	return this;
    }
    
    public SideNavigationBarPage loginButton() throws InterruptedException
    {
    	Page.excplictWait(LoginPageLocater.username);
    	// LoginPageLocater.loginbutton.click();
    	Page.click(LoginPageLocater.loginbutton);
    	return new SideNavigationBarPage();
    }
   

}
