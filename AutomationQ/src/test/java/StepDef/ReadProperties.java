package StepDef;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
	    
	    public static Properties readData() {
	        Properties objProp = new Properties();
	        try {
	            String env = System.getProperty("env");
	            File file = new File("Data.properties");
	            FileInputStream fileInput = null;
	            fileInput = new FileInputStream(file);
	            objProp.load(fileInput);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return objProp;
	    }

}
