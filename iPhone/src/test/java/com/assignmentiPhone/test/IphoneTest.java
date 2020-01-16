package com.assignmentiPhone.test;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.assignment.generic.BaseClass;
import com.assignment.pom.*;
/**
 * 
 * @author Anju
 *
 */
public class IphoneTest extends BaseClass {
	@Test
	
	public void seachTest() throws Throwable {
		/*Amazon*/
		AmazonPom amazon=new AmazonPom(driver);
		
		/*searching product*/
		amazon.searchProduct("Sheet1",1,0);
		
		/* getting price*/
		int amazonPrice=amazon.productPrice();
		//Reporter.log("amazon price:"+amazonPrice,true);
		
		
		/*Flipkart*/
		FlipkartPOM flipkart=new FlipkartPOM(driver);
		
		/*searching product*/
		flipkart.searchProduct("Sheet1", 1, 0);
		/* getting price*/
		int flipkartPrice = flipkart.productPrice();
		//Reporter.log("flipkartPrice:"+flipkartPrice ,true);
		
		/* comparison between amazon price and flipkart price*/
		if(amazonPrice > flipkartPrice) {
			Reporter.log("Flipkart has Lesser Price than Amazon", true);
			Reporter.log("price of flipkart: "+flipkartPrice ,true);
		}else if (amazonPrice < flipkartPrice) {
			Reporter.log("Amazon has Lesser Price than flipkart", true);
			Reporter.log("price of amazon : "+amazonPrice,true );
		}
			else
				Reporter.log("Both price are same"+amazonPrice,true );
		
		
	}
	

}
