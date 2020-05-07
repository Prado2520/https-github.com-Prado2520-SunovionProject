package com.sunovion.pages;

import org.openqa.selenium.By;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.TestPage;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;

public class practicedashboardpage extends WebDriverBaseTestPage<WebDriverTestPage> {
	

	@QAFTestStep (description = "To verify dashbaord page")
	public void dashboardPage() throws InterruptedException {
		//wait(1000);
		//CommonStep.waitForVisible("dashboard.welcome.text");
		//driver.manage().timeouts().wait(1500);
		//wait(5000);
		
		Validator.verifyTrue(CommonStep.verifyPresent("dashboard.welcome.text"), "You are not on Dashboard page", "Welcome to Dashboard page");
	}
	
	@QAFTestStep (description = "Click on Quaterly button")
	public void clickQuarterlyButton() {
		CommonStep.click("dashboard.quarterly.button");
	}
	
	@QAFTestStep (description = "Verify Quarter Button")
	public void verifyQuarterButton() {
		Validator.verifyTrue(CommonStep.verifyPresent("dashboard.quarterly.button"), "Quarterly button verification failed", "Quarterly button verified successfully");
	}
	
	@QAFTestStep (description = "Verify Monthly Button")
	public void verifyMonthlyButton() {
		Validator.verifyTrue(CommonStep.verifyPresent("dashboard.monthly.button"), "Monthly button verification failed", "Monthly button verified successfully");
	}
	
	@QAFTestStep (description = "Click on Monthly button")
	public void clickMonthlyButton() {
		CommonStep.click("dashboard.monthly.button");
		
	}
	
	@QAFTestStep (description = "Back arrow button")
	public void backArrowButton() {
		CommonStep.click("sims.bkarrow.text");
	}
	
	@QAFTestStep (description = "Forward arrow button")
	public void forwardArrowButton() {
		CommonStep.click("dashboard.forwardarrow.text");
	}
	
	@QAFTestStep (description = "Click on back arrow button quarter wise")
	public void selectQuarter(String sQuarterName) throws InterruptedException {

		int x = 1;

		do {
			try {
				QAFExtendedWebElement ele = driver.findElement(By.xpath(
						String.format("//div[@class='kn-navigator text-center']//h6[contains(.,'%s')]", sQuarterName)));
				x = 2;
			    Reporter.logWithScreenShot("Selected Quarter Screenshot");
				//QAFWebElement ele1 = driver.findElement(By.xpath(String.format("//div[@class='kn-navigator text-center']//h6[contains(.,'%s')]", sQuarterName)));
			}

			catch (Exception e) {
				e.printStackTrace();
				Thread.sleep(2000);
				CommonStep.click("sims.bkarrow.text");
			}
		} while (x == 1);
	}
	
	@QAFTestStep (description = "Click on back arrow button month wise")
	public void selectMonth(String sMonthName) throws InterruptedException {

		int x = 1;

		do {
			try {
				QAFExtendedWebElement ele = driver.findElement(By.xpath(
						String.format("//div[@class='kn-navigator text-center']//h6[contains(.,'%s')]", sMonthName)));
				x = 2;
			    Reporter.logWithScreenShot("Selected Quarter Screenshot");
				//QAFWebElement ele1 = driver.findElement(By.xpath(String.format("//div[@class='kn-navigator text-center']//h6[contains(.,'%s')]", sQuarterName)));
			}

			catch (Exception e) {
				e.printStackTrace();
				Thread.sleep(2000);
				CommonStep.click("sims.bkarrow.text");
			}
		} while (x == 1);
	}
	
	@QAFTestStep (description = "Click on SUNOVION logo")
	public void clickSunovionlogo() {
		CommonStep.click("dash.logo.text");
	}
	
	@QAFTestStep (description = "Click on Disbursement link")
	public void clickDisbursementLink() {
		CommonStep.click("rep.disbursement.link");
	}
	
	@QAFTestStep (description = "Click on Inventory link")
	public void clickInventoryLink() {
		CommonStep.click("rep.inventory.link");
	}
	
	@QAFTestStep (description = "Click on Shipments link")
	public void clickShipmentsLink() {
		CommonStep.click("rep.shipments.link");
	}
	
	@QAFTestStep (description = "Click on Shipment Acknowledgements link")
	public void clickShipment_AcknowledgementsLink() {
		CommonStep.click("rep.shipmentak.link");
	}
	
	@QAFTestStep (description = "Click on Returns link")
	public void clickReturnsLink() {
		CommonStep.click("rep.returns.link");
	}
	
	@QAFTestStep (description = "Click on Returns Acknowledgements link")
	public void clickReturn_AcknowledgementsLink() {
		CommonStep.click("rep.returnak.link");
	}
	
	@QAFTestStep (description = "Click on Transfers Out link")
	public void clickTransfersOutLink() {
		CommonStep.click("rep.transferout.link");
	}
	
	@QAFTestStep (description = "Click on Transfers In link")
	public void clickTransfersInLink() {
		CommonStep.click("rep.transferin.link");
	}
	
	@QAFTestStep (description = "Click on Thefts link")
	public void clickTheftsLink() {
		CommonStep.click("rep.thefts.link");
	}
	
	@QAFTestStep (description = "Click on Losses link")
	public void clickLossesLink() {
		CommonStep.click("rep.losses.link");
	}
	
	@QAFTestStep (description = "Click on Adjustments link")
	public void clickAdjustmentsLink() {
		CommonStep.click("rep.adjustments.link");
	}
	
	//------------------------------------------------------------------------------------------------------------------
	@QAFTestStep (description = "Get Disbursement Count")
	public void getDisbursementCount() {
		CommonStep.getText("rep.disbursement.link");
	}
	
	@QAFTestStep (description = "Get Inventory Count")
	public void getInventoryCount() {
		CommonStep.getText("rep.inventory.link");
	}
	
	@QAFTestStep (description = "Get Shimpents Count")
	public void getShipmentsCount() {
		CommonStep.getText("rep.shipments.link");
	}
	
	@QAFTestStep (description = "Get Shipment Acknowledgement Count")
	public void getShipmentAcknowledgement() {
		CommonStep.getText("rep.shipmentak.link");
	}
	
	@QAFTestStep (description = "Get Returns Count")
	public void getReturnsCount() {
		CommonStep.getText("rep.returns.link");
	}

	@QAFTestStep (description = "Get Return Acknowldegement Count")
	public void getReturnAcknowledgementCount() {
		CommonStep.getText("rep.returnak.link");
	}

	@QAFTestStep (description = "Get Transfers Out Count")
	public void getTransfersOutCount() {
		CommonStep.getText("rep.transferout.link");
	}
	
	@QAFTestStep (description = "Get Transfers In Count")
	public void getTransfersInCount() {
		CommonStep.getText("rep.transferin.link");
	}
	
	@QAFTestStep (description = "Get Thefts Count")
	public void getTheftsCount() {
		CommonStep.getText("rep.thefts.link");
	}

	@QAFTestStep (description = "Get Losses Count")
	public void getLossesCount() {
		CommonStep.getText("rep.thefts.link");
	}
	
	@QAFTestStep (description = "Get Adjustments Count")
	public void getAdjustmentsCount() {
	  CommonStep.getText("rep.adjustments.link");
	}
	
	
	

	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}

}
