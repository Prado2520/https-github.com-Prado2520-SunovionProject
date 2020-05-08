package com.sunovinon.steps;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Set;

import org.hamcrest.Matchers;
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
import com.qmetry.qaf.automation.util.Validator;

public class VerifyDoLogin extends WebDriverBaseTestPage<WebDriverTestPage> {

	// String firstWindowHandle = new
	// WebDriverTestBase().getDriver().getWindowHandle();

	TimeStampScreenshot scrsht = new TimeStampScreenshot();
    

	@QAFTestStep(description = "User opens the Url")
	public void OpenUrl() {

		CommonStep.get("/");

	}

	@QAFTestStep(description = "User enter valid {0} and valid {1}")
	public void doMyLogin(String userName, String password) throws AWTException, IOException {
		CommonStep.sendKeys(userName, "login.username.text");
		CommonStep.sendKeys(password, "login.password.text");
		System.out.println(password);
		System.out.println(userName);
		CommonStep.click("login.loginbtn.text");
		driver.manage().window().maximize();
		Reporter.logWithScreenShot("Login Successful");
		CommonStep.waitForVisible("sims.description.text");
		Validator.verifyThat("Wlecome to Home Page", "Knipper's Sample Compliance System", Matchers.equalToIgnoringWhiteSpace(CommonStep.getText("sims.description.text")));
		//Validator.verifyThat(TotalCount, Matchers.equalTo(TransactionLabelCountInt));
		scrsht.Login();

	}

	@QAFTestStep(description = "Verify dashboard page")
	public void verifyDashboardPagee() throws AWTException, IOException {
		
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
		Validator.verifyThat("Wlecome to DashboardPage Page", "Rep Sampling Activities", Matchers.equalToIgnoringWhiteSpace(CommonStep.getText("sims.dash.text")));
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("scroll(0, 350);");

		Reporter.logWithScreenShot("Screenshot Rep Samling Activity Page");



	}

	@QAFTestStep(description = "Verify count displayed in Rep Sampling Activity Page to that displayed in the Transaction Page")
	public void CountVerification() throws AWTException, IOException, InterruptedException {
		
		CommonStep.click("sims.bkarrow.text");
		CommonStep.click("sims.bkarrow.text");
		CommonStep.click("sims.bkarrow.text");
		CommonStep.click("sims.bkarrow.text");
		CommonStep.click("sims.bkarrow.text");
		Reporter.logWithScreenShot("Click on Back arrow");
	
		scrsht.Login();
		String textDisbursements = CommonStep.getText("rep.dlink.text");
		Reporter.log("Disbursement Object count in Rep Sampling Activity :" + textDisbursements);
		
		Reporter.logWithScreenShot("Welcome to Transaction Page");
		System.out.println("-------Text Disbursement = " + textDisbursements);
		CommonStep.click("rep.dlink.text");
		// CommonStep.waitForText("", "");
		Thread.sleep(3000);

		String textTransactions = CommonStep.getText("rep.tlink.text");
		System.out.println("Text Trans :"+textTransactions);

		String textTransactions1 = textTransactions.replaceAll("[^0-9]", "");
		Reporter.log("Disbursement Object count displayed on the Transaction Page :" + textTransactions1);
		System.out.println("-------textTransactions1 =" + textTransactions1);
		// CommonStep.verifyText(textTransactions1, textDisbursements);

		Validator.verifyThat(textDisbursements, Matchers.equalTo(textTransactions1));
		if (textDisbursements.equalsIgnoreCase(textTransactions1)) {
			System.out.println("Count matches");
			Reporter.log("Count Matches");

		}
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {

	}
}
