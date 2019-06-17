package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ReportsPOM {
	
private WebDriver driver; 
	
	public ReportsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//*[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	@FindBy(id="menu-report")
	private WebElement report; 
	
	@FindBy(linkText="Sales")
	private WebElement Sales; 
	
	@FindBy(linkText="Shipping")
	private WebElement Shipping; 
	
	@FindBy(id="input-group")
	private WebElement group;
	
	@FindBy(id="button-filter")
	private WebElement filter;
	
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	
	
	public void clickReports() throws Throwable {
		Actions action=new Actions(driver);
		action.moveToElement(report).build().perform();
		Thread.sleep(2000);
		this.Sales.click();
		Thread.sleep(2000);
		this.Shipping.click();
		Assert.assertTrue(this.Shipping.isSelected());
		Select sel=new Select(group);
		sel.selectByIndex(1);
		Thread.sleep(2000);
		this.filter.click();
		
	}

}
