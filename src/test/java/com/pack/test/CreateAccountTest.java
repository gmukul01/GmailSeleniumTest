package com.pack.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.pack.base.DriverLoader;
import com.pack.base.PageLoader;
import com.pack.config.Constants;
import com.pack.pages.CreateAccountPage;
import com.pack.pages.HomePage;
import com.pack.pages.LoginPage;

import junit.framework.Assert;

public class CreateAccountTest {
	WebDriver driver;
  
  @BeforeClass
  public void beforeClass() 
  {
	  driver = DriverLoader.getDriver();
	  driver.get(Constants.BASE_URL);
  }
  
  @Test
  public void executeTest() 
  {
	  PageLoader pageLoader = new PageLoader(driver);
	  
	  HomePage homePage = (HomePage)pageLoader.getPage(Constants.PageName.HOMEPAGE);
	  Assert.assertTrue("Unable to go on Google Page", homePage.verifyPageTitile());
	  homePage.clickOnGmail();
	  
	  LoginPage loginPage = (LoginPage)pageLoader.getPage(Constants.PageName.LOGINPAGE);
	  Assert.assertTrue("Unable to go on Gmail Page", loginPage.verifyPageTitile());
	  loginPage.clickOnCreateAccountLink();
	  
	  CreateAccountPage createAccountPage = (CreateAccountPage)pageLoader.getPage(Constants.PageName.CREATEACCOUNTPAGE);
	  Assert.assertTrue("Unable to go on Create Account Page", createAccountPage.verifyPageTitile());
	  createAccountPage.enterFirstName("Mukul");
	  createAccountPage.enterLastName("Bansal");
	  createAccountPage.enterPassword("hello_123");
	  createAccountPage.enterConfirmPassword("hello_123");
	  createAccountPage.selectMonth(Constants.Month.AUGUST);
	  createAccountPage.enterBirthDay("10");
	  createAccountPage.enterBirthYear("1991");
	  createAccountPage.selectGenger(Constants.Gender.MALE);
	  createAccountPage.enterMobileNumber("+917744012740");
	  createAccountPage.clickSkipCaptcha();
	  createAccountPage.clickTermsOfService();
	  createAccountPage.clickSubmitButton();
	  Assert.assertTrue("Error Message should be there for Empty Field",  createAccountPage.verifyEmptyFieldErrorMessage());
	 
  }

  @AfterClass
  public void afterClass() 
  {
	  DriverLoader.tearDown();
  }

}
