package utilities;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropFile {
	
	String isRemoteString = "";
	boolean isRemote = false;
	InputStream inputStream;
 
	/**
	 * gets value of URL property from prop file
	 * @return
	 * @throws IOException
	 */
	public String getURL(){
		String currentURL = null;
		try {
			currentURL = getProperty("url");
		} catch (IOException e) {
			throw new IllegalStateException("settings.properties did not contain url value");
		}
		return currentURL;
	}
	
	/**
	 * Gets value of isRemote property from prop file, returns boolean result
	 * @return
	 * @throws IOException
	 */
	public boolean checkIfRemote() throws IOException {
		isRemoteString =  getProperty("isRemote");
		if (isRemoteString.equals("true")) isRemote = true;
		else if (isRemoteString.equals("false")) isRemote = false;
		else throw new IllegalArgumentException("isRemote setting did not hold a valid value");
		return isRemote;
	}
	
	/**
	 * gets specified setting from the settings.properties file and returns the value
	 * in a String
	 * @param setting
	 * @return
	 * @throws IOException
	 */
	public String getProperty(String setting) throws IOException {
		try {
			Properties prop = new Properties();
			String propFileName = "settings.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			isRemoteString = prop.getProperty(setting);
		} finally {
			inputStream.close();
		}
		return isRemoteString;
	}

}
