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

public class NewUserRegistrationtest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		//crate obj for all the utilities
		WebDriverUtlis wLib=new WebDriverUtlis();
		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		ExcelUtility eLib=new ExcelUtility();
		
		
		//Read data from Property File
		String BROWSER = fLib.getPropertKeyValue("browser");
		String URL = fLib.getPropertKeyValue("url");
		String USERNAME = fLib.getPropertKeyValue("username");
		String PASSWORD = fLib.getPropertKeyValue("password");
		
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
		
		//driver.manage().window().maximize();
		wLib.maximizeTheBrowser(driver);
		
		driver.get(URL);
		DashBoardPage db=new DashBoardPage(driver);
		db.clickonRegister();
//		driver.findElement(By.xpath("//a[text()='Register']")).click();
		
		driver.findElement(By.id("fullname")).sendKeys("Heshika");
		driver.findElement(By.id("username")).sendKeys("Ishu");
		driver.findElement(By.id("mobile")).sendKeys("9876543200");
		driver.findElement(By.id("email")).sendKeys("ishu@gmail.com");
		driver.findElement(By.id("password")).sendKeys("ishu");
		driver.findElement(By.id("c_password")).sendKeys("ishu");
		driver.findElement(By.xpath("//button[.='Submit']")).click();
		
		
	}

}
