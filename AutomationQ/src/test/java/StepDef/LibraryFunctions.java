package StepDef;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class LibraryFunctions {
    protected static WebDriver driver;
    
    public static void setBrowser() {
        /***** Set Browser *****/
        try {
            //URL testGridUrl = new URL(System.getProperty("gridURL").trim());
            String strExecutionPlatform = System.getProperty("executionPlatform").trim().toUpperCase();
            //LOCAL_CHROME, LOCAL_FIREFOX, AWS_CHROME, AWS_FIREFOX, AWS_DEVICEFARM_CHROME, AWS_DEVICEFARM_FIREFOX
            
            switch (strExecutionPlatform) {
            case "LOCAL_CHROME": 
                driver = DriverSetup.getChromeWebDriver();
                break;
            case "LOCAL_FIREFOX":
                driver = DriverSetup.getFireFoxWebDriver();
                break;
            case "AWS_CHROME":
                driver = DriverSetup.getAWSChromeDriver();
                break;
            case "AWS_FIREFOX":
                driver = DriverSetup.getAWSFirefoxDriver();
                break;
                default:
                    System.out.println("\nExecutionPlatform Platform must be set in settings file.\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
        // Maximize Browser window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    
  
    public static void closeBrowser() {
        // Close Browser
        driver.quit();
    }
}
