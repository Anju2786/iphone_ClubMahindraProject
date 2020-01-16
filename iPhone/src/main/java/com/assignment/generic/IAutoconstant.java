package com.assignment.generic;

public interface IAutoconstant 
{
	String PROP_PATH="C:\\Users\\cools\\Documents\\TY\\Assignment\\iPhone\\data\\commonData.properties";
	String CHROME_KEY="webdriver.chrome.driver";
	String CHROME_VALUE="C:\\Users\\cools\\Documents\\TY\\Assignment\\iPhone\\chromedriver.exe";
	String FIREFOX_KEY="webdriver.gecko.driver";
	String FIREFOX_VALUE="C:\\Users\\cools\\Documents\\TY\\Assignment\\iPhone\\geckodriver.exe";
     String EXCEL_PATH=	"C:\\Users\\cools\\Documents\\TY\\Assignment\\iPhone\\data\\iphone.xlsx";
	
	
	long ITO = 10;		//Implicit TimeOut
	long ETO = 10;		//Explicit TimeOut
	long FTO = 10;		//Fluentwait TimeOut 
	long FPP = 200;		//Fluentwait Polling Period
	long TTO = 1000;	//Thread TimeOut
}
