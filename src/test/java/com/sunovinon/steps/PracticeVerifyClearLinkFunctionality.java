package com.sunovinon.steps;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import com.sunovion.pages.PracticeTransactionPage;
import com.sunovion.pages.practicedashboardpage;
import com.sunovion.pages.practicehomepage;
import com.sunovion.pages.practiceloginpage;

public class PracticeVerifyClearLinkFunctionality extends WebDriverTestCase {
	practiceloginpage lpage = new practiceloginpage();
	practicedashboardpage dpage = new practicedashboardpage();
	PracticeTransactionPage tpage = new PracticeTransactionPage();

	@QAFTestStep(description = "user launches the Url")
	public void clickURL() {
		lpage.launchSunovionSite();
		Reporter.logWithScreenShot("Welcome to Login Page");
	}

	@QAFTestStep(description = "user enter valid credentials and click on login button")
	public void loginIn() {
		lpage.enterUsername(getProps().getString("Username"));
		lpage.enterPassword(getProps().getString("Password"));
		lpage.clickLoginButton();
		
	}

	@QAFTestStep(description = "user is on home page & clicks on dashboard label")
	public void verifyHomepage() {
		practicehomepage hpage = new practicehomepage();
		hpage.homepageVerification();
		hpage.clickDashboardLink();

	}

	@QAFTestStep(description = "user is on dasboard page")
	public void dashboard()  {
		try {
			dpage.dashboardPage();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Validator.verifyTrue(CommonStep.verifyPresent("dash.logo.text"), "Current page is not a Dashboard page", "Dashboard page");
		
	}

	@QAFTestStep(description = "user clicks on quarter button under rep sampling activities")
	public void QuarterButton() {
		dpage.clickQuarterlyButton();

	}

	@QAFTestStep(description = "user clicks back arrow")
	public void BackArrow() throws InterruptedException {
		dpage.selectQuarter(getProps().getString("Quarter"));
	}

	@QAFTestStep(description = "user clicks on any object link under the rep sampling activity")
	public void vcclickObjectLink() {
		dpage.clickDisbursementLink();
		//dpage.clickShipment_AcknowledgementsLink();

	}

	@QAFTestStep(description = "user is on transaction page")
	public void verifyTransactionPage() {
		tpage.verifyTransactionPage();
	}

	@QAFTestStep(description = "user applies filter & clicks on apply filter button")
	public void checkbox() {
		tpage.checkTransferInCheckbox();
		tpage.checkTransferOutCheckbox();
		tpage.clickApplyFilterButton();
		Reporter.logWithScreenShot("Filter applied screenshot");
	}

	@QAFTestStep(description = "click on clear link & verify all filters are cleared")
	public void verifyFilterClear() {
		tpage.clickClearLink();
		Validator.verifyTrue(CommonStep.verifyNotSelected("transaction.transferin.checkbox"), "Transfer in checkbox is still checked", "Transfer in checkbox unchecked");
		CommonStep.verifyNotSelected("transaction.transferin.checkbox");
		Validator.verifyTrue(CommonStep.verifyNotSelected("transaction.transferout.checkbox"), "transferout checkbox is still checked", "transferout checkbox unchecked");
		CommonStep.verifyNotSelected("transaction.transferout.checkbox");		
	}

}
