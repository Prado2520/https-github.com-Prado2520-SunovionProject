package com.sunovinon.steps;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.util.Validator;

//public class UIBackend extends WebDriverBaseTestPage<WebDriverTestPage> {
public class UIBackend extends WebDriverBaseTestPage<WebDriverTestPage> {
	String d = "dlink";

	public void extractDisplayUIData() {

		System.out.println("Disbursement_UI_Count :" + CommonStep.getText("rep.dlink.text"));
		System.out.println("Inventory_UI_Count :" + CommonStep.getText("rep.invenlink.text"));
		System.out.println("Shipments_UI_Count :" + CommonStep.getText("rep.shiplink.text"));
		System.out.println("ShipmentsAcknowledgements_UI_Count :" + CommonStep.getText("rep.shipAklink.text"));
		System.out.println("Returns_UI_Count :" + CommonStep.getText("rep.returnlink.text"));
		System.out.println("ReturnsAcknowledgements_UI_Count :" + CommonStep.getText("rep.returnAklink.text"));
		System.out.println("TransfersOut_UI_Count :" + CommonStep.getText("rep.tranoutlink.text"));
		System.out.println("TransfersIn_UI_Count :" + CommonStep.getText("rep.traninlink.text"));
		System.out.println("Thefts_UI_Count :" + CommonStep.getText("rep.theftlink.text"));
		System.out.println("Losses_UI_Count :" + CommonStep.getText("rep.losslink.text"));
		System.out.println("Adjustments_UI_Count :" + CommonStep.getText("rep.adjustlink.text"));

	}
	

	public void loginPage() {
		// Login block
		CommonStep.get("/");
		CommonStep.sendKeys("super", "login.username.text");
		CommonStep.sendKeys("Welcome1", "login.password.text");
		CommonStep.click("login.loginbtn.text");
		driver.manage().window().maximize();

	}

	public void dashboardPage() {

		// CLick on the Dashboard link
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
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("scroll(0, 350);");

	}
    
	@QAFTestStep (description ="To select Quarter")
	public void createLOC(String sQuarterName) throws InterruptedException {

		int x = 1;

		do {
			try {
				QAFExtendedWebElement ele = driver.findElement(By.xpath(
						String.format("//div[@class='kn-navigator text-center']//h6[contains(.,'%s')]", sQuarterName)));
				x = 2;
			}

			catch (Exception e) {
				e.printStackTrace();
				Thread.sleep(2000);
				CommonStep.click("sims.bkarrow.text");
			}
		} while (x == 1);
	}

	@QAFTestStep(description = "User should be connected to corresponding database & should be present on the Sunovion dashboard page")
	public void connection() throws InterruptedException {
		UIBackend u = new UIBackend();
		u.loginPage();
		u.dashboardPage();
		u.createLOC("Q1, 2019");
	}

	@QAFTestStep(description = "User should extract data from both back end & UI of all the objects")
	public void data() {
		UIBackend u = new UIBackend();
		u.extractDisplayUIData();
		Reporter.log("ahpahihgaighiahgiahgifhagffhhfihfd");

		System.out.println("-------------------------Backend Data---------------------------------------------");
		Reporter.log("-------------------------Backend Data---------------------------------------------");
		DatabaseConnectionPOC d = new DatabaseConnectionPOC();
		String a = "";
		a=d.DBConfig(d.query_DisbursementCount_Q1_2019);
		System.out.println("DisbursementCount_Back_End :" + d.DBConfig(d.query_DisbursementCount_Q1_2019));
		Reporter.log("DisbursementCount_Back_End :" + d.DBConfig(d.query_DisbursementCount_Q1_2019));
		Reporter.log("DisbursementCount_Back_End :" + a);
		// ----------------------Adjustments---------------------------------------------------
		System.out.println("AdjustmentsCount_Back_End :" + d.DBConfig(d.query_Adjustments_Q1_2019));
		Reporter.log("AdjustmentsCount_Back_End :" + d.DBConfig(d.query_Adjustments_Q1_2019));
		// ----------------------Transfer Out----------------------------------------------------------------
        System.out.println("Transfer_OutCount_Back_End :" + d.DBConfig(d.query_Transfer_Out_Q1_2019));
        Reporter.log("Transfer_OutCount_Back_End :" + d.DBConfig(d.query_Transfer_Out_Q1_2019));
		// -----------------------Transfer IN----------------------------------------
		System.out.println("Transfer_InCount_Back_End :" + d.DBConfig(d.query_Transfer_In_Q1_2019));
		Reporter.log("Transfer_InCount_Back_End :" + d.DBConfig(d.query_Transfer_In_Q1_2019));
		// -----------------------------------Thefts----------------------------------------------------------
		System.out.println("TheftsCount_Back_End :" + d.DBConfig(d.query_Thefts_Q1_2019));
		Reporter.log("TheftsCount_Back_End :" + d.DBConfig(d.query_Thefts_Q1_2019));
		// ----------------------------------------Shipment_Ack------------------------------------------------
		System.out.println("Shipment_AckCount_Back_End :" + d.DBConfig(d.query_Shipment_Ack_Q1_2019));
		Reporter.log("Shipment_AckCount_Back_End :" + d.DBConfig(d.query_Shipment_Ack_Q1_2019));
		// --------------------------------------Shipment------------------------------------------------------
		System.out.println("ShipmentCount_Back_End :" + d.DBConfig(d.query_Shipment_Q1_2019));
		Reporter.log("ShipmentCount_Back_End :" + d.DBConfig(d.query_Shipment_Q1_2019));
		// ------------------------------------------Returns_Ack-----------------------------------------------
		System.out.println("Returns_AckCount_Back_End :" + d.DBConfig(d.query_Returns_Ack_Q1_2019));
		Reporter.log("Returns_AckCount_Back_End :" + d.DBConfig(d.query_Returns_Ack_Q1_2019));
		// -------------------------------------------Returns--------------------------------------------------
		System.out.println("ReturnsCount_Back_End :" + d.DBConfig(d.query_Returns_Q1_2019));
		Reporter.log("ReturnsCount_Back_End :" + d.DBConfig(d.query_Returns_Q1_2019));
		// --------------------------------------------Losses--------------------------------------------------
		System.out.println("LossesCount_Back_End :" + d.DBConfig(d.query_Losses_Q1_2019));
		Reporter.log("LossesCount_Back_End :" + d.DBConfig(d.query_Losses_Q1_2019));
		// ------------------------------------------Inventory-------------------------------------------------
		System.out.println("InventoryCount_Back_End :" + d.DBConfig(d.query_Inventory_Q1_2019));
		Reporter.log("InventoryCount_Back_End :" + d.DBConfig(d.query_Inventory_Q1_2019));

	}

