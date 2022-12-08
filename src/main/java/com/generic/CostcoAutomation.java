package com.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constant;
import com.util.HighLighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

public  class CostcoAutomation {
	public static void productHandle(){
	WebDriver driver =	DriverManager.getBrowser("chrome");
	driver.manage().window().maximize();
	driver.navigate().to(Constant.COSTCO_URL);
	//driver.manage().timeouts().implicitlyWait(driver,5);
	SeleniumWait.imwait(driver, 5);
	System.out.println("Home Page Name ="+ driver.getTitle());
	System.out.println("Curent page URL=" +driver.getCurrentUrl());
	SoftAssert sf =new SoftAssert();
	sf.assertEquals(driver.getCurrentUrl(),Constant.COSTCO_URL );
	
	ScreenShot.getScreenShot(driver, "Home Page Name");
	
	SeleniumPageFactory pf =new SeleniumPageFactory(driver);
	//SeleniumWait.getExplicitWait(driver, pf.getCostcoLogin(), 5);
	HighLighter.getColor(driver, pf.getCostcoLogin().get(0),"red");
	pf.getCostcoLogin().get(0).click();
	System.out.println("Login Page Name ="+ driver.getTitle());
	ScreenShot.getScreenShot(driver,"Login Page Name" );
	//driver.navigate().back();
	//driver.navigate().back();
	
	
	while (true) {
		
			if(pf.getCostcoLogin().size()>0) {
				break;
			}else {
				driver.navigate().back();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}
	
	System.out.println("Menu count = "+pf.getCostcoMenuBtn().size());
	
	for(int i=0;i<pf.getCostcoMenuBtn().size();i++) {
		HighLighter.getColor(driver, pf.getCostcoMenuBtn().get(i), "red");
		System.out.println(pf.getCostcoMenuBtn().get(i).getText());
		
	}
	

	for(int i=0;i<pf.getCostcoMenuBtn().size();i++) {
		
		if(pf.getCostcoMenuBtn().get(i).getText().contains("Deals")) {//true
			HighLighter.getColor(driver, pf.getCostcoMenuBtn().get(i), "white");
			Actions ac = new Actions(driver);
			ac.moveToElement(pf.getCostcoMenuBtn().get(i)).perform();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Deal option Count="+pf.getDealOptions().size());
			for(int j=0;j<pf.getDealOptions().size();j++) {
				HighLighter.getColor(driver, pf.getDealOptions().get(j), "green");
				System.out.println(pf.getDealOptions().get(j).getText());
				
			}
		}
		
	}
	
	sf.assertAll();
	}
	public static void main(String[] args) {
		CostcoAutomation.productHandle();
	}

}
