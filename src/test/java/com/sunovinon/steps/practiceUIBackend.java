package com.sunovinon.steps;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import com.sunovion.pages.practiceDatabaseConnection;
import com.sunovion.pages.practicedashboardpage;
import com.sunovion.pages.practicehomepage;
import com.sunovion.pages.practiceloginpage;

public class practiceUIBackend extends WebDriverTestCase {
	practiceloginpage lpage = new practiceloginpage();
	practicehomepage hpage = new practicehomepage();
	practicedashboardpage dpage = new practicedashboardpage();
	practiceDatabaseConnection d = new practiceDatabaseConnection();
	
   String s = getProps().getString("Year");
   
   

	@QAFTestStep(description = "User connected to database")
	public void databaseConn() {
		practiceDatabaseConnection dconn = new practiceDatabaseConnection();
		System.out.println("Year from property file :"+s);
	}

	@QAFTestStep(description = "User clicks on url")
	public void launch() {
		lpage.launchSunovionSite();
	}

	@QAFTestStep(description = "User enters valid username, password & clicks on login button")
	public void validLogin() {
		lpage.enterUsername(getProps().getString("Username"));
		lpage.enterPassword(getProps().getString("Password"));
		lpage.clickLoginButton();

	}

	@QAFTestStep(description = "user is on homepage & clicks on dashboard link")
	public void homepageDashboardLink() {
		hpage.homepageVerification();
		hpage.clickDashboardLink();
	}

	@QAFTestStep(description = "User is on dashboard page & clicks on quarter button under Rep Sampling Activites section")
	public void clickQuarterButton() throws InterruptedException {
		dpage.dashboardPage();
		dpage.clickQuarterlyButton();
	}

	@QAFTestStep(description = "User clicks on back arrow button until selected quarter appears")
	public void clickBackArrow() throws InterruptedException {
		dpage.selectQuarter(getProps().getString("Quarter"));
	}

	@QAFTestStep(description = "extract count from the respective objects displayed besides the object name")
	public void extractUICount() {
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

		Reporter.log("Disbursement_UI_Count :" + CommonStep.getText("rep.dlink.text"));
		Reporter.log("Inventory_UI_Count :" + CommonStep.getText("rep.invenlink.text"));
		Reporter.log("Shipments_UI_Count :" + CommonStep.getText("rep.shiplink.text"));
		Reporter.log("ShipmentsAcknowledgements_UI_Count :" + CommonStep.getText("rep.shipAklink.text"));
		Reporter.log("Returns_UI_Count :" + CommonStep.getText("rep.returnlink.text"));
		Reporter.log("ReturnsAcknowledgements_UI_Count :" + CommonStep.getText("rep.returnAklink.text"));
		Reporter.log("TransfersOut_UI_Count :" + CommonStep.getText("rep.tranoutlink.text"));
		Reporter.log("TransfersIn_UI_Count :" + CommonStep.getText("rep.traninlink.text"));
		Reporter.log("Thefts_UI_Count :" + CommonStep.getText("rep.theftlink.text"));
		Reporter.log("Losses_UI_Count :" + CommonStep.getText("rep.losslink.text"));
		Reporter.log("Adjustments_UI_Count :" + CommonStep.getText("rep.adjustlink.text"));
	}

