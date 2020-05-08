package com.sunovinon.steps;

import java.awt.AWTException;
import java.io.IOException;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.sunovion.pages.practicedashboardpage;
import com.sunovion.pages.practicehomepage;
import com.sunovion.pages.practiceloginpage;

public class PracticeVerifyDashbaordPageSteps extends WebDriverTestCase {

	practiceloginpage lpage = new practiceloginpage();

	@QAFTestStep(description = "launch the Url")
	public void launchSite() {
		lpage.launchSunovionSite();

	}

	@QAFTestStep(description = "enter valid credentials and click on login button")
	public void login() {
		lpage.enterUsername(getProps().getString("Username"));
		lpage.enterPassword(getProps().getString("Password"));
		lpage.clickLoginButton();
	}

	@QAFTestStep(description = "hover over sims3.0 beta label and click on dashboard label")
	public void clickDashboardButton() {
		practicehomepage hpage = new practicehomepage();
		hpage.clickDashboardLink();

	}

	@QAFTestStep(description = "verify that user is present on dashboard page")
	public void verifyDashboardPage() throws AWTException, IOException, InterruptedException {
		practicedashboardpage dpage = new practicedashboardpage();
		dpage.dashboardPage();
		TimeStampScreenshot scrsht = new TimeStampScreenshot();
		//Validator.verifyTrue(CommonStep.verifyPresent("dash.logo.text"), "Dashboard page verification failed", "Dashboard page verification passed");
		scrsht.DashboardPage();

	}

}
