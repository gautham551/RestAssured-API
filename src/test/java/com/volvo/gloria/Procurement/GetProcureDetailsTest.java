package com.volvo.gloria.Procurement;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import org.jsoup.select.Evaluator.ContainsText;
import org.testng.annotations.Test;

import com.volvo.gloria.GenericLibrary.BaseClass;
import com.volvo.gloria.GenericLibrary.CommonLibrary;
import com.volvo.gloria.GenericLibrary.DataProviderClass;
import com.volvo.gloria.PayLoadsForPostRequests.ProcurementPayloads;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class GetProcureDetailsTest extends BaseClass{

/*    @BeforeClass
    public String Login1() throws Throwable {

        BaseClass.login(MCuserID);
        return sessionId;
    }
*/
/**
 * http://gloria-qa.got.volvo.net/GloriaUIServices/api/common/v1/suppliercounterparts?companyCode=SE04&_=1573729122420
 * 
 * @param CompanyCode
 * @return suppliercounterparts
 */
    @Test(dataProvider = "CompanyCodes", dataProviderClass = DataProviderClass.class)
    public void GetProcureDetailsSupplierCounterPartsTest(String CompanyCode){
        given().cookie(sessionId)
        .param("companyCode", CompanyCode)
        .when().get("/GloriaUIServices/api/common/v1/suppliercounterparts").then().assertThat().statusCode(200);
       
    }
    
    /**
     * http://gloria-qa.got.volvo.net/GloriaUIServices/api/common/v1/companycodes?
     * type=MATERIAL_CONTROL&ignoreDisableRequests=true&userId=A238540&page=1&per_page=15&code=*SE04&_=1573729122422
     * @param CompanyCode
     * @return companycodes
     */
    @Test(dataProvider = "CompanyCodes", dataProviderClass = DataProviderClass.class)
    public void GetProcureDetailsCompanyCodeTest(String CompanyCode){
        given().cookie(sessionId)
        .param("type", "MATERIAL_CONTROL")
        .param("ignoreDisableRequests", "true")
        .param("userId", MCuserID)
        .param("page", "1")
        .param("per_page", "15")
        .param("code", CompanyCode)
        .when().get("/GloriaUIServices/api/common/v1/companycodes").then().assertThat().statusCode(200);
        
    }
    
    /**
     * http://gloria-qa.got.volvo.net/GloriaUIServices/api/common/v1/glaccounts?
     * page=1&per_page=15&sipdGlaccounts=no&companyCode=SE04&accountName=*401301&_=1573729122423
     * @param CompanyCode
     * @return glaccounts
     */
    @Test(dataProvider = "CompanyCodes", dataProviderClass = DataProviderClass.class)
    public void GetProcureDetailsGLAccountsTest(String CompanyCode){
        Response resp = given().cookie(sessionId)
        .param("page", "1")
        .param("per_page", "15")
        .param("sipdGlaccounts", "no")
        .param("companyCode", CompanyCode)
        .param("accountName", "*401301")
        .when().get("/GloriaUIServices/api/common/v1/glaccounts").then().assertThat().statusCode(200).extract().response();
        
    }
    
    /**
     * 
     * http://gloria-qa.got.volvo.net/GloriaUIServices/api/common/v1/wbselements?
     * page=1&per_page=15&companyCode=SE04&projectId=AE0910074&wbs=*EPG10-12576-01-01&_=1573729122424
     * @param CompanyCode
     * @return wbselements
     */
    //Need to remove and update the hard coded wbs values
    @Test(dataProvider = "CompanyCodes", dataProviderClass = DataProviderClass.class)
    public void GetProcureDetailsWBSElementsTest(String CompanyCode){
        given().cookie(sessionId)
        .param("page", "1")
        .param("per_page", "15")
        .param("companyCode", CompanyCode)
        .param("projectId", "AE0910074")
        .param("wbs", "*EPG10-12576-01-01")
        .when().get("/GloriaUIServices/api/common/v1/wbselements").then().assertThat().statusCode(200);
        
    }
    
    /**
     * http://gloria-qa.got.volvo.net/GloriaUIServices/api/common/v1/costcenters?
     * page=1&per_page=15&companyCode=SE04&costCenter=*0000055560&_=1573729122425
     * @param CompanyCode
     */
    @Test(dataProvider = "CompanyCodes", dataProviderClass = DataProviderClass.class)
    public void GetProcureDetailsCostCentersTest(String CompanyCode){
        given().cookie(sessionId)
        .param("page", "1")
        .param("per_page", "15")
        .param("companyCode", CompanyCode)
        .param("costCenter", "*0000055560")
        .when().get("/GloriaUIServices/api/common/v1/costcenters").then().assertThat().statusCode(200);
        
    }
    
    /**
     * http://gloria-qa.got.volvo.net/GloriaUIServices/api/procurement/v1/purchaseorganization?_=1573729122426
     */
    @Test
    public void GetProcureDetailsPurchaseOrgTest(){
        given().cookie(sessionId)
        .when().get("/GloriaUIServices/api/procurement/v1/purchaseorganization").then().assertThat().statusCode(200);   
        
    }
    
    /**
     * http://gloria-qa.got.volvo.net/GloriaUIServices/api/warehouse/v1/warehouses?_=1573729122430
     */
    @Test
    public void GetProcureDetailsWarehousesTest(){
        given().cookie(sessionId)
        .when().get("/GloriaUIServices/api/warehouse/v1/warehouses").then().assertThat().statusCode(200); 
        
    }
    
    /**
     * http://gloria-qa.got.volvo.net/GloriaUIServices/api/common/v1/currency?page=1&per_page=15&currency=&_=1574317687077
     */
    @Test
    public void GetCurrencyTest(){
        given().cookie(sessionId)
        .param("page", "1")
        .param("per_page", "15")
        .param("currency", "")
        .when().get("/GloriaUIServices/api/common/v1/currency").then().assertThat().statusCode(200);
        
    }
    
    /**
     * http://gloria-qa.got.volvo.net/GloriaUIServices/api/procurement/v1/currentbuyer?
     * materialUserId=1090&partNumber=84441759&partAffiliation=X&_=1574317687076
     */
    @Test
    public void GetCurrentBuyer(){
        given().cookie(sessionId)
        .param("materialUserId", "1090")
        .param("partNumber", "22634858")
        .param("partAffiliation", "V")
        .when().get("/GloriaUIServices/api/procurement/v1/currentbuyer").then().assertThat().statusCode(200);
        
    }
    
    /**
     * http://gloria-qa.got.volvo.net/GloriaUIServices/api/procurement/v1/internalordernosap?
     * page=1&per_page=15&code=&_=1574317687079
     */
    @Test
    public void GetInternalOrderSAPTest(){
        given().cookie(sessionId)
        .param("page", "1")
        .param("per_page", "15")
        .param("code", "")
        .when().get("/GloriaUIServices/api/procurement/v1/internalordernosap").then().assertThat().statusCode(200);
        
    }
    
    /**
     * This method will fetch the procure details of the material request created through procure line ID.
     * 
     * @RequestURL- http://gloria-qa.got.volvo.net/GloriaUIServices/api/procurement/v1/procurelines/{ProcureLineOID}
     */
    @Test
    public void GETProcureLineDetailsTest(){
        System.out.println(ToProcurePageTest.ProcureLineID);
        ValidatableResponse response = given().cookie(sessionId)
        .when().get("/GloriaUIServices/api/procurement/v1/procurelines/459847").then().assertThat().statusCode(200);
        
        String resp = response.extract().asString();
        JsonPath json = CommonLibrary.rawToJSON(resp);
        String ProcureLineOID = json.get("id");
        System.out.println(ProcureLineOID);
        
    }
    

    
  
}
