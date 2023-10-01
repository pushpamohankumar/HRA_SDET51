
package com.HRA.GenericUtilis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {

	public String getPropertKeyValue(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstants.propertyfilepath);
		Properties p=new Properties();
		p.load(fis);
		return p.getProperty(key);
		
	}
}
