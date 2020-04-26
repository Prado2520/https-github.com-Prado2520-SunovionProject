package com.sunovinon.steps;

import java.awt.AWTException;
import java.io.IOException;

import org.hamcrest.Matchers;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.step.QAFTestStep;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.ui.api.PageLocator;

import com.qmetry.qaf.automation.util.Validator;
import com.sunovinon.steps.TimeStampScreenshot;
import com.sunovion.pages.practiceloginpage;
 
public class practiceSteps extends WebDriverTestCase {

	practiceloginpage page = new practiceloginpage();

	@QAFTestStep(description = "launch the Url")
	public void pLaunchWebsite() {
		page.launchSunovionSite();
	}

	@QAFTestStep(description = "user enter username password")
	public void enterUserPass() {
		page.enterUsername(getProps().getString("Username"));
		page.enterPassword(getProps().getString("Password"));
	}

	@QAFTestStep(description = "click on login button")
	public void loginButton() {
		page.clickLoginButton();

	}

	@QAFTestStep(description = "verify user is logged in successfully")
	public void verifyLoginSuccess() throws AWTException, IOException {
		TimeStampScreenshot scrsht = new TimeStampScreenshot();
		CommonStep.waitForVisible("sims.description.text");
		Validator.verifyThat("Wlecome to Home Page", "Knipper's Sample Compliance System",
				Matchers.equalToIgnoringWhiteSpace(CommonStep.getText("sims.description.text")));
		scrsht.Login();
	}

	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stub

	}

}
