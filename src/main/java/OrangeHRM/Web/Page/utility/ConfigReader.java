package OrangeHRM.Web.Page.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
private static Properties prop;
public ConfigReader() throws IOException {
	  prop = new Properties();
	  try {
//		  String filepath=prop.getProperty("user.dir")+"/src/test/resources/testdata.properties";
		FileInputStream file=new FileInputStream("C:\\Users\\sansingh\\eclipse-workspace\\Web\\src\\test\\resources\\properties\\testdata.properties");
		prop.load(file);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
   public static String getProperty(String key) {
    return prop.getProperty(key);
    }
}
