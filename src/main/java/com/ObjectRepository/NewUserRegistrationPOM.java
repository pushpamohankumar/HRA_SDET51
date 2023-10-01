package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewUserRegistrationPOM {

	//declaration
	
	@FindBy(id="fullname")
	private WebElement FullNameEdt;
	
	@FindBy(id="username")
	private WebElement UserEdt;
	
	@FindBy(id="mobile")
	private WebElement MobileEdt;
	
	@FindBy(id="email")
	private WebElement EmailEdt;
	
	@FindBy(id="password")
	private WebElement PasswordEdt;
	
	@FindBy(id="c_password")
	private WebElement ConformPwdEdt;
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement SubmitBtn;
	
	//initialization
	
	public NewUserRegistrationPOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

		//Utilization
	public WebElement getFullNameEdt() {
		return FullNameEdt;
	}

	public WebElement getUserEdt() {
		return UserEdt;
	}

	public WebElement getMobileEdt() {
		return MobileEdt;
	}

	public WebElement getEmailEdt() {
		return EmailEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getConformPwdEdt() {
		return ConformPwdEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	public void NewUserRegistration()
	{
		FullNameEdt.sendKeys();
		
	}
}
