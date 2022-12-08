package com.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constant;
import com.util.HighLighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

import freemarker.template.utility.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseLogin {
	
	public void getLogin(){
		//open a browser
		//WebDriverManager.chromedriver().setup();
		 WebDriver driver =DriverManager.getBrowser("chrome");
		//WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		SeleniumWait.imwait(driver, 3);
		// go to URL
		driver.navigate().to(Constant.URL);
		
		
			ScreenShot.getScreenShot(driver, "HomePage");
	
		//explicit wait=WebDriver wait
		SeleniumPageFactory pf = new SeleniumPageFactory(driver);
		//SeleniumWait.getExplicitWait(driver, pf.getSigninBtn().get(0), 3);
		//click sign in
		HighLighter.getColor(driver, pf.getSigninBtn().get(0));
		pf.getSigninBtn().get(0).click();
		
		
			ScreenShot.getScreenShot(driver, "Login Page");
		
		HighLighter.getColor(driver, pf.getEmail());
		pf.getEmail().click();
		pf.getEmail().sendKeys(Constant.user);
		//put pass
		HighLighter.getColor(driver, pf.getPassword());
		pf.getPassword().click();
		pf.getPassword().sendKeys(Constant.passWord);
		//click second sign in
		HighLighter.getColor(driver, pf.getSecondSigninBtn());
		pf.getSecondSigninBtn().click();
		
			ScreenShot.getScreenShot(driver, "Login Validation");
		
		//validation	
		boolean status =pf.getWelcome().get(0).isDisplayed();
		//Assertion = Hard & soft
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(status);//condition =true or false
		
		sa.assertAll();//validation
		
	}
		
	}
		

