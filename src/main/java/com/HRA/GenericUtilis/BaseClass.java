package com.HRA.GenericUtilis;

import java.sql.SQLException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.ObjectRepository.DashBoardPage;
import com.ObjectRepository.HomePage;
import com.ObjectRepository.LoginPage;


public class BaseClass {
	
	public DatabaseUtility dLib=new DatabaseUtility();
	public WebDriverUtlis wLib=new WebDriverUtlis();
	public ExcelUtility eLib=new ExcelUtility();
	public FileUtility fLib=new FileUtility();
	public JavaUtility jLib=new JavaUtility();
	public static WebDriver sdriver;
	
	public WebDriver driver;
	@BeforeSuite(alwaysRun=true)
	public void configBS() throws Throwable {
		dLib.connectToDB();
		System.out.println("Connected to DataBase");
	}
		@Parameters("BROWSER")
		@BeforeClass(alwaysRun=true)
		
	public void configBC(String BROWSER) throws Throwable {
			//String BROWSER=fLib.getPropertKeyValue("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("FireFox"))
		{
			driver=new FirefoxDriver();
			
		}
		else {
			System.out.println("Invalid Browser");
		}
		
		wLib.implicitwait(driver, 15);
		sdriver = driver;
		wLib.maximizeTheBrowser(driver);
		System.out.println("Browser is Launched");
	}
	 @BeforeMethod(alwaysRun=true)
	public void configBM() throws Throwable {
		String USERNAME=fLib.getPropertKeyValue("username");
		String PASSWORD=fLib.getPropertKeyValue("password");
		String URL=fLib.getPropertKeyValue("url");
		
		driver.get(URL);
		HomePage hp=new HomePage(driver);
		hp.clickonLogin();
		System.out.println("Loged into Application");
		
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
	}
	 @AfterMethod(alwaysRun=true)
	public void configAM() {
		 DashBoardPage db=new DashBoardPage(driver);
		 db.clickonLogout();
		 System.out.println("Loged out to the Appliction");
	 }
	@AfterClass(alwaysRun=true)
	 public void configAc() {
		 driver.quit();
		 System.out.println("Close the Browser");
	 }
	@AfterSuite(alwaysRun=true)
	public void configAS() throws Throwable {
		dLib.closeDB();
		System.out.println("Close the DB");
	}
	}

