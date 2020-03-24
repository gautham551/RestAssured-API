package com.volvo.gloria.GenericLibrary;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {

    @DataProvider(name = "TeamNames")
    public Object[] getTeamNames() {
        return new Object[] { "AGEO","BLR","BRIS","CUR","GOT","GOT_PE","GOT_VE","GSO","HAG","LYS"};
    }

    @DataProvider(name = "CompanyCodes")
    public static Object[] getCompanyCodes() {
        return new Object[] { "FR46", "IN01", "BR03", "US10", "US45", "JP40", "SE26", "SE27", "SE04", "AU04" };
    }
    @DataProvider(name = "CompanyCodes and TeamNames")
    public Object[][] getCompanyCode() throws Throwable{
        FileLibrary fileLibrary = new FileLibrary();
        Object[][] data = fileLibrary.getExcelSheetData("Sheet1");
        return data;
    }
   
    @DataProvider(name = "Warehouse")
    public Object[] getWarehouse() throws Throwable{
        return new Object[] { "34331","36012","40382","8374","1620","34347","42102","47670","45907","2919","4042","47941","664","1722","37837" };
        }
    }
   
    

