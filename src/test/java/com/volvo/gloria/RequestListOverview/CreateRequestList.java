package com.volvo.gloria.RequestListOverview;

import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.logging.LogManager;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.volvo.gloria.GenericLibrary.BaseClass;
import com.volvo.gloria.GenericLibrary.CommonLibrary;
import com.volvo.gloria.MaterialOverview.MaterialOverviewTest;
import com.volvo.gloria.resources.ExtentReporterNG;
import org.hamcrest.Matchers;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

public class CreateRequestList extends BaseClass {
Logger log = Logger.getLogger(CreateRequestList.class);
    static String status;
    String shipperName;
    String shipFromName;
    @BeforeTest
    public String LoginMC() throws Throwable {

        BaseClass.login(WHuserID);
        return sessionId;
    }
    /**
     * @RequestURL- http://gloria-qa.got.volvo.net/GloriaUIServices/api/procurement/v1/requestlists/materiallines/1944218
     */
    @Test
    public void GETMaterialLineTest() {
        log.info("Initated test case GETMaterialLine" );
       /* ValidatableResponse response = given().cookie(sessionId).when().get("/GloriaUIServices/api/procurement/v1/requestlists/materiallines/"
                + MaterialOverviewTest.materialLineID + "").then().assertThat().statusCode(200);*/
         ValidatableResponse response = given().cookie(sessionId).when().get("/GloriaUIServices/api/procurement/v1/requestlists/materiallines/1944218").then().assertThat().statusCode(200);
        String resp = response.extract().asString();
        JsonPath json = CommonLibrary.rawToJSON(resp);
        status = json.get("[0].status");
        log.info("The status of the material line created is "+status+"");
        System.out.println(status);

    }

    /**
     * @RequestURL- http://gloria-qa.got.volvo.net/GloriaUIServices/api/material/v1/deliveryInformation?shipper=8374&shipFrom=8374&_=1583391735396
     */
    @Test
    public void GETDeliveryInformationTest() {

        ValidatableResponse response = given().cookie(sessionId).param("shipper", "8374").param("shipFrom", "8374").when()
                                              .get("/GloriaUIServices/api/material/v1/deliveryInformation").then().assertThat().statusCode(200);

        String resp = response.extract().asString();
        JsonPath json = CommonLibrary.rawToJSON(resp);
        shipperName = json.get("shipperName");
        shipFromName = json.get("shipFromName");
        System.out.println(shipperName);
        SoftAssert asrt = new SoftAssert();
        asrt.assertEquals(shipperName, "UD Truck Corporation");

    }
/**
 * This test is executed to check if we can create request list for the material lines with status.equals("ORDER_PLACED_INTERNAL") || status.equals("READY_TO_STORE") || status.equals("STORED") 
 * --API triggered when Create Request Button in Application is cicked.
 * 
 * @RequestURI- http://gloria-qa.got.volvo.net/GloriaUIServices/api/procurement/v1/requestlists/materiallines/1944218?_=1583407505595
 */
    @Test
    public void GETCreateRequestList() {
        if (status.equals("ORDER_PLACED_INTERNAL") || status.equals("READY_TO_STORE") || status.equals("STORED")) {
            given().cookie(sessionId).when().get("/GloriaUIServices/api/procurement/v1/requestlists/materiallines/" + MaterialOverviewTest.materialLineID + "")
                   .then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().body("[0].status",Matchers.contains("ORDER_PLACED_INTERNAL","READY_TO_STORE"));
            System.out.println("wwwww");
                }
    }
    
    /**
     * 
     * @RequestURL- http://gloria-qa.got.volvo.net/GloriaUIServices/api/user/v1/users/A238540/roles?_=1583468878159
     */
    @Test
  
    public void GETRoles(){
        logger = report.createTest("Gettiing Roles for creating Request List");
        ValidatableResponse response = given().cookie(sessionId).when().get("/GloriaUIServices/api/user/v1/users/"+MCuserID+"/roles")
        .then().assertThat().statusCode(200);
        
        String resp = response.extract().asString();
        JsonPath json = CommonLibrary.rawToJSON(resp);
        //List<String> s = json.getList(resp);
        
        int array = json.get("array.size()");
        String roleName = json.get("[0].roleName");
        logger.pass("pass");
        
        
        for (int i = 0; i < array; i++) {
            String roleName1 = json.get("["+i+"].roleName");
            if (roleName1.equals("REQUESTER_FOR_PULL")) {
                System.out.println("Pass");
                break;
            }
            else{
                System.out.println("Fail");
            }
        }
        
    }
    
    /**
     * 
     * 
     * 
     */
    @Test
    public void POSTSendRequestList(){
        
        
    }
}
