
	
	package com.sunovinon.steps;

	import java.util.ArrayList;
	import java.util.List;
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
	import com.qmetry.qaf.automation.ui.api.TestPage;
	import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
	import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
	import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
	import com.qmetry.qaf.automation.util.Reporter;
	import com.qmetry.qaf.automation.util.Validator;

	public class BackendUIDataCompr extends WebDriverBaseTestPage<WebDriverTestPage> {

		// public String
		int No_Of_Times =5;

		public void loginPage() {
			// Login block
			CommonStep.get("/");
			CommonStep.sendKeys("super", "login.username.text");
			CommonStep.sendKeys("Welcome1", "login.password.text");
			CommonStep.click("login.loginbtn.text");
			driver.manage().window().maximize();

		}
		
		
		public void createLOC(String sQuarterName) {

			
			int x = 1;
			
			do {
				try {
					QAFExtendedWebElement ele = driver
			                .findElement(By.xpath(String.format("//div[@class='kn-navigator text-center']//h6[contains(.,'%s')]", sQuarterName)));
					x=2;
				}
				
				catch(Exception e)
				{
					e.printStackTrace();
					CommonStep.click("sims.bkarrow.text");
				}
			}
			while(x==1);
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

		public void extractDisplayUIData() {
			String Disbursement_UI_Count = CommonStep.getText("rep.dlink.text");
			String Inventory_UI_Count = CommonStep.getText("rep.invenlink.text");
			String Shipments_UI_Count = CommonStep.getText("rep.shiplink.text");
			String ShipmentsAcknowledgements_UI_Count = CommonStep.getText("rep.shipAklink.text");
			String Returns_UI_Count = CommonStep.getText("rep.returnlink.text");
			String ReturnsAcknowledgements_UI_Count = CommonStep.getText("rep.returnAklink.text");
			String TransfersOut_UI_Count = CommonStep.getText("rep.tranoutlink.text");
			String TransfersIn_UI_Count = CommonStep.getText("rep.traninlink.text");
			String Thefts_UI_Count = CommonStep.getText("rep.theftlink.text");
			String Losses_UI_Count = CommonStep.getText("rep.losslink.text");
			String Adjustments_UI_Count = CommonStep.getText("rep.adjustlink.text");
			
			System.out.println("Disbursement_UI_Count :"+ Disbursement_UI_Count);
			System.out.println("Inventory_UI_Count :"+ Inventory_UI_Count);
			System.out.println("Shipments_UI_Count :"+ Shipments_UI_Count);
			System.out.println("ShipmentsAcknowledgements_UI_Count :"+ ShipmentsAcknowledgements_UI_Count);
			System.out.println("Returns_UI_Count :"+ Returns_UI_Count);
			System.out.println("ReturnsAcknowledgements_UI_Count :"+ ReturnsAcknowledgements_UI_Count);
			System.out.println("TransfersOut_UI_Count :"+ TransfersOut_UI_Count);
			System.out.println("TransfersIn_UI_Count :"+ TransfersIn_UI_Count);
			System.out.println("Thefts_UI_Count :"+ Thefts_UI_Count);
			System.out.println("Losses_UI_Count :"+ Losses_UI_Count);
			System.out.println("Adjustments_UI_Count :"+ Adjustments_UI_Count);
			
			
		}
		
		BackendUIDataCompr bi =new BackendUIDataCompr();

		public void UI_Backend_Connection() throws InterruptedException {
			String CountDB = "";
			/*
			 * DatabaseConnectionPOC d = new DatabaseConnectionPOC(); CountDB
			 * =d.DBConfig(query_DisbursementCount_Q3_2019);
			 */
			//BackendUIDataComp bi =new BackendUIDataComp();
			//UI data
			bi.loginPage();
			//bi.dashboardPage();
			//bi.backArrowClick(No_Of_Times);
			//bi.createLOC("Q1, 2019");
			//Thread.sleep(5000);
			//Reporter.logWithScreenShot("UI ");
			//Back end data
			
		}
		
	/*	@QAFTestStep(description = "User should extract data from both back end & UI of all the objects.")
		public void extractData() {
			
			//bi.extractDisplayUIData();
			
			String Disbursement_UI_Count = CommonStep.getText("rep.dlink.text");
			String Inventory_UI_Count = CommonStep.getText("rep.invenlink.text");
			String Shipments_UI_Count = CommonStep.getText("rep.shiplink.text");
			String ShipmentsAcknowledgements_UI_Count = CommonStep.getText("rep.shipAklink.text");
			String Returns_UI_Count = CommonStep.getText("rep.returnlink.text");
			String ReturnsAcknowledgements_UI_Count = CommonStep.getText("rep.returnAklink.text");
			String TransfersOut_UI_Count = CommonStep.getText("rep.tranoutlink.text");
			String TransfersIn_UI_Count = CommonStep.getText("rep.traninlink.text");
			String Thefts_UI_Count = CommonStep.getText("rep.theftlink.text");
			String Losses_UI_Count = CommonStep.getText("rep.losslink.text");
			String Adjustments_UI_Count = CommonStep.getText("rep.adjustlink.text");
			
			System.out.println("Disbursement_UI_Count :"+ Disbursement_UI_Count);
			System.out.println("Inventory_UI_Count :"+ Inventory_UI_Count);
			System.out.println("Shipments_UI_Count :"+ Shipments_UI_Count);
			System.out.println("ShipmentsAcknowledgements_UI_Count :"+ ShipmentsAcknowledgements_UI_Count);
			System.out.println("Returns_UI_Count :"+ Returns_UI_Count);
			System.out.println("ReturnsAcknowledgements_UI_Count :"+ ReturnsAcknowledgements_UI_Count);
			System.out.println("TransfersOut_UI_Count :"+ TransfersOut_UI_Count);
			System.out.println("TransfersIn_UI_Count :"+ TransfersIn_UI_Count);
			System.out.println("Thefts_UI_Count :"+ Thefts_UI_Count);
			System.out.println("Losses_UI_Count :"+ Losses_UI_Count);
			System.out.println("Adjustments_UI_Count :"+ Adjustments_UI_Count);
		
			
			
			
			
		}
		
	*/
		@Override
		protected void openPage(PageLocator arg0, Object... arg1) {
			// TODO Auto-generated method stub

		}

	}



