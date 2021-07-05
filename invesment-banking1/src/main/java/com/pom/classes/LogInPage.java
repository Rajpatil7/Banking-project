package com.pom.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

	@FindBy (xpath="(//input[@type='text'])[1]") private WebElement user;
	
	@FindBy (xpath="(//input[@type='password'])[1]") private WebElement pass;

	@FindBy (xpath="//a[@id=\"loginButton\"]") private WebElement logIn;

	public LogInPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void sendDataToUser(){
		boolean b=user.isEnabled();
		if(b==true)
		{
			user.sendKeys("admin");
		}
		else 
		{
			System.out.println("user is not visible");
		}
	}
		
	public void sendDataToPass(){
		pass.sendKeys("manager");
	}
	
	public void clickOnLogin() {
		logIn.click();
	}	
	
	
}
