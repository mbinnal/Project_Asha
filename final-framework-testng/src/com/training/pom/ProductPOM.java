package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPOM {
	
private WebDriver driver; 
	
	public ProductPOM(WebDriver driver) {
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
	
	@FindBy(xpath="//*[@id='input-name']")
	private WebElement productname; 
	
	@FindBy(id="button-filter")
	private WebElement filter; 
	
	@FindBy(id="input-price")
	private WebElement price1; 
	
	@FindBy(linkText="Integer vitae iaculis massa")
	private WebElement subprodname; 
	
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
	
	
	
	public void clickProduct(String price) throws Throwable {
		Actions action=new Actions(driver);
		action.moveToElement(catalog).build().perform();
		Thread.sleep(2000);
		this.Products.click();
		Thread.sleep(2000);
	
		this.productname.click();
		Thread.sleep(2000);
		this.subprodname.click();
		this.filter.click();
		Thread.sleep(2000);
		this.price1.sendKeys(price);
		this.filter.click();
		
	}
	

}
