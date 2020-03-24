package com.volvo.gloria.Procurement;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.volvo.gloria.GenericLibrary.BaseClass;

import static io.restassured.RestAssured.given;

public class GetProcuredDetailsTest extends BaseClass{
    
/*    @BeforeClass
    public String Login1() throws Throwable {

        BaseClass.login(MCuserID);
        return sessionId;
    }*/

    /**
     * http://gloria-qa.got.volvo.net/GloriaUIServices/api/common/v1/qualitydocuments?_=1581333369386
     * 
     * @return qualitydocuments
     */
    @Test
    public void GetQualityDocumentsTest(){
        given().cookie(sessionId)
        .when().get("/GloriaUIServices/api/common/v1/qualitydocuments")
        .then().assertThat().statusCode(200);
    }
    
    
    /**
     * http://gloria-qa.got.volvo.net/GloriaUIServices/api/common/v1/dangerousgoods?_=1581333369385
     * 
     * @return dangerousgoods
     */
    
    @Test
    public void GetDangerousGoodsTest(){
        given().cookie(sessionId)
        .when().get("/GloriaUIServices/api/common/v1/dangerousgoods")
        .then().assertThat().statusCode(200);
    }
}
