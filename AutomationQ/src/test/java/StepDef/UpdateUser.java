package StepDef;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpdateUser{
	
	WebDriver driver;
	
	public UpdateUser(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(xpath="//table[@class='wpn_content']/tbody/descendant::td[contains(text(),'Ritika')][2]/following::td[2]")
	WebElement Edit;
	
	@FindBy(xpath="//input[@name=\"email_id\"]") 
	WebElement Email;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement Update;
	
	public void editD() throws InterruptedException
	{
		Thread.sleep(3000);
		Edit.click();
	}
	
	public void updateDetails() throws InterruptedException
	{
		Thread.sleep(3000);
		Email.sendKeys(Keys.CONTROL + "a");  
		Email.sendKeys(Keys.DELETE);        
		Thread.sleep(3000);
		Email.sendKeys("ritikasaha20@gmail.com");
		Thread.sleep(3000);
		Update.click();
		
	}
	
}