	@QAFTestStep(description = "extract same quarter data from backend")
	public void extractBackendCount() {

		Reporter.log("DisbursementCount_Back_End :" + d.DBConfig(d.query_DisbursementCount_Q1_2019));
		Reporter.log("AdjustmentsCount_Back_End :" + d.DBConfig(d.query_Adjustments_Q1_2019));
		Reporter.log("Transfer_OutCount_Back_End :" + d.DBConfig(d.query_Transfer_Out_Q1_2019));
		Reporter.log("Transfer_InCount_Back_End :" + d.DBConfig(d.query_Transfer_In_Q1_2019));
		Reporter.log("TheftsCount_Back_End :" + d.DBConfig(d.query_Thefts_Q1_2019));
		Reporter.log("Shipment_AckCount_Back_End :" + d.DBConfig(d.query_Shipment_Ack_Q1_2019));
		Reporter.log("ShipmentCount_Back_End :" + d.DBConfig(d.query_Shipment_Q1_2019));
		Reporter.log("Returns_AckCount_Back_End :" + d.DBConfig(d.query_Returns_Ack_Q1_2019));
		Reporter.log("ReturnsCount_Back_End :" + d.DBConfig(d.query_Returns_Q1_2019));
		Reporter.log("LossesCount_Back_End :" + d.DBConfig(d.query_Losses_Q1_2019));
		Reporter.log("InventoryCount_Back_End :" + d.DBConfig(d.query_Inventory_Q1_2019));

	}

	@QAFTestStep(description = "compare the back end and UI")
	public void compareCount() {
		// Disbursement Count Comparison
		Validator.verifyTrue(
				(CommonStep.getText("rep.dlink.text")).equalsIgnoreCase(d.DBConfig(d.query_DisbursementCount_Q1_2019)),
				"Disbursement Count doesn't Matches", "Disbursement Count Matches");

		// Shipment_Acknowledgement Count Comparison
		Validator.verifyTrue(
				(CommonStep.getText("rep.shipAklink.text")).equalsIgnoreCase(d.DBConfig(d.query_Shipment_Ack_Q1_2019)),
				"Shipment_Ack Count doesn't Matches", "Shipment_Ack Count Matches");

		// Transfer Out Count Comparison
		Validator.verifyTrue(
				(CommonStep.getText("rep.tranoutlink.text")).equalsIgnoreCase(d.DBConfig(d.query_Transfer_Out_Q1_2019)),
				"Transfer Out Count doesn't Matches", "Transfer Out Count Matches");

		// Transfer In Count Comparison
		Validator.verifyTrue(
				(CommonStep.getText("rep.traninlink.text")).equalsIgnoreCase(d.DBConfig(d.query_Transfer_In_Q1_2019)),
				"Transfer In Count doesn't Matches", "Transfer In Count Matches");

		// Adjustments Comparison
		Validator.verifyTrue(
				(CommonStep.getText("rep.adjustlink.text")).equalsIgnoreCase(d.DBConfig(d.query_Adjustments_Q1_2019)),
				"Adjustments Count doesn't Matches", "Adjustments Count Matches");

		// Returns Acknowledgement Comparison
		Validator.verifyTrue(
				(CommonStep.getText("rep.returnAklink.text")).equalsIgnoreCase(d.DBConfig(d.query_Returns_Ack_Q1_2019)),
				"Returns Acknowledgement Count doesn't Matches", "Returns Acknowledgement Count Matches");

		// Returns Comparison
		Validator.verifyTrue(
				(CommonStep.getText("rep.returnlink.text")).equalsIgnoreCase(d.DBConfig(d.query_Returns_Q1_2019)),
				"Returns Count doesn't Matches", "Returns Count Matches");

		// Inventory Comparison
		Validator.verifyTrue(
				(CommonStep.getText("rep.invenlink.text")).equalsIgnoreCase(d.DBConfig(d.query_Inventory_Q1_2019)),
				"Inventory Count doesn't Matches", "Inventory Count Matches");

		// Theft Comparison
		Validator.verifyTrue(
				(CommonStep.getText("rep.theftlink.text")).equalsIgnoreCase(d.DBConfig(d.query_Thefts_Q1_2019)),
				"Theft Count doesn't Matches", "Theft Count Matches");

		// Loss Comparison
		Validator.verifyTrue(
				(CommonStep.getText("rep.losslink.text")).equalsIgnoreCase(d.DBConfig(d.query_Losses_Q1_2019)),
				"Loss Count doesn't Matches", "Loss Count Matches");

	}

}
