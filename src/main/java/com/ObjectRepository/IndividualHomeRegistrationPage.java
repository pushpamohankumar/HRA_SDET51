package com.ObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRA.GenericUtilis.WebDriverUtlis;

public class IndividualHomeRegistrationPage extends WebDriverUtlis {

		//Declaration
	@FindBy(id="fullname")
	private WebElement FullNameEdt;
	
	@FindBy(id="mobile")
	private WebElement MobileEdt;
	
	@FindBy(id="alternat_mobile")
	private WebElement AlternateMobileEdt;
	
	@FindBy(id="email")
	private WebElement EmailEdt;
	
	@FindBy(id="plot_number")
	private WebElement PlotNoEdt;
	
	@FindBy(id="rooms")
	private WebElement RoomsEdt;
	
	@FindBy(id="country")
	private WebElement CountryEdt;
	
	@FindBy(id="state")
	private WebElement StateEdt;
	
	@FindBy(id="city")
	private WebElement CityEdt;
	
	@FindBy(id="rent")
	private WebElement RentEdt;
	
	@FindBy(id="sale")
	private WebElement SaleEdt;
	
	@FindBy(id="deposit")
	private WebElement DepositEdt;
	
	@FindBy(id="accommodation")
	private WebElement FacilitiesEdt;
	
	@FindBy(id="description")
	private WebElement DescriptionEdt;
	
	@FindBy(id="landmark")
	private WebElement LandMarkEdt;
	
	@FindBy(id="address")
	private WebElement AddressEdt;
	
	@FindBy(id="vacant")
	private WebElement Vacant_OccupiedEdt;
	
	@FindBy(id="image")
	private WebElement Home_Image;
	
	@FindBy(name="register_individuals")
	private WebElement submit;
	
	//Initializaion
	public IndividualHomeRegistrationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getFullNameEdt() {
		return FullNameEdt;
	}

	public WebElement getMobileEdt() {
		return MobileEdt;
	}

	public WebElement getAlternateMobileEdt() {
		return AlternateMobileEdt;
	}

	public WebElement getEmailEdt() {
		return EmailEdt;
	}

	public WebElement getPlotNoEdt() {
		return PlotNoEdt;
	}

	public WebElement getRoomsEdt() {
		return RoomsEdt;
	}

	public WebElement getCountryEdt() {
		return CountryEdt;
	}

	public WebElement getStateEdt() {
		return StateEdt;
	}

	public WebElement getCityEdt() {
		return CityEdt;
	}

	public WebElement getRentEdt() {
		return RentEdt;
	}

	public WebElement getSaleEdt() {
		return SaleEdt;
	}

	public WebElement getDepositEdt() {
		return DepositEdt;
	}

	public WebElement getFacilitiesEdt() {
		return FacilitiesEdt;
	}

	public WebElement getDescriptionEdt() {
		return DescriptionEdt;
	}

	public WebElement getLandMarkEdt() {
		return LandMarkEdt;
	}

	public WebElement getAddressEdt() {
		return AddressEdt;
	}

	public WebElement getVacantEdt() {
		return Vacant_OccupiedEdt;
	}

	public WebElement getHome_Image() {
		return Home_Image;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public void setSubmit(WebElement submit) {
		this.submit = submit;
	}

	public void setHome_Image(WebElement home_Image) {
		Home_Image = home_Image;
	}

	public void homeRegistration(HashMap<String,String> map,WebDriver driver,String VisText ) 
	{
		for(Entry<String, String> s:map.entrySet())
		{
			
				driver.findElement(By.id(s.getKey())).sendKeys(s.getValue());
			
		}
		selectDropdown(VisText, Vacant_OccupiedEdt);
		
	}
	
	public void submit()
	{
		submit.click();
	}
	}


