package com.pom.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
	
	@FindBy (xpath="(//a[@href='/tasks/otasklist.do']//img)[1]") private WebElement task ;
	@FindBy (xpath="(//img[@width='84'])[3]") private WebElement report ;
	@FindBy (xpath="//a[@id='logoutLink']") private WebElement logout ;
	@FindBy (xpath="(//img[@width='84'])[5]") private WebElement b ;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void ClickOnTask() {
		task.click();
		
	}
	
	public void ClickOnReport() {
		report.click();
	}
	
	public void ClickOnLogout() {
		logout.click();
	}
	
	public void ClickOnWorkSchdl() {
		Actions a=new Actions(driver);
		a.moveToElement(b).click().build().perform();
	}


}
