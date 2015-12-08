package com.pack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	
private WebDriver driver;
	
	public Page(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void click(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public void sendKeys(WebElement element, String text)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.clear();
		element.sendKeys(text);
	}
	
	public void waiting(long time)
	{
		try 
		{
			Thread.sleep(time);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public abstract boolean verifyPageTitile();
}
