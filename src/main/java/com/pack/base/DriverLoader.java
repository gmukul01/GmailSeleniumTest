package com.pack.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverLoader {
	
	private static WebDriver driver;
	
	private DriverLoader(){};
	
	public static WebDriver getDriver()
	{
		if(driver == null)
		{
			synchronized(DriverLoader.class)
			{
				if(driver == null)
				{
					driver = new FirefoxDriver();
					driver.manage().window().maximize();
				}
			}
		}
		return driver;
	}
	
	public static void tearDown()
	{
		driver.quit();
	}

}
