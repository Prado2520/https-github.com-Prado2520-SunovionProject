package com.sunovinon.steps;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.util.Reporter;

public class SunovionVerifyLinks extends WebDriverBaseTestPage<WebDriverTestPage>  {
     TimeStampScreenshot scrsht = new TimeStampScreenshot();
     
	@QAFTestStep(description = "User clicks on the Url link")
	public void OpenApplication() {
         
		CommonStep.get("/");
		driver.manage().window().maximize();
	}

	@QAFTestStep(description = "Enter Login credentials")
	public void LoginPage() {

		CommonStep.sendKeys("super", "login.username.text");
		CommonStep.sendKeys("Welcome1", "login.password.text");
		CommonStep.click("login.loginbtn.text");
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[text()='SIMS 3.0 Beta']"));
		action.moveToElement(element).perform();

		String firstWindowHandle = new WebDriverTestBase().getDriver().getWindowHandle();
		System.out.println("--------------------window before click" + firstWindowHandle);

		CommonStep.click("home.dashboard.link");
		Set<String> setWindowHandles = new WebDriverTestBase().getDriver().getWindowHandles();
		System.out.println("--------------------window after click" + setWindowHandles);

		for (String strWindowHandle : setWindowHandles) {
			if (!strWindowHandle.equals(firstWindowHandle))

			{
				new WebDriverTestBase().getDriver().switchTo().window(strWindowHandle);
			}

		}

		String SecondWindowHandle = new WebDriverTestBase().getDriver().getWindowHandle();
		System.out.println("======== Second Window Handle" + SecondWindowHandle);

		CommonStep.waitForVisible("sims.quarterly.text");
		driver.manage().window().maximize();

	}

	@QAFTestStep(description = "User clicks on Dashboard link")
	public void DashboardLink() {
		System.out.println("You are in verify dashbaord Page");
		driver.manage().window().maximize();
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("scroll(0, 350);");

		Reporter.logWithScreenShot("Screenshot Rep Samling Activity Page");

	}

