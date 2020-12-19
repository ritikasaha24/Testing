package StepDef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage 
{
	 WebDriver driver;
	 
	 public LandingPage(WebDriver driver)  //creating constructor
		{
			this.driver=driver;    
		}
	 @FindBy(xpath="//input[@id=\"username\"]") 
		WebElement Username;
	 @FindBy(xpath="//input[@name=\"password\"]") 
		WebElement Password;
	 @FindBy(xpath="//input[@name=\"login\"]") 
		WebElement  Login;
	 @FindBy(xpath="//a[contains(text(),'Employee Details')]") 
		WebElement EmployeeD;
	 @FindBy(xpath="//a[contains(text(),'Create New User')]") 
		WebElement NewUser;
	   
	 public void RightPageVerify()
	 {
			if(driver.getCurrentUrl().contains("Technologies"))
		    {
		    	System.out.println("The user is in correct page");
		    }
		}
	
	 public void defaultuser() throws InterruptedException
	 {

	    Username.sendKeys("admin");
	    Thread.sleep(3000);
	 	Password.sendKeys("admin");
	 	Thread.sleep(3000);
	 }
	 
	 public void Login() throws InterruptedException
	 {
	    Login.click();
	 	Thread.sleep(3000);
	 }
	 
	 public void Click_Employee() throws InterruptedException
	 {
	 	EmployeeD.click();
	 	Thread.sleep(3000);
	 }
	 public void Click_NewUser() throws InterruptedException
	 {
		 NewUser.click();
		 Thread.sleep(3000);
	 }
	 //New Employee Registration Form
	 
}
