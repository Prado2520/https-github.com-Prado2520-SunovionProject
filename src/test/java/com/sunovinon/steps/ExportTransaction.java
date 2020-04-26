package com.sunovinon.steps;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.sunovion.pages.PracticeTransactionPage;
import com.sunovion.pages.practicedashboardpage;
import com.sunovion.pages.practicehomepage;
import com.sunovion.pages.practiceloginpage;

public class ExportTransaction extends WebDriverTestCase{
	practiceloginpage lpage = new practiceloginpage();
	practicehomepage hpage = new practicehomepage();
	practicedashboardpage dpage = new practicedashboardpage();
	PracticeTransactionPage tpage = new PracticeTransactionPage();
	
	@QAFTestStep (description = "user launches the Url")
	public void etlaunch() {
		lpage.launchSunovionSite();
		
	}
	
	@QAFTestStep (description = "user enter valid credentials and click on login button")
	public void etlaunchPage() {
		lpage.enterUsername(getProps().getString("Username"));
		lpage.enterPassword(getProps().getString("Password"));
		lpage.clickLoginButton();
	}
	
	@QAFTestStep (description = "user enter valid credentials and click on login button")
	public void ethomePage() {
		hpage.homepageVerification();
		hpage.clickDashboardLink();
	}

	@QAFTestStep (description = "user is on dasboard page & clicks on quarter button under rep sampling activities")
	public void etdashboardPage() {
		try {
			dpage.dashboardPage();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dpage.clickQuarterlyButton();
		}
	
	@QAFTestStep (description = "user clicks back arrow until quarter q1 & year 2019")
	public void etquarterButton() throws InterruptedException {
		dpage.selectQuarter(getProps().getString("Quarter"));
	}
	
	@QAFTestStep (description = "user clicks on any object link under the rep sampling activity")
	public void etclickLink() {
		dpage.clickDisbursementLink();
	}
	
	@QAFTestStep (description = "user is on transaction page")
	public void ettransactionPage() {
		tpage.verifyTransactionPage();
	}
	
	@QAFTestStep (description = "clicks on export transaction button")
	public void etclickExportTransactionButton() throws InterruptedException, AWTException {
		tpage.clickExportTransaction();
		Thread.sleep(15000);
		//Robot obj = new Robot();
		//obj.keyPress(KeyEvent.VK_ENTER);
	}
}
