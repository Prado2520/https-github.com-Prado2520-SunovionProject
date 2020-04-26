package com.sunovion.pages;

import java.awt.AWTException;
import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.TestPage;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import com.sunovinon.steps.TimeStampScreenshot;

public class practiceloginpage extends WebDriverBaseTestPage<WebDriverTestPage> {
	
	
	public void launchSunovionSite() {
		CommonStep.get("/");
	}
	
	public void enterUsername(String Username) {
		
		CommonStep.sendKeys(Username, "login.username.text");
	}
	
	public void enterPassword(String Password) {
		
		CommonStep.sendKeys(Password, "login.password.text");
	}
	
	public void clickLoginButton() {
		
		CommonStep.click("login.loginbtn.text");
		driver.manage().window().maximize();
		
		
	}

	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
}