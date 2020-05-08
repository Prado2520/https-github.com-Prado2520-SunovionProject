package com.sunovinon.steps;

import java.awt.AWTException;
import java.io.IOException;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.util.Reporter;

public class VerifyDateFilter extends WebDriverBaseTestPage<WebDriverTestPage>{
	
	String FromDate = "1/1/2020";
	String ToDate = "1/3/2020";
	

	TimeStampScreenshot scrsht = new TimeStampScreenshot();
	
	@QAFTestStep (description = "Transaction page Date Filter")
	public void TransactionPageDateFilter() throws InterruptedException {
		VerifyLastNameFilter Filter = new VerifyLastNameFilter();
		Filter.TransactionPage();
	}
	
	@QAFTestStep (description = "User uses Date Filter")
	public void DateFilter() throws InterruptedException, AWTException, IOException {
		CommonStep.sendKeys(FromDate, "tran.LDateRangeFrom.text");
		CommonStep.sendKeys(ToDate, "tran.LDateRangeTo.text");
		CommonStep.click("tran.fil.text");
		Thread.sleep(10000);
		Reporter.logWithScreenShot("Filter Applied");
		scrsht.DateFilter();
		
		/*Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	    BufferedImage screenFullImage = new Robot().createScreenCapture(screenRect);
	    String ext = "dat";
	    File dir = new File("C:/Screenshots/LinkingDateRange");
	    String name = String.format("%s.%s",RandomStringUtils.randomAlphabetic(8), ext);
	    ImageIO.write(screenFullImage, "png", new File(dir, name));
		*/
		
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}

}
