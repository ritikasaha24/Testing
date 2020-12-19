package StepDef;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Createuser 
{
	 WebDriver driver;

	 public Createuser(WebDriver driver)  //creating constructor
		{
			this.driver=driver;    
		}
	 
	 //Page factory is used for initialization of page objects
	 @FindBy(xpath="//input[@id=\"employee_id\"]") 
		WebElement Nusername;
	 @FindBy(xpath="//input[@name=\"first_name\"]") 
		WebElement FirstName;
	 @FindBy(xpath="//input[@name=\"company_name\"]")
	 WebElement Company;
	 @FindBy(xpath="//input[@name=\"password\"]") 
		WebElement Npassword;
	 @FindBy(xpath="//input[@name=\"confirmpassword\"]") 
		WebElement ConfirmP;
	 @FindBy(xpath="//input[@name=\"date\"]") 
		WebElement JoiningDate;
	 @FindBy(xpath="//table/tbody/tr[9]/td[2]/input") 
		WebElement EmailID;
	 
	@FindBy(xpath="//table[@class=\"stylized\"]/tbody/tr[11]/td[2]/select")
	WebElement Country;
	@FindBy(xpath="//input[@name=\"rateperhour\"]")
 	WebElement Rate;
	 @FindBy(xpath="//input[@type=\"submit\"]")
	 WebElement SaveDetails;
	 
	 @FindBy(xpath="//a[contains(text(),'Logout')]")
	 WebElement Logoutt;
	 
	 //To externalise data
	 public void readExcelData() throws FileNotFoundException, IOException, InterruptedException 
	    {         
			
	        File src=new File("D:\\download\\Selenium\\AutomationQ\\TestOutput\\EmployeeDetails.xlsx");
	       
	        FileInputStream fis=new FileInputStream(src);
		    
		    XSSFWorkbook wb=new XSSFWorkbook(fis);
		    
		    Sheet sheet1=wb.getSheet("Sheet1");
		    
		    Row row1=sheet1.getRow(4);
		    Cell cell1=row1.getCell(0); //First row first cell
		    String uname=cell1.getStringCellValue(); //To store the value of the first column in uname
		    
		    Cell cell2=row1.getCell(1);
		    String first=cell2.getStringCellValue();
		    
		    Cell cell3=row1.getCell(2);
		    String Cname=cell3.getStringCellValue();
		    
		    Cell cell4=row1.getCell(3);
		    String pass=cell4.getStringCellValue();
		    
		    Cell cell5=row1.getCell(4);
		    String cpass=cell5.getStringCellValue();
		    
		    DataFormatter formatter = new DataFormatter(); //To change the data type from integer to string
		    String JDate = formatter.formatCellValue(sheet1.getRow(4).getCell(5));
		    
		    Cell cell7=row1.getCell(6);
		    String Email=cell7.getStringCellValue();
		    
		    Cell cell8=row1.getCell(7);
		    String country=cell8.getStringCellValue();
		    
		    DataFormatter format = new DataFormatter();
		    String rph = format.formatCellValue(sheet1.getRow(4).getCell(8));
		   
		    Nusername.sendKeys(uname);
		    Thread.sleep(3000);
		    FirstName.sendKeys(first);
		    Thread.sleep(3000);
		    Company.sendKeys(Cname);
		    Thread.sleep(3000);
		    Npassword.sendKeys(pass);
		    Thread.sleep(3000);
		    ConfirmP.sendKeys(cpass);
		    Thread.sleep(3000);
		    JoiningDate.sendKeys(JDate);
		    Thread.sleep(3000);
		    EmailID.sendKeys(Email);
		    Thread.sleep(3000);
		    
		    Country.sendKeys(country);
		    Country.sendKeys(Keys.ENTER);
		    Thread.sleep(3000);
		    Rate.sendKeys(rph);
		    
		    //read data from the excel file
		    //close output stream
		    fis.close();
		    
		    wb.close();
	    }
	 
	 public void Click_Save() throws InterruptedException
	 {
		 Thread.sleep(3000);
		 SaveDetails.click();
	 }
	 
	 public void Click_Logout() throws InterruptedException 
	 {
		 Logoutt.click();
		 Thread.sleep(3000);
	 }
	}


