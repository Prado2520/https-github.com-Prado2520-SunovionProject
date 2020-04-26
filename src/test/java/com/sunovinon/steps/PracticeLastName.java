package com.sunovinon.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;
import com.sunovion.pages.PracticeTransactionPage;
import com.sunovion.pages.practicedashboardpage;
import com.sunovion.pages.practicehomepage;
import com.sunovion.pages.practiceloginpage;

public class PracticeLastName extends WebDriverTestCase {
	
	practiceloginpage lpage = new practiceloginpage();
	practicehomepage hpage = new practicehomepage();
	practicedashboardpage dpage = new practicedashboardpage();
	PracticeTransactionPage tpage = new PracticeTransactionPage();
	
	@QAFTestStep (description = "user launches the Url")
	public void lnlaunch() {
		lpage.launchSunovionSite();
		
	}
	
	@QAFTestStep (description = "user enter valid credentials and click on login button")
	public void lnlaunchPage() {
		lpage.enterUsername(getProps().getString("Username"));
		lpage.enterPassword(getProps().getString("Password"));
		lpage.clickLoginButton();
	}
	
	@QAFTestStep (description = "user enter valid credentials and click on login button")
	public void lnhomePage() {
		hpage.homepageVerification();
		hpage.clickDashboardLink();
	}

	@QAFTestStep (description = "user is on dasboard page & clicks on quarter button under rep sampling activities")
	public void lndashboardPage() {
		try {
			dpage.dashboardPage();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dpage.clickQuarterlyButton();
		}
	
	@QAFTestStep (description = "user clicks back arrow until quarter q1 & year 2019")
	public void lnquarterButton() throws InterruptedException {
		Thread.sleep(5000);
		dpage.selectQuarter(getProps().getString("Quarter"));
	}
	
	@QAFTestStep (description = "user clicks on any object link under the rep sampling activity")
	public void lnclickLink() {
		dpage.clickDisbursementLink();
	}
	
	@QAFTestStep (description = "user is on transaction page")
	public void lntransactionPage() {
		tpage.verifyTransactionPage();
	}
	
	@QAFTestStep (description = "clicks on employee last name textbox and enters the lastname")
	public void lnLastNameFilter() {
		Reporter.logWithScreenShot("Before applying filter");
		tpage.clickAndEnterEmployeeLastName(getProps().getString("EmployeeLastName"));	
	}
	
	@QAFTestStep (description = "clicks on apply filter button")
	public void lnFilterButton() {
		tpage.clickApplyFilterButton();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@QAFTestStep (description = "verify employee lastname")
	public void lnverifyFilter() {
		tpage.lastNameFilterResult(getProps().getString("EmployeeLastName"));
		Reporter.logWithScreenShot("After applying filter");
		
		
	}


}
