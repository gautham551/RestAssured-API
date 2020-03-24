package com.volvo.gloria.GenericLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Properties;
import org.apache.poi.ss.usermodel.*;

import org.testng.annotations.DataProvider;



/**
 * Author - A238540
 */
public class FileLibrary {
    public static FileInputStream fis;
    public static Workbook wb;
    public static String propertyFilePath = "./Files/Environment.properties";
    public static String testScriptPath ="C:\\Gloria_Docs\\Gloria_Ref_Docs\\5_TestSet\\Gloria_API_Automation\\GloriaAPIAutomation\\Files\\testScriptData.xlsx";
    
    /**
     * This method is used to read the common data such as URL(HOST) from the properties file.
     * @param Key is the data which needs to be fetched from the property file, for eg. "HOST","USERID" etc.
     * @return Key value will be retured - For example "HOST" key will return http://gloria-qa.got.volvo.net.
     * @throws Throwable
     */
    public static String getPropertyFileData(String Key) throws Throwable{
        fis = new FileInputStream(propertyFilePath);
        Properties prop = new Properties();
        prop.load(fis);
        String data = prop.getProperty(Key);
        return data;
    }
    
    /**
     * This method will return you the column string value.
     * 
     * @param sheetName
     * @param rowNum
     * @param celNum
     * @return String Value
     * @throws Throwable
     */
    public static  String getTestScriptData(String sheetName, int rowNum, int celNum) throws Throwable {
       // File file = new File(testScriptPath);
        //ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(testScriptPath);
        fis = new FileInputStream(file);
        wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet(sheetName);
        Row row = sh.getRow(rowNum);
        Cell cel = row.getCell(celNum);
        String data = cel.getStringCellValue();
        return data;
    }
    
    public static Object[][] getExcelSheetData(String sheetName) throws Throwable{
        try {
            fis = new FileInputStream(testScriptPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            wb = WorkbookFactory.create(fis);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Sheet sh = wb.getSheet(sheetName);
        Object[][] data = new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
        
        for (int i = 0; i < sh.getLastRowNum(); i++) {
            for (int j = 0; j < sh.getRow(0).getLastCellNum(); j++) {
                data[i][j] = sh.getRow(i+1).getCell(j).toString();
                
            }
        }
        
        return data;
        
    }
    public static void main(String[] args) throws Throwable {
       
        //Object[][] data=FileLibrary.getExcelSheetData("Sheet1");
        
        //FileLibrary.getTestScriptData("Sheet1", 1, 1);
        
        
        Object[][] data = FileLibrary.getExcelSheetData("Sheet1");
        String op = data.toString();
        
       System.out.println(op);
       
       String lineSeparator = System.lineSeparator();
       StringBuilder sb = new StringBuilder();

       for (Object[] row : data) {
           sb.append(Arrays.toString(row))
             .append(lineSeparator);
       }

       String result = sb.toString();
       System.out.println(result);
    }
  
    
}
