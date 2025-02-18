package Utility_pack;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtile {
	
	 private static Properties properties;

	    static {
	        try (FileInputStream fileInputStream = new FileInputStream("src/test/TestData.properties")) 
	        {
	            properties = new Properties();
	            properties.load(fileInputStream);
	        } catch (IOException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Failed to load properties file!");
	        }
	    }

	    public static String getProperty(String key) {
	        return properties.getProperty(key);
	    }

}
