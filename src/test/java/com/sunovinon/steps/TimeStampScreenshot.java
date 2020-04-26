package com.sunovinon.steps;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.lang.RandomStringUtils;

public class TimeStampScreenshot {
	
	
	public void EmpLastName() throws AWTException, IOException {
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	    BufferedImage screenFullImage = new Robot().createScreenCapture(screenRect);
	    String ext = "jpg";
	    File dir = new File("C:/Screenshots/EmployeeLastName");
	    String nameL= "EmpLastname_";
	    String name = String.format("%s.%s",RandomStringUtils.randomAlphanumeric(2), ext);
	    nameL = nameL.concat(name);
	    ImageIO.write(screenFullImage, "jpg", new File(dir, nameL));
	}

	
	public void EmployeeID() throws Exception {
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	    BufferedImage screenFullImage = new Robot().createScreenCapture(screenRect);
	    String ext = "jpg";
	    File dir = new File("C:/Screenshots/EmployeeID");
	    String EmployeeID = "EmployeeID_";
	    String name = String.format("%s.%s",RandomStringUtils.randomAlphanumeric(2), ext);
	    EmployeeID = EmployeeID.concat(name);
	    ImageIO.write(screenFullImage, "jpg", new File(dir, EmployeeID));
	}
	
	public void Login() throws AWTException, IOException {
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	    BufferedImage screenFullImage = new Robot().createScreenCapture(screenRect);
	    String ext = "jpg";
	    File dir = new File("C:/Screenshots/Login");
	    String Login = "Login_";
	    String name = String.format("%s.%s",RandomStringUtils.randomAlphanumeric(2), ext);
	    Login=Login.concat(name);
	    ImageIO.write(screenFullImage, "jpg", new File(dir, Login));
	}
	
	public void Links() throws AWTException, IOException {
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	    BufferedImage screenFullImage = new Robot().createScreenCapture(screenRect);
	    String ext = "jpg";
	    File dir = new File("C:/Screenshots/Links");
	    String Links = "Links_";
	    String name = String.format("%s.%s",RandomStringUtils.randomAlphanumeric(2), ext);
	    Links=Links.concat(name);
	    ImageIO.write(screenFullImage, "jpg", new File(dir, Links));
	}
	
	public void ClearLinks() throws AWTException, IOException {
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	    BufferedImage screenFullImage = new Robot().createScreenCapture(screenRect);
	    String ext = "jpg";
	    File dir = new File("C:/Screenshots/ClearLinks");
	    String ClearLinks = "ClearLinks_";
	    String name = String.format("%s.%s",RandomStringUtils.randomAlphanumeric(2), ext);
	    ClearLinks = ClearLinks.concat(name);
	    ImageIO.write(screenFullImage, "jpg", new File(dir, ClearLinks));
	}
	    
		public void SelectColumn() throws AWTException, IOException {
			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		    BufferedImage screenFullImage = new Robot().createScreenCapture(screenRect);
		    String ext = "jpg";
		    File dir = new File("C:/Screenshots/SelectColumn");
		    String SelectColumn = "SelectColumn_";
		    String name = String.format("%s.%s",RandomStringUtils.randomAlphanumeric(2), ext);
		    SelectColumn = SelectColumn.concat(name);
		    ImageIO.write(screenFullImage, "jpg", new File(dir, SelectColumn));
	}
		
		public void DateFilter() throws AWTException, IOException {
			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		    BufferedImage screenFullImage = new Robot().createScreenCapture(screenRect);
		    String ext = "jpg";
		    File dir = new File("C:/Screenshots/DateFilter");
		    String DateFilter = "DateFilter_";
		    String name = String.format("%s.%s",RandomStringUtils.randomAlphanumeric(2), ext);
		    DateFilter = DateFilter.concat(name);
		    ImageIO.write(screenFullImage, "jpg", new File(dir, DateFilter));
	}
		
		public void Territory() throws AWTException, IOException {
			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		    BufferedImage screenFullImage = new Robot().createScreenCapture(screenRect);
		    String ext = "jpg";
		    File dir = new File("C:/Screenshots/Territory");
		    String Territory = "Territory_";
		    String name = String.format("%s.%s",RandomStringUtils.randomAlphanumeric(2), ext);
		    Territory=Territory.concat(name);
		    ImageIO.write(screenFullImage, "jpg", new File(dir, Territory));
	}
		
	
		public void DocumentReference() throws AWTException, IOException {
			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		    BufferedImage screenFullImage = new Robot().createScreenCapture(screenRect);
		    String ext = "jpg";
		    File dir = new File("C:/Screenshots/DocumentReference");
		    String DocumentReference = "DocumentReference_";
		    String name = String.format("%s.%s",RandomStringUtils.randomAlphanumeric(2), ext);
		    DocumentReference=DocumentReference.concat(name);
		    ImageIO.write(screenFullImage, "jpg", new File(dir, DocumentReference));
	}
		
		public void TransitionTableCount() throws AWTException, IOException {
			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		    BufferedImage screenFullImage = new Robot().createScreenCapture(screenRect);
		    String ext = "jpg";
		    File dir = new File("C:/Screenshots/TransitionTableCount");
		    String TransitionTableCount = "TransitionTableCount_";
		    String name = String.format("%s.%s",RandomStringUtils.randomAlphanumeric(2), ext);
		    TransitionTableCount=TransitionTableCount.concat(name);
		    ImageIO.write(screenFullImage, "jpg", new File(dir, TransitionTableCount));

	}
		
		public void DashboardPage() throws AWTException, IOException {
			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		    BufferedImage screenFullImage = new Robot().createScreenCapture(screenRect);
		    String ext = "jpg";
		    File dir = new File("C:/Screenshots/Dashboard");
		    String Dashboard = "Dashboard_";
		    String name = String.format("%s.%s",RandomStringUtils.randomAlphanumeric(2), ext);
		    Dashboard=Dashboard.concat(name);
		    ImageIO.write(screenFullImage, "jpg", new File(dir, Dashboard));

	}
}
