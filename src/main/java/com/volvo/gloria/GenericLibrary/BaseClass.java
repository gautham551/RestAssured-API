package com.volvo.gloria.GenericLibrary;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

import java.io.File;

public class BaseClass {
    public static String sessionId;
    static Logger log = Logger.getLogger(BaseClass.class);
    public static String MCuserID;
    public String WHuserID;
    public String Team;
    public static String companyCode;
    public static String WareHouse;
    public static String userName;
    public static String revUserName;
    public ExtentReports report;
    public ExtentTest logger;
    // public String teamName;

    
    @BeforeSuite
    public void setUp(){
        ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/extent.html"));
        report = new ExtentReports();
        report.attachReporter(extent);
        
    }
    public BaseClass() {
        try {

            MCuserID = FileLibrary.getPropertyFileData("MCUSERID");
            WHuserID = FileLibrary.getPropertyFileData("WHUSERID");
            companyCode = FileLibrary.getPropertyFileData("companyCode");
            Team = FileLibrary.getPropertyFileData("Team");
            WareHouse = FileLibrary.getPropertyFileData("WareHouse");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    /**
     * Test This method will run before ever test which will login to the application and capture the Session ID.
     * 
     * @throws Throwable
     */
    //@Parameters({"userID"})
    @BeforeTest
    public static void login(@Optional String userID) throws Throwable {

        log.info("*****************Test Case Started***********************");
        RestAssured.baseURI = FileLibrary.getPropertyFileData("HOST");

        ValidatableResponse responseBody = given().param("userId", userID).when().get("/GloriaUIServices/api/usertest/v1/login").then().assertThat()
                                                  .statusCode(200);
        String resp = responseBody.extract().asString();
        JsonPath json = CommonLibrary.rawToJSON(resp);
        String firstName = json.get("firstName");
        String lastName = json.get("lastName");
        userName = firstName + " " + lastName;
        revUserName = lastName + " " + firstName;
        sessionId = "JSESSIONID=" + responseBody.extract().response().cookie("JSESSIONID");
        log.info("JSESSIONID is " + sessionId);
        System.out.println(sessionId);
        System.out.println(userName);

    }

/*    @AfterTest
    public void logout() {
        log.info("*****************Test Case Executed***********************");
      
    }*/
}
