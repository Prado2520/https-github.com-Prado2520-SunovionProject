package com.sunovion.pages;

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
import com.qmetry.qaf.automation.util.Validator;

public class practicehomepage extends WebDriverBaseTestPage<WebDriverTestPage> {
	
	
	@QAFTestStep(description = "verify homepage")
	public void homepageVerification() {
		Validator.verifyTrue(CommonStep.verifyPresent("homepage.label.text"), "You are not on Home page", "Welcome to Homepage");
		
	}

	@QAFTestStep(description = "click on dashboard link")
	public void clickDashboardLink() {
		driver.navigate().refresh();
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[text()='SIMS 3.0 Beta']"));
		action.moveToElement(element).perform();

		String firstWindowHandle = new WebDriverTestBase().getDriver().getWindowHandle();
		verifyDashboardLink();
		CommonStep.click("home.dashboard.link");
		Set<String> setWindowHandles = new WebDriverTestBase().getDriver().getWindowHandles();
		System.out.println("--------------------window after click" + setWindowHandles);

		for (String strWindowHandle : setWindowHandles) {
			if (!strWindowHandle.equals(firstWindowHandle)) {
				new WebDriverTestBase().getDriver().switchTo().window(strWindowHandle);
			}}

		String SecondWindowHandle = new WebDriverTestBase().getDriver().getWindowHandle();
	}
	
	
	@QAFTestStep (description = "verify dashboard link")
	public void verifyDashboardLink() {
		Validator.verifyTrue(CommonStep.verifyPresent("home.dashboard.link"), "Dashboard link verification failed", "Dashboard link verification passed");
	}
	

	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stub

	}

}
