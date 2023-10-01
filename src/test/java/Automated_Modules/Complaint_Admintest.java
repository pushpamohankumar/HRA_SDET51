package Automated_Modules;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.HRA.GenericUtilis.BaseClass;
import com.HRA.GenericUtilis.ExcelUtility;
import com.HRA.GenericUtilis.FileUtility;
import com.HRA.GenericUtilis.JavaUtility;
import com.HRA.GenericUtilis.WebDriverUtlis;
import com.ObjectRepository.DashBoardPage;
import com.ObjectRepository.HomePage;
import com.ObjectRepository.LoginPage;
@Listeners(com.HRA.GenericUtilis.ListenersImpClass.class) 

class Complaint_Admintest extends BaseClass {

	@	Test
	public void executeComplaint()  throws Throwable{
	WebDriverUtlis wLib=new WebDriverUtlis();
	FileUtility fLib=new FileUtility();
	JavaUtility jLib=new JavaUtility();
	ExcelUtility eLib=new ExcelUtility();
	{
		// TODO Auto-generated method stub
		
		// Create Object for All the Uility Classes
				
				
				//Read Data From Propery File
				String BROWSER = fLib.getPropertKeyValue("browser");
				String URL = fLib.getPropertKeyValue("url");
				String USERNAME = fLib.getPropertKeyValue("username");
				String PASSWORD = fLib.getPropertKeyValue("password");
				
				//Launch The Browser
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
		wLib.maximizeTheBrowser(driver);
		//driver. manage().window().maximize();
	   
		driver.get(URL);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    HomePage hp=new HomePage(driver);
	    hp.clickonLogin();
	    LoginPage lp=new LoginPage(driver);
	    lp.login(USERNAME, PASSWORD);
	    
//	    driver.findElement(By.xpath("//a[.='Login']")).click();
//	    driver.findElement(By.id("exampleInputEmail1")).sendKeys("admin");
//	    driver.findElement(By.id("exampleInputPassword1")).sendKeys("admin");
//	    driver.findElement(By.name("login")).click();
	    DashBoardPage db=new DashBoardPage(driver);
	    db.details();
	    
	    //driver.findElement(By.linkText("Details/Update")).click();
	    
	   // driver.findElement(By.xpath("//a[.='Complaint']")).click();
	    db.complaintlist();
	    
	    driver.findElement(By.id("name")).sendKeys("Henita");
	    driver.findElement(By.id("cmp")).sendKeys("There is no Proper Supply and EB also");
	    driver.findElement(By.name("register")).click();
	    
	}

	}
}
