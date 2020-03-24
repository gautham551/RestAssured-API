package com.volvo.gloria.Procurement;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.volvo.gloria.GenericLibrary.BaseClass;
import com.volvo.gloria.GenericLibrary.DataProviderClass;

public class GetExceptionTest extends BaseClass {
    
/*    @BeforeClass
    public String Login1() throws Throwable {

        BaseClass.login(MCuserID);
        return sessionId;
    }*/

    /**
     * http://gloria-qa.got.volvo.net/GloriaUIServices/api/procurement/v1/materiallines?
     * page=1&per_page=10&sort_by=orderNo%2CpPartNumber%2CpPartVersion&order=desc&type=MATERIAL_CONTROL
     * &assignedMaterialControllerId=A238540&assignedMaterialControllerTeam=LYS&moduleName=exception
     * &_=1581416959377
     * 
     * @return Exception tab material lines
     */
    
    @Test(dataProvider = "TeamNames", dataProviderClass = DataProviderClass.class)
    public void GetUsageReplacedMaterialsTest(String teamName){
        given().cookie(sessionId)
        .param("page", "1").param("per_page", "10")
        .param("sort_by", "orderNo%2CpPartNumber%2CpPartVersion")
        .param("order", "desc")
        .param("type", "MATERIAL_CONTROL")
        .param("procureLineStatus", "WAIT_TO_PROCURE")
        .param("assignedMaterialControllerId", MCuserID)
        .param("assignedMaterialControllerTeam", teamName)
        .param("moduleName", "exception")
        .when().get("/GloriaUIServices/api/procurement/v1/materials")
        .then().assertThat().statusCode(200);
    }
}
