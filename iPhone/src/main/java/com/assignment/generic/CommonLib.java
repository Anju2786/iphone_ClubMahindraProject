package com.assignment.generic;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author Anju
 *
 */

public class CommonLib implements IAutoconstant{
	
	private WebDriver driver;
	private JavascriptExecutor jse;
	private FluentWait<WebDriver> fwait;
	
	
	public CommonLib(WebDriver driver) {
		this.driver=driver;
		this.jse = (JavascriptExecutor)driver;
	}
	
	public Object runScript(String script) {
		return jse.executeScript(script);
	}
	/**
	 * wait for page to load
	 */
	public void waitForPageToLoad(){
		fwait = new FluentWait<WebDriver>(driver)
				.pollingEvery(Duration.ofMillis(FPP))
				.withTimeout(Duration.ofSeconds(FTO))
				.ignoring(NoSuchElementException.class);

		fwait.until(new ExpectedCondition<Boolean>(){
			public Boolean apply(WebDriver input) {
				String state = (String) runScript("return document.readyState");
				if(state.equals("complete")) {
					return true;
				}
				return false;
			}
		});
	}
	
	/**
	 * Wait for element to be displayed on GUI
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitForElemnetToAppear(WebElement element) throws InterruptedException {
		int timeCount =0;
		while(timeCount<20) {
			try {
				element.isDisplayed();
				break;
			}catch (Exception e) {
				Thread.sleep(FPP);
				timeCount++;
			}
		}
	}

	/**
	 * converting to integer by removing Alphabets, specialCharacters
	 * @param Str
	 * @return int
	 */
	public int removeSpecialChars(String Str) {
		char[] split = Str.toCharArray();
		String s = "";
		for (int i = 0; i < split.length; i++) {
			if(Character.isDigit(split[i])) {
				s = s + split[i];
			}
		}
		return Integer.parseInt(s);
		
	}
/**
 * Scroll down
 * @param driver
 * @param element
 */
	public void scroll(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	
	
	
	private String parentId;
	private String childId; 
	private Set<String> windows;
	
	/**
	 * Obtains the parent and the child window handles
	 * @param string 
	 * @param driver2 
	 * @return Set of window handles
	 */
	public Set<String> switchWindow() {
		windows = driver.getWindowHandles();
		Iterator<String> window = windows.iterator();
		parentId = window.next();
		childId = window.next();
		return windows;
	}
	public void switchWindow(WebDriver driver, String title)
	{
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator() ;
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			if(driver.getTitle().contains(title))
			{
				break;
			}
		}
	}
	/**
	 * Switches to the child window
	 */
	public void switchToChildWindow() {
		switchWindow();
		driver.switchTo().window(childId);
	}
	
	
}

