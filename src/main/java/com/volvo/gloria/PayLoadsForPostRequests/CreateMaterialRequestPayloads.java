package com.volvo.gloria.PayLoadsForPostRequests;

import com.volvo.gloria.CreateMaterialRequest.CreateNewMaterialRequestTest;
import com.volvo.gloria.GenericLibrary.BaseClass;
import com.volvo.gloria.GenericLibrary.CommonLibrary;

public class CreateMaterialRequestPayloads extends BaseClass{
    public static int partNumber = CommonLibrary.getRandomNum();
    
	public static String POSTMaterialRequestAddHeaderPayload() 
	{
		
	    String Currentdate = CommonLibrary.CurrentDate();
	    String DateAfterSixMonths = CommonLibrary.DateAfterSixMonths();
		
		String payload = "{\"type\":\"SINGLE\",\"name\":\"Test Object\",\"title\":\"API_Test\",\"pmrId\":\"PMR ID\",\"qjId\":null,\"tossId\":null,\"companyCode\":\""+ companyCode +"\",\"projectId\":\"03-07417\",\"glAccount\":\"659261\",\"wbsCode\":\"L1G10-10210-03-01-01\",\"costCenter\":\"0000010101\","
				+ "\"requiredStaDate\":\""+ DateAfterSixMonths +"\",\"outboundStartDate\":\"" + Currentdate+ "\","
				+ "\"outboundLocationId\":\"PB054\",\"contactPersonUserId\":\"A238540\",\"contactPersonName\":\"Gautham Nandigam Raju\",\"mailFormId\":\"L8983833\",\"materialControllerUserId\":\"A238540\",\"materialControllerName\":\"Gautham Nandigam Raju\",\"isNew\":\"true\"}";
	
		
		return payload;	
	}
	
	
	public static String POSTMaterialRequestAddPartPayload() 
	{
		
		String payload = "{\"partAffiliation\":\"V\",\r\n\"partNumber\":\""+partNumber+"\",\r\n\"partVersion\":\"P02\",\r\n\"partName\":\"Bracket\",\r\n\"partModification\":null,\"quantity\":12,\r\n\"unitOfMeasure\":\"PCE\",\"functionGroup\":\"9531\",\r\n\"reference\":\"111\",\r\n\"purchaseInfo\":\"Information to purchase\",\r\n\"warehouseComment\":\"Warehouse Comment\"\r\n}";
		
		return payload;
	}
	
	
	
	public static String PUTMaterialRequestPreSendPayload() 
	{
		int MRID1 = CreateNewMaterialRequestTest.MRID;
		String MTRID = CreateNewMaterialRequestTest.MTRID;
		int materialRequestVersionId = CreateNewMaterialRequestTest.materialRequestVersionId;
		int materialRequestObjectID = CreateNewMaterialRequestTest.materialRequestObjectID;
	    String Currentdate = CommonLibrary.CurrentDate();
	    String DateAfterSixMonths = CommonLibrary.DateAfterSixMonths();
	    	    
		String payload = "{\r\n\t\"id\": \""+ MRID1 +"\",\r\n    \"version\": 1,\r\n    \"financeMaterialID\": \""+ MRID1 +"\",\r\n    \"financeMaterialVersion\": 1,\r\n    \"projectId\": \"03-07417\",\r\n    \"referenceGroup\": null,\r\n    \"materialRequestObjectID\": \""+ materialRequestObjectID +"\",\r\n    \"materialRequestObjectVersion\": 1,\r\n    \"name\": \"Test Object\",\r\n    \"materialRequestVersionId\": \""+materialRequestVersionId +"\",\r\n    \"materialRequestVersionVersion\": 1,\r\n    \"title\": \"API_Test\",\r\n    \"mtrlRequestVersion\": \""+ MTRID +"\",\r\n    \"materialRequestVersionStatus\": \"CREATED\",\r\n    \"materialRequestVersionStatusDate\": \""+ Currentdate +"\",\r\n    \"contactPersonUserId\": \"A238540\",\r\n    \"contactPersonName\": \"Gautham Nandigam Raju\",\r\n    \"requesterId\": \"A238540\",\r\n    \"requesterName\": \"Nandigam Raju Gautham\",\r\n    \"type\": \"SINGLE\",\r\n    \"companyCode\": \"JP40\",\r\n    \"glAccount\": \"659261\",\r\n    \"wbsCode\": \"L1G10-10210-03-01-01\",\r\n    \"costCenter\": \"0000010101\",\r\n    \"internalOrderNoSAP\": null,\r\n    \"requiredStaDate\": \""+ DateAfterSixMonths +"\",\r\n    \"outboundStartDate\": \""+ Currentdate +"\",\r\n    \"outboundLocationId\": \"PB054\",\r\n    \"mailFormId\": \"L8983833\",\r\n    \"approvalAmount\": 0.0,\r\n    \"approvalCurrency\": null,\r\n    \"materialControllerUserId\": \"A238540\",\r\n    \"materialControllerName\": \"Gautham Nandigam Raju\",\r\n    \"qjId\": null,\r\n    \"pmrId\": \"PMR ID\",\r\n    \"tossId\": null,\r\n    \"materialRequest\": null\r\n}";
		
		return payload;
	
	}
	
