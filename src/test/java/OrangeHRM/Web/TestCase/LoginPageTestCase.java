package OrangeHRM.Web.TestCase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import OrangeHRM.Web.Base.Page;
import OrangeHRM.Web.Base.Locater.DashBoardPageLocater;
import OrangeHRM.Web.Base.Locater.LoginPageLocater;
import OrangeHRM.Web.Page.LoginPage;
import OrangeHRM.Web.Page.SideNavigationBarPage;
import OrangeHRM.Web.Page.utility.ConfigReader;

public class LoginPageTestCase {

	 static ConfigReader config;
		@BeforeClass
	    public void setUp() throws IOException {
	        // Initialize WebDriver and configuration before tests
	        Page.initConfiguration();
	        config = new ConfigReader();
	        
	    }
		
		 @Test(priority = 1)
		    public static void invalidUserNameandPasswordErrorMassage() throws InterruptedException {
		        // Login action
			 
		        LoginPage action = new LoginPage();
		        Page.clear(LoginPageLocater.username);
		        Page.clear(LoginPageLocater.password);
		        action
		            .enterUserName(config.getProperty("invalidUsername"))
		            .enterPassword(config.getProperty("invalidPassword"))
		            .loginButton();
		        
		          String actcalResult=Page.getText(LoginPageLocater.errorMassgae);
		          String ExpectedResult=ConfigReader.getProperty("invalidUserNameandPasswordErrorMassage");
		          Assert.assertEquals(actcalResult, ExpectedResult, "Text does not match!");
		        
		    }
		 
		 @Test(priority = 2)
		 public static void invalidPassword() throws InterruptedException {
		        // Login action
		        LoginPage action = new LoginPage();
		        Page.clear(LoginPageLocater.username);
		        Page.clear(LoginPageLocater.password);
		        action
		            .enterUserName(config.getProperty("validUsername"))
		            .enterPassword(config.getProperty("invalidPassword"))
		            .loginButton();
		         
		          String actcalResult=Page.getText(LoginPageLocater.errorMassgae);
		          String ExpectedResult=ConfigReader.getProperty("invalidUserNameandPasswordErrorMassage");
		          Assert.assertEquals(actcalResult, ExpectedResult, "Text does not match!");
		    }
		 
		 @Test(priority = 3)
		 public static void invalidUserName() throws InterruptedException {
		        // Login action
		        LoginPage action = new LoginPage();
		        Page.clear(LoginPageLocater.username);
		        Page.clear(LoginPageLocater.password);
		        action
		            .enterUserName(config.getProperty("invalidUsername"))
		            .enterPassword(config.getProperty("validPassword"))
		            .loginButton();
		        
		          String actcalResult=Page.getText(LoginPageLocater.errorMassgae);
		          String ExpectedResult=ConfigReader.getProperty("invalidUserNameandPasswordErrorMassage");
		          Assert.assertEquals(actcalResult, ExpectedResult, "Text does not match!");
		    }
		 @Test(priority = 4)
		 public static void BlankUserName() throws InterruptedException {
		        // Login action
		        LoginPage action = new LoginPage();
		        Page.clear(LoginPageLocater.username);
		        Page.clear(LoginPageLocater.password);
		        action
		            .enterPassword(config.getProperty("validPassword"))
		            .loginButton();
		          String actucalResult=Page.getText(LoginPageLocater.blankuserNameerrorMassgae);
		          
		          String ExpectedResult=ConfigReader.getProperty("blankUserNameErrorMassage");
		          Assert.assertEquals(actucalResult, ExpectedResult, "Text does not match!");
		    }
		 @Test(priority = 5)
		 public static void loginSucessfully() throws InterruptedException {
		        // Login action
		        LoginPage action = new LoginPage();
		        Page.clear(LoginPageLocater.username);
		        Page.clear(LoginPageLocater.password);
		        action
		            .enterUserName(config.getProperty("validUsername"))
		            .enterPassword(config.getProperty("validPassword"))
		            .loginButton();
		    }

}
