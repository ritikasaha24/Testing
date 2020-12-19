package StepDef;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePage extends LibraryFunctions
{
	
	LandingPage loc;

	@Given("Open browser and navigate to the Url")
	public void open_browser_and_navigate_to_the_Url() throws IOException
	{
		//driver=createWebDriverInstance();
		LibraryFunctions.setBrowser();
		driver.get("http://qualitypointtech.net/timesheetdemo/index.php");
		driver.manage().window().maximize();
		Screenshots.captureScreenshot(driver, "BrowserOpened");
		
	}

	@When("In the HomePage Enter the valid username and password")
	public void in_the_HomePage_Enter_the_valid_username_and_password() throws InterruptedException
	{
		LandingPage loc=PageFactory.initElements(driver, LandingPage.class);
		loc.RightPageVerify();
		Thread.sleep(3000);
		loc.defaultuser();
		Thread.sleep(3000);
	}
	
	@Then("User should be able to Login")
	public void user_should_be_able_to_Login() throws InterruptedException 
	{
		LandingPage loc=PageFactory.initElements(driver, LandingPage.class);
		loc.Login();
		Screenshots.captureScreenshot(driver, "AfterLogin");
	}

	@Then("Verify the user is able to login successfully")
	public void verify_the_user_is_able_to_login_successfully() 
	{
		System.out.println(driver.getTitle());
		System.out.println("The user is in RightPage");
	}
	
	@Given("Click on Employee Details")
	public void click_on_Employee_Details() throws InterruptedException 
	{
		
		LandingPage loc=PageFactory.initElements(driver, LandingPage.class);
		loc.Click_Employee();
		Screenshots.captureScreenshot(driver, "EmpDetails");
	}

	@Then("Create a new user by clicking on the link")
	public void create_a_new_user_by_clicking_on_the_link() throws InterruptedException 
	{
	   
		LandingPage loc=PageFactory.initElements(driver, LandingPage.class);
		loc.Click_NewUser();
		
	}

	@Then("Fill the details and create the user")
	public void check_Verify_the_new_user_Page_is_Displayed() throws InterruptedException, FileNotFoundException, IOException
	{
	    
		Createuser us=PageFactory.initElements(driver,Createuser.class);
		us.readExcelData();
		Screenshots.captureScreenshot(driver, "NewUser");
		
	}
	@Then("Message displayed Employee Details saved sucessfully")
	public void message_displayed_Employee_Details_saved_sucessfully() throws InterruptedException
	{
		Createuser us=PageFactory.initElements(driver,Createuser.class);
		us.Click_Save();
		System.out.println("Employee Details saved sucessfully");
	}

	@Then("User will navigate to logout")
	public void user_will_navigate_to_logout() throws InterruptedException 
	{
		Createuser us=PageFactory.initElements(driver,Createuser.class);
		us.Click_Logout();
	}

	@Then("Message displayed You have been logged out")
	public void message_displayed_You_have_been_logged_out() 
	{
	  System.out.println("You have Logged Out Successfully");
	  Screenshots.captureScreenshot(driver, "LoggedOut");
	  
	}

	@Then("Go to edit employee")
	public void go_to_edit_employee() throws InterruptedException
	{
		UpdateUser upd=PageFactory.initElements(driver,UpdateUser.class);
		upd.editD();
		Screenshots.captureScreenshot(driver, "EditDetails");
	}

	@Then("User will update new email ID")
	public void user_will_update_new_email_ID() throws InterruptedException 
	{
		UpdateUser upd=PageFactory.initElements(driver,UpdateUser.class);
		upd.updateDetails();
		Screenshots.captureScreenshot(driver, "UpdatedDetails");
	}

	@Then("Message displayed Employee Details updated Successfully")
	public void message_displayed_Employee_Details_updated_Successfully() 
	{
		System.out.println("Employee Details Updated Successfully");
		
	}
	
	@Then("User will Validate the updated Email id")
	public void user_will_Validate_the_updated_Email_id() throws IOException
	{
		ValidateE valid=new ValidateE(driver);
		System.out.println("Employee Details Updated in Excel");
		valid.Write();
	}

	@Then("Close the browser")
	public void close_the_browser() 
	{
	    driver.close();
	    
	}

}
