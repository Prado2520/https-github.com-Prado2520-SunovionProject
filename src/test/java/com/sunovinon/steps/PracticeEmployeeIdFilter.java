package com.sunovinon.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;
import com.sunovion.pages.PracticeTransactionPage;
import com.sunovion.pages.practicedashboardpage;
import com.sunovion.pages.practicehomepage;
import com.sunovion.pages.practiceloginpage;

public class PracticeEmployeeIdFilter extends WebDriverTestCase {
	practiceloginpage lpage = new practiceloginpage();
	practicehomepage hpage = new practicehomepage();
	practicedashboardpage dpage = new practicedashboardpage();
	PracticeTransactionPage tpage = new PracticeTransactionPage();
	
	@QAFTestStep (description = "user launches the Url")
	public void lnlaunch() {
		lpage.launchSunovionSite();
		
	}
	
	@QAFTestStep (description = "user enter valid credentials and click on login button")
	public void eilaunchPage() {
		lpage.enterUsername(getProps().getString("Username"));
		lpage.enterPassword(getProps().getString("Password"));
		lpage.clickLoginButton();
	}
	
	@QAFTestStep (description = "user enter valid credentials and click on login button")
	public void eihomePage() {
		hpage.homepageVerification();
		hpage.clickDashboardLink();
	}

	@QAFTestStep (description = "user is on dasboard page & clicks on quarter button under rep sampling activities")
	public void eidashboardPage() {
		try {
			dpage.dashboardPage();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dpage.clickQuarterlyButton();
		}
	
	@QAFTestStep (description = "user clicks back arrow until quarter q1 & year 2019")
	public void eiquarterButton() throws InterruptedException {
		dpage.selectQuarter(getProps().getString("Quarter"));
	}
	
	@QAFTestStep (description = "user clicks on disbursement link under the rep sampling activity")
	public void eiclickLink() {
		dpage.clickDisbursementLink();
	}
	
	@QAFTestStep (description = "user is on transaction page")
	public void eitransactionPage() {
		tpage.verifyTransactionPage();
		
	}
	
	@QAFTestStep (description = "enter employeeid in the employee text field")
	public void eiLastNameFilter() {
		Reporter.logWithScreenShot("Before applying filter");
		tpage.enterEmployeeId(getProps().getString("EmployeeId"));	
	}
	
	@QAFTestStep (description = "clicks on apply filter button")
	public void eiFilterButton() {
		tpage.clickApplyFilterButton();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@QAFTestStep (description = "verify that in search only applied filter results are displayed")
	public void eiVerifyFilter() {
		tpage.employeeIdFilterResult(getProps().getString("EmployeeId"));
		Reporter.logWithScreenShot("After applying screenshot");
	}


}
