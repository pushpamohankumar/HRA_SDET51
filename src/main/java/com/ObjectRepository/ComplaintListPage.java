package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComplaintListPage {

	@FindBy(xpath="//p[text()='mahantesh1235#']/ancestor::div[@class='card card-inverse card-info mb-3']/div/a[text()='Edit']")
	private WebElement Edit;
	
	
}

