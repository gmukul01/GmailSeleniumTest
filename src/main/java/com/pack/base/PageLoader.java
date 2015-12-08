package com.pack.base;

import org.openqa.selenium.WebDriver;

import com.pack.config.Constants;
import com.pack.pages.CreateAccountPage;
import com.pack.pages.HomePage;
import com.pack.pages.LoginPage;
import com.pack.pages.Page;

public class PageLoader {
	
	private static WebDriver driver;
	
	public PageLoader(WebDriver driver)
	{
		PageLoader.driver = driver;
	}
	
	public Page getPage(Constants.PageName name)
	{
		Page page = null;
		switch (name) 
		{
		case HOMEPAGE:
			page = new HomePage(driver);
			break;
		case LOGINPAGE:
			page = new LoginPage(driver);
			break;
		case CREATEACCOUNTPAGE:
			page = new CreateAccountPage(driver);
			break;
		default:
			break;
		}
		return page;
	}

}
