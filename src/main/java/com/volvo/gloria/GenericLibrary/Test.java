package com.volvo.gloria.GenericLibrary;

import static io.restassured.RestAssured.given;

import java.util.regex.Matcher;

import org.codehaus.groovy.transform.EqualsAndHashCodeASTTransformation;
import org.testng.Assert;

import io.restassured.response.ValidatableResponse;

public class Test extends BaseClass {
    @org.testng.annotations.Test
    public void GetToProcureTeamsTest(String teamName) throws Throwable {
        ValidatableResponse resp = given().cookie(sessionId).param("type", "MATERIAL_CONTROL").param("userCategory", "MATERIAL_CONTROLLER").when()
                                          .get("/GloriaUIServices/api/user/v1/teams/" + teamName + "/users").then().assertThat().statusCode(200);
        /*
         * JsonPath body = CommonLibrary.rawToJSON(resp); ArrayList array[] = null;
         * 
         * 
         * for (int i = 0; i < array.length; i++) { String bosy1=body.get("id[0]"); System.out.println(bosy1); }
         */

    }

}
