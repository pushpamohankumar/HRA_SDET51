package com.HRA.GenericUtilis;

import java.sql.Date;
import java.util.Random;

public class JavaUtility {

	/**
	 * This method is used to get the Random Number
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran=new Random();
		int randNum = ran.nextInt(1000);
		return randNum;
		
	}
	
	public String getSystemDate()
	{
		Date date=new Date(0);
		return date.toString();	
	}
	
	public String getSystemDateInFomant()
	{
		Date dateTime=new Date(0);
		String[] a=dateTime.toString().split("");
		
		String day=a[0];
		String Month=a[1];
		String date=a[2];
		String year=a[5];
		String finalFormat=day+ " "+Month + " "+date+ " "+year;
		return finalFormat;
		
	}
}
