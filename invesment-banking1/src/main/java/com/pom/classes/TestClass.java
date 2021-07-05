package com.pom.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shree\\selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost/login.do");
		
		LogInPage LogIn=new LogInPage(driver);
		LogIn.sendDataToUser();
		LogIn.sendDataToPass();
		LogIn.clickOnLogin();
	}
	

}
