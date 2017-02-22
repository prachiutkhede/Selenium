package com.poi.example.poiexample;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PoiExample {
	static FileInputStream fs = null;
	static XSSFWorkbook wb = null;
	static XSSFSheet sheet = null;
	static XSSFRow row = null;
	static XSSFCell col = null;

	public static void getCelldata(String xlsFileName) throws IOException {
		fs = new FileInputStream(xlsFileName);
		wb = new XSSFWorkbook(fs);
		sheet = wb.getSheet("register");

		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			row = sheet.getRow(i);
			short j = row.getLastCellNum();
			for (int k = 0; k < j; k++) {

				col = row.getCell(k);
				System.out.println(col.getStringCellValue());
			}
		}
	}

	public static void main(String[] args) throws IOException {
		String xlsfileName = "/Users/prachiutkhede/Documents/Poiexcelsheet.xlsx";
		PoiExample.getCelldata(xlsfileName);
	}
}