	@QAFTestStep(description = "Verify links under rep sampling")
	public void VerifyLinks() throws InterruptedException, AWTException, IOException {
		int size = 7;
		for (int i = 0; i < size; i++) {
			CommonStep.click("sims.bkarrow.text");
		}
		Reporter.logWithScreenShot("Click on Back arrow");

		String textDisbursements = CommonStep.getText("rep.dlink.text");
		System.out.println("-------Text Disbursement = " + textDisbursements);
		CommonStep.click("rep.dlink.text");
		Reporter.log("Click on Disbursement Link");
		CommonStep.waitForVisible("rep.tlink.text");
		Reporter.logWithScreenShot("Welcome to Transaction Page");
		scrsht.Links();
		String textTransactions = CommonStep.getText("rep.tlink.text");

		String textTransactions1 = textTransactions.replaceAll("[^0-9]", "");
		System.out.println("-------textTransactions1 =" + textTransactions1);
		// CommonStep.verifyText(textTransactions1, textDisbursements);
		if (textDisbursements.equalsIgnoreCase(textTransactions1)) {
			System.out.println("Count matches");

		}
		CommonStep.click("dash.logo.text");
		Reporter.logWithScreenShot("Back to Rep Sampling Page");
		/////////////////////////////////////////////////////////////////////////////////////
		// ----Click on Shipment Link----------------
		Thread.sleep(5000);
		CommonStep.click("sims.monthly.text");
		CommonStep.click("sims.quat.text");

		for (int i = 0; i < size; i++) {
			CommonStep.click("sims.barrow.text");
		}

		Reporter.logWithScreenShot("Click on Back arrow");
		CommonStep.click("rep.shiplink.text");
		Reporter.log("Click on Shipment Link");
		CommonStep.waitForVisible("rep.tlink.text");
		Reporter.logWithScreenShot("Welcome to Transaction__Shipment Page");
		scrsht.Links();
		CommonStep.click("dash.logo.text");
		Reporter.logWithScreenShot("Back to Rep Sampling Page");

		// ----Click on Inventory Link----------------
		Thread.sleep(5000);
		CommonStep.click("sims.monthly.text");
		CommonStep.click("sims.quat.text");

		for (int i = 0; i < size; i++) {
			CommonStep.click("sims.barrow.text");
		}

		Reporter.logWithScreenShot("Click on Back arrow");
		CommonStep.click("rep.invenlink.text");
		Reporter.log("Click on Inventory Link");
		CommonStep.waitForVisible("rep.tlink.text");
		Reporter.logWithScreenShot("Welcome to Transaction__Inventory Page");
		scrsht.Links();
		CommonStep.click("dash.logo.text");
		Reporter.logWithScreenShot("Back to Rep Sampling Page");

		// ----Click on Shipment_Acknowledgement Link----------------
		Thread.sleep(5000);
		CommonStep.click("sims.monthly.text");
		CommonStep.click("sims.quat.text");

		for (int i = 0; i < size; i++) {
			CommonStep.click("sims.barrow.text");
		}

		Reporter.logWithScreenShot("Click on Back arrow");
		CommonStep.click("rep.shipAklink.text");
		Reporter.log("Click on Shipment_Acknowledgement Link");
		CommonStep.waitForVisible("rep.tlink.text");
		Reporter.logWithScreenShot("Welcome to Transaction__Shipment_Acknowledgement Page");
		scrsht.Links();
		CommonStep.click("dash.logo.text");
		Reporter.logWithScreenShot("Back to Rep Sampling Page");

		// ----Click on Returns Link----------------
		Thread.sleep(5000);
		CommonStep.click("sims.monthly.text");
		CommonStep.click("sims.quat.text");

		for (int i = 0; i < size; i++) {
			CommonStep.click("sims.barrow.text");
		}

		Reporter.logWithScreenShot("Click on Back arrow");
		CommonStep.click("rep.returnlink.text");
		Reporter.log("Click on Return Link");
		CommonStep.waitForVisible("rep.tlink.text");
		Reporter.logWithScreenShot("Welcome to Transaction_Returns Page");
		scrsht.Links();
		CommonStep.click("dash.logo.text");
		Reporter.logWithScreenShot("Back to Rep Sampling Page");

		// ----Click on Returns Acknowledgement Link----------------
		Thread.sleep(5000);
		CommonStep.click("sims.monthly.text");
		CommonStep.click("sims.quat.text");

		for (int i = 0; i < size; i++) {
			CommonStep.click("sims.barrow.text");
		}

		Reporter.logWithScreenShot("Click on Back arrow");
		CommonStep.click("rep.returnAklink.text");
		Reporter.log("Click on Return Acknowledgement Link");
		CommonStep.waitForVisible("rep.tlink.text");
		Reporter.logWithScreenShot("Welcome to Transaction_Returns_Acknowledgement Page");
		scrsht.Links();
		CommonStep.click("dash.logo.text");
		Reporter.logWithScreenShot("Back to Rep Sampling Page");

		// ----Click on Transfer Out Link----------------
		Thread.sleep(5000);
		CommonStep.click("sims.monthly.text");
		CommonStep.click("sims.quat.text");

		for (int i = 0; i < size; i++) {
			CommonStep.click("sims.barrow.text");
		}

		Reporter.logWithScreenShot("Click on Back arrow");
		CommonStep.click("rep.tranoutlink.text");
		Reporter.log("Click on Transfer_Out Link");
		CommonStep.waitForVisible("rep.tlink.text");
		Reporter.logWithScreenShot("Welcome to Transaction_Transfer_Out Page");
		scrsht.Links();
		CommonStep.click("dash.logo.text");
		Reporter.logWithScreenShot("Back to Rep Sampling Page");

		// ----Click on Transfer In Link----------------
		Thread.sleep(5000);
		CommonStep.click("sims.monthly.text");
		CommonStep.click("sims.quat.text");

		for (int i = 0; i < size; i++) {
			CommonStep.click("sims.barrow.text");
		}

		Reporter.logWithScreenShot("Click on Back arrow");
		CommonStep.click("rep.traninlink.text");
		Reporter.log("Click on Transfer_In Link");
		CommonStep.waitForVisible("rep.tlink.text");
		Reporter.logWithScreenShot("Welcome to Transaction_Transfer_In Page");
		scrsht.Links();
		CommonStep.click("dash.logo.text");
		Reporter.logWithScreenShot("Back to Rep Sampling Page");

	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub

	}

}
