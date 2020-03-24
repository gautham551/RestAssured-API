package com.volvo.gloria.CreateMaterialRequest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import com.volvo.gloria.GenericLibrary.BaseClass;

/**
 * Test Material Request Page with API -
 * http://gloria-qa.got.volvo.net/GloriaUIServices/api/materialrequest/v1/materialrequests/current?page=1&per_page=10&sort_by=materialRequestVersionStatusDate&
 * order=desc&requesterId=TIN3000&userId=TIN3000&_=1573221731144
 */
public class MaterialRequestPageTest extends BaseClass {
    Logger log = Logger.getLogger(MaterialRequestPageTest.class);

/*    @BeforeClass
    public String Login1() throws Throwable {

        BaseClass.login(MCuserID);
        return sessionId;
    }*/

    /**
     * APIs tested
     */
    @Test
    public void GetMaterialRequestPageTest() {
        given().cookie(sessionId).param("_", "1567685771946").param("page", "1").param("per_page", "10").param("sort_by", "materialRequestVersionStatusDate")
               .param("order", "desc").param("userId", "A238540").when().get("/GloriaUIServices/api/materialrequest/v1/materialrequests/current").then()
               .assertThat().statusCode(200).extract().response();

    }
}
