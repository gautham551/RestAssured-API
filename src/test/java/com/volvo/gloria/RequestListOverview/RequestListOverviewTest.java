package com.volvo.gloria.RequestListOverview;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.volvo.gloria.CreateMaterialRequest.MaterialRequestOverviewPageTest;
import com.volvo.gloria.GenericLibrary.BaseClass;

public class RequestListOverviewTest extends BaseClass{
	Logger log = Logger.getLogger(RequestListOverviewTest.class);
	
/*	@BeforeClass
		public String Login1() throws Throwable 
	{
		BaseClass.login(MCuserID);
		return sessionId;
	}*/

	
		/*
	 * http://gloria-qa.got.volvo.net/GloriaUIServices/api/warehouse/v1/warehouses?_=1578905219739
	 */
	@Test
	public void GetRequestListOverviewWarehouse()
	{
		String Resp=given().cookie(sessionId).
		when().get("/GloriaUIServices/api/warehouse/v1/warehouses").
		then().assertThat().log().ifError().statusCode(200).body(Matchers.containsString("[{\"id\":14,\"version\":2,\"defaultPrinter\":13,\"siteId\":\"47941\",\"siteCode\":\"Camrett\",\"siteName\":\"Camrett\",\"countryCode\":\"US\",\"companyCode\":\"US10\",\"address\":\"Camrett Logistics, 6540 Viscoe Road,Radford,VA 24141\",\"setUp\":\"AISLE\",\"qiSupported\":true},{\"id\":8,\"version\":2,\"defaultPrinter\":6,\"siteId\":\"8374\",\"siteCode\":\"AGE PT\",\"siteName\":\"GTO Ageo Eng Assy plant/GTT Proto WS\",\"countryCode\":\"JP\",\"companyCode\":\"JP40\",\"address\":\"Street 1-1 Postal Code 362-8523, AGEO-SHI\",\"setUp\":\"ROW\",\"qiSupported\":true},{\"id\":15,\"version\":1,\"defaultPrinter\":24,\"siteId\":\"37837\",\"siteCode\":\"37837\",\"siteName\":\"GTT Australia proto WS\",\"countryCode\":\"AU\",\"companyCode\":\"AU04\",\"address\":\"Volvo Group Trucks Technology,36 Viking Drive,Wacol QLD 4076, Australia\",\"setUp\":\"ROW\",\"qiSupported\":false},{\"id\":3,\"version\":1,\"defaultPrinter\":0,\"siteId\":\"36012\",\"siteCode\":\"BL Gare X2\",\"siteName\":\"GTT Blainville Gare X2\",\"countryCode\":\"FR\",\"companyCode\":\"FR46\",\"address\":\"rue du Canal, 14550, BLAINVILLE-SUR-ORNE\",\"setUp\":\"ROW\",\"qiSupported\":false},{\"id\":6,\"version\":2,\"defaultPrinter\":2,\"siteId\":\"47670\",\"siteCode\":\"CUR BLCW\",\"siteName\":\"GTT Curitiba Prototype Warehouse\",\"countryCode\":\"BR\",\"companyCode\":\"BR03\",\"address\":\"Av. Juscelino K de Oliveira, 2600, CURITIBA\",\"setUp\":\"AISLE\",\"qiSupported\":true},{\"id\":13,\"version\":2,\"defaultPrinter\":0,\"siteId\":\"4042\",\"siteCode\":\"GSO\",\"siteName\":\"GTT Greensboro Proto WS\",\"countryCode\":\"US\",\"companyCode\":\"US10\",\"address\":\"661 Brigham Road, Suite 100, NC-27409, Greensboro,United States\",\"setUp\":\"AISLE\",\"qiSupported\":true},{\"id\":7,\"version\":2,\"defaultPrinter\":5,\"siteId\":\"45907\",\"siteCode\":\"HAG PP\",\"siteName\":\"GTT Hagerstown Proto warehouse\",\"countryCode\":\"US\",\"companyCode\":\"US45\",\"address\":\"Drop Area B-3, 13302 Pennsylvania Avenue, 21742 HAGERSTOWN\",\"setUp\":\"AISLE\",\"qiSupported\":true},{\"id\":5,\"version\":2,\"defaultPrinter\":3,\"siteId\":\"42102\",\"siteCode\":\"GTT BLR\",\"siteName\":\"GTT Hoskote Proto WS\",\"countryCode\":\"IN\",\"companyCode\":\"IN01\",\"address\":\"Yalachahally,Taverekere Post, Hosakote\",\"setUp\":\"ROW\",\"qiSupported\":true},{\"id\":10,\"version\":8,\"defaultPrinter\":16,\"siteId\":\"1722\",\"siteCode\":\"PE Lundby\",\"siteName\":\"GTT Lundby (O, UV) Proto WS\",\"countryCode\":\"SE\",\"companyCode\":\"SE04\",\"address\":\"Lundby \",\"setUp\":\"ROW\",\"qiSupported\":true},{\"id\":12,\"version\":3,\"defaultPrinter\":14,\"siteId\":\"664\",\"siteCode\":\"N5\",\"siteName\":\"GTT Lundby, Prototype warehouse (N5)\",\"countryCode\":\"SE\",\"companyCode\":\"SE04\",\"address\":\"Volvo Trucks Corperation, GTT Lundby, Prototype warehouse N5/187 John Bunyans v?g 3, SE-41729, G?teborg Sweden\",\"setUp\":\"ROW\",\"qiSupported\":true},{\"id\":11,\"version\":2,\"defaultPrinter\":10,\"siteId\":\"2919\",\"siteCode\":\"MAL\",\"siteName\":\"GTT Malm? Prototype workshop\",\"countryCode\":\"SE\",\"companyCode\":\"SE04\",\"address\":\"Volvo Powertrain AB, J?gershillgatan 22, 213 75 MALM?\",\"setUp\":\"ROW\",\"qiSupported\":true},{\"id\":2,\"version\":2,\"defaultPrinter\":1,\"siteId\":\"34347\",\"siteCode\":\"LY Gare 54\",\"siteName\":\"GTT Saint-Priest Gare 54 Prototype warehouse\",\"countryCode\":\"FR\",\"companyCode\":\"FR46\",\"address\":\"1 Av Henri Germain Postal Code 69802 SAINT-PRIEST CEDEX\",\"setUp\":\"ROW\",\"qiSupported\":true},{\"id\":1,\"version\":1,\"defaultPrinter\":0,\"siteId\":\"34331\",\"siteCode\":\"LY GARE 55\",\"siteName\":\"GTT Saint-Priest Gare 55\",\"countryCode\":\"FR\",\"companyCode\":\"FR46\",\"address\":\"Renault trucks gare 55, 99 route de Lyon, 69806, SAINT PRIEST\",\"setUp\":\"ROW\",\"qiSupported\":false},{\"id\":4,\"version\":1,\"defaultPrinter\":0,\"siteId\":\"40382\",\"siteCode\":\"LY Gare C8\",\"siteName\":\"GTT Saint-Priest Gare C8\",\"countryCode\":\"FR\",\"companyCode\":\"FR46\",\"address\":\"Renault Trucks gare C8, 99 route de Lyon, 69806, SAINT PRIEST\",\"setUp\":\"ROW\",\"qiSupported\":false},{\"id\":9,\"version\":2,\"defaultPrinter\":9,\"siteId\":\"1620\",\"siteCode\":\"SKO PP\",\"siteName\":\"GTT Sk?vde Proto\",\"countryCode\":\"SE\",\"companyCode\":\"SE04\",\"address\":\"Volvov?gen 5 F-Port, 541 87 SK?VDE\",\"setUp\":\"ROW\",\"qiSupported\":true}]")).
		extract().asString();
		System.out.println(Resp);
	}
	
	
	/*
	 * http://gloria-qa.got.volvo.net/GloriaUIServices/api/material/v1/requestlistoverview
	 * ?page=1&per_page=10&sort_by=requestListCardinal&order=desc
	 * &requestUserId=A044096&userId=A044096&_=1579163432826
	 */	
	
