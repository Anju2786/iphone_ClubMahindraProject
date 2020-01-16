package com.assignmentiPhone.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.assignment.generic.BaseClass;
import com.assignment.pom.TripAdvisorPage;
/**
 * 
 * @author Anju
 *
 */
public class TripAdviserReviewTest extends BaseClass {
	@Test
	
	public void reviewHotel() throws Throwable {
/* creating an object for tripadvisor pom class*/
	TripAdvisorPage review=new TripAdvisorPage(driver);
	/*searching Club Mahindra */
	review.searchinTripAdvisor();
	/* review*/
	review.searchForReview();
	
}
}