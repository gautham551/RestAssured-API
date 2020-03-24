package com.volvo.gloria.Procurement;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.volvo.gloria.GenericLibrary.BaseClass;
import com.volvo.gloria.GenericLibrary.DataProviderClass;

public class GetProcuredTest extends BaseClass {
    
/*    @BeforeClass
    public String Login1() throws Throwable {

        BaseClass.login(MCuserID);
        return sessionId;
    }*/
/**
 * http://gloria-qa.got.volvo.net/GloriaUIServices/api/procurement/v1/procurelines?
 * page=1&per_page=10&sort_by=requisitionFailed&order=desc&type=MATERIAL_CONTROL&
 * procureResponsibility=PROCURER%2CBUILDSITE&status=PROCURED%2CPLACED%2CRECEIVED_PARTLY%2CRECEIVED%2CFAILED&
 * assignedMaterialControllerId=A238540&assignedMaterialControllerTeam=GOT&_=1581333369380
 * 
 * Returns List of Procured lines
 */
    
    
   @Test(dataProvider = "TeamNames", dataProviderClass = DataProviderClass.class)
   public void GetProcuredLinesTest(String teamName){
       given().cookie(sessionId)
       .param("page", "1").param("per_page", "10")
       .param("sort_by", "requisitionFailed")
       .param("order", "desc")
       .param("type", "MATERIAL_CONTROL")
       .param("procureResponsibility", "PROCURER%2CBUILDSITE")
       .param("status", "PROCURED%2CPLACED%2CRECEIVED_PARTLY%2CRECEIVED%2CFAILED")
       .param("assignedMaterialControllerId", MCuserID)
       .param("assignedMaterialControllerTeam", teamName)
       .param("materialType", "USAGE%2CUSAGE_REPLACED")
       .when().get("/GloriaUIServices/api/procurement/v1/procurelines")
       .then().assertThat().statusCode(anyOf(is(200),is(204)));
       
   }
}
