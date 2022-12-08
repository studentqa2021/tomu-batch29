package com.cucumber.test;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constant;
import com.util.HighLighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdef {
	WebDriver driver;
	SeleniumPageFactory pf;
	@Given("open any browser")
	public void open_any_browser() {
		 driver =DriverManager.getBrowser("chrome");
		driver.manage().window().maximize();
		SeleniumWait.imwait(driver, 3);
	}

	@Given("go to application URL")
	public void go_to_application_URL() {
		driver.navigate().to(Constant.URL);
		ScreenShot.getScreenShot(driver, "Home Page");
		//explicit wait=WebDriver wait
		 pf = new SeleniumPageFactory(driver);
		//SeleniumWait.getExplicitWait(driver, pf.getSigninBtn().get(0), 3);
	}

	@When("click sign in button")
	public void click_sign_in_button() {
		HighLighter.getColor(driver, pf.getSigninBtn().get(0));
		pf.getSigninBtn().get(0).click();
		
		ScreenShot.getScreenShot(driver, "Login Page");
	}

	@When("put email")
	public void put_email() {
		HighLighter.getColor(driver, pf.getEmail());
		pf.getEmail().click();
		pf.getEmail().sendKeys(Constant.user);
	}

	@When("put Password")
	public void put_password() {
		HighLighter.getColor(driver, pf.getPassword());
		pf.getPassword().click();
		pf.getPassword().sendKeys(Constant.passWord);
	}

	@When("click second sign in button")
	public void click_secod_sign_button() {
		HighLighter.getColor(driver, pf.getSecondSigninBtn());
		pf.getSecondSigninBtn().click();
		ScreenShot.getScreenShot(driver, "Login Validation");
	}

	@Then("validate login was successful")
	public void validate_login_was_successful() {
		boolean status =pf.getWelcome().get(0).isDisplayed();
		//Assertion = Hard & soft
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(status);//condition =true or false
		
		sa.assertAll();//validation
	}

}
