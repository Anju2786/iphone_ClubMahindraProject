package com.assignment.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
/**
 * 
 * @author Anju
 *
 */

public class BaseClass implements IAutoconstant {

	public WebDriver driver;

	FileLib flib = new FileLib();
	private String sheet;
	private int row;

	/**
	 * Launch the selected browser
	 * 
	 * @throws Throwable
	 */
	@BeforeTest
	public void configBrowser() throws Throwable {
		
		/* get url and launch browser */
		System.setProperty(CHROME_KEY, CHROME_VALUE);

		String browser = flib.getKeyPropertyvalue(PROP_PATH, "browser");
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else {
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();

	}

	/* closing the browser*/
	@AfterTest
	public void browserClosing() {
		driver.quit();
	}
}
