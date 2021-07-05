package com.pom.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

//	public void ss() throws EncryptedDocumentException, IOException {
//	FileInputStream file = new FileInputStream("C:\\Users\\Shree\\Desktop\\Book1.xlsx");
//	Workbook a=WorkbookFactory.create(file);
//	String data=a.getSheet("Sheet1").getRow(2).getCell(0).getStringCellValue();
//	System.out.println(data);
//	
	
	public static void takesScreenShot(WebDriver driver, int testID) throws IOException {
	File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	
	File dest=new File("C:\\Users\\Shree\\eclipse-workspace\\invesment-banking1\\test-output\\failedTestCaseSS\\"+testID+".jpeg");
	
	FileHandler.copy(source, dest);
	}
}
