package com.volvo.gloria.Procurement;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.volvo.gloria.GenericLibrary.BaseClass;
import com.volvo.gloria.GenericLibrary.DataProviderClass;

public class GetOnBuildSiteTest extends BaseClass {

/*    @BeforeClass
    public String Login1() throws Throwable {

        BaseClass.login(MCuserID);
        return sessionId;
    }*/
    /**
     * http://gloria-qa.got.volvo.net/GloriaUIServices/api/procurement/v1/procurelines?
     * page=1&per_page=10&sort_by=requisitionFailed&order=desc&type=MATERIAL_CONTROL&
     * procureResponsibility=BUILDSITE&status=WAIT_TO_PROCURE&assignedMaterialControllerId=TIN3000&
     * assignedMaterialControllerTeam=GOT&_=1574317687148
     * 
     * Method - GET 
     */
    @Test(dataProvider = "TeamNames", dataProviderClass = DataProviderClass.class)
    public void GetBuildSiteProcurelinesTest(String teamName){
        
        given().cookie(sessionId)
        .param("page", "1").param("per_page", "10")
        .param("sort_by", "requisitionFailed")
        .param("order", "desc")
        .param("type", "MATERIAL_CONTROL")
        .param("procureResponsibility", "BUILDSITE")
        .param("status", "WAIT_TO_PROCURE")
        .param("assignedMaterialControllerId", MCuserID)
        .param("assignedMaterialControllerTeam", teamName)
        .when().get("/GloriaUIServices/api/procurement/v1/procurelines")
        .then().assertThat().statusCode(204);
    }
    
    /**
     * @GET
     * http://gloria-qa.got.volvo.net/GloriaUIServices/api/procurement/v1/partaffiliations?requestable=true&
     * 
     * @return 
     */
}
