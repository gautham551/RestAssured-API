package com.volvo.gloria.CreateQuickMaterial;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import com.volvo.gloria.CreateMaterialRequest.MaterialRequestOverviewPageTest;
import com.volvo.gloria.GenericLibrary.BaseClass;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateQuickMaterialTest extends BaseClass
{
	Logger log = Logger.getLogger(CreateQuickMaterialTest.class);

//	/GloriaUIServices/api/material/v1/material/addToStock
	
	@Test
	public void createQuickMaterialRequest() 
	{
		given().cookie(sessionId).
		body("{\"id\": null,\n\"materialType\": \"RELEASED\",\n\"companyCode\": \"FR46\",\n\"whSiteId\": \"34347\",\n\"binlocation\": \"1529\",\n\"buildSeries\": null,\n\"projectId\": null,\n\"partAffiliation\": \"V\",\n\"partNumber\": \"00266755\",\n\"partVersion\": \"B04\",\n\"partName\": \"LOC SLEEVE 1:ST - 2ND   . \",\n\"partModification\": null,\n\"quantity\": 10,\n\"unitOfMeasure\": \"PCE\",\n\"expirationDate\": null,\n\"aliasId\": \"0\",\n\"domain\": null,\n\"functionGroup\": \"0000\",\n\"pmrId\": null,\n\"qjId\": null,\n\"tossId\": null,\n\"contactPersonId\": \"a272223\",\n\"contactPersonName\": \"Mohammed Tauheed Maher\",\n\"materialControllerId\": \"TIN3000\",\n\"materialControllerName\": \"Remya T\",\n\"orderReference\": null,\n\"supplierId\": null,\n\"supplierName\": null,\n\"countryOfOrigin\": null,\n\"hsnCode\": null,\n\"eccnCode\": null,\n\"currency\": \"SEK\",\n\"unitPrice\": 100,\n\"unitOfPrice\": 1,\n\"itemOID\": \"71273\",\n\"itemIssueOID\": \"22325\"\n}").
		when().post("GloriaUIServices/api/material/v1/material/addToStock").
		then().assertThat().log().ifError().statusCode(200).extract();	
		
	}
	
}