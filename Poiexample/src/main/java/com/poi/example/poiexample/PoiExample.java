package com.poi.example.poiexample;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PoiExample {
    private FileInputStream fs = null;
    private XSSFWorkbook wb = null;
    private XSSFSheet sheet = null;

    public PoiExample(String fileName) throws IOException {
        fs = new FileInputStream(fileName);
        wb = new XSSFWorkbook(fs);
        sheet = wb.getSheet("register");      
    }
    
    public String getCelldata(int rowIndex, int columnIndex) throws IOException {
        // Check if the rowIndex is valid.
        if(rowIndex < 0 || rowIndex > sheet.getLastRowNum()) return null;
        
        // Get the row corresponding to the row index.
        XSSFRow row = sheet.getRow(rowIndex);
        
        // Check if column index is valid.
        if(columnIndex < 0 || columnIndex > row.getLastCellNum()) return null;

        // Get the column corresponding to the row.
        XSSFCell col = row.getCell(columnIndex);

        return col.getStringCellValue();
    }
    
    public void printSheet() {
        XSSFRow row;
        XSSFCell col;
        
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
            short j = row.getLastCellNum();
            for (int k = 0; k < j; k++) {
                col = row.getCell(k);
                System.out.print(String.format("%15s", col.getStringCellValue()));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        String xlsfileName = "/Users/prachiutkhede/git/Selenium/Poiexample/src/main/resources/Poiexcelsheet.xlsx";
        
        PoiExample poiExample = new PoiExample(xlsfileName);
        poiExample.printSheet();
        
        System.out.println("\nRow 0 Col 0: " + poiExample.getCelldata(1, 0));
    }
}