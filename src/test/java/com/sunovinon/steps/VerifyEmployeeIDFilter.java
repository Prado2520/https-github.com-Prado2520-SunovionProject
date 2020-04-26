package com.sunovinon.steps;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.lang.RandomStringUtils;
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

public class VerifyEmployeeIDFilter extends WebDriverBaseTestPage<WebDriverTestPage>{
	
	//String EmployeeID = "1057";1181
	String EmployeeID = "1181";
	TimeStampScreenshot Scrshot = new TimeStampScreenshot();
	
	@QAFTestStep (description = "User there on transaction page")
	public void TPage() throws InterruptedException {
		VerifyLastNameFilter Filter = new VerifyLastNameFilter();
		Filter.TransactionPage();
	}
	
	@QAFTestStep (description = "User uses specific employee id filter")
	public void EmployeeIDFilter() throws Exception {
	//CommonStep.click("tran.empID.text");
	CommonStep.sendKeys(EmployeeID, "tran.empID.text");
	CommonStep.click("tran.fil.text");
	Thread.sleep(10000);
	Reporter.logWithScreenShot("Filter Applied");
	//System.out.println(CommonStep.getText("tran.onerow.data"));
	//table[@class='table full-width']/tbody/tr/td[8]
	//List<WebElement> data = new ArrayList<WebElement>();
	/*data = (ArrayList<String>) driver.findElements("tran.lastnamecol.data");
	*/
	List<WebElement> data = driver.findElements(By.xpath("//table[@class='table full-width']/tbody/tr/td[7]"));
	List<WebElement> element = data;
	int Count=data.size();
	System.out.println(Count);
	Reporter.log("No. of rows after applying filter for EmployeeID :--"+EmployeeID+" are "+Count);
	
	for(int i =0; i<data.size(); i++) {
		
		Validator.verifyThat(data.get(i).getText(), Matchers.equalTo(EmployeeID));
	}
	
	
	
	System.out.println("Data should be printed here");
	
	
	



	
			
			
	Scrshot.EmployeeID();		
			
/*	Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
    BufferedImage screenFullImage = new Robot().createScreenCapture(screenRect);
    String ext = "dat";
    File dir = new File("C:/Screenshots/EmployeeID");
    String name = String.format("%s.%s",RandomStringUtils.randomAlphabetic(8), ext);
    ImageIO.write(screenFullImage, "png", new File(dir, name));*/
    
}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	
	

}
