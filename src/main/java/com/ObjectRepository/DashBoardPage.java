package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DashBoardPage {

	//declaration
	@FindBy(linkText = "Home")
	private WebElement Homelnk;
	
	@FindBy(linkText = "Register")
	private WebElement Registerlnk;
	
	@FindBy(linkText = "Details/Update")
	private WebElement Detailslnk;
	
	@FindBy(linkText = "Send SMS")
	private WebElement SendSMSlnk;
	
	@FindBy(linkText = "Complaint List")
	private WebElement ComplaintListlnk;
	
	@FindBy(xpath="//span[@class='badge badge-pill badge-success']/ancestor::b[text()='Registered Users: ']")
	private WebElement RegisteredUserslnk;
	
	@FindBy(xpath="//span[@class='badge badge-pill badge-success']/ancestor::b[text()='Rooms for Rent: ']")
	private WebElement RoomsforRentlnk;
	
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutBtn;
	
	
	//initialization
	public DashBoardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getHomelnk() {
		return Homelnk;
	}


	public WebElement getRegisterlnk() {
		return Registerlnk;
	}


	public WebElement getDetailslnk() {
		return Detailslnk;
	}


	public WebElement getSendSMSlnk() {
		return SendSMSlnk;
	}


	public WebElement getComplaintListlnk() {
		return ComplaintListlnk;
	}


	public WebElement getRegisteredUserslnk() {
		return RegisteredUserslnk;
	}


	public WebElement getRoomsforRentlnk() {
		return RoomsforRentlnk;
	}


	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	
	//Business logic
	public void clickonRegister()
	{
		RegisteredUserslnk.click();
	}
	public void details()
	{
		Detailslnk.click();
	}
	public void complaintlist()
	{
	ComplaintListlnk.click();	
	}
	
	public void clickonLogout() {
		logoutBtn.click();
	}
	}
