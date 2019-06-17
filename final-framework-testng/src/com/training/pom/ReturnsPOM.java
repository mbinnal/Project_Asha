package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ReturnsPOM {
	
private WebDriver driver; 
	
	public ReturnsPOM(WebDriver driver) {
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
	
	@FindBy(linkText="Returns")
	private WebElement Returns; 
	
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
	
	
	
	public void clickReturns() throws Throwable {
		Actions action=new Actions(driver);
		action.moveToElement(report).build().perform();
		Thread.sleep(2000);
		this.Sales.click();
		Thread.sleep(2000);
		this.Returns.click();
		Assert.assertTrue(this.Returns.isSelected());
		Select sel=new Select(group);
		sel.selectByIndex(3);
		Thread.sleep(3000);
		this.filter.click();
		
	}

}
