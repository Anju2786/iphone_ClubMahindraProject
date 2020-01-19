package com.assignment.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assignment.generic.CommonLib;
import com.assignment.generic.FileLib;
import com.assignment.generic.IAutoconstant;
/**
 * 
 * @author Anju
 *
 */
public class TripAdvisorPage implements IAutoconstant {
	private WebDriver driver;
	FileLib filb=new FileLib();
    private CommonLib common;
    
    /* locating all the Elements*/
    
    @FindBy(xpath=("//span[@class='brand-global-nav-action-search-Search__label--3PRUD']")) private WebElement search;
    @FindBy(id = "mainSearch") private WebElement mainSearch;
    @FindBy (xpath=("(//div[@class='result-title'])[1]")) private WebElement hotel; 
    @FindBy (xpath=("//a[@class='ui_button primary']")) private WebElement writeReview;
    @FindBy (xpath=("//span[@id='bubble_rating']")) private WebElement overAllRating;
   // @FindBy (xpath=("//span[@data-value='5']")) private WebElement overAllRating;
    @FindBy (xpath=("//input[@id='ReviewTitle']")) private WebElement reviewTitle;
    @FindBy (xpath=(" //textarea[@id='ReviewText']")) private WebElement yourReview;
    @FindBy (xpath=(" (//div[@class='labelHeader'])[3]")) private WebElement hotelRating;
    @FindBy (xpath=(" (//span[@id='qid12_bubbles']")) private WebElement serviceRating;
    @FindBy (xpath=(" (//span[@id='qid11_bubbles']")) private WebElement roomsRating;
    @FindBy (xpath=(" //span[@id='qid190_bubbles']")) private WebElement sleepQuality;
    @FindBy (xpath=(" //div[@id='SUBMIT']")) private WebElement submit;
  
    /* initializing and launch the url*/
    
    public TripAdvisorPage(WebDriver driver) throws Throwable {
    	this.driver = driver;
		driver.get(filb.getKeyPropertyvalue(PROP_PATH, "url3"));
		PageFactory.initElements(driver, this);
		common = new CommonLib(driver);
	}
    
    
    
    /**
     * seach club mahindra
     * @throws Throwable
     */


	public void searchinTripAdvisor() throws Throwable
    {
    	search.click();
    	
    	
    	
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(mainSearch));
		mainSearch.sendKeys("Club Mahindra",Keys.ENTER);
		common.waitForPageToLoad();
	     hotel.click();
		
		
    }
    /**
     * passing review 
     * @throws Throwable  
     */
   
	public void searchForReview() throws Throwable {
		common.switchToChildWindow();
		common.waitForPageToLoad();
		
		Actions act=new Actions(driver);
		act.moveToElement(writeReview ).perform();
		
		
		writeReview.click();
		common.switchWindow();
		
		
		common.waitForPageToLoad();
		common.switchWindow(driver, "Write a review");
	 	common.waitForPageToLoad();
	
		act.moveToElement(overAllRating ).perform();
		overAllRating.click();
		reviewTitle.sendKeys("The rooms are large and ecofriendly");
		yourReview.sendKeys("Good hospitality");
		
		act.moveToElement(serviceRating ).perform();
		serviceRating.click();
		act.moveToElement(roomsRating).perform();
		roomsRating.click();
		act.moveToElement(sleepQuality).perform();
		sleepQuality.click();
		common.scroll(driver, submit);
		submit.click();
 }
	
	
	}
    