	@Test
	public void GetRequestListOverviewPage()
	{
		given().log().all().cookie(sessionId).param("page","1").param("per_page","1").param("sort_by","requestListCardinal").
		param("order","desc").param("requestUserId",  MCuserID ).param("userId",  MCuserID ).
		when().get("/GloriaUIServices/api/material/v1/requestlistoverview").
		then().assertThat().log().ifError().statusCode(200);
		
	}
	
	/*
	 * http://gloria-qa.got.volvo.net/GloriaUIServices/api/user/v1/users/A044096/sites?_=1579163432827
	 */	
	
	@Test
	public void GetRequestListOverviewSites()
	{

		String Response = "[{\"id\":1,\"siteId\":\"664\",\"siteCode\":\"N5\",\"siteName\":\"GTT Lundby, Prototype warehouse (N5)\",\"address\":\"Volvo Trucks Corperation, GTT Lundby, Prototype warehouse N5/187 John Bunyans v?g 3, SE-41729, G?teborg Sweden\",\"phone\":\"\",\"countryCode\":\"SE\",\"companyCode\":\"SE04\",\"jointVenture\":false,\"shipToSite\":true,\"shipToType\":\"WH\",\"buildSite\":false,\"buildSiteType\":\"\",\"qiSupport\":false,\"whSite\":false,\"whVirtual\":false},{\"id\":9,\"siteId\":\"1722\",\"siteCode\":\"PE Lundby\",\"siteName\":\"GTT Lundby (O, UV) Proto WS\",\"address\":\"Lundby \",\"phone\":\"\",\"countryCode\":\"SE\",\"companyCode\":\"SE04\",\"jointVenture\":false,\"shipToSite\":true,\"shipToType\":\"WH\",\"buildSite\":false,\"buildSiteType\":\"\",\"qiSupport\":false,\"whSite\":false,\"whVirtual\":false},{\"id\":14,\"siteId\":\"4042\",\"siteCode\":\"GSO\",\"siteName\":\"GTT Greensboro Proto WS\",\"address\":\"661 Brigham Road, Suite 100, NC-27409, Greensboro,United States\",\"phone\":\"\",\"countryCode\":\"US\",\"companyCode\":\"US10\",\"jointVenture\":false,\"shipToSite\":true,\"shipToType\":\"WH\",\"buildSite\":true,\"buildSiteType\":\"PLANT\",\"qiSupport\":false,\"whSite\":false,\"whVirtual\":false},{\"id\":21,\"siteId\":\"8374\",\"siteCode\":\"AGE PT\",\"siteName\":\"GTO Ageo Eng Assy plant/GTT Proto WS\",\"address\":\"Street 1-1 Postal Code 362-8523, AGEO-SHI\",\"phone\":\"\",\"countryCode\":\"JP\",\"companyCode\":\"JP40\",\"jointVenture\":false,\"shipToSite\":true,\"shipToType\":\"WH\",\"buildSite\":true,\"buildSiteType\":\"PLANT\",\"qiSupport\":false,\"whSite\":false,\"whVirtual\":false},{\"id\":33,\"siteId\":\"34331\",\"siteCode\":\"LY GARE 55\",\"siteName\":\"GTT Saint-Priest Gare 55\",\"address\":\"Renault trucks gare 55, 99 route de Lyon, 69806, SAINT PRIEST\",\"phone\":\"\",\"countryCode\":\"FR\",\"companyCode\":\"FR46\",\"jointVenture\":false,\"shipToSite\":true,\"shipToType\":\"VIRTUAL\",\"buildSite\":false,\"buildSiteType\":\"\",\"qiSupport\":false,\"whSite\":false,\"whVirtual\":false},{\"id\":36,\"siteId\":\"36012\",\"siteCode\":\"BL Gare X2\",\"siteName\":\"GTT Blainville Gare X2\",\"address\":\"rue du Canal, 14550, BLAINVILLE-SUR-ORNE\",\"phone\":\"\",\"countryCode\":\"FR\",\"companyCode\":\"FR46\",\"jointVenture\":false,\"shipToSite\":true,\"shipToType\":\"VIRTUAL\",\"buildSite\":false,\"buildSiteType\":\"\",\"qiSupport\":false,\"whSite\":false,\"whVirtual\":false},{\"id\":38,\"siteId\":\"42102\",\"siteCode\":\"GTT BLR\",\"siteName\":\"GTT Hoskote Proto WS\",\"address\":\"Yalachahally,Taverekere Post, Hosakote\",\"phone\":\"\",\"countryCode\":\"IN\",\"companyCode\":\"IN01\",\"jointVenture\":false,\"shipToSite\":true,\"shipToType\":\"WH\",\"buildSite\":true,\"buildSiteType\":\"WORKSHOP\",\"qiSupport\":false,\"whSite\":false,\"whVirtual\":false},{\"id\":39,\"siteId\":\"45907\",\"siteCode\":\"HAG PP\",\"siteName\":\"GTT Hagerstown Proto warehouse\",\"address\":\"Drop Area B-3, 13302 Pennsylvania Avenue, 21742 HAGERSTOWN\",\"phone\":\"\",\"countryCode\":\"US\",\"companyCode\":\"US45\",\"jointVenture\":false,\"shipToSite\":true,\"shipToType\":\"WH\",\"buildSite\":true,\"buildSiteType\":\"PLANT\",\"qiSupport\":false,\"whSite\":false,\"whVirtual\":false},{\"id\":34,\"siteId\":\"34347\",\"siteCode\":\"LY Gare 54\",\"siteName\":\"GTT Saint-Priest Gare 54 Prototype warehouse\",\"address\":\"1 Av Henri Germain Postal Code 69802 SAINT-PRIEST CEDEX\",\"phone\":\"\",\"countryCode\":\"FR\",\"companyCode\":\"FR46\",\"jointVenture\":false,\"shipToSite\":true,\"shipToType\":\"WH\",\"buildSite\":false,\"buildSiteType\":\"\",\"qiSupport\":false,\"whSite\":false,\"whVirtual\":false},{\"id\":37,\"siteId\":\"40382\",\"siteCode\":\"LY Gare C8\",\"siteName\":\"GTT Saint-Priest Gare C8\",\"address\":\"Renault Trucks gare C8, 99 route de Lyon, 69806, SAINT PRIEST\",\"phone\":\"\",\"countryCode\":\"FR\",\"companyCode\":\"FR46\",\"jointVenture\":false,\"shipToSite\":true,\"shipToType\":\"VIRTUAL\",\"buildSite\":false,\"buildSiteType\":\"\",\"qiSupport\":false,\"whSite\":false,\"whVirtual\":false},{\"id\":40,\"siteId\":\"47670\",\"siteCode\":\"CUR BLCW\",\"siteName\":\"GTT Curitiba Prototype Warehouse\",\"address\":\"Av. Juscelino K de Oliveira, 2600, CURITIBA\",\"phone\":\"\",\"countryCode\":\"BR\",\"companyCode\":\"BR03\",\"jointVenture\":false,\"shipToSite\":true,\"shipToType\":\"WH\",\"buildSite\":false,\"buildSiteType\":\"\",\"qiSupport\":false,\"whSite\":false,\"whVirtual\":false},{\"id\":6,\"siteId\":\"1620\",\"siteCode\":\"SKO PP\",\"siteName\":\"GTT Sk?vde Proto\",\"address\":\"Volvov?gen 5 F-Port, 541 87 SK?VDE\",\"phone\":\"\",\"countryCode\":\"SE\",\"companyCode\":\"SE04\",\"jointVenture\":false,\"shipToSite\":true,\"shipToType\":\"WH\",\"buildSite\":true,\"buildSiteType\":\"PLANT\",\"qiSupport\":false,\"whSite\":false,\"whVirtual\":false}]";

		String ExpectedResponse = "[{\"id\":1,\"siteId\":\"664\",\"siteCode\":\"N5\",\"siteName\":\"GTT Lundby, Prototype warehouse (N5)\",\"address\":\"Volvo Trucks Corperation, GTT Lundby, Prototype warehouse N5/187 John Bunyans v�g 3, SE-41729, G�teborg Sweden\",\"phone\":\"\",\"countryCode\":\"SE\",\"companyCode\":\"SE04\",\"jointVenture\":false,\"shipToSite\":true,\"shipToType\":\"WH\",\"buildSite\":false,\"buildSiteType\":\"\",\"qiSupport\":false,\"whSite\":false,\"whVirtual\":false},{\"id\":9,\"siteId\":\"1722\",\"siteCode\":\"PE Lundby\",\"siteName\":\"GTT Lundby (O, UV) Proto WS\",\"address\":\"Lundby \",\"phone\":\"\",\"countryCode\":\"SE\",\"companyCode\":\"SE04\",\"jointVenture\":false,\"shipToSite\":true,\"shipToType\":\"WH\",\"buildSite\":false,\"buildSiteType\":\"\",\"qiSupport\":false,\"whSite\":false,\"whVirtual\":false},{\"id\":14,\"siteId\":\"4042\",\"siteCode\":\"GSO\",\"siteName\":\"GTT Greensboro Proto WS\",\"address\":\"661 Brigham Road, Suite 100, NC-27409, Greensboro,United States\",\"phone\":\"\",\"countryCode\":\"US\",\"companyCode\":\"US10\",\"jointVenture\":false,\"shipToSite\":true,\"shipToType\":\"WH\",\"buildSite\":true,\"buildSiteType\":\"PLANT\",\"qiSupport\":false,\"whSite\":false,\"whVirtual\":false},{\"id\":21,\"siteId\":\"8374\",\"siteCode\":\"AGE PT\",\"siteName\":\"GTO Ageo Eng Assy plant/GTT Proto WS\",\"address\":\"Street 1-1 Postal Code 362-8523, AGEO-SHI\",\"phone\":\"\",\"countryCode\":\"JP\",\"companyCode\":\"JP40\",\"jointVenture\":false,\"shipToSite\":true,\"shipToType\":\"WH\",\"buildSite\":true,\"buildSiteType\":\"PLANT\",\"qiSupport\":false,\"whSite\":false,\"whVirtual\":false},{\"id\":33,\"siteId\":\"34331\",\"siteCode\":\"LY GARE 55\",\"siteName\":\"GTT Saint-Priest Gare 55\",\"address\":\"Renault trucks gare 55, 99 route de Lyon, 69806, SAINT PRIEST\",\"phone\":\"\",\"countryCode\":\"FR\",\"companyCode\":\"FR46\",\"jointVenture\":false,\"shipToSite\":true,\"shipToType\":\"VIRTUAL\",\"buildSite\":false,\"buildSiteType\":\"\",\"qiSupport\":false,\"whSite\":false,\"whVirtual\":false},{\"id\":36,\"siteId\":\"36012\",\"siteCode\":\"BL Gare X2\",\"siteName\":\"GTT Blainville Gare X2\",\"address\":\"rue du Canal, 14550, BLAINVILLE-SUR-ORNE\",\"phone\":\"\",\"countryCode\":\"FR\",\"companyCode\":\"FR46\",\"jointVenture\":false,\"shipToSite\":true,\"shipToType\":\"VIRTUAL\",\"buildSite\":false,\"buildSiteType\":\"\",\"qiSupport\":false,\"whSite\":false,\"whVirtual\":false},{\"id\":38,\"siteId\":\"42102\",\"siteCode\":\"GTT BLR\",\"siteName\":\"GTT Hoskote Proto WS\",\"address\":\"Yalachahally,Taverekere Post, Hosakote\",\"phone\":\"\",\"countryCode\":\"IN\",\"companyCode\":\"IN01\",\"jointVenture\":false,\"shipToSite\":true,\"shipToType\":\"WH\",\"buildSite\":true,\"buildSiteType\":\"WORKSHOP\",\"qiSupport\":false,\"whSite\":false,\"whVirtual\":false},{\"id\":39,\"siteId\":\"45907\",\"siteCode\":\"HAG PP\",\"siteName\":\"GTT Hagerstown Proto warehouse\",\"address\":\"Drop Area B-3, 13302 Pennsylvania Avenue, 21742 HAGERSTOWN\",\"phone\":\"\",\"countryCode\":\"US\",\"companyCode\":\"US45\",\"jointVenture\":false,\"shipToSite\":true,\"shipToType\":\"WH\",\"buildSite\":true,\"buildSiteType\":\"PLANT\",\"qiSupport\":false,\"whSite\":false,\"whVirtual\":false},{\"id\":34,\"siteId\":\"34347\",\"siteCode\":\"LY Gare 54\",\"siteName\":\"GTT Saint-Priest Gare 54 Prototype warehouse\",\"address\":\"1 Av Henri Germain Postal Code 69802 SAINT-PRIEST CEDEX\",\"phone\":\"\",\"countryCode\":\"FR\",\"companyCode\":\"FR46\",\"jointVenture\":false,\"shipToSite\":true,\"shipToType\":\"WH\",\"buildSite\":false,\"buildSiteType\":\"\",\"qiSupport\":false,\"whSite\":false,\"whVirtual\":false},{\"id\":37,\"siteId\":\"40382\",\"siteCode\":\"LY Gare C8\",\"siteName\":\"GTT Saint-Priest Gare C8\",\"address\":\"Renault Trucks gare C8, 99 route de Lyon, 69806, SAINT PRIEST\",\"phone\":\"\",\"countryCode\":\"FR\",\"companyCode\":\"FR46\",\"jointVenture\":false,\"shipToSite\":true,\"shipToType\":\"VIRTUAL\",\"buildSite\":false,\"buildSiteType\":\"\",\"qiSupport\":false,\"whSite\":false,\"whVirtual\":false},{\"id\":40,\"siteId\":\"47670\",\"siteCode\":\"CUR BLCW\",\"siteName\":\"GTT Curitiba Prototype Warehouse\",\"address\":\"Av. Juscelino K de Oliveira, 2600, CURITIBA\",\"phone\":\"\",\"countryCode\":\"BR\",\"companyCode\":\"BR03\",\"jointVenture\":false,\"shipToSite\":true,\"shipToType\":\"WH\",\"buildSite\":false,\"buildSiteType\":\"\",\"qiSupport\":false,\"whSite\":false,\"whVirtual\":false},{\"id\":6,\"siteId\":\"1620\",\"siteCode\":\"SKO PP\",\"siteName\":\"GTT Sk�vde Proto\",\"address\":\"Volvov�gen 5 F-Port, 541 87 SK�VDE\",\"phone\":\"\",\"countryCode\":\"SE\",\"companyCode\":\"SE04\",\"jointVenture\":false,\"shipToSite\":true,\"shipToType\":\"WH\",\"buildSite\":true,\"buildSiteType\":\"PLANT\",\"qiSupport\":false,\"whSite\":false,\"whVirtual\":false}]";

						
		given().log().all().cookie(sessionId).
		when().get("/GloriaUIServices/api/user/v1/users/"+MCuserID+"/sites").
		then().assertThat().log().ifError().statusCode(200).body(Matchers.containsString(ExpectedResponse));
		
	}
	
	
	
}