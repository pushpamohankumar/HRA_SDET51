package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	//declaration
	@FindBy(xpath="//a[.='Search']")
	private WebElement search;
	
	@FindBy(xpath="//a[.='Login']")
	private WebElement login;
	
	@FindBy(xpath="//a[.='Register']")
	private WebElement register;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logout;
	
	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getSearch() {
		return search;
	}

	public WebElement getLogin() {
		return login;
	}

	public WebElement getRegister() {
		return register;
	}
	
	public WebElement getLogout() {

		return logout;
	}

	

	public void clickonLogin()
	{
		login.click();
	}
	
	public void register() {
		register.click();
	}
	
	public void clickonLogout()
	{
		logout.click();
	}
}
