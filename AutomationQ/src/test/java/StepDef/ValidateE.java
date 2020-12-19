package StepDef;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ValidateE 
{

	 WebDriver driver;
	 
	 public ValidateE(WebDriver driver)   //creating constructor
		{
			this.driver=driver;
		}
	 
	 public void Write() throws IOException 
	 {
		 
		 String str="ritikasaha20@gmail.com";
			
			 File src=new File("D:\\download\\Selenium\\AutomationQ\\TestOutput\\EmployeeDetails.xlsx");
		       
		        FileInputStream fis= new FileInputStream(src);
			    
			    XSSFWorkbook wb=new XSSFWorkbook(fis);
			    
			   Sheet sheet2=wb.getSheet("Sheet1");
			    
			   Row row1=sheet2.getRow(4);
			   Cell cell2=row1.getCell(6);
			   cell2.setCellValue(str);

				fis.close();
			   
				FileOutputStream fos = new FileOutputStream(src);		    //write data in the excel file
				 
				  wb.write(fos);
				
				  fos.close();
				  
				  wb.close();
			  
	 }
	 
	 
}
