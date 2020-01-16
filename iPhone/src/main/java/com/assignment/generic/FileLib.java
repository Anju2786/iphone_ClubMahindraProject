package com.assignment.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author Anju
 *
 */
public class FileLib implements IAutoconstant {
	private String sheet;
/**
 * enter the url
 * @param proppPath
 * @param key
 * @return
 * @throws Throwable
 */
	public String getKeyPropertyvalue(String proppPath, String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(proppPath);
		Properties pc=new Properties();
		pc.load(fis);
		String excelData=pc.getProperty(key,"not present");
		return excelData;
		
	}
	/**
	 * getting data from excel
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws Throwable
	 */
	public String getCellData (String sheet,int row, int cell) throws Throwable 
	{
		FileInputStream fis=new FileInputStream(EXCEL_PATH);
		Workbook wb= WorkbookFactory.create(fis);
		String excelvalue=wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		wb.close();
		return excelvalue;
	}
	
}
