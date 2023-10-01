package com.HRA.GenericUtilis;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtlis {
	/**
	 * This method is used to maximize the browser
	 * @param driver
	 */
		public void maximizeTheBrowser(WebDriver driver) {
			driver.manage().window().maximize();
		}
	/**
	 * This method is used to minimize the browser
	 * @param driver
	 */
	public void minimizeTheBrowser(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will wait util the element in the page get load
	 * @param driver
	 * @param duration
	 */
	public void implicitwait(WebDriver driver,int duration)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}
	
	
	/**
	 * This method will wait until the url of the page get load
	 * @param driver
	 * @param duration
	 * @param expectedurl
	 */
	public void waitUntilUrlLoads(WebDriver driver,int duration,String expectedurl)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.urlContains(expectedurl));
	}
	
	/**
	 * This method will wait until the title of the page get load
	 * @param driver
	 * @param duration
	 * @param expectedTitle
	 */
	public void waitUntilTitleLoads(WebDriver driver,int duration,String expectedTitle)
	{
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.titleContains(expectedTitle));
	}
	
	/**
	 * This method will wait until element in the page get loads
	 * @param driver
	 * @param duration
	 * @param element
	 */
	public void waitUUnitElementtobeClickable(WebDriver driver,int duration,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will ignore NosuchElementException and continues the execution 
	 * @param driver
	 * @param duration
	 */
	public void ignoreNoSuchElementException(WebDriver driver,int duration) 
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
	}
	
	/**
	 * This method will wait until the element to be visible in the page
	 * @param element
	 * @throws InterruptedException
	 */
	public void customWait(WebElement element) throws InterruptedException
	{
		int count=0;
		while(count<20)
		{
			try {
				element.click();
				break;
			}
		catch(Exception e)
		{
			Thread.sleep(1000);
			count++;
		}
	}}
	/**
	 * This method will select a dropdown element based on index
	 * @param element
	 * @param index
	 */
	public void selectDropDown(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method will select a dropdown based on value
	 * @param element
	 * @param value
	 */
	
	public void selectDropdown(WebElement element,String value)
	{
	Select s=new Select(element);
	s.selectByValue(value);
	}

		/**
		 * This method will select a dropdown based on text
		 * @param text
		 * @param element
		 */
	public void selectDropdown(String text,WebElement element)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * This method is used to mouse over on an element
	 * @param driver
	 * @param element
	 */

	public void mouseoveronElement(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}

		/**
		 * This method is used to right click on an element
		 * @param driver
		 * @param element
		 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}

		/**
		 * This method is used to click on enter button
		 * @param driver
		 */
	public void clickonEnterKey(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}
	
	/**
	 * This method is used tto switch from one frame to another using index
	 * @param driver
	 * @param index
	 */
	
	public void switchFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method is used to switch from one frame to another using id
	 * @param driver
	 * @param id
	 */
	public void switchFrame(WebDriver driver,String id)
	{
		driver.switchTo().frame(id);
	}

		/**
		 * This method is used to switch frm one frame to another using webelement
		 * @param driver
		 * @param element
		 */
		public void switchFrame(WebDriver driver,WebElement element)
		{
			driver.switchTo().frame(element);
		}
	
		
		/**
		 * This method is used to switch to main frame
		 * @param driver
		 */
		public void switchtoMainFrame(WebDriver driver)
		{
			driver.switchTo().defaultContent();
		}
		
		
		/**
		 * This method is used to accept alert popup
		 * @param driver
		 * @param expectedmsg
		 */

		public void acceptAlertPopup(WebDriver driver,String expectedmsg)
		{
			Alert alt = driver.switchTo().alert();
			if(alt.getText().equalsIgnoreCase(expectedmsg))
			{
				System.out.println("Alert is verified");
			}
			else {
				System.out.println("Alert is not verified");
			}
			alt.accept();
			
		}
		/**
		 * This method is used to dismiss the alert popup
		 * @param driver
		 * @param expectedmsg
		 */

		public void dismissAlertPopup(WebDriver driver,String expectedmsg)
		{
			Alert a=driver.switchTo().alert();
			if(a.getText().equalsIgnoreCase(expectedmsg))
			{
				System.out.println("Alert is verified");
			}
			else {
				System.out.println("Alert is not verified");
			}
			a.dismiss();
		}
		
		/**
		 * This method is used to switch from one window to another based on title
		 * @param driver
		 * @param expectedTitle
		 */
		public void switchwindowBasedonTitle(WebDriver driver,String expectedTitle)
		{
			Set<String> set = driver.getWindowHandles();
			for(String str:set) {
				driver.switchTo().window(str);
				String title=driver.getTitle();
				if(title.contains(expectedTitle))
				{
					break;
				}
			}
		}
		
		/**
		 * This method is used to switch from one window to another based on url
		 * @param driver
		 * @param expectedUrl
		 */

		public void switchwindowBasedUrl(WebDriver driver,String expectedUrl)
		{
			Set<String> set = driver.getWindowHandles();
			Iterator<String> it=set.iterator();
			while(it.hasNext())
			{
				String wid=it.next();
				driver.switchTo().window(wid);
				String url=driver.getCurrentUrl();
				if(url.contains(expectedUrl))
				{
					break;
				}
			}
		}
		/**
		 * This method is used to take screenshotwhenever the test script getting failed
		 * @param driver
		 * @param ScreenshotName
		 * @return
		 */
		public String takeScreenShot(WebDriver driver,String ScreenshotName)
		{
			TakesScreenshot takescreenshot=(TakesScreenshot) driver;
			File src=takescreenshot.getScreenshotAs(OutputType.FILE);
			File dst=new File("./screenShots/"+ScreenshotName+"png");
			try {
				FileUtils.copyFile(src, dst);
				}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return ScreenshotName;
		}
		
		/**
		 * This method is used to scrol particular element
		 * 
		 * @param driver
		 * @param element
		 */
		public void scrollToParticularElement(WebDriver driver,WebElement element)
		{
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView()", element);
		}
		
		/**
		 * This method is used to Scroll
		 * @param driver
		 */
		public void scroolbarAction(WebDriver driver,int x,int y)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scroolBy("+x+","+y+")","");
		}
		/**

		 * This method will press Enter Key
		 * @param driver
		 * @throws Throwable
		 */
		public void enterKey(WebDriver driver) throws Throwable
		{
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
		}
		/**
		 * This method will Release the key
		 * @param driver
		 * @throws Throwable
		 */
		public void enterRelease(WebDriver driver) throws Throwable
		{
			Robot r=new Robot();
			r.keyRelease(KeyEvent.VK_ENTER);
		}
		
		/**
		 * This method is used to DragandDrop the element
		 * @param driver
		 * @param src
		 * @param dst
		 */
		public void dragandDrop(WebDriver driver,WebElement src,WebElement dst)
		{
			Actions a=new Actions(driver);
			a.dragAndDrop(src, dst).perform();
		}
		
		/**
		 * This method will double click on webpage
		 * @param driver
		 * @param element
		 */
		public void doubleClickAction(WebDriver driver,WebElement element)
		{
			Actions a=new Actions(driver);
			a.doubleClick(element).perform();
		}
}









