package com.volvo.gloria.CreateMaterialRequest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import static org.hamcrest.Matchers.lessThan;
import static io.restassured.RestAssured.given;
import org.apache.log4j.Logger;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.volvo.gloria.GenericLibrary.BaseClass;
import com.volvo.gloria.GenericLibrary.CommonLibrary;
import com.volvo.gloria.GenericLibrary.DataProviderClass;
import com.volvo.gloria.PayLoadsForPostRequests.CreateMaterialRequestPayloads;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

public class CreateNewMaterialRequestTest extends BaseClass {
	Logger log = Logger.getLogger(CreateNewMaterialRequestTest.class);
	String Currentdate = CommonLibrary.CurrentDate();
	String DateAfterSixMonths = CommonLibrary.DateAfterSixMonths();
	public static int MRID;
	public static String MTRID;
	public static int materialRequestVersionId;
	public static int materialRequestObjectID;
	
	@BeforeTest
	public String Login1() throws Throwable {

		BaseClass.login(MCuserID);
		return sessionId;
	}


 
	 /*
	 * http://gloria-qa.got.volvo.net/GloriaUIServices/api/user/v1/ldapusers/"+MCuserID+
	 */ 
	  
	  @Test 
	  public void GETMaterialRequestusers() 
	  {
		  given().and().cookie(sessionId).and().param("_","1574251584759").
		  when().get("/GloriaUIServices/api/user/v1/ldapusers/"+MCuserID+"").
		  then().assertThat().statusCode(200).time(lessThan(1500L)).extract().response().asString(); 
	  }
	  
	  /*
	   * *http://gloria-qa.got.volvo.net/GloriaUIServices/api/common/v1/companycodes 
	   */
	  
	  @Test 
	  public void GETMaterialRequestCompanyCodes() 
	  {
		  given().cookie(sessionId).and().param("type","MATERIAL_CONTROL").
		  param("ignoreDisableRequests","false").
		  param("userId",MCuserID).param("page","1").param("per_page","1").param("code","").param("_","1574251584759").
		  when().get("/GloriaUIServices/api/common/v1/companycodes").
		  then().assertThat().statusCode(200).time(lessThan(10000L)).extract().response().asString(); 
	  }
	  
	  
	  /**
	   * http://gloria-qa.got.volvo.net/GloriaUIServices/api/common/v1/companycodes/ComapnyCodes/projects  
	   * @param ComapnyCodes
	   */
	  
		  @Test(dataProvider="CompanyCodes", dataProviderClass=DataProviderClass.class)
	  public void GETMaterialRequestProjects(String ComapnyCodes) 
	  {
		  given().cookie(sessionId).and().
		  param("page","1").param("per_page","1").param("_","1574251584759"). 
		  when().get("/GloriaUIServices/api/common/v1/companycodes/ComapnyCodes/projects").
		  then().assertThat().statusCode(200).time(lessThan(10000L)).extract().response().asString();
	  }
	  
	 
	  /**
	   * http://gloria-qa.got.volvo.net/GloriaUIServices/api/common/v1/companycodes/CompanyCodes/projects 
	   * @param CompanyCodes
	   */
	  
		  @Test(dataProvider="CompanyCodes", dataProviderClass=DataProviderClass.class)
	  public void GETMaterialRequestGLAccounts(String CompanyCodes) 
	  {
		  given().cookie(sessionId).and().
		  param("page","1").param("per_page","1").param("code","").param("_","1574251584759"). 
		  when().get("/GloriaUIServices/api/common/v1/companycodes/CompanyCodes/projects").
		  then().assertThat().statusCode(200).time(lessThan(10000L)).extract().response().asString(); 
	  }
	  
	  
	  /**
	   * http://gloria-qa.got.volvo.net/GloriaUIServices/api/common/v1/wbselements?page=1&
	   * per_page=15&companyCode=FR46&projectId=03-07417&wbs=&_=1574663390539
	   */
	    
	  
		  @Test() 
	  public void GETMaterialRequestWBS()
	  {
		  given().cookie(sessionId).and().
		  param("page","1").param("per_page","1").param("code","").param("_","1574251584759"). 
		  when().get("/GloriaUIServices/api/common/v1/wbselements?page=1&per_page=15&companyCode=FR46&projectId=03-07417&wbs=&_=1574663390539"). 
		  then().assertThat().statusCode(200).time(lessThan(10000L)).extract().response().asString(); 
	  }
	  
	  
	  /*
	   * *http://gloria-qa.got.volvo.net/GloriaUIServices/api/common/v1/costcenters
	   */
	  
		  @Test(dataProvider="CompanyCodes", dataProviderClass=DataProviderClass.class)
	  public void GETMaterialRequestCostCenter(String CompanyCodes) 
	  {
		  given().cookie(sessionId).and().
		  param("page","1").param("per_page","1").param("code","").param("_","1574251584759").
		  param("companyCode",CompanyCodes).param("costCenter","").
		  when().get("/GloriaUIServices/api/common/v1/costcenters").
		  then().assertThat().statusCode(200).time(lessThan(10000L)).extract().response().asString();
	  }
	  
	  /**
	   * http://gloria-qa.got.volvo.net/GloriaUIServices/api/common/v1/buildsites
	   */
	  
	  	  @Test 
	  public void GETMaterialRequestBuildLocation() 
	  {
		  given().cookie(sessionId).and().
		  param("page","1").param("per_page","1").param("code","").param("siteId","").
		  when().get("/GloriaUIServices/api/common/v1/buildsites").
		  then().assertThat().statusCode(200).time(lessThan(10000L)); 
	  }
	 
	 /**
	  * http://gloria-qa.got.volvo.net/GloriaUIServices/api/materialrequest/v1/materialrequests/"+MRID+	 
	  */
	 
