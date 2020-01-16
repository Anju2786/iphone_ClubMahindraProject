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

public class FlipkartPOM extends FileLib implements IAutoconstant {
	private WebDriver driver;
	private CommonLib common;
	FileLib file = new FileLib();
	/* locating elements */
	@FindBy(xpath = "//button[text()='✕']")
	private WebElement closeBtn;
	@FindBy(xpath = "//input[@class='LM6RPg']")
	private WebElement search;
	@FindBy(xpath = "//div[text()='Apple iPhone XR (Yellow, 64 GB)']/../following-sibling::div/div/div/div")
	private WebElement price;

	/**
	 * constructor
	 * 
	 * @param driver
	 * @throws Throwable
	 */
	public FlipkartPOM(WebDriver driver) throws Throwable {
		// TODO Auto-generated constructor stub
		driver.get(file.getKeyPropertyvalue(PROP_PATH, "url2"));
		PageFactory.initElements(driver, this);
		this.driver = driver;
		common = new CommonLib(driver);
	}

	/**
	 * Search for product
	 * 
	 * @param sheetName
	 * @param row
	 * @param column
	 * @throws Throwable
	 */
	public void searchProduct(String sheetName, int row, int column) throws Throwable {

		common.waitForPageToLoad();
		closeBtn.click();
//		searchField.sendKeys(file.getCellData(sheetName,row,column));

		search.sendKeys("iPhone XR (64GB) - Yellow", Keys.ENTER);

	}
/**
 * getting price 
 * @return price
 * @throws Throwable
 */
	public int productPrice() throws Throwable {
		common.waitForPageToLoad();
		common.waitForElemnetToAppear(price);
		String priceValue = price.getText();
		int pricedata = common.removeSpecialChars(priceValue);
		return pricedata;
	
	}

}
