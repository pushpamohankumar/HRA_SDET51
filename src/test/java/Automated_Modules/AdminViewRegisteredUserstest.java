package Automated_Modules;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.HRA.GenericUtilis.ExcelUtility;
import com.HRA.GenericUtilis.FileUtility;
import com.HRA.GenericUtilis.JavaUtility;
import com.HRA.GenericUtilis.WebDriverUtlis;
import com.ObjectRepository.DashBoardPage;
import com.ObjectRepository.HomePage;
import com.ObjectRepository.LoginPage;

public class AdminViewRegisteredUserstest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		//Create Obj For All the Utility
		// Create Object for All the Uility Classes
		WebDriverUtlis wLib=new WebDriverUtlis();
		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		ExcelUtility eLib=new ExcelUtility();
		
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
	
		
		driver.get(URL);
		HomePage hp=new HomePage(driver);
		hp.clickonLogin();
		
		LoginPage li=new LoginPage(driver);
		li.login(USERNAME, PASSWORD);
//		driver.findElement(By.id("exampleInputEmail1")).sendKeys("admin");
//		driver.findElement(By.id("exampleInputPassword1")).sendKeys("admin");
//		driver.findElement(By.xpath("//button[.='Submit']")).click();
		
		DashBoardPage db=new DashBoardPage(driver);
		
		//driver.findElement(By.xpath("(//div[@class='alert alert-warning'])[1]")).click();
	}

}
