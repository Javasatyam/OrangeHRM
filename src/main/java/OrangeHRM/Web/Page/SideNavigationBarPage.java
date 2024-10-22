package OrangeHRM.Web.Page;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


import OrangeHRM.Web.Base.Page;
import OrangeHRM.Web.Base.Locater.SideNavigationBarLocater;

public class SideNavigationBarPage {
	SideNavigationBarLocater nav;
 public SideNavigationBarPage()
 {
	 this.nav=new SideNavigationBarLocater();
	 AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(Page.driver,10);
	 PageFactory.initElements(factory, this.nav);
 }
 
 public SideNavigationBarPage goToAdminPage()
 {
	 Page.excplictWait(SideNavigationBarLocater.Adminpage);
	 SideNavigationBarLocater.Adminpage.click();
	 return this;
 }
 
 public SideNavigationBarPage goToPIMPage() throws InterruptedException
 {
	 Page.excplictWait(SideNavigationBarLocater.PIMpage);
	 SideNavigationBarLocater.PIMpage.click();
	 return this;
 }
}
