package com.sunovinon.steps;

import java.awt.AWTException;
import java.io.IOException;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;
import com.sunovion.pages.PracticeTransactionPage;
import com.sunovion.pages.practicedashboardpage;
import com.sunovion.pages.practicehomepage;
import com.sunovion.pages.practiceloginpage;


public class VerifyLastNameFilter extends WebDriverTestCase {
	practiceloginpage lpage = new practiceloginpage();
	practicehomepage hpage = new practicehomepage();
	practicedashboardpage dpage = new practicedashboardpage();
	PracticeTransactionPage tpage = new PracticeTransactionPage();
	   String EmployeeLastName = "Parker";
	   TimeStampScreenshot Scrshot = new TimeStampScreenshot();
	
	
	@QAFTestStep(description = "User on transaction page")
	public void TransactionPage() throws InterruptedException {
/*		SunovionVerifyLinks login = new SunovionVerifyLinks();
		VerifyLastNameFilter Filter = new VerifyLastNameFilter();
		login.OpenApplication();
		login.LoginPage();*/
		lpage.launchSunovionSite();
		lpage.enterUsername(getProps().getString("Username"));
		lpage.enterPassword(getProps().getString("Password"));
		lpage.clickLoginButton();
		hpage.homepageVerification();
		hpage.clickDashboardLink();
		dpage.dashboardPage();
		dpage.clickQuarterlyButton();
		dpage.selectQuarter(getProps().getString("Quarter"));
		dpage.clickDisbursementLink();
		Reporter.logWithScreenShot("Before Filter");
}
	
	@QAFTestStep(description = "User uses = filter")
	public void EqualsFilter() throws AWTException, IOException, Throwable {
		//CommonStep.click("tran.empLastName.text");
		//CommonStep.sendKeys(EmployeeLastName, "tran.empLastName.textbox");
		tpage.clickAndEnterEmployeeLastName(EmployeeLastName);
		tpage.clickApplyFilterButton();
		
		//CommonStep.click("tran.fil.text");
		//Thread.sleep(10000);
		Reporter.logWithScreenShot("Filter Applied");
		Scrshot.EmpLastName();
		//System.out.println(CommonStep.getText("tran.onerow.data"));
		//table[@class='table full-width']/tbody/tr/td[8]
		//List<WebElement> data = new ArrayList<WebElement>();
		/*data = (ArrayList<String>) driver.findElements("tran.lastnamecol.data");
		
		List<WebElement> data = driver.findElements(By.xpath("//table[@class='table full-width']/tbody/tr/td[8]"));
		List<WebElement> element = data;
		int Count=data.size();
		System.out.println(Count);
		
		for(int i =0; i<data.size(); i++) {
			
			Validator.verifyThat(data.get(i).getText(), Matchers.equalTo(EmployeeLastName));*/
		}
		
		
		
		/*//System.out.println("Data should be printed here");
		
		Reporter.log("The total no. rows after filter of "+EmployeeLastName+" is applied are :"+Count);*/
		
				
		/*Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	    BufferedImage screenFullImage = new Robot().createScreenCapture(screenRect);
	    String ext = "dat";
	    File dir = new File("C:/Screenshots");
	    String name = String.format("%s.%s",RandomStringUtils.randomAlphabetic(8), ext);
	    ImageIO.write(screenFullImage, "png", new File(dir, name));*/
	}
	
/*public class VerifyLastNameFilter extends WebDriverBaseTestPage<WebDriverTestPage>{
	   int size =5;
	   String EmployeeLastName = "Parker";
	   TimeStampScreenshot Scrshot = new TimeStampScreenshot();
	   
	   
	   
	public void TranPage(int size) throws InterruptedException {
		Thread.sleep(5000);
		Reporter.logWithScreenShot("Transaction Page");
	
		for (int i=0;i<size;i++)
		{
			CommonStep.click("sims.barrow.text");
		}
		
		String textDisbursements = CommonStep.getText("rep.dlink.text");
		//System.out.println("-------Text Disbursement = "+textDisbursements);
		CommonStep.click("rep.dlink.text");
		Reporter.log("Click on Disbursement Link");
		CommonStep.waitForVisible("rep.tlink.text");
	}
	
	@QAFTestStep(description = "User on transaction page")
	public void TransactionPage() throws InterruptedException {
		SunovionVerifyLinks login = new SunovionVerifyLinks();
		VerifyLastNameFilter Filter = new VerifyLastNameFilter();
		login.OpenApplication();
		login.LoginPage();
		Filter.TranPage(size);
		Reporter.logWithScreenShot("Before Filter");
		
		
	}
	
	@QAFTestStep(description = "User uses = filter")
	public void EqualsFilter() throws AWTException, IOException, Throwable {
		CommonStep.click("tran.empLastName.text");
		CommonStep.sendKeys(EmployeeLastName, "tran.empLastName.textbox");
		CommonStep.click("tran.fil.text");
		Thread.sleep(10000);
		Reporter.logWithScreenShot("Filter Applied");
		//System.out.println(CommonStep.getText("tran.onerow.data"));
		//table[@class='table full-width']/tbody/tr/td[8]
		//List<WebElement> data = new ArrayList<WebElement>();
		data = (ArrayList<String>) driver.findElements("tran.lastnamecol.data");
		
		List<WebElement> data = driver.findElements(By.xpath("//table[@class='table full-width']/tbody/tr/td[8]"));
		List<WebElement> element = data;
		int Count=data.size();
		System.out.println(Count);
		
		for(int i =0; i<data.size(); i++) {
			
			Validator.verifyThat(data.get(i).getText(), Matchers.equalTo(EmployeeLastName));
		}
		
		
		
		//System.out.println("Data should be printed here");
		
		Reporter.log("The total no. rows after filter of "+EmployeeLastName+" is applied are :"+Count);
		
		
		
		
		
	

	
		
				
				
		Scrshot.EmpLastName();
				
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	    BufferedImage screenFullImage = new Robot().createScreenCapture(screenRect);
	    String ext = "dat";
	    File dir = new File("C:/Screenshots");
	    String name = String.format("%s.%s",RandomStringUtils.randomAlphabetic(8), ext);
	    ImageIO.write(screenFullImage, "png", new File(dir, name));
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	

}
*/