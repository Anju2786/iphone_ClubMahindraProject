package com.assignment.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assignment.generic.CommonLib;
import com.assignment.generic.FileLib;
import com.assignment.generic.IAutoconstant;

/**
 * 
 * @author Anju
 *
 */

public class AmazonPom extends FileLib implements IAutoconstant {
	private WebDriver driver;
	private CommonLib common;
	FileLib file=new FileLib();
	
	/* search for iphone*/
	@FindBy(xpath="//input[@name='field-keywords']") private WebElement searchField;
	
	@FindBy(xpath="//span[text()='Apple iPhone XR (64GB) - Yellow']/../../../../../../..//span[@class='a-price-whole']") private WebElement price;
	@FindBy(xpath = "//input[@value='Go']") private WebElement searchBtn;
	/*
	 * initializing
	 */
	public  AmazonPom(WebDriver driver) throws Throwable {
		driver.get(file.getKeyPropertyvalue(PROP_PATH, "url"));
		PageFactory.initElements(driver, this);
		this.driver=driver;
		common=new CommonLib(driver);
		//return driver;
	}
	/**
	 * Search for product
	 * @param sheetName
	 * @param row
	 * @param column
	 * @throws Throwable
	 */
	public void searchProduct(String sheetName,int row,int column) throws Throwable {
	
		
		common.waitForPageToLoad();
//		searchField.sendKeys(file.getCellData(sheetName,row,column));
		searchBtn.click();
		searchField.sendKeys("iPhone XR (64GB) - Yellow",Keys.ENTER);
		
	}
	/**
	 * fetching price
	 * @return price
	 */
	public int productPrice() {
		String priceValue=price.getText();
		int pricedata=common.removeSpecialChars(priceValue);
		return pricedata;
		//return priceValue; 
	}

}
