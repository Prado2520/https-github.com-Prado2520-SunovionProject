
package com.sunovinon.steps;

import java.util.ArrayList;
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

public class VerifyTypeCheckboxFilter extends WebDriverBaseTestPage<WebDriverTestPage> {

	@QAFTestStep(description = "Transaction page TypeCheckbox Filter")
	public void TransactionPageTypeCheckboxFilter() throws InterruptedException {
		VerifyLastNameFilter Filter = new VerifyLastNameFilter();
		Filter.TransactionPage();
	}

	int DisbursementCount = 0;
	int Shipment_acknowledgement=0;
	int Shipment = 0;
	int Inventory =0;
	int Return=0;
	int Return_acknowledgement=0;
	int Transfer_In =0;
	int Transfer_Out =0;
	List<String> names = new ArrayList<String>();

	@QAFTestStep(description = "User uses TypeCheckbox Filter")
	public void TypeCheckboxFilter() throws InterruptedException {
		CommonStep.click("tran.shipa.cbx");
		CommonStep.click("tran.tro.cbx");
		CommonStep.click("tran.tri.cbx");
		CommonStep.click("tran.fil.text");

		Thread.sleep(5000);

		List<WebElement> namesElements = driver
				.findElements(By.xpath("//table[@class='table full-width']/tbody/tr/td[4]"));

		for (WebElement namesElement : namesElements) {
			names.add(namesElement.getText());
		}

		String color = driver.findElement(By.xpath("//span[text()='NEXT']")).getCssValue("color");

		while (color.equals("rgba(0, 0, 0, 0.87)")) {
			CommonStep.click("tran.next.text");

			Thread.sleep(5000);

			namesElements = driver.findElements(By.xpath("//table[@class='table full-width']/tbody/tr/td[4]"));

			for (WebElement namesElement : namesElements) {
				names.add(namesElement.getText());
			}

			color = driver.findElement(By.xpath("//span[text()='NEXT']")).getCssValue("color");

		}

		for (String name : names) {

			System.out.println(name);
			if (name.equalsIgnoreCase("Disbursement"))

			{
				DisbursementCount = ++DisbursementCount;
			}

			if (name.equalsIgnoreCase("Shipment acknowledgement"))

			{
				Shipment_acknowledgement = ++Shipment_acknowledgement;
			}
			
			if (name.equalsIgnoreCase("Shipment"))

			{
				Shipment = ++Shipment;
			}
			
			if (name.equalsIgnoreCase("Inventory"))

			{
				Inventory = ++Inventory;
			}
			if (name.equalsIgnoreCase("Return_acknowledgement"))

			{
				Return_acknowledgement = ++Return_acknowledgement;
			}
			
			if (name.equalsIgnoreCase("Return"))

			{
				Return = ++Return;
			}
			
			if (name.equalsIgnoreCase("Transfer in"))

			{
				Transfer_In = ++Transfer_In;
			}
			
			if (name.equalsIgnoreCase("Transfer out"))

			{
				Transfer_Out = ++Transfer_Out;
			}

		}
		System.out.println("DisbursementCount : " + DisbursementCount);
		Reporter.log("DisbursementCount : " + DisbursementCount);
		System.out.println("Shipment_acknowledgement : " + Shipment_acknowledgement);
		Reporter.log("Shipment_acknowledgement : " + Shipment_acknowledgement);
		System.out.println("Shipment : " + Shipment);
		Reporter.log("Shipment : " + Shipment);
		System.out.println("Inventory : " + Inventory);
		Reporter.log("Inventory : " + Inventory);
		System.out.println("Return_acknowledgement : " + Return_acknowledgement);
		Reporter.log("Return_acknowledgement : " + Return_acknowledgement);
		System.out.println("Return : " + Return);
		Reporter.log("Return : " + Return);
		System.out.println("Return_acknowledgement : " + Return_acknowledgement);
		Reporter.log("Return_acknowledgement : " + Return_acknowledgement);
		System.out.println("Return : " + Return);
		Reporter.log("Return : " + Return);
		System.out.println("Transfer_In : " + Transfer_In);
		Reporter.log("Transfer_In : " + Transfer_In);
		System.out.println("Transfer_Out : " + Transfer_Out);
		Reporter.log("Transfer_Out : " + Transfer_Out);

		
		
		
		
		
		
		String TransCount = CommonStep.getText("rep.tlink.text");
		String TransactionLabelCount = TransCount.replaceAll("[^0-9]", "");
		int TransactionLabelCountInt = Integer.parseInt(TransactionLabelCount);
		System.out.println("-------TransactionLabelCount =" + TransactionLabelCount);
		Reporter.log("TransactionLabelCount =" + TransactionLabelCount);

		int RowsCount = names.size();
		Reporter.log("RowsCount : " + RowsCount);
		Reporter.log("TransactionLabelCountInt : " + TransactionLabelCountInt);
		Validator.verifyThat(RowsCount, Matchers.equalTo(TransactionLabelCountInt));
		if (RowsCount == TransactionLabelCountInt) {
			System.out.println("Count matches");
			Reporter.log("Count matches");

		}
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub

	}

}
