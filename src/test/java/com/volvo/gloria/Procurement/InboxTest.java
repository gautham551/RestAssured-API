package com.volvo.gloria.Procurement;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.volvo.gloria.GenericLibrary.BaseClass;
import com.volvo.gloria.GenericLibrary.DataProviderClass;
import com.volvo.gloria.GenericLibrary.FileLibrary;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
/**
 * All API Test when Procurement Inbox tab is clicked.
 */
public class InboxTest extends BaseClass 
{
    
/*    @BeforeClass
    public String Login1() throws Throwable {

        BaseClass.login(MCuserID);
        return sessionId;
    }*/
    
    /**
     * http://gloria-qa.got.volvo.net/GloriaUIServices/api/procurement/v1/materialheaders/current?MCuserID={MCuserID}&page=1&per_page=10
     * &sort_by=assignedMaterialControllerId&order=desc&_=1573544616801
     * @throws Throwable 
     */
    @Test
        public void GETInboxProcurementTest() throws Throwable
    {
        
        MCuserID = FileLibrary.getPropertyFileData("MCMCuserID");
         Response proc = given().cookie(sessionId)
         .param("MCuserID", MCuserID)
         .param("page", "1").param("per_page", "10")
         .param("sort_by", "assignedMaterialControllerId")
         .param("order", "desc").when()
         .get("/GloriaUIServices/api/procurement/v1/materialheaders/current")
         .then().assertThat().statusCode(204).extract().response();
         System.out.println(proc);
         String a = proc.asString();
         JsonPath js = new JsonPath(a);
         System.out.println(js);
        
    }
    
    /**
     * http://gloria-qa.got.volvo.net/GloriaUIServices/api/procurement/v1/procurement/alertonprocurement?
     * procureResponsibility=PROCURER&type=MATERIAL_CONTROL&assignedMaterialControllerId={MCuserID}&
     * assignedMaterialControllerTeam=GSO&_=1573544616800
     * @throws Throwable
     */
    @Test(dataProvider = "TeamNames", dataProviderClass = DataProviderClass.class)
    public void GETInboxAlertonProcurementTest(String teamName) throws Throwable{
        
        MCuserID = FileLibrary.getPropertyFileData("MCMCuserID");
        
        Response proc1 =given().cookie(sessionId)
        .param("procureResponsibility", "PROCURER")
        .param("type", "MATERIAL_CONTROL")
        .param("assignedMaterialControllerId", MCuserID)
        .param("assignedMaterialControllerTeam", teamName)
        .when().get("/GloriaUIServices/api/procurement/v1/procurement/alertonprocurement")
        .then().assertThat().statusCode(200).extract().response();
        
        
    }
    /**
     * http://gloria-qa.got.volvo.net/GloriaUIServices/api/procurement/v1/changeids/alertChange?
     * assignedMaterialControllerTeam=GOT_VE&loggedInMCuserID={MCuserID}&_=1573544616799
     * @throws Throwable 
     */
    @Test(dataProvider = "TeamNames", dataProviderClass = DataProviderClass.class)
    public void GETInboxAlertChangeTest(String teamName) throws Throwable{
        MCuserID = FileLibrary.getPropertyFileData("MCMCuserID");
        given().cookie(sessionId)
        .param("loggedInMCuserID", MCuserID)
        .param("assignedMaterialControllerTeam", teamName)
        .when().get("/GloriaUIServices/api/procurement/v1/changeids/alertChange")
        .then().assertThat().statusCode(200);
        
    }
    /**
     * http://gloria-qa.got.volvo.net/GloriaUIServices/api/user/v1/users/{MCuserID}/teams?
     * type=MATERIAL_CONTROL&_=1573544616798
     * @throws Throwable 
     */
    @Test
    public void GETInboxProcurementTeamsTest() throws Throwable{
        MCuserID = FileLibrary.getPropertyFileData("MCMCuserID");
       
        given().cookie(sessionId)
        .param("type", "MATERIAL_CONTROL")
        .when().get("/GloriaUIServices/api/user/v1/users/"+MCuserID+"/teams")
        .then().assertThat().statusCode(200);
    }
    
    /**
     * This API Test is to test if MTR ID which is created is integrated to Inbox tab.
     * 
     * http://gloria-qa.got.volvo.net/GloriaUIServices/api/procurement/v1/materialheaders/current?
     * userId=A238540&page=1&per_page=10&total_pages=934&total_entries=9333&sort_by=mtrlRequestVersion&
     * order=asc&mtrlRequestVersion=*S48709V1&_=1581416959389
     * 
     * @return Material Header line of the material request created
     * 
     */
    
    @Test
    public void GETInboxSearchMTRID(){
        given().cookie(sessionId)
        .param("userId", MCuserID)
        .param("page", "1")
        .param("per_page", "10")
        .param("sort_by", "mtrlRequestVersion")
        .param("order", "asc")
        .param("mtrlRequestVersion", "")
        .when()
        .get().then().assertThat().statusCode(200);
        
    }
}
