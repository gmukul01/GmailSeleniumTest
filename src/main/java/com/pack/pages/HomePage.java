package com.pack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends Page{
	
	private WebDriver driver;
	private static String PAGE_TITLE = "Google" ; 

	@FindBy(xpath="//a[contains(text(),'Gmail')]")
	WebElement gmail;
	
	public HomePage(WebDriver driver)
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
	
	public void clickOnGmail()
	{
		click(gmail);
	}

}
