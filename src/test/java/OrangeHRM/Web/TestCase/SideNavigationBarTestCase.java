package OrangeHRM.Web.TestCase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import OrangeHRM.Web.Base.Page;
import OrangeHRM.Web.Page.SideNavigationBarPage;

public class SideNavigationBarTestCase {
	

	 @Test(priority = 2)
	    public void navigationTest() throws InterruptedException {
	        // After login, go to Admin and PIM pages
	        SideNavigationBarPage page = new SideNavigationBarPage();
	        page.goToAdminPage().goToPIMPage();
	    }	 
}
