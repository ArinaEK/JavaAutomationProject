package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Utils {

	public static String readProperty(String key) {
		String value="";		
		try (InputStream input = new FileInputStream("./src/data/configuration.properties")) {
			Properties prop = new Properties();
			// load a properties file
			prop.load(input);
			// get the property value and return
			value=prop.getProperty(key);        
			//System.out.println(prop.getProperty("db.url"));
			//System.out.println(prop.getProperty("db.user"));
			//System.out.println(prop.getProperty("db.password"));

		} catch (Exception ex) {
		}
		return value;
	}
}
