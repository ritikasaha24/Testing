package StepDef;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshots 
{
	public static void captureScreenshot(WebDriver driver, String screenshotname) 
	{
		try 
		{
			
			File ts = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					
			FileHandler.copy(ts, new File(".\\Screenshots\\"+screenshotname+".png"));
			
			System.out.println("Screenshot taken");
		} 
		
		catch (Exception e) 
		{
			System.out.println("Exception while taking screenshot "+e.getMessage());
			
		} 

	}
}
