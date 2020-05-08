package com.sunovinon.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.sunovion.pages.PracticeInventoryPage;
import com.sunovion.pages.PracticeTransactionPage;
import com.sunovion.pages.practicedashboardpage;
import com.sunovion.pages.practicehomepage;
import com.sunovion.pages.practiceloginpage;

public class VerifyInventoryCommentFunctionality extends WebDriverTestCase {
	
	practiceloginpage lpage = new practiceloginpage();
	practicehomepage hpage = new practicehomepage();
	practicedashboardpage dpage = new practicedashboardpage();
	PracticeTransactionPage tpage = new PracticeTransactionPage();
	PracticeInventoryPage ipage = new PracticeInventoryPage();
	TimeStampScreenshot scrsht = new TimeStampScreenshot();
	
	@QAFTestStep (description = "user launches the Url")
	public void ifLaunch() {
		lpage.launchSunovionSite();
		
	}
	
	@QAFTestStep (description = "user enter valid credentials and click on login button")
	public void ifLoginPage() {
		lpage.enterUsername(getProps().getString("Username"));
		lpage.enterPassword(getProps().getString("Password"));
		lpage.clickLoginButton();
	}
	
	@QAFTestStep (description = "user enter valid credentials and click on login button")
	public void ifHomePage() {
		hpage.homepageVerification();
		hpage.clickDashboardLink();
	}

	@QAFTestStep (description = "user is on dasboard page & clicks on quarter button under rep sampling activities")
	public void ifDashboardPage() {
		try {
			dpage.dashboardPage();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dpage.clickQuarterlyButton();
		}
	
	@QAFTestStep (description = "user clicks back arrow until quarter q3 & year 2018")
	public void ifQuarterButton() throws InterruptedException {
		dpage.selectQuarter(getProps().getString("Quater_Q32018"));
	}
	
	@QAFTestStep (description = "user clicks on any object link under the rep sampling activity")
	public void ifClickLink() {
		dpage.clickInventoryLink();
	}
	
	@QAFTestStep (description = "user is on transaction page")
	public void ifTransactionPage() {
		tpage.verifyTransactionPage();
	}
	
	@QAFTestStep (description = "click on any inventory id")
	public void ifInventoryID() throws InterruptedException {
		ipage.clickInventoryID(getProps().getString("ID"));
		Thread.sleep(3000);	
	}
	
	@QAFTestStep (description = "user is on inventory page")
	public void ifInventoryPage() {
		ipage.inventoryPageVerification();
	}

}
