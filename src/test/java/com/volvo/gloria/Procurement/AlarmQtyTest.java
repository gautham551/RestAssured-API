package com.volvo.gloria.Procurement;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.apache.log4j.Logger;
import com.volvo.gloria.GenericLibrary.BaseClass;
import com.volvo.gloria.GenericLibrary.CommonLibrary;
import com.volvo.gloria.GenericLibrary.DataProviderClass;
import com.volvo.gloria.PayLoadsForPostRequests.ProcurementPayloads;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

import org.testng.annotations.Test;

public class AlarmQtyTest extends BaseClass {

    public static int alarmId;
    Logger log = Logger.getLogger(AlarmQtyTest.class);
/*    @BeforeClass
    public String LoginMC() throws Throwable {

        BaseClass.login(MCuserID);
        return sessionId;
    }*/
    /**
     * http://gloria-qa.got.volvo.net/GloriaUIServices/api/procurement/v1/alarms?
     * page=1&per_page=10&sort_by=id&order=asc&alarmType=STOCK&assignedMaterialControllerId=A238540& assignedMaterialControllerTeam=GOT&_=1581333369424
     * 
     * @return alarmLines of Stock Balance Level
     * 
     */

    @Test(dataProvider = "TeamNames", dataProviderClass = DataProviderClass.class)
    public void GETProcurementAlarmQtyStockBalanceLines(String teamName) {
        given().cookie(sessionId).param("type", "MATERIAL_CONTROL").param("page", "1").param("per_page", "10").param("sort_by", "id").param("order", "asc")
               .param("alarmType", "STOCK").param("assignedMaterialControllerId", MCuserID).param("assignedMaterialControllerTeam", teamName).when()
               .get("/GloriaUIServices/api/procurement/v1/alarms").then().assertThat().statusCode(200);
    }

    /**
     * http://gloria-qa.got.volvo.net/GloriaUIServices/api/procurement/v1/alarms?
     * page=1&per_page=10&total_pages=40&total_entries=395&sort_by=id&order=asc&assignedMaterialControllerId=A238540&assignedMaterialControllerTeam=LYS
     * &status=COMPLETED%2CPLACED%2CRECEIVED_PARTLY&teamType=MATERIAL_CONTROL&alarmType=ORDER&_=1581416959330
     * 
     * @return alarmLines of Order Line Level
     * 
     */

    @Test(dataProvider = "TeamNames", dataProviderClass = DataProviderClass.class)
    public void GETProcurementAlarmQtyOrderLevelLines(String teamName) {
        given().cookie(sessionId).param("type", "MATERIAL_CONTROL").param("page", "1").param("per_page", "10").param("sort_by", "id").param("order", "asc")
               .param("alarmType", "ORDER").param("assignedMaterialControllerId", MCuserID).param("assignedMaterialControllerTeam", teamName).when()
               .get("/GloriaUIServices/api/procurement/v1/alarms").then().assertThat().statusCode(200);
    }
    /**
     * 
     * @Request URL http://gloria-qa.got.volvo.net/GloriaUIServices/api/warehouse/v1/warehouses/47941/zones?_=1581333369427
     * @see While Adding Alarm Qty Rule
     * @return Zones
     */

    @Test(dataProvider = "Warehouse", dataProviderClass = DataProviderClass.class)
    public void GETZoneDetailsForWarehouse(String warehouse) {
        given().cookie(sessionId).when().get("/GloriaUIServices/api/warehouse/v1/warehouses/47941/zones")
        .then().assertThat().statusCode(200);
    }
    
    /**
     * This method will Create a new Alaram Qty Rule under Stock Balance Level
     * 
     * @Post Url - http://gloria-qa.got.volvo.net/GloriaUIServices/api/procurement/v1/alarms?action=ADD&alarmType=STOCK
     * 
     * @author a238540
     */
    
    @Test
    public void POSTCreateNewAlarmQtyStockBalanceLevelTest(){
        
        ValidatableResponse response = given().cookie(sessionId)
        .header("Content-Type","application/json")
        .queryParam("action", "ADD")
        .queryParam("alarmType", "STOCK")
        .body(ProcurementPayloads.POSTCreateNewAlarmQtyStockBalanceLevelPayload())
        .when().post("/GloriaUIServices/api/procurement/v1/alarms").then()
        .assertThat().statusCode(200);
        
        String resp = response.extract().asString();
        JsonPath json = CommonLibrary.rawToJSON(resp);
        int alarmID = json.get("id");
        System.out.println(alarmID);
    }
    
    /**
     * This method will delete the Alarm qty created for Stock Balance Level
     * 
     * @RequestURL - http://gloria-qa.got.volvo.net/GloriaUIServices/api/procurement/v1/alarms/599?alarmType=STOCK
     * @param alarmType=STOCK
     *
     */
    @Test(dependsOnMethods= {"POSTCreateNewAlarmQtyStockBalanceLevelTest"})
    public void DELETEAlarmQtyStockBalanceLevelTest(){
        
       
        given().cookie(sessionId)
        .queryParam("alarmType", "STOCK")
        .when().delete("/GloriaUIServices/api/procurement/v1/alarms/"+alarmId+"").then()
        .assertThat().statusCode(204);
        
    }
}
