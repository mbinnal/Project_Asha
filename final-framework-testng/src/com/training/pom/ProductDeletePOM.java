package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductDeletePOM {

private WebDriver driver; 
	
	public ProductDeletePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//*[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	@FindBy(id="menu-catalog")
	private WebElement catalog; 
	
	@FindBy(linkText="Products")
	private WebElement Products; 
	
	@FindBy(xpath="//*[@type='checkbox' and @name='selected[]'and @value='794']")
	private WebElement checkbox; 
	
	@FindBy(xpath="//*[@class='btn btn-danger']")
	private WebElement delete;
	
	
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
	
	
	
	public void clickProduct() throws Throwable {
		Actions action=new Actions(driver);
		action.moveToElement(catalog).build().perform();
		Thread.sleep(2000);
		this.Products.click();
		Thread.sleep(2000);
		
		this.checkbox.click();
		Assert.assertTrue(this.checkbox.isSelected());
		this.delete.click();
		Thread.sleep(4000);
		Alert alert= driver.switchTo().alert();
		alert.accept();
	

		
	}
}
