package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//declaration
	@FindBy(id="exampleInputEmail1")
	private WebElement UsernameEdt;
	
	@FindBy(id="exampleInputPassword1")
	private WebElement PasswordEdt;
	
	@FindBy(name="login")
	private WebElement submitBtn;
	
	
	//initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getUsernameEdt() {
		return UsernameEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	//Business Libraries
	public void login(String username,String password) {
		UsernameEdt.sendKeys(username);
		PasswordEdt.sendKeys(password);
		submitBtn.click();
		
		
	}
	
}