	  @Test(priority=1)
	  public void DeleteMaterialRequest()
	  {
		  
		  CreateNewMaterialRequestTest M= new CreateNewMaterialRequestTest();
		  M.POSTMaterialRequestAddHeader();
		  M.POSTMaterialRequestAddPart();
		  
		  given().cookie(sessionId).
		  when().delete("/GloriaUIServices/api/materialrequest/v1/materialrequests/"+MRID+"").
		  then().assertThat().log().ifError().statusCode(204).time(lessThan(10000L));
		  log.info("Materail Reaquest" +MTRID+ "is deleted successfully");
		  
	  }
	  

		/**
		 * http://gloria-qa.got.volvo.net/GloriaUIServices/api/materialrequest/v1/materialrequests
		 */
	
	  @Test ()
	  public void POSTMaterialRequestAddHeader() 
	  { 
		  String materialHeader=CreateMaterialRequestPayloads.POSTMaterialRequestAddHeaderPayload();
		  
		  ValidatableResponse resp1=given().cookie(sessionId).header("Content-Type", "application/json").
		  body(materialHeader).
		  when().post("/GloriaUIServices/api/materialrequest/v1/materialrequests").
		  then().assertThat().log().ifError().statusCode(200).time(lessThan(10000L)).
		  body("materialRequestVersionStatus",Matchers.equalTo("CREATED"));
		  
		  String resp=resp1.extract().response().asString();
		  
		  JsonPath json = CommonLibrary.rawToJSON(resp); 
		  MRID = json.get("id"); 
		  MTRID = json.get("mtrlRequestVersion"); 
		  materialRequestObjectID = json.get("materialRequestObjectID"); 
		  materialRequestVersionId = json.get("materialRequestVersionId");
		  System.out.println(MRID); 
		  System.out.println("materialRequestID = " +MTRID); 
		  System.out.println("materialRequestObjectID = " +materialRequestObjectID );
		  System.out.println("materialRequestVersionId = " +materialRequestVersionId );
	  }
	  

		/**
		 * http://gloria-qa.got.volvo.net/GloriaUIServices/api/materialrequest/v1/materialrequests/" + MRID + "/current/materialrequestlines
		 */
		  
	  
	  @Test(dependsOnMethods= {"POSTMaterialRequestAddHeader"}) 
	  public void POSTMaterialRequestAddPart() 
	  {
		  String Partdetails=CreateMaterialRequestPayloads.POSTMaterialRequestAddPartPayload(); 
		  given().cookie(sessionId).header("Content-Type", "application/json").
		  body(Partdetails).
		  when().post("/GloriaUIServices/api/materialrequest/v1/materialrequests/"+MRID+"/current/materialrequestlines").
		  then().assertThat().log().ifError().statusCode(200).time(lessThan(10000L)); 
	  }
	  
	  /**
	   *  http://gloria-qa.got.volvo.net/GloriaUIServices/api/materialrequest/v1/materialrequests/JP40/isValidMC/A238540
	   *  */
	  
	  	  @Test ()
	  public void GETMaterialRequestValidMC() 
	  {
		  given().cookie(sessionId).and().
		  param("page","1").param("per_page","1").param("code","").param("siteId","").
		  when().get("/GloriaUIServices/api/materialrequest/v1/materialrequests/JP40/isValidMC/"+MCuserID+"").
		  then().assertThat().time(lessThan(10000L)).statusCode(200).body(Matchers.equalTo("true"));
	  }
	 
	  /**
	   * http://gloria-qa.got.volvo.net/GloriaUIServices/api/materialrequest/v1/materialrequests/48068
	   */
	
	  @Test (dependsOnMethods= {"POSTMaterialRequestAddPart"})
	  public void PUTMaterialRequestPreSend() 
	  { 
		  String PreSendData=CreateMaterialRequestPayloads.PUTMaterialRequestPreSendPayload();   
		  ValidatableResponse resp1=given().cookie(sessionId).header("Content-Type","application/json").
		  body(PreSendData). 
		  when().put("/GloriaUIServices/api/materialrequest/v1/materialrequests/"+MRID+"").
		  then().log().ifError().statusCode(200).time(lessThan(10000L)).and().body("materialRequestVersionStatus", Matchers.equalTo("CREATED"));
	  }
	  
	  
	  /**
	   * http://gloria-qa.got.volvo.net/GloriaUIServices/api/materialrequest/v1/materialrequests/"+ MRID +"/current
	   */
	  
	  @Test (dependsOnMethods= {"PUTMaterialRequestPreSend"})
	  public void PUTMaterialRequestSend() 
	  { 
		  String SendData=CreateMaterialRequestPayloads.PUTMaterialRequestSendPayload();
		  ValidatableResponse resp1=given().cookie(sessionId).header("Content-Type","application/json").
		  queryParam("action","send"). body(SendData).
		  when().put("GloriaUIServices/api/materialrequest/v1/materialrequests/"+ MRID +"/current").
		  then().log().ifError().statusCode(200).time(lessThan(10000L)).
		  body("materialRequestVersionStatus", Matchers.equalTo("SENT_ACCEPTED"));
	  }
	 
	 
	 /**
	  * http://gloria-qa.got.volvo.net/GloriaUIServices/api/user/v1/users/"+MCuserID+"/procureteammembers
	  */
	
	  @Test 
	  public void GETMaterialRequestprocureteammembers() 
	  {
		  given().cookie(sessionId).and().
		  when().get("GloriaUIServices/api/user/v1/users/"+MCuserID+"/procureteammembers").
		  then().assertThat().log().ifError().statusCode(200).time(lessThan(10000L));
	  } 
	 
	  
	
}
