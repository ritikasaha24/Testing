package StepDef;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.sitture.ExtentReporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.*; 

//Tells about the test runner class to start executing our tests
@RunWith(Cucumber.class)
//To set some properties for our cucumber test
@CucumberOptions(features="src\\test\\resources\\Features",glue= {"StepDef"},strict = true,monochrome=true,

plugin= {"com.sitture.ExtentFormatter:TestReports/extent-reports/report.html",
		"json","json:target/JSONReports/report.json",
		"html:target\\HtmlReports",
		"junit:target/XMLReports/report.xml"}
)
public class TestRunner {
	
	@AfterClass 
    public static void writeExtentReport() throws IOException { 
        String extentConfigPath = System.getProperty("user.dir") + "\\src\\test\\resources\\extent-config.xml";
         ExtentReporter.setConfig(extentConfigPath);
         //ExtentReporter.setSystemInfo("Browser", ReadProperties.browser());
         ExtentReporter.setSystemInfo("User Name", System.getProperty("user.name"));
   }

}
