package com.volvo.gloria.Procurement;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import org.testng.AssertJUnit;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.volvo.gloria.CreateMaterialRequest.CreateNewMaterialRequestTest;
import com.volvo.gloria.GenericLibrary.BaseClass;
import com.volvo.gloria.GenericLibrary.CommonLibrary;
import com.volvo.gloria.GenericLibrary.DataProviderClass;
import com.volvo.gloria.PayLoadsForPostRequests.ProcurementPayloads;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class ToProcurePageTest extends BaseClass {
    
    
    Logger log = Logger.getLogger(ToProcurePageTest.class);
    public static int financeHeaderId;
    public static String status;
    public static int ProcureLineID;
    public static int materialId;
    public static String mtrlRequestId;
    public static String partNumber;

    
/*    @BeforeClass
    public String Login1() throws Throwable {

        BaseClass.login("A238540");
        return sessionId;
    }*/
    /**
     * http://gloria-qa.got.volvo.net/GloriaUIServices/api/user/v1/teams/LYS/users?
     *  type=MATERIAL_CONTROL&userCategory=MATERIAL_CONTROLLER&_=1573729122341
     * 
     * @throws Throwable
     */
    @Test(dataProvider = "TeamNames", dataProviderClass = DataProviderClass.class)
    public void GetToProcureTeamsTest(String teamName) throws Throwable {
       String resp =  given().cookie(sessionId).param("type", "MATERIAL_CONTROL").param("userCategory", "MATERIAL_CONTROLLER").when()
               .get("/GloriaUIServices/api/user/v1/teams/" + teamName + "/users").then().assertThat().statusCode(anyOf(is(200),is(204))).extract().response().asString();
       
    
       AssertJUnit.assertEquals(resp.contains(MCuserID), true);
    }

    /**
     * http://gloria-qa.got.volvo.net/GloriaUIServices/api/user/v1/flags? userId=TIN3000&type=MATERIAL_CONTROL&assignedTeam=GOT&_=1573729122354 *
     * 
     * @throws Throwable
     */
    @Test(dataProvider = "TeamNames", dataProviderClass = DataProviderClass.class)
    public void GetToProcureFlagsTest(String teamName) throws Throwable {

        given().cookie(sessionId).param("userId", MCuserID).param("type", "MATERIAL_CONTROL").param("assignedTeam", "LYS").when()
               .get("/GloriaUIServices/api/user/v1/flags").then().assertThat().statusCode(200);
    }
    /**
     * http://gloria-qa.got.volvo.net/GloriaUIServices/api/procurement/v1/procurelines?page=1&per_page=10&sort_by=orderCancelled&
     * order=desc&type=MATERIAL_CONTROL&procureResponsibility=PROCURER&status=WAIT_TO_PROCURE&assignedMaterialControllerId=TIN3000&
     * assignedMaterialControllerTeam=GOT&_=1573729122355
     */
    @Test(dataProvider = "TeamNames", dataProviderClass = DataProviderClass.class)
    public void GetToProcureProcureLinesTest(String teamName){
        given().cookie(sessionId)
        .param("page", "1").param("per_page", "10")
        .param("sort_by", "orderCancelled")
        .param("order", "desc")
        .param("type", "MATERIAL_CONTROL")
        .param("procureResponsibility", "PROCURER")
        .param("status", "WAIT_TO_PROCURE")
        .param("assignedMaterialControllerId", MCuserID)
        .param("assignedMaterialControllerTeam", teamName)
        .when().get("/GloriaUIServices/api/procurement/v1/procurelines")
        .then().assertThat().statusCode(anyOf(is(200),is(204)));
    }
    
    /**
     * http://gloria-qa.got.volvo.net/GloriaUIServices/api/procurement/v1/flags/tableHeader?
     * userId=TIN3000&type=MATERIAL_CONTROL&assignedTeam=GOT&_=1573729122353
     */
    @Test(dataProvider = "TeamNames", dataProviderClass = DataProviderClass.class)
    public void GetToProcureTableHeaderTest(String teamName){
        given().cookie(sessionId)
        .param("type", "MATERIAL_CONTROL")
        .param("userId", MCuserID)
        .param("assignedTeam", teamName)
        .when().get("/GloriaUIServices/api/procurement/v1/flags/tableHeader")
        .then().assertThat().statusCode(anyOf(is(200),is(204)));
        
    }
    
    /**
     * This method will search the procure line and capture the procurelineID in "To Procure tab" with the help of MTR ID created.
     * @throws InterruptedException 
     * 
     * @Request URL - http://gloria-qa.got.volvo.net/GloriaUIServices/api/procurement/v1/procurelines?
     * page=1&per_page=10&total_pages=248&total_entries=2480&sort_by=orderCancelled&order=desc&type=MATERIAL_CONTROL
     * &procureResponsibility=PROCURER&status=WAIT_TO_PROCURE&assignedMaterialControllerId=TIN3000
     * &assignedMaterialControllerTeam=LYS&changeRequestIds=*S48927V1&_=1582870688967
     */
    
    @Test
    public void GETProcureLinewithMTRID() throws InterruptedException{
        Thread.sleep(2000);
        ValidatableResponse response = given().cookie(sessionId)
                .param("page", "1")
                .param("per_page", "10")
                .param("sort_by", "orderCancelled")
                .param("order", "desc")
                .param("type", "MATERIAL_CONTROL")
                .param("procureResponsibility", "PROCURER")
                .param("status", "WAIT_TO_PROCURE")
                .param("assignedMaterialControllerId", MCuserID)
                .param("assignedMaterialControllerTeam", Team)
                .param("changeRequestIds", CreateNewMaterialRequestTest.MTRID)
                .when().get("/GloriaUIServices/api/procurement/v1/procurelines").then().assertThat().statusCode(200);
        
        String resp = response.extract().asString();
        JsonPath json = CommonLibrary.rawToJSON(resp);
        ProcureLineID = json.get("[0].id");
        financeHeaderId = json.get("[0].financeHeaderId");
        status = json.get("[0].status");
        
        System.out.println(ProcureLineID);
        System.out.println(resp);
        System.out.println(json.get());
        log.info(resp);
        
    }
    
    @Test(dependsOnMethods= {"GETProcureLinewithMTRID"})
    public void GETMaterialfromProcurelinesTest(){
        ValidatableResponse response = given().cookie(sessionId)
                .when().get("/GloriaUIServices/api/procurement/v1/procurelines/"+ProcureLineID+"/materials").then().assertThat().statusCode(200);
        String resp = response.extract().asString();
        JsonPath json = CommonLibrary.rawToJSON(resp);
        materialId = json.get("[0].id");
        mtrlRequestId = json.get("[0].mtrlRequestId");
        partNumber = json.get("[0].partNumber");
        System.out.println(partNumber);
        
        
        System.out.println(materialId);
    }
    
    /**
     * This method will post the material information linked to the procure line. This API is executed on clicking Procure button
     * @RequestURL- http://gloria-qa.got.volvo.net/GloriaUIServices/api/procurement/v1/procurelines/460171/materials/748932
     */
    @Test(dependsOnMethods= {"GETMaterialfromProcurelinesTest"})
    public void POSTMaterialfromProcurelinesTest(){
        System.out.println("entered class ");
        
        
        System.out.println(ProcureLineID+"PROCURE");
        System.out.println("MID = "+materialId);
        ValidatableResponse response = given().cookie(sessionId)
                .header("Content-Type","application/json")
                .body(ProcurementPayloads.POSTMaterialfromProcurelinesPayload())
                .when().put("/GloriaUIServices/api/procurement/v1/procurelines/"+ProcureLineID+"/materials/"+materialId+"").then()
                .assertThat().statusCode(200);
                
                String resp = response.extract().asString();
                JsonPath json = CommonLibrary.rawToJSON(resp);
                
    }
    /**
     * 
     * @RequestURL- http://gloria-qa.got.volvo.net/GloriaUIServices/api/procurement/v1/procurelines/460171?&action=procure
     */
    @Test(dependsOnMethods= {"POSTMaterialfromProcurelinesTest"})
    public void POSTProcurementTest(){
        
        ValidatableResponse response = given().cookie(sessionId)
                .header("Content-Type","application/json")
                .queryParam("action", "procure")
                .body(ProcurementPayloads.POSTProcurementPayload())
                .when().put("/GloriaUIServices/api/procurement/v1/procurelines/"+ProcureLineID+"").then()
                .assertThat().statusCode(200);
                
                String resp = response.extract().asString();
                JsonPath json = CommonLibrary.rawToJSON(resp);
                
    }

}
