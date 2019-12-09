package utilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader 
{
	Properties prop;
	FileInputStream fis;
	public ConfigFileReader()
	{
		 prop= new Properties();
		try 
		{
			 fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//testData//config.properties");
			try 
			{
				prop.load(fis);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		} 
		catch (FileNotFoundException e) 
		{
			
			e.printStackTrace();
		}
	}
	public String getBrowser()
	{
		return prop.getProperty("browser");
	}
	
	public String getURL()
	{
		return prop.getProperty("url");
	}
}
