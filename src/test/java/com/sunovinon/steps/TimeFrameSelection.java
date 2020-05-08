package com.sunovinon.steps;

import java.awt.AWTException;
import java.io.IOException;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;
import com.sunovion.pages.PracticeTransactionPage;
import com.sunovion.pages.practicedashboardpage;
import com.sunovion.pages.practicehomepage;
import com.sunovion.pages.practiceloginpage;

public class TimeFrameSelection extends WebDriverTestCase {
	practiceloginpage lpage = new practiceloginpage();
	practicedashboardpage dpage = new practicedashboardpage();
	PracticeTransactionPage tpage = new PracticeTransactionPage();
	practicehomepage hpage = new practicehomepage();

	@QAFTestStep (description = "user launches the Url")
	public void tfLaunch() throws AWTException, IOException {
		lpage.launchSunovionSite();
	}
	
	@QAFTestStep (description = "Log in SIMS application")
	public void tfLogin() throws AWTException, IOException {
		lpage.enterUsername(getProps().getString("Username"));
		lpage.enterPassword(getProps().getString("Password"));
		lpage.clickLoginButton();
	}
	
	@QAFTestStep (description = "user is on home page")
	public void tfHomepage() {
		hpage.homepageVerification();
	}
	
	@QAFTestStep (description = "click on menu button and verify the new dashboard link")
	public void tfDashboard() {
		hpage.clickDashboardLink();
	}
	
	@QAFTestStep (description = "Verify the time frame selection tab")
	public void tfVerifyTimeFrame() throws InterruptedException {
		dpage.dashboardPage();
		dpage.verifyQuarterButton();
		dpage.verifyMonthlyButton();
	}
	

	
	@QAFTestStep (description = "select the time frame as Quarterly and click on back and front arrow")
	public void tfQuaterly() {
		dpage.clickQuarterlyButton();
		String Before = CommonStep.getText("dashboard.timeframe.text");
		System.out.println("Before : "+Before);
		Reporter.logWithScreenShot("Before clicking on back arrow :"+Before);
		int back =9;
		for (int i=1;i<=9;i++)
		{
			dpage.backArrowButton();
			}
		String After = CommonStep.getText("dashboard.timeframe.text");
		System.out.println("After : "+After);
		Reporter.logWithScreenShot("After clicking on back arrow :"+After);
		if(Before!=After) {
			System.out.println("Back arrow working verified successfully");
			Reporter.log("Back arrow working verified successfully");
		}
		
	   System.out.println("Quarter before clicking on the forward button");
	   Reporter.log("Quarter before clicking on the forward button");
	   
	    Before = CommonStep.getText("dashboard.timeframe.text");
		System.out.println("Before : "+Before);
		Reporter.logWithScreenShot("Before clicking on forward arrow :"+Before);
		dpage.forwardArrowButton();
		dpage.forwardArrowButton();
		 After = CommonStep.getText("dashboard.timeframe.text");
		System.out.println("After : "+After);
		Reporter.logWithScreenShot("After clicking on forward arrow :"+After);
		if(Before!=After) {
			System.out.println("Forward arrow working verified successfully");
			Reporter.log("Forward arrow working verified successfully");
		}
	   
	}
	
	@QAFTestStep (description = "select the time frame as monthly and click on back and front arrow")
	public void tfMonthly() {
		dpage.clickMonthlyButton();
		String Before = CommonStep.getText("dashboard.timeframe.text");
		System.out.println("Before : "+Before);
		Reporter.logWithScreenShot("Before clicking on back arrow :"+Before);
		int back =19;
		for (int i=1;i<=back;i++)
		{
			dpage.backArrowButton();
			}
		String After = CommonStep.getText("dashboard.timeframe.text");
		System.out.println("After : "+After);
		Reporter.logWithScreenShot("After clicking on back arrow :"+After);
		if(Before!=After) {
			System.out.println("Back arrow working verified successfully");
			Reporter.log("Back arrow working verified successfully");
		}
		
	   System.out.println("Month before clicking on the forward button");
	   Reporter.log("Month before clicking on the forward button");
	   
	    Before = CommonStep.getText("dashboard.timeframe.text");
		System.out.println("Before : "+Before);
		Reporter.logWithScreenShot("Before clicking on forward arrow :"+Before);
		dpage.forwardArrowButton();
		dpage.forwardArrowButton();
		 After = CommonStep.getText("dashboard.timeframe.text");
		System.out.println("After : "+After);
		Reporter.logWithScreenShot("After clicking on forward arrow :"+After);
		if(Before!=After) {
			System.out.println("Forward arrow working verified successfully");
			Reporter.log("Forward arrow working verified successfully");
		}
	}
	
	@QAFTestStep (description = "User should able to see the previous month data")
	public void tfData() {
		Reporter.logWithScreenShot("Data Screenshot");
	}
}
