package com.sunovion.pages;

import org.openqa.selenium.By;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class PracticeInventoryPage extends WebDriverBaseTestPage<WebDriverTestPage> {
	
	@QAFTestStep (description = "click on inventory Id")
	public void clickInventoryID(String ID) {
		//a[contains(.,'41854')]
		QAFExtendedWebElement ele = driver.findElement(By.xpath(
				String.format("//a[contains(.,'%s')]", ID)));
		ele.click();
	}
	
	@QAFTestStep (description = "verify Inventory page")
	public void inventoryPageVerification() {
		String Inventorypage="Transaction Detail: Inventory";
		System.out.println(CommonStep.getText("inventory.ipage.text"));
		CommonStep.getText("inventory.ipage.text");
		Validator.verifyTrue(Inventorypage.equalsIgnoreCase(CommonStep.getText("inventory.ipage.text")), "Inventory page verification failed", "Inventory page verification passed");
		
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}

}