	public static String PUTMaterialRequestSendPayload() 
	{
		int MRID1 = CreateNewMaterialRequestTest.MRID;
		String MTRID = CreateNewMaterialRequestTest.MTRID;
		int materialRequestVersionId = CreateNewMaterialRequestTest.materialRequestVersionId;
		int materialRequestObjectID = CreateNewMaterialRequestTest.materialRequestObjectID;
	    String Currentdate = CommonLibrary.CurrentDate();
	    String DateAfterSixMonths = CommonLibrary.DateAfterSixMonths();
	    
		String payload = "{\r\n\t\"id\": \""+ MRID1 +"\",\r\n    \"version\": 1,\r\n    \"financeMaterialID\": \""+ MRID1 +"\",\r\n    \"financeMaterialVersion\": 1,\r\n    \"projectId\": \"03-07417\",\r\n    \"referenceGroup\": null,\r\n    \"materialRequestObjectID\": \""+ materialRequestObjectID +"\",\r\n    \"materialRequestObjectVersion\": 2,\r\n    \"name\": \"Test Object\",\r\n    \"materialRequestVersionId\": \""+materialRequestVersionId +"\",\r\n    \"materialRequestVersionVersion\": 3,\r\n    \"title\": \"API_Test\",\r\n    \"mtrlRequestVersion\": \""+ MTRID +"\",\r\n    \"materialRequestVersionStatus\": \"SENT_ACCEPTED\",\r\n    \"materialRequestVersionStatusDate\": \""+ Currentdate +"\",\r\n    \"contactPersonUserId\": \"A238540\",\r\n    \"contactPersonName\": \"Gautham Nandigam Raju\",\r\n    \"requesterId\": \"A238540\",\r\n    \"requesterName\": \"Nandigam Raju Gautham\",\r\n    \"type\": \"SINGLE\",\r\n    \"companyCode\": \"JP40\",\r\n    \"glAccount\": \"659261\",\r\n    \"wbsCode\": \"L1G10-10210-03-01-01\",\r\n    \"costCenter\": \"0000010101\",\r\n    \"internalOrderNoSAP\": null,\r\n    \"requiredStaDate\": \""+ DateAfterSixMonths +"\",\r\n    \"outboundStartDate\": \""+ Currentdate +"\",\r\n    \"outboundLocationId\": \"PB054\",\r\n    \"mailFormId\": \"L8983833\",\r\n    \"approvalAmount\": 0.0,\r\n    \"approvalCurrency\": null,\r\n    \"materialControllerUserId\": \"A238540\",\r\n    \"materialControllerName\": \"Gautham Nandigam Raju\",\r\n    \"qjId\": null,\r\n    \"pmrId\": \"PMR ID\",\r\n    \"tossId\": null,\r\n    \"materialRequest\": null\r\n}";
		return payload;
	
	}
	
	
	
	    
}
