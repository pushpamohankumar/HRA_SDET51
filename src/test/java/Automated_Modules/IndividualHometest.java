package Automated_Modules;


import static org.testng.Assert.*;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.HRA.GenericUtilis.BaseClass;
import com.HRA.GenericUtilis.ExcelUtility;
import com.HRA.GenericUtilis.FileUtility;
import com.HRA.GenericUtilis.JavaUtility;
import com.HRA.GenericUtilis.WebDriverUtlis;
import com.ObjectRepository.HomePage;
import com.ObjectRepository.IndividualHomeRegistrationPage;
import com.ObjectRepository.LoginPage;

@Listeners(com.HRA.GenericUtilis.ListenersImpClass.class)
public class IndividualHometest extends BaseClass{
	
	@Test
		
	public void executeScript() throws Throwable{
	// Create Object for All the Uility Classes
	WebDriverUtlis wLib=new WebDriverUtlis();
	FileUtility fLib=new FileUtility();
	JavaUtility jLib=new JavaUtility();
	ExcelUtility eLib=new ExcelUtility();

	
	//Create Object for All the Utilities
	
	// fetch common data from property file
	/*FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
	Properties p=new Properties();
	p.load(fis);*/
	
	String BROWSER = fLib.getPropertKeyValue("browser");
	String URL = fLib.getPropertKeyValue("url");
	String USERNAME = fLib.getPropertKeyValue("username");
	String PASSWORD = fLib.getPropertKeyValue("password");
	
	//launch the browser
	WebDriver driver=null;
	
	if(BROWSER.equalsIgnoreCase("chrome")){
		driver=new ChromeDriver();
			}
	else if(BROWSER.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
	}else
	{
		System.out.println("invalid Browser");
	}
	//Enter URL
	driver.get(URL);
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	wLib.implicitwait(driver, 10);
	//driver. manage().window().maximize();
	wLib.maximizeTheBrowser(driver);
	
	//Admin Login
////	driver.findElement(By.xpath("//a[.='Login']")).click();
//    driver.findElement(By.id("exampleInputEmail1")).sendKeys(USERNAME);
//    driver.findElement(By.id("exampleInputPassword1")).sendKeys(PASSWORD);
//    driver.findElement(By.name("login")).click();
	HomePage hp=new HomePage(driver);
	hp.clickonLogin();
	
	LoginPage lp=new LoginPage(driver);
	lp.login(USERNAME, PASSWORD);
    
    // CLICK ON REGISTER
   // driver.findElement(By.linkText("Register")).click();
  // DashBoardPage db=new DashBoardPage(driver);
  // db.clickonRegister();
	hp.register();
    
	//read the data from excel sheet
			/*FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\ReadDataFromExcel.xlsx");
			Workbook wb = WorkbookFactory.create(fi);
			Sheet sh = wb.getSheet("Registration");
			int count=sh.getLastRowNum();
			*/
			
    	//int rowcount = eLib.getRowCount("Registration");
    
    	//Add excel values in key and value form
	/*	HashMap<String, String>	map=new HashMap<String,String>();
		for(int i=1;i<=count;i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);		
		}
		for (Entry<String, String> entry:map.entrySet()) {
			driver.findElement(By.id(entry.getKey())).sendKeys(entry.getValue());
		}*/
  	HashMap<String, String> map = eLib.getMultipleDataFromExcel("Registration",0,1, driver);
  	
//    	WebElement status = driver.findElement(By.id("vacant"));
//    	Select s=new Select(status) ;
//    	s.selectByVisibleText("Vacant");
   IndividualHomeRegistrationPage ior=new IndividualHomeRegistrationPage(driver);
   ior.homeRegistration(map, driver,"Occupied");
  // driver.findElement(By.id("image")).sendKeys("C:\\Users\\Acer\\Desktop\\house.jpg");
   //driver.findElement(By.name("register_individuals")).click();
   ior.submit();
   Thread.sleep(2000);
	Assert.fail();
   try {
    String actual = driver.findElement(By.xpath("//h2[text()='Register Room']/../div[text()='Registration successfull. Thank you']")).getText();
   //	System.out.println(actual);
    	 if(actual.contains("Registration successfull. Thank you")) 		
    	   {
    		   System.out.println("Registration Successful");
    	   }}
    catch(Exception e)
    {
    		   System.out.println("Registration Not Successful");
    	   }
    }
   
	}
   




