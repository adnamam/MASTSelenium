package utilities;

import java.util.ResourceBundle;

public class GetPropertyValues {
	
	public static String getValues() {
//		Properties prop = new Properties();
//		String propFileName = "settings.properties";
//		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
//		
//		if (inputStream != null) {
//			prop.load(inputStream);
//		} else {
//			throw new FileNotFoundException("Property file '" + propFileName + "' not found in the classpath");
//		}
//		
//		String url = prop.getProperty("url");
		
		ResourceBundle bun = ResourceBundle.getBundle("settings.properties");
		String url = bun.getString("url");

		return url;
	}

}
