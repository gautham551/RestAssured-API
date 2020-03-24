package com.volvo.gloria.CreateMaterialRequest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

import com.volvo.gloria.GenericLibrary.BaseClass;

/**
 * Test APIs for Create Material Request screen.
 */
public class MaterialRequestOverviewPageTest extends BaseClass {
    Logger log = Logger.getLogger(MaterialRequestOverviewPageTest.class);

/*    @BeforeClass
    public String Login1() throws Throwable {

        BaseClass.login(MCuserID);
        return sessionId;
    }*/

    /**
     * API to fetch Material Request lines
     */
    @Test
    public void GetMaterialRequestLinesTest() {
        given().cookie(sessionId).param("page", "1").param("per_page", "100").param("sort_by", "materialRequestVersionStatusDate")
               .param("order", "desc").param("requesterId", "TIN3000").param("userId", "A238540").when()
               .get("/GloriaUIServices/api/materialrequest/v1/materialrequests/current").then().assertThat().statusCode(200).time(lessThan(4000L));
        // JsonPath JP = new JsonPath(resp1);
        // System.out.println(JP);
    }

    /**
     * API to fetch Material Request procure team members
     */

    @Test
    public void GetMaterialRequestTeamMembers() {
        given().cookie(sessionId).when().get("/GloriaUIServices/api/user/v1/users/A238540/procureteammembers").then().assertThat().statusCode(200)
               .time(lessThan(4000L)).extract().response().asString();

    }
}
