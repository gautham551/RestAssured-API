package com.volvo.gloria.MaterialOverview;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.volvo.gloria.CreateMaterialRequest.CreateNewMaterialRequestTest;
import com.volvo.gloria.GenericLibrary.BaseClass;
import com.volvo.gloria.GenericLibrary.CommonLibrary;
import com.volvo.gloria.PayLoadsForPostRequests.CreateMaterialRequestPayloads;
import com.volvo.gloria.PayLoadsForPostRequests.ProcurementPayloads;
import com.volvo.gloria.Procurement.GetProcureDetailsTest;
import com.volvo.gloria.Procurement.ToProcurePageTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

/**
 * This class
 */
public class MaterialOverviewTest extends BaseClass
{
    public static int materialLineID;
    /**
     * This method will search for the material created and test if all the details are correct.
     * 
     * @RequestURL:- http://gloria-qa.got.volvo.net/GloriaUIServices/api/procurement/v1/materiallines?
     * page=1&per_page=10&total_pages=0&total_entries=0&sort_by=orderNo%2CpPartNumber%2CpPartVersion&
     * order=desc&type=MATERIAL_CONTROL&userId=A238540&mtrlRequestVersion=*S49102V1&procureUserId=A238540&
     * 
     */
    @Test
    public void GETMaterialOverviewMTRIDSearch()
    {
        ValidatableResponse response = given().cookie(sessionId)
        .param("type", "MATERIAL_CONTROL")
        .param("mtrlRequestVersion", "S49102V1")
        .param("userId", MCuserID)
        .param("page", "1")
        .param("per_page", "10")
        .param("sort_by", "orderNo%2CpPartNumber%2CpPartVersion")
        .param("total_pages", "0")
        .param("total_entries", "0")
        .when().get("/GloriaUIServices/api/procurement/v1/materiallines").then().assertThat().statusCode(200);
        
        String resp = response.extract().asString();
        JsonPath json = CommonLibrary.rawToJSON(resp);
        materialLineID = json.get("[0].id");
        String mtrID = json.get("[0].changeRequestIds");
        String status = json.get("[0].status");
        System.out.println(materialLineID+", "+mtrID+", "+status);
    }
}
