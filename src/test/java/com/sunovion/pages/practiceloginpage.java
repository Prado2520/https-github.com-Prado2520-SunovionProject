package com.sunovion.pages;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;

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
	
	public void clickLoginButton()  {
		CommonStep.click("login.loginbtn.text");
		driver.manage().window().maximize();
		
		
		
	}

	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
}