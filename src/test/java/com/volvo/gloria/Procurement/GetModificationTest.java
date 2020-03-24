package com.volvo.gloria.Procurement;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.volvo.gloria.GenericLibrary.BaseClass;
import com.volvo.gloria.GenericLibrary.DataProviderClass;

public class GetModificationTest extends BaseClass{
    
/*    @BeforeClass
    public String Login1() throws Throwable {

        BaseClass.login(MCuserID);
        return sessionId;
    }*/
    
/**
 * http://gloria-qa.got.volvo.net/GloriaUIServices/api/procurement/v1/materials?
 * page=1&per_page=10&sort_by=id&order=asc&type=MATERIAL_CONTROL&assignedMaterialControllerId=TIN3000&
 * assignedMaterialControllerTeam=GOT&materialType=USAGE%2CUSAGE_REPLACED&procureLineStatus=WAIT_TO_PROCURE&_=1574317687114
 * 
 * Returns: Procure Lines which can be modified and which are modified
 */
    
    
    @Test(dataProvider = "TeamNames", dataProviderClass = DataProviderClass.class)
    public void GetUsageReplacedMaterialsTest(String teamName){
        given().cookie(sessionId)
        .param("page", "1").param("per_page", "10")
        .param("sort_by", "id")
        .param("order", "asc")
        .param("type", "MATERIAL_CONTROL")
        .param("procureLineStatus", "WAIT_TO_PROCURE")
        .param("assignedMaterialControllerId", MCuserID)
        .param("assignedMaterialControllerTeam", teamName)
        .param("materialType", "USAGE%2CUSAGE_REPLACED")
        .when().get("/GloriaUIServices/api/procurement/v1/materials")
        .then().assertThat().statusCode(200);
    }
}
