package com.volvo.gloria.Procurement;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.volvo.gloria.GenericLibrary.BaseClass;
import com.volvo.gloria.GenericLibrary.DataProviderClass;

import io.restassured.response.Response;

public class GetChangeTest extends BaseClass {
    
    
/*    @BeforeClass
    public String Login1() throws Throwable {

        BaseClass.login(MCuserID);
        return sessionId;
    }*/
    /**
     *   http://gloria-qa.got.volvo.net/GloriaUIServices/api/procurement/v1/changeids?
     *   page=1&per_page=10&sort_by=id&order=asc&status=WAIT_CONFIRM%2CCANCEL_WAIT&assignedMaterialControllerTeam=AGEO&_=1578563588072
     */
      
      @Test(dataProvider = "TeamNames", dataProviderClass = DataProviderClass.class)
      public void GetChangeProcurementTest(String teamName){
          given().cookie(sessionId)
          .param("page", "1").param("per_page", "10")
          .param("sort_by", "id")
          .param("order", "asc")
          .param("status", "WAIT_CONFIRM%2CCANCEL_WAIT")
          .param("assignedMaterialControllerTeam", teamName)
          .when().get("/GloriaUIServices/api/procurement/v1/changeids")
          .then().assertThat().statusCode(200);
      }
}
