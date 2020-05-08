package com.sunovinon.steps;

import java.awt.AWTException;
import java.io.IOException;

import org.sikuli.script.FindFailed;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;
import com.sunovion.pages.PracticeTransactionPage;
import com.sunovion.pages.ScreenClass;
import com.sunovion.pages.practicedashboardpage;
import com.sunovion.pages.practicehomepage;
import com.sunovion.pages.practiceloginpage;

public class ExportTransaction extends WebDriverTestCase{
	practiceloginpage lpage = new practiceloginpage();
	practicehomepage hpage = new practicehomepage();
	practicedashboardpage dpage = new practicedashboardpage();
	PracticeTransactionPage tpage = new PracticeTransactionPage();
	TimeStampScreenshot scrshot = new TimeStampScreenshot();
	
	
	@QAFTestStep (description = "user launches the Url")
	public void etlaunch() throws AWTException, IOException, InterruptedException {
		lpage.launchSunovionSite();
		Thread.sleep(2000);
		scrshot.ExportTransaction();
	}
	
	@QAFTestStep (description = "user enter valid credentials and click on login button")
	public void etlaunchPage() throws InterruptedException, AWTException, IOException  {
		lpage.enterUsername(getProps().getString("Username"));
		lpage.enterPassword(getProps().getString("Password"));
		Thread.sleep(2000);
		scrshot.ExportTransaction();
		lpage.clickLoginButton();
	}
	
	@QAFTestStep (description = "user enter valid credentials and click on login button")
	public void ethomePage() throws InterruptedException, AWTException, IOException {
		hpage.homepageVerification();
		Thread.sleep(2000);
		scrshot.ExportTransaction();
		hpage.clickDashboardLink();
	}

	@QAFTestStep (description = "user is on dasboard page & clicks on quarter button under rep sampling activities")
	public void etdashboardPage() throws AWTException, IOException, InterruptedException {
		Thread.sleep(2000);
		scrshot.ExportTransaction();
		dpage.clickQuarterlyButton();
		}
	
	@QAFTestStep (description = "user clicks back arrow until quarter q1 & year 2019")
	public void etquarterButton() throws InterruptedException, AWTException, IOException {
	    tpage.waitTillPageLoads();
		dpage.selectQuarter(getProps().getString("Quarter"));
		Thread.sleep(2000);
		scrshot.ExportTransaction();
	}
	
	@QAFTestStep (description = "user clicks on any object link under the rep sampling activity")
	public void etclickLink() {
		dpage.clickDisbursementLink();
	}
	
	@QAFTestStep (description = "user is on transaction page")
	public void ettransactionPage() throws AWTException, IOException, InterruptedException {
		tpage.verifyTransactionPage();
		Thread.sleep(2000);
		scrshot.ExportTransaction();
	}
	
	@QAFTestStep (description = "click on select column link and select columns")
	public void etSelectAdditionalColumn() throws InterruptedException, AWTException, IOException {
		tpage.clickSelectColumnLink();
	    tpage.clickAllCheckBox();
	   scrshot.ExportTransaction();
	}
	
	@QAFTestStep (description = "clicks on export transaction button")
	public void etclickExportTransactionButton() throws InterruptedException, AWTException {
		Thread.sleep(3000);
		tpage.clickExportTransaction();
		Thread.sleep(10000);
	}
	
	@QAFTestStep (description = "open trnasaction excel sheet")
	public void etSikuli() throws FindFailed, InterruptedException, AWTException, IOException {
		ScreenClass sc = new ScreenClass();
		sc.DesktopAutomation();
	}
	
	@QAFTestStep (description = "import excel data & verify all the columns are dislayed in the excel sheet data")
	public void etVerifyExcelColumns() throws IOException {
		ImportExcelData ed = new ImportExcelData();
		ed.readExcel(ed.filepath, ed.fileName, ed.sheetName);
		Reporter.log("Script is executed comepletely ");
		
	}
}
