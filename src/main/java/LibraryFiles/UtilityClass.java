package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass
{
	//This method is use to get test data from excel sheet 
	//need to pass 2 parameters 1. rowIndex 2. colIndex
	//Author name: Sanjay
	public static String getTD(int rowIndex,int colIndex) throws EncryptedDocumentException, IOException 
	{
		FileInputStream file=new FileInputStream("D:\\SOFTWARE TESTING\\Nov20CSelenium_Maven1\\TestData\\Framework with DDF_2.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
		String value = sh.getRow(rowIndex).getCell(colIndex).getStringCellValue();
		return value;
	}
	
	
	//This method is use to capture screenshot of webpage
	//need to pass 2 parameters 1. webdriver Object 2. TCID
	//Author name: Sanjay
	public static void captureScreenshot(WebDriver driver,int TCID) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("D:\\SOFTWARE TESTING\\Nov20CSelenium_Maven1\\Screenshots"+TCID+".jpg");
		FileHandler.copy(src, dest);
	}
	
	
	//this method is use to read property file data
	//need pass 1 parameter: String key
	//Author name: Sanjay
	public static String getPFData(String key) throws IOException
	{
		FileInputStream file=new FileInputStream("D:\\SOFTWARE TESTING\\Nov20CSelenium_Maven1\\PropertyFile.properties");
		
		Properties p=new Properties();
		p.load(file);
		
		String value = p.getProperty(key);
		
		return value;
	}
	
	
	
	

}
