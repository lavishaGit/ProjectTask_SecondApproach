package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class propertyReader {
	
	   public static  Properties loadProperties() {
	        try {
	        	 FileInputStream fis = new FileInputStream("/Users/nitin/eclipse workspace/Java/Projecttask_SecondApproach/src/test/resources/Properties/readConfig.properties");
	        	 Properties prop = new Properties();
	            prop.load(fis);
	            fis.close();
	            return prop;

	        } catch (Exception e) {
	            System.out.println("Config.properties file not found");
	            return null;
	        }

	    }
	   
	   public static String getURL()
	   {
		  return  loadProperties().getProperty("baseURL");
	   }
public static String getUsername()
{
	return loadProperties().getProperty("username");
	
}
public static String getPassword()
{
	return loadProperties().getProperty("password");
	
}
}
