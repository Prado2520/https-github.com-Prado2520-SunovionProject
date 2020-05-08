package com.sunovinon.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.util.Reporter;

public class VerifyTerritoryFilter extends WebDriverBaseTestPage<WebDriverTestPage>{
	
	//String Territory = "K03103071";
	String Territory = "H04606072";
	
	TimeStampScreenshot scrsht = new TimeStampScreenshot();
	
	@QAFTestStep (description = "Transaction page for Territory Filter")
	public void TransactionPageTerritory() throws InterruptedException {
		VerifyLastNameFilter Filter = new VerifyLastNameFilter();
		Filter.TransactionPage();
	}
	
	@QAFTestStep (description = "User uses Territory Filter to filter records")
	public void TerritoryFilter() throws Throwable {
		CommonStep.sendKeys(Territory, "tran.territory.text");
		CommonStep.click("tran.fil.text");
		Thread.sleep(10000);
		Reporter.logWithScreenShot("Filter Applied");
		//System.out.println(CommonStep.getText("tran.onerow.data"));
		//table[@class='table full-width']/tbody/tr/td[8]
		//List<WebElement> data = new ArrayList<WebElement>();
		/*data = (ArrayList<String>) driver.findElements("tran.lastnamecol.data");
		*/
		//List<WebElement> data = driver.findElements(By.xpath("//table[@class='table full-width']/tbody/tr/td[5]"));
		List<WebElement> data = driver.findElements(By.xpath("//table[@class='table full-width']/tbody/tr"));
		
		List<WebElement> element = data;
		int Count=data.size();
		System.out.println(Count);
		Reporter.log("No. of rows after applying filter for Territory :--"+Territory+" is "+Count);
		
		/*for(int i =0; i<data.size(); i++) {
			
			Validator.verifyThat(data.get(i).getText(), Matchers.equalTo(Territory));
		}*/
		
		scrsht.Territory();
		
				
/*		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	    BufferedImage screenFullImage = new Robot().createScreenCapture(screenRect);
	    String ext = "dat";
	    File dir = new File("C:/Screenshots/Territory");
	    String name = String.format("%s.%s",RandomStringUtils.randomAlphabetic(8), ext);
	    ImageIO.write(screenFullImage, "png", new File(dir, name));*/
		
	}

	

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	

}
