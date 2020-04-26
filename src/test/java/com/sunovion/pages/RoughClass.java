
/*package com.sunovion.pages;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 
public class RoughClass {
		     
		  public static void main(String[] args) {    
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime DateTime1 = LocalDateTime.now();  
		   LocalDateTime  DateTime= LocalDateTime.now();
   System.out.println(DateTime); 

}
}

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

	@QAFTestStep(description = "User uses TypeCheckbox Filter")
	public void TypeCheckboxFilter() throws InterruptedException {

		int RowsCount, TotalCount = 0;

		int a = 50;
		// String color =
		// driver.findElement(By.xpath("//span[text()='NEXT']")).getCssValue("color");
		// System.out.println("color : "+color);

		
		 * String color =
		 * driver.findElement(By.xpath("//span[text()='NEXT']")).getCssValue("color");
		 * String[]hexValue= color.replace("rgba(","").replace(")","").split(",");
		 * 
		 * int hexValue1=Integer.parseInt(hexValue[0]); hexValue[1]=hexValue[1].trim();
		 * int hexValue2=Integer.parseInt(hexValue[1]); hexValue[2]= hexValue[2].trim();
		 * int hexValue3=Integer.parseInt(hexValue[2]); String actualColor =
		 * String.format("#%02x%02x%02x",hexValue1,hexValue2,hexValue3);
		 * 
		 * System.out.println(actualColor);
		 
		List<String> Elements = new ArrayList<String>();
		while (a != 100)
		// while(driver.findElement(By.xpath("//span[text()='NEXT']")). {
		// if((driver.findElement(By.xpath("//span[text()='NEXT']")).isEnabled()))
		{

			
			 * List<WebElement> Rows =
			 * driver.findElements(By.xpath("//table[@class='table full-width']/tbody/tr"));
			 * RowsCount = Rows.size(); TotalCount= TotalCount + RowsCount;
			 

			String color = driver.findElement(By.xpath("//span[text()='NEXT']")).getCssValue("color");

			// if(!driver.findElement(By.xpath("//li[@class='pagination-next']/button[@disabled]")).isPresent())
			
			
			if (color.equals("rgba(0, 0, 0, 0.87)")) {

				List<WebElement> Rows1 = driver.findElements(By.xpath("//table[@class='table full-width']/tbody/tr"));
				RowsCount = Rows1.size();
				for (int i=0;i<Rows1.size();i++)
			    {
			    	System.out.println(Rows1.get(i).getText());
			    }
				
				for(WebElement Rw : Rows1)
				{
					Elements.add(Rw.getText());
				}
				Thread.sleep(5000);
				TotalCount = TotalCount + RowsCount;
				System.out.println("TotalCount :" + TotalCount);
				Thread.sleep(2000);
				CommonStep.click("tran.next.text");
				// System.out.println(actualColor);

			} else {
				a = 100;

			}

		}

		CommonStep.click("tran.next.text");
		CommonStep.click("tran.next.text");
		List<WebElement> Rows = driver
				.findElements(By.xpath("//button[@disabled]//following::span[text()='NEXT'] //preceding::tbody/tr"));
		RowsCount = Rows.size();
		System.out.println("RowsCount :" + RowsCount);
		TotalCount = TotalCount + RowsCount;
		
		 * List<WebElement> Rows =
		 * driver.findElements(By.xpath("//table[@class='table full-width']/tbody/tr"));
		 * int RowsCount = Rows.size(); System.out.println(RowsCount);
		 

		// CommonStep.click("//span[text()='NEXT']);
		// Get Count from Transaction Label
		String TransCount = CommonStep.getText("rep.tlink.text");
		String TransactionLabelCount = TransCount.replaceAll("[^0-9]", "");
		int TransactionLabelCountInt = Integer.parseInt(TransactionLabelCount);
		System.out.println("-------TransactionLabelCount =" + TransactionLabelCount);
		// CommonStep.verifyText(textTransactions1, textDisbursements);

		Reporter.log("RowsCount : " + TotalCount);
		Reporter.log("TransactionLabelCountInt : " + TransactionLabelCountInt);
		Validator.verifyThat(TotalCount, Matchers.equalTo(TransactionLabelCountInt));
		if (TotalCount == TransactionLabelCountInt) {
			System.out.println("Count matches");
			Reporter.log("Count matches");

		}
		
		
		for(String data :Elements)
		{
			System.out.println(data);
		}
		
		
	    
		
		
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub

	}

}
*/