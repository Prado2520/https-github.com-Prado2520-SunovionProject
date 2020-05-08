package com.sunovinon.steps;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;

public class verifyDocumentReferenceFilter extends WebDriverBaseTestPage<WebDriverTestPage> {
	String Document_Reference = "C036064690";
	

	TimeStampScreenshot scrsht = new TimeStampScreenshot();
	
	@QAFTestStep (description = "Transaction page")
	public void TransactionPageDocumentFilter() throws InterruptedException {
		VerifyLastNameFilter Filter = new VerifyLastNameFilter();
		Filter.TransactionPage();
	}
	
	 
	@QAFTestStep (description = "User uses Document/Reference Filter")
	public void DocumentReferenceFilter() throws AWTException, InterruptedException, IOException {
		
		CommonStep.sendKeys(Document_Reference, "tran.docref.text");
		CommonStep.click("tran.fil.text");
		Thread.sleep(10000);
		Reporter.logWithScreenShot("Filter Applied");
		//System.out.println(CommonStep.getText("tran.onerow.data"));
		//table[@class='table full-width']/tbody/tr/td[8]
		//List<WebElement> data = new ArrayList<WebElement>();
		/*data = (ArrayList<String>) driver.findElements("tran.lastnamecol.data");
		*/
		List<WebElement> data = driver.findElements(By.xpath("//table[@class='table full-width']/tbody/tr/td[5]"));
		List<WebElement> element = data;
		int Count=data.size();
		System.out.println(Count);
		Reporter.log("No. of rows after applying filter for Document_Reference :--"+Document_Reference+" is "+Count);
		
		for(int i =0; i<data.size(); i++) {
			
			Validator.verifyThat(data.get(i).getText(), Matchers.equalTo(Document_Reference));
		}
		
		
		
		scrsht.DocumentReference();
		System.out.println("Data should be printed here");
				/*
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	    BufferedImage screenFullImage = new Robot().createScreenCapture(screenRect);
	    String ext = "dat";
	    File dir = new File("C:/Screenshots/DocumentReference");
	    String name = String.format("%s.%s",RandomStringUtils.randomAlphabetic(8), ext);
	    ImageIO.write(screenFullImage, "png", new File(dir, name));*/
	}


	

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	
}
