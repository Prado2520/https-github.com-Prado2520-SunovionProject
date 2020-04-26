package com.sunovion.pages;

import java.util.HashMap;
import java.util.List;

import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.TestPage;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;


public class PracticeTransactionPage extends WebDriverBaseTestPage<WebDriverTestPage>{
	
	
	
	@QAFTestStep (description = "Verify transaction page")
	public void verifyTransactionPage() {
		CommonStep.waitForVisible("transaction.export.button");
		Validator.verifyTrue(CommonStep.verifyPresent("transaction.export.button"), "You are not on Transaction page", "Welcome to Transaction page");
	}
	
	@QAFTestStep (description = "Click Apply Filter button")
	public void clickApplyFilterButton() {
		CommonStep.click("transaction.filter.button");
	}
	
	@QAFTestStep (description ="Click Clear link")
	public void clickClearLink() {
		CommonStep.click("transaction.clear.link");
	}
	
	@QAFTestStep (description = "Click SelectColumn link")
	public void clickSelectColumnLink() {
		CommonStep.click("transaction.selectcolumn.link");
	}
	
	@QAFTestStep (description = "Click Next button")
	public void clickNextButton() {
		CommonStep.click("transaction.next.button");
	}
	
	@QAFTestStep (description = "Check Transfer In checkbox") 
	public void checkTransferInCheckbox() {
		CommonStep.click("transaction.transferin.checkbox");
	}
	
	@QAFTestStep (description = "Check Transfer Out checkbox") 
	public void checkTransferOutCheckbox() {
		CommonStep.click("transaction.transferout.checkbox");
	}
	
	@QAFTestStep (description = "Click Export Transaction button")
	public void clickExportTransaction() {
		CommonStep.click("transaction.export.button");
		
	}
	
	@QAFTestStep (description = "Click on Employee last name text field")
	public void clickAndEnterEmployeeLastName(String EmployeeLastName) {
		CommonStep.click("tran.empLastName.text");
		CommonStep.sendKeys(EmployeeLastName, "tran.empLastName.textbox");
	}
	

	@QAFTestStep (description = "EmployeeLastName filter result")
	public void lastNameFilterResult(String EmployeeLastName) {
		 List<WebElement> data1 = driver.findElements(By.xpath("//table[@class='table full-width']/tbody/tr/td[8]"));
		 int Count=data1.size();
			System.out.println("Count captured :"+Count);
			for(int i =0; i<data1.size(); i++) {
				Validator.verifyThat(data1.get(i).getText(), Matchers.equalTo(EmployeeLastName));
			}
			System.out.println("Data should be printed here");
			Reporter.log("The total no. rows after filter of "+EmployeeLastName+" is applied are :"+Count);
		}
	
	
	@QAFTestStep (description = "EmployeeId filter result")
	public void employeeIdFilterResult(String EmployeeId) {
		 List<WebElement> data = driver.findElements(By.xpath("//table[@class='table full-width']/tbody/tr/td[7]"));
		 int Count=data.size();
			System.out.println("Count captured :"+Count);
			
			for(int i =0; i<data.size(); i++) {	
				Validator.verifyThat(data.get(i).getText(), Matchers.equalTo(EmployeeId));
			}
			System.out.println("Data should be printed here");
			Reporter.log("The total no. rows after filter of "+EmployeeId+" is applied are :"+Count);
		}
	
   @QAFTestStep (description = "Enter Employee Id in the employee id filter")
   public void enterEmployeeId(String EmployeeId) {
	   CommonStep.sendKeys(EmployeeId, "tran.empID.text");
   }
   
   @QAFTestStep (description = "Click SelectColumn Link")
   public void selectColumnLink() {
	   Reporter.logWithScreenShot("Before applying filter");
	   CommonStep.click("tran.sc.link");
   }
   
   @QAFTestStep (description = "click checkbox")
   public void clickCheckBoxAndSelectButton() {
	   CommonStep.click("tran.ai.chckbx");
	   CommonStep.click("tran.practitioner.chckbx");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.logWithScreenShot("Additional Column Screenshot");
		CommonStep.click("tran.sel.btn");   
   }
   
   @QAFTestStep (description = "verify")
   public void verifySelectColumn() throws InterruptedException {
	   
		Thread.sleep(15000);
		CommonStep.click("tran.right.text");
		   JavascriptExecutor jse = (JavascriptExecutor) driver;
			WebElement Element = driver.findElement(By.xpath("(//table[@class='table full-width']/tbody/tr)[1]"));
			jse.executeScript("arguments[0].scrollIntoView();", Element);
		if(CommonStep.verifyPresent("transaction.accountid.text")) {
			System.out.println("Account_ID column is present");
			Reporter.logWithScreenShot("Account_ID column is present");
		} else {
			System.out.println("Account_ID column is not present");
			Reporter.logWithScreenShot("Account_ID column is not present");	
		}
		
		if(CommonStep.verifyPresent("transaction.practitioner.text")) {
			System.out.println("Practitioner column is present");
			Reporter.logWithScreenShot("Practitioner column is present");
		} else {
			System.out.println("Practitioner column is not present");
			Reporter.logWithScreenShot("Practitioner column is not present");
			
		}
	  // Validator.verifyTrue(CommonStep.verifyPresent("transaction.accountid.text"), "Account_ID column is not present", "Account_ID column is present");
	  // Validator.verifyTrue(CommonStep.verifyPresent("transaction.practitioner.text"), "Practitioner column is not present", "Practitioner column is present");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
	    Reporter.logWithScreenShot("Screenshot");
	
   }
   
	

	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}

}
