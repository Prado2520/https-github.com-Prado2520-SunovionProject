package com.sunovinon.steps;

import java.awt.AWTException;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.util.Reporter;
import com.sunovion.pages.PracticeTransactionPage;
import com.sunovion.pages.practicedashboardpage;
import com.sunovion.pages.practicehomepage;
import com.sunovion.pages.practiceloginpage;

public class SelectColumnStep extends WebDriverBaseTestPage<WebDriverTestPage> {
	practiceloginpage lpage = new practiceloginpage();
	practicehomepage hpage = new practicehomepage();
	practicedashboardpage dpage = new practicedashboardpage();
	PracticeTransactionPage tpage = new PracticeTransactionPage();
	
	TimeStampScreenshot scrsht = new TimeStampScreenshot();
	
	@QAFTestStep(description = "User currently on transaction page")
	public void Transaction() throws InterruptedException, IOException, AWTException {
		SunovionVerifyLinks s = new SunovionVerifyLinks();
		LocalDateTime  DateTime= LocalDateTime.now();
		s.OpenApplication();
		s.LoginPage();
		Thread.sleep(5000);
		Reporter.logWithScreenShot("Transaction Page");
		int size = 5;
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
	
	@QAFTestStep (description = "Click on the Additional Columns & selecting checkboxes")
	public void SelectColumn() throws InterruptedException, AWTException, IOException {
		
		CommonStep.click("tran.sc.link");
		Thread.sleep(5000);
		CommonStep.click("tran.ai.chckbx");
		
		CommonStep.click("tran.practitioner.chckbx");
		scrsht.SelectColumn();
		Thread.sleep(3000);
		scrsht.SelectColumn();
		Reporter.logWithScreenShot("Additional Column Screenshot");
		CommonStep.click("tran.sel.btn");
		Thread.sleep(3000);
		//driver.manage().window().maximize();
		CommonStep.click("tran.right.text");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("(//table[@class='table full-width']/tbody/tr)[1]"));
		jse.executeScript("arguments[0].scrollIntoView();", Element);
		
		/*//jse.executeScript("window.scrollBy(0,1000)");
		tran.poweredby.text
		jse.executeScript("scroll(0, 500);");
*/
		Thread.sleep(3000);
	    Reporter.logWithScreenShot("Screenshot");
	    
	   // System.out.println(DateTime);
	    scrsht.SelectColumn();
		
	}

	

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}

}
