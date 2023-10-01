package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApartmentRegistrationPage {

	//declaration
	@FindBy(xpath="//h2[.='Apartment Room']")
	private WebElement ApartmentName;
	
	@FindBy(xpath="//h2[.='Apartment Room']/ancestor::div[@class='alert alert-info']/descendant::input[@id='mobile']")
	private WebElement Apartment_MobileNo;
	
	@FindBy(xpath="//h2[.='Apartment Room']/../descendant::input[@id='alternat_mobile']")
	private WebElement Apartment_AlternameMbile;
	
	@FindBy(xpath="//h2[.='Apartment Room']/../descendant::input[@id='email']")
	private WebElement Apartment_Email;
	
	@FindBy(xpath="//h2[.='Apartment Room']/../descendant::input[@id='plot_number']")
	private WebElement Apartment_PlotNo;
	
	@FindBy(xpath="//h2[.='Apartment Room']/../descendant::input[@id='country']")
	private WebElement Apartment_Country;
	
	@FindBy(xpath="//h2[.='Apartment Room']/../descendant::input[@id='state']")
	private WebElement Apartment_State;
	
	@FindBy(xpath="//h2[.='Apartment Room']/../descendant::input[@id='city']")
	private WebElement Apartment_City;
	
	@FindBy(xpath="//h2[.='Apartment Room']/../descendant::input[@id='landmark']")
	private WebElement Apartment_LandMark;
	
	@FindBy(xpath="//h2[.='Apartment Room']/../descendant::input[@id='address']")
	private WebElement Apartment_Address;
	
	@FindBy(xpath="(//input[@id='image'])[2]")
	private WebElement Apartment_Image;
	
	@FindBy(xpath="//a[text()='Add More(Plat Number/Description)']")
	private WebElement Apartment_AddMorePlat;

	@FindBy(xpath="//h2[.='Apartment Room']/../descendant::button[.='Submit']")
	private WebElement Apartment_Submit;
	
	//initialization
	public ApartmentRegistrationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Utilization
	public WebElement getApartmentName() {
		return ApartmentName;
	}

	public WebElement getApartment_MobileNo() {
		return Apartment_MobileNo;
	}

	public WebElement getApartment_AlternameMbile() {
		return Apartment_AlternameMbile;
	}

	public WebElement getApartment_Email() {
		return Apartment_Email;
	}

	public WebElement getApartment_PlotNo() {
		return Apartment_PlotNo;
	}

	public WebElement getApartment_Country() {
		return Apartment_Country;
	}

	public WebElement getApartment_State() {
		return Apartment_State;
	}

	public WebElement getApartment_City() {
		return Apartment_City;
	}

	public WebElement getApartment_LandMark() {
		return Apartment_LandMark;
	}

	public WebElement getApartment_Address() {
		return Apartment_Address;
	}

	public WebElement getApartment_Image() {
		return Apartment_Image;
	}

	public WebElement getApartment_Submit() {
		return Apartment_Submit;
	}
	public WebElement getApartment_AddMorePlat() {
		return Apartment_AddMorePlat;
	}
	
}
