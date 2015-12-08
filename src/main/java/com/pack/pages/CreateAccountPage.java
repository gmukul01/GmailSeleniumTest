package com.pack.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pack.config.Constants;

public class CreateAccountPage extends Page{
	
	private WebDriver driver;
	private static String PAGE_TITLE = "Create your Google Account" ; 
	
	@FindBy(id="FirstName")
	WebElement firstName;
	
	@FindBy(id="LastName")
	WebElement lastName;
	
	@FindBy(id="GmailAddress")
	WebElement userName;
	
	@FindBy(id="Passwd")
	WebElement password;
	
	@FindBy(id="PasswdAgain")
	WebElement confirmPassword;
	
	@FindBy(css="#BirthMonth > div")
	WebElement birthMonth;
	
	@FindBy(id="BirthDay")
	WebElement birthDay;
	
	@FindBy(id="BirthYear")
	WebElement birthYear;
	
	@FindBy(xpath="//div[@id='Gender']/div")
	WebElement gender;
	
	@FindBy(id="RecoveryPhoneNumber")
	WebElement mobileNumber;
	
	@FindBy(id="RecoveryEmailAddress")
	WebElement recoveryEmailAddress;
	
	@FindBy(id="SkipCaptcha")
	WebElement skipCaptcha;
	
	@FindBy(id="TermsOfService")
	WebElement termsOfService;
	
	@FindBy(id="submitbutton")
	WebElement submitButton;
	
	@FindBy(xpath="//span[contains(text(),'leave this empty') and @class='errormsg']")
	WebElement errorMessage;
	
	
	public CreateAccountPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	@Override
	public boolean verifyPageTitile() {
		return getPageTitle().contains(PAGE_TITLE);
	}
	
	public void enterFirstName(String fname)
	{
		sendKeys(firstName,fname);
	}
	
	public void enterLastName(String lname)
	{
		sendKeys(lastName,lname);
	}
	
	public void enterUserName(String uname)
	{
		sendKeys(userName,uname);
	}
	
	public void enterPassword(String pass)
	{
		sendKeys(password,pass);
	}
	
	public void enterConfirmPassword(String cpass)
	{
		sendKeys(confirmPassword,cpass);
	}
	
	public void selectMonth(Constants.Month monthOption)
	{
		try 
		{
			click(birthMonth);
			Thread.sleep(1000);
			
			List<WebElement> toElement = driver.findElements(By.xpath("//span[@id='BirthMonth']/div[2]//div[@role='option']"));
			Actions builder = new Actions(driver);
			Action action = builder.moveToElement(toElement.get(monthOption.getValue())).build();
			action.perform();
			Thread.sleep(1000);
			
			
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
	
	public void enterBirthDay(String day)
	{
		sendKeys(birthDay,day);
	}
	
	public void enterBirthYear(String year)
	{
		sendKeys(birthYear,year);
	}
	
	public void selectGenger(Constants.Gender genderoption)
	{
		click(gender);
		WebElement slctGender;
		switch(genderoption)
		{
		case MALE:
			slctGender = driver.findElement(By.xpath("//div[@id='Gender']//div[contains(text(),'Male')]"));
			break;
		case FEMALE:
			slctGender = driver.findElement(By.xpath("//div[@id='Gender']//div[contains(text(),'Female')]"));
			break;
		default:
			slctGender = driver.findElement(By.xpath("//div[@id='Gender']//div[contains(text(),'Other')]"));
			break;
		}
		
		try 
		{
			Thread.sleep(1000);
			Actions builder = new Actions(driver);
			Action action = builder.moveToElement(slctGender).build();
			action.perform();
			Thread.sleep(1000);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void enterMobileNumber(String mobile)
	{
		sendKeys(mobileNumber,mobile);
	}
	
	public void enterRecoveryEmailAddress(String remail)
	{
		sendKeys(recoveryEmailAddress,remail);
	}
	
	public void clickSkipCaptcha()
	{
		click(skipCaptcha);
	}
	
	public void clickTermsOfService()
	{
		click(termsOfService);
	}
	
	public void clickSubmitButton()
	{
		click(submitButton);
	}
	
	public boolean verifyEmptyFieldErrorMessage()
	{
		Actions builder = new Actions(driver);
		Action action = builder.moveToElement(errorMessage).build();
		action.perform();
		((JavascriptExecutor)driver).executeScript("arguments[0].style.border='5px solid yellow'", errorMessage);
		waiting(2000);
		return errorMessage.isDisplayed();
	}
	
	}
