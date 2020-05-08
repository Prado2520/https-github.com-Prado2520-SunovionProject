package com.sunovion.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.sunovinon.steps.TimeStampScreenshot;

//import org.sikuli.api.Screen;

//import org.sikuli.api.Screen;

public class ScreenClass {

	
	
	
	
	
	public void DesktopAutomation() throws FindFailed, InterruptedException, AWTException, IOException {
		TimeStampScreenshot scrshot = new TimeStampScreenshot();
		Screen screen = new Screen();
		//Robot r = new Robot();
		Pattern searchbox = new Pattern("C:\\Users\\pjalapur\\Desktop\\Sikuli\\SearchBox.png");
		Pattern downloadicon = new Pattern("C:\\Users\\pjalapur\\Desktop\\Sikuli\\icon.png");
		Pattern Sidearrow = new Pattern("C:\\Users\\pjalapur\\Desktop\\Sikuli\\Sidearrow.png");

		
		//screen.click(close);
		screen.click(searchbox);
		//Thread.sleep(5000);
		screen.type(searchbox, "  C:\\Users\\pjalapur\\Downloads\\Transaction search results.xlsx");
		Thread.sleep(3000);
		//screen.click(downloadicon);
		screen.doubleClick(downloadicon);
		//Thread.sleep(2000);
		//screen.doubleClick(Exceliconicon);
		//screen.rightClick(Exceliconicon);
		//screen.click(open);
		//screen.click(Exceliconicon);
		Thread.sleep(10000);
		for(int i=0;i<=25;i++) {
			screen.click(Sidearrow);
			if(i==0||i==5||i==10||i==15||i==20||i==25) {
				Thread.sleep(2000);
				scrshot.ExportTransaction();
			}
		}	
	}

	public static void main(String[] args) throws FindFailed, InterruptedException, AWTException, IOException {
		ScreenClass sc = new ScreenClass();
			sc.DesktopAutomation();
	}

}
