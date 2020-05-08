package com.sunovinon.steps;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.util.Reporter;

public class VerifyClearLink extends WebDriverBaseTestPage<WebDriverTestPage> {
	
	TimeStampScreenshot scrsht = new TimeStampScreenshot();
	@QAFTestStep(description = "User clicks on base URL")
	public void Application() {

		CommonStep.get("/");
		driver.manage().window().maximize();
	}
	
	
	@QAFTestStep(description = "User enters valid login details")
	public void LoginA() {
		
		CommonStep.sendKeys("super", "login.username.text");
		CommonStep.sendKeys("Welcome1", "login.password.text");
		CommonStep.click("login.loginbtn.text");
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[text()='SIMS 3.0 Beta']"));
		action.moveToElement(element).perform();
		String firstWindowHandle = new WebDriverTestBase().getDriver().getWindowHandle();
		System.out.println("--------------------window before click"+firstWindowHandle);

		CommonStep.click("home.dashboard.link");
		Set<String> setWindowHandles = new WebDriverTestBase().getDriver().getWindowHandles();
		System.out.println("--------------------window after click"+setWindowHandles);
		
		for ( String strWindowHandle : setWindowHandles)
			{                 if (!strWindowHandle.equals(firstWindowHandle))
				
			{                     new WebDriverTestBase().getDriver().switchTo().window(strWindowHandle);
			}

			
			}

		String SecondWindowHandle = new WebDriverTestBase().getDriver().getWindowHandle();
		
	}
	
	@QAFTestStep(description = "User clicks on Dashboard link")
	public void Dashboard() {

		String firstWindowHandle = new WebDriverTestBase().getDriver().getWindowHandle();
		System.out.println("--------------------window before click"+firstWindowHandle);

		CommonStep.click("home.dashboard.link");
		Set<String> setWindowHandles = new WebDriverTestBase().getDriver().getWindowHandles();
		System.out.println("--------------------window after click"+setWindowHandles);
		
		for ( String strWindowHandle : setWindowHandles)
			{                 if (!strWindowHandle.equals(firstWindowHandle))
				
			{                     new WebDriverTestBase().getDriver().switchTo().window(strWindowHandle);
			}

			
			}

		String SecondWindowHandle = new WebDriverTestBase().getDriver().getWindowHandle();
		System.out.println("======== Second Window Handle"+SecondWindowHandle);
		
		
CommonStep.waitForVisible("sims.quarterly.text");
driver.manage().window().maximize();
	}
	

	@QAFTestStep(description = "User clicks on any object links under Rep Sampling activites")
	public void RepSampling( ) throws InterruptedException, AWTException, IOException {
		int size = 5;
		for (int i=0;i<size;i++)
		{
			CommonStep.click("sims.bkarrow.text");
		}
			Reporter.logWithScreenShot("Click on Back arrow");


			String textDisbursements = CommonStep.getText("rep.dlink.text");
			System.out.println("-------Text Disbursement = "+textDisbursements);
			CommonStep.click("rep.dlink.text");
			Reporter.log("Click on Disbursement Link");
			CommonStep.waitForVisible("rep.tlink.text");
			Reporter.logWithScreenShot("Welcome to Transaction Page");
			scrsht.ClearLinks();
			Reporter.logWithScreenShot("Before clickin on clear link");
			CommonStep.click("tran.clear.text");
			Thread.sleep(5000);
			Reporter.logWithScreenShot("cleared");
			/*CommonStep.click("tran.sc.link");
			CommonStep.click("tran.ai.text");
			Thread.sleep(5000);
			CommonStep.click("tran.sel.btn");
			CommonStep.click("tran.right.text");*/
			Thread.sleep(5000);
		    Reporter.logWithScreenShot("Confrimation");
		    scrsht.ClearLinks();

	}
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}

}