	@QAFTestStep(description = "Compare the back end and UI count")
	public void compare() {
		UIBackend u = new UIBackend();
		DatabaseConnectionPOC d = new DatabaseConnectionPOC();
		System.out.println("Hello");
		System.out.println(CommonStep.getText("rep.dlink.text"));
		System.out.println(CommonStep.getText("rep.dlink.text"));

		if ((CommonStep.getText("rep.dlink.text")).equalsIgnoreCase(d.DBConfig(d.query_DisbursementCount_Q1_2019))) {
			System.out.println("Disbursement Count Matches");
		}
		
		
		
		
        //Disbursement Count Comparison
		Validator.verifyTrue((CommonStep.getText("rep.dlink.text")).equalsIgnoreCase(d.DBConfig(d.query_DisbursementCount_Q1_2019)),
				"Disbursement Count doesn't Matches", "Disbursement Count Matches");

		//Shipment_Acknowledgement Count Comparison
		Validator.verifyTrue((CommonStep.getText("rep.shipAklink.text")).equalsIgnoreCase(d.DBConfig(d.query_Shipment_Ack_Q1_2019)),
				"Shipment_Ack Count doesn't Matches", "Shipment_Ack Count Matches");
		
		//Transfer Out Count Comparison
		Validator.verifyTrue((CommonStep.getText("rep.tranoutlink.text")).equalsIgnoreCase(d.DBConfig(d.query_Transfer_Out_Q1_2019)),
				"Transfer Out Count doesn't Matches", "Transfer Out Count Matches");

		//Transfer In Count Comparison
		Validator.verifyTrue((CommonStep.getText("rep.traninlink.text")).equalsIgnoreCase(d.DBConfig(d.query_Transfer_In_Q1_2019)),
				"Transfer In Count doesn't Matches", "Transfer In Count Matches");
		
		//Adjustments Comparison
				Validator.verifyTrue((CommonStep.getText("rep.adjustlink.text")).equalsIgnoreCase(d.DBConfig(d.query_Adjustments_Q1_2019)),
						"Adjustments Count doesn't Matches", "Adjustments Count Matches");
				
		//Returns Acknowledgement Comparison
				Validator.verifyTrue((CommonStep.getText("rep.returnAklink.text")).equalsIgnoreCase(d.DBConfig(d.query_Returns_Ack_Q1_2019)),
						"Returns Acknowledgement Count doesn't Matches", "Returns Acknowledgement Count Matches");
	   
		//Returns  Comparison
				Validator.verifyTrue((CommonStep.getText("rep.returnlink.text")).equalsIgnoreCase(d.DBConfig(d.query_Returns_Q1_2019)),
						"Returns Count doesn't Matches", "Returns Count Matches");
	 
		//Inventory  Comparison
				Validator.verifyTrue((CommonStep.getText("rep.invenlink.text")).equalsIgnoreCase(d.DBConfig(d.query_Inventory_Q1_2019)),
						"Inventory Count doesn't Matches", "Inventory Count Matches");
				
	    //Theft  Comparison
				Validator.verifyTrue((CommonStep.getText("rep.theftlink.text")).equalsIgnoreCase(d.DBConfig(d.query_Thefts_Q1_2019)),
						"Theft Count doesn't Matches", "Theft Count Matches");
				
		//Loss  Comparison
				Validator.verifyTrue((CommonStep.getText("rep.losslink.text")).equalsIgnoreCase(d.DBConfig(d.query_Losses_Q1_2019)),
						"Loss Count doesn't Matches", "Loss Count Matches");
				
		
		
		
		
	}

	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stub

	}

}
