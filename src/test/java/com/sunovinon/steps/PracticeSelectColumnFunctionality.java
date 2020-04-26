package com.sunovinon.steps;

import java.awt.AWTException;
import java.io.IOException;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.sunovion.pages.PracticeTransactionPage;
import com.sunovion.pages.practicedashboardpage;
import com.sunovion.pages.practicehomepage;
import com.sunovion.pages.practiceloginpage;

public class PracticeSelectColumnFunctionality extends WebDriverTestCase {
	
	practiceloginpage lpage = new practiceloginpage();
	practicehomepage hpage = new practicehomepage();
	practicedashboardpage dpage = new practicedashboardpage();
	PracticeTransactionPage tpage = new PracticeTransactionPage();
	TimeStampScreenshot scrsht = new TimeStampScreenshot();
	
	@QAFTestStep (description = "user launches the Url")
	public void scLaunch() {
		lpage.launchSunovionSite();
		
	}
	
	@QAFTestStep (description = "user enter valid credentials and click on login button")
	public void scLoginPage() {
		lpage.enterUsername(getProps().getString("Username"));
		lpage.enterPassword(getProps().getString("Password"));
		lpage.clickLoginButton();
	}
	
	@QAFTestStep (description = "user enter valid credentials and click on login button")
	public void scHomePage() {
		hpage.homepageVerification();
		hpage.clickDashboardLink();
	}

	@QAFTestStep (description = "user is on dasboard page & clicks on quarter button under rep sampling activities")
	public void scDashboardPage() {
		try {
			dpage.dashboardPage();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dpage.clickQuarterlyButton();
		}
	
	@QAFTestStep (description = "user clicks back arrow until quarter q1 & year 2019")
	public void scQuarterButton() throws InterruptedException {
		dpage.selectQuarter(getProps().getString("Quarter"));
	}
	
	@QAFTestStep (description = "user clicks on any object link under the rep sampling activity")
	public void scClickLink() {
		dpage.clickDisbursementLink();
	}
	
	@QAFTestStep (description = "user is on transaction page")
	public void scTransactionPage() {
		tpage.verifyTransactionPage();
	}
	
	@QAFTestStep (description = "click on select column")
	public void scSelectColumn() {
		tpage.selectColumnLink();
	}
	
	@QAFTestStep (description = "check chekboxes and click on select button")
	public void scSelectCheckBox() throws AWTException, IOException {
		tpage.clickCheckBoxAndSelectButton();
		scrsht.SelectColumn();
	}
	
	@QAFTestStep (description = "verify selected columns are displayed under the transaction table")
    public void scVerify() throws AWTException, IOException, InterruptedException {
		tpage.verifySelectColumn();
		//scrsht.SelectColumn();
	}
	
	


}
