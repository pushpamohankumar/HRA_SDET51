package Automated_Modules;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.HRA.GenericUtilis.DatabaseUtility;
import com.HRA.GenericUtilis.ExcelUtility;
import com.HRA.GenericUtilis.FileUtility;
import com.HRA.GenericUtilis.JavaUtility;
import com.HRA.GenericUtilis.WebDriverUtlis;

public class UserApartmentDetailsReflecttest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		DatabaseUtility dLib=new DatabaseUtility();
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtlis wLib=new WebDriverUtlis();
		JavaUtility JLib=new JavaUtility();
		FileUtility fLib=new FileUtility();
		
		
	    
	    //Read the Common Data from property File
//	    FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
//	    Properties p=new Properties();
//	    p.load(fis);
	    String BROWSER = fLib.getPropertKeyValue("browser");
	    String URL = fLib.getPropertKeyValue("url");
	    String USERNAME =fLib.getPropertKeyValue("username");
	    String PASSWORD= fLib.getPropertKeyValue("password");
	    
	    //Launch the Browser
	    
	    WebDriver driver=null;
	   if(BROWSER.equalsIgnoreCase("chrome"))
	   {
		   driver=new ChromeDriver();
	   }
	   else if(BROWSER.equalsIgnoreCase("Firefox"))
	   {
		   driver=new FirefoxDriver();
	   }
	   else
	   {
		   System.out.println("invalid Browser");
	   }
	    
	    //driver. manage().window().maximize();
	   wLib.maximizeTheBrowser(driver);
	    driver.get(URL);
	   // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    wLib.implicitwait(driver, 10);
	    
	    driver.findElement(By.xpath("//a[.='Login']")).click();
	    driver.findElement(By.id("exampleInputEmail1")).sendKeys("Ishu");
	    driver.findElement(By.id("exampleInputPassword1")).sendKeys("ishu");
	    driver.findElement(By.name("login")).click();
	   
	    driver.findElement(By.linkText("Register")).click();
	    driver.findElement(By.xpath("//a[.='Apartment Registration']")).click();
	    //driver.findElement(By.id("apartment_name")).sendKeys("Heshika");
	    //Fetch the data from Excel file
	    //FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\ReadDataFromExcel.xlsx");
	   // Workbook wb = WorkbookFactory.create(fis1);
	   // Sheet sh = eLib.getSheet("Registration1");
	   
	    int count= eLib.getRowCount("Apartment");
	  
	    /*driver.findElement(By.id("apartment_name")).sendKeys("Heshika");
	    driver.findElement(By.xpath("(//label[.='Mobile'])[2]/following-sibling::input[@id='mobile']")).sendKeys("9876543234");
	    driver.findElement(By.xpath("//h2[.='Apartment Room']/../descendant::input[@id='alternat_mobile']")).sendKeys("9876567890");
	    driver.findElement(By.xpath("//h2[.='Apartment Room']/../descendant::input[@id='email']")).sendKeys("ishu@gmail.com");
	    driver.findElement(By.xpath("//h2[.='Apartment Room']/../descendant::input[@id='plot_number']")).sendKeys("123A");
	    driver.findElement(By.xpath("//h2[.='Apartment Room']/../descendant::input[@id='country']")).sendKeys("India");
	    driver.findElement(By.xpath("//h2[.='Apartment Room']/../descendant::input[@id='state']")).sendKeys("karnataka");
	    driver.findElement(By.xpath("//h2[.='Apartment Room']/../descendant::input[@id='city']")).sendKeys("Bangalore");
	    driver.findElement(By.xpath("//h2[.='Apartment Room']/../descendant::input[@id='landmark']")).sendKeys("Near BTM");
	    driver.findElement(By.xpath("//h2[.='Apartment Room']/../descendant::input[@id='address']")).sendKeys("Bangalore BTM");
	    driver.findElement(By.xpath("//h2[.='Apartment Room']/../descendant::input[@id='image']")).sendKeys("C:\\Users\\Acer\\Desktop\\house.jpg");
	    driver.findElement(By.xpath("//h2[.='Apartment Room']/..//button[.='Submit']")).click();
	    driver.findElement(By.xpath("//a[.='Heshika ']/../following-sibling::li/a")).click();	    //login as a admin
		
	    driver.findElement(By.xpath("//a[.='Login']")).click();
	    driver.findElement(By.id("exampleInputEmail1")).sendKeys("admin");
	    driver.findElement(By.id("exampleInputPassword1")).sendKeys("admin");
	    driver.findElement(By.name("login")).click();
	    driver.findElement(By.xpath("//a[.='Details/Update']")).click();*/
	   
	  /* HashMap<String, String>	map=new HashMap<String,String>();
		for(int i=1;i<=count;i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);		
		}
		for (Entry<String, String> entry:map.entrySet()) {
			driver.findElement(By.xpath(entry.getKey())).sendKeys(entry.getValue());
		}	*/
	    eLib.getMultipleDataFromExcel("Apartment", 0, 1, driver);
	
		driver.findElement(By.xpath("(//input[@id='image'])[2]")).sendKeys("C:\\Users\\Acer\\Desktop\\Most-Beautiful-House-in-the-World.jpg");
		driver.findElement(By.xpath("//h2[.='Apartment Room']/../descendant::button[.='Submit']")).click();
	    
	}

}
