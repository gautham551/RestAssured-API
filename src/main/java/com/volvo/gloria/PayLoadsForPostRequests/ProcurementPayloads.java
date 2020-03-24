package com.volvo.gloria.PayLoadsForPostRequests;

import com.volvo.gloria.CreateMaterialRequest.CreateNewMaterialRequestTest;
import com.volvo.gloria.GenericLibrary.BaseClass;
import com.volvo.gloria.GenericLibrary.CommonLibrary;
import com.volvo.gloria.Procurement.GetProcureDetailsTest;
import com.volvo.gloria.Procurement.ToProcurePageTest;

public class ProcurementPayloads extends BaseClass{
    static String partNumber = ToProcurePageTest.partNumber;
    static String Currentdate = CommonLibrary.CurrentDate();
    static String DateAfterSixMonths = CommonLibrary.DateAfterSixMonths();
    static int procureLineID = ToProcurePageTest.ProcureLineID;
    static String mtrlRequestId = ToProcurePageTest.mtrlRequestId;
    static int financeHeaderId = ToProcurePageTest.financeHeaderId;
    static int materialID = ToProcurePageTest.materialId;
    static String OrderNumber;

    public static String POSTCreateNewAlarmQtyStockBalanceLevelPayload() {

        String payload = "{\n    \"id\": null,\n    \"partAffiliation\": \"V\",\n    \"partNumber\": \"" + partNumber + "\","
                + "\n    \"partVersion\": \"P07\",\n    \"partModification\": null,\n    \"alarmQuantity\": 12,"
                + "\n    \"companyCode\": \"US45\",\n    \"warehouse\": \"45907\",\n    \"zoneCode\": null,"
                + "\n    \"sendMailToReceiver\": true,\n    \"receiverId\": \"A238540\",\n    \"receiverName\": \"Gautham Nandigam Raju\","
                + "\n    \"sendMailToReceiverGroups\": false,\n    \"receiverGroups\": null\n}";
        return payload;

    }
    
    public static String POSTMaterialfromProcurelinesPayload() {
        String MTRID = CreateNewMaterialRequestTest.MTRID;
        
        String materialPayLoad = "{\n    \"id\": \""+materialID+"\",\n    \"version\": 2,\n    \"referenceId\": \"Test Object\","
                + "\n    \"quantity\": 12,\n    \"quantityInclusiveCancelled\": 12,\n    \"additionalQuantity\": 0,"
                + "\n    \"unitOfMeasure\": \"PCE\",\n    \"receiver\": null,\n    \"partNumber\": \""+partNumber+"\","
                + "\n    \"partVersion\": \"P02\",\n    \"partName\": \"BRACKET\",\n    \"partModification\": null,"
                + "\n    \"orderNo\": null,\n    \"requiredStaDate\": \""+ DateAfterSixMonths +"\",\n    \"buildId\": null,"
                + "\n    \"buildType\": \"FIRSTASSEMBLY\",\n    \"mtrlRequestVersion\": \""+MTRID+"\","
                + "\n    \"mtrlRequestType\": \"SINGLE\",\n    \"outboundStartDate\": \"" + Currentdate+ "\","
                + "\n    \"outboundLocationId\": \"PB054\",\n    \"contactPersonId\": \""+MCuserID+"\","
                + "\n    \"contactPersonName\": \""+userName+"\",\n    \"requesterUserId\": \""+MCuserID+"\","
                + "\n    \"requesterName\": \""+revUserName+"\",\n    \"partAffiliation\": \"V\","
                + "\n    \"functionGroup\": \"9531\",\n    \"designResponsible\": null,\n    \"itemToVariantLinkId\": 0,"
                + "\n    \"modularHarness\": null,\n    \"unitPrice\": 0,\n    \"currency\": null,"
                + "\n    \"pPartAffiliation\": \"V\",\n    \"pPartNumber\": \""+partNumber+"\",\n    \"pPartVersion\": \"P02\","
                + "\n    \"pPartName\": \"BRACKET\",\n    \"dfuObjectNumber\": null,\n    \"procureLineId\": "+procureLineID+","
                + "\n    \"procureLineStatus\": \"WAIT_TO_PROCURE\",\n    \"mark\": null,\n    \"mailFormId\": \"L8983833\","
                + "\n    \"changeAction\": null,\n    \"finalWhSiteId\": \"8374\",\n    \"materialType\": \"USAGE\","
                + "\n    \"modificationId\": 0,\n    \"modificationType\": null,\n    \"procurementQty\": 0,\n    \"projectId\": \"03-07417\","
                + "\n    \"referenceGroup\": null,\n    \"buildName\": null,\n    \"mtrlRequestId\": \""+mtrlRequestId+"\",\n    \"companyCode\": \"JP40\","
                + "\n    \"wbsCode\": \"L1G10-10210-03-01-01\",\n    \"costCenter\": \"0000010101\",\n    \"glAccount\": \"659261\","
                + "\n    \"internalOrderNoSAP\": null,\n    \"materialControllerUserId\": \""+MCuserID+"\","
                + "\n    \"materialControllerName\": \""+revUserName+"\",\n    \"deliveryControllerUserId\": null,"
                + "\n    \"deliveryControllerUserName\": null,\n    \"finalWhSiteNames\": [\n        null\n    ],"
                + "\n    \"procureType\": \"EXTERNAL\",\n    \"procureComment\": null,\n    \"requestType\": \"SINGLE\","
                + "\n    \"orderId\": 0,\n    \"migrated\": false,\n    \"procureRequestId\": null,\n    \"borrow\": false,"
                + "\n    \"reference\": \"111\",\n    \"purchaseInfo\": \"Information to purchase\","
                + "\n    \"warehouseComment\": \"Warehouse Comment\",\n    \"hsnCode\": null,\n    \"eccnCode\": null,"
                + "\n    \"deliveryInformationDTO\": null,\n    \"directSendAddressType\": \"NO\",\n    \"requestListIdsParentIdMap\": {},"
                + "\n    \"directSendRequiredDeliveryDate\": null,\n    \"qjId\": null,\n    \"pmrId\": \"PMR ID\",\n    \"tossId\": null,"
                + "\n    \"baseCurrency\": null,\n    \"countryOfOrigin\": null,\n    \"ppu\": 0,\n    \"totalValue\": 0,\n    \"discount\": 0,"
                + "\n    \"dangerousGoods\": false,\n    \"orderReference\": null,\n    \"infoToInternalProcurer\": null,\n    \"isRead\": true,"
                + "\n    \"alertPartVersion\": false\n}";
        
        return materialPayLoad;
        
    }
    public static String POSTProcurementPayload() {
        String MTRID = CreateNewMaterialRequestTest.MTRID;
        
        String orderStaDate = CommonLibrary.DateAfterSixMonths();
        OrderNumber = "O_" + MTRID;
        String procurePost = "{\n    \"id\": \""+procureLineID+"\",\n    \"version\": 2,\n    \"financeHeaderId\": "+financeHeaderId+","
                + "\n    \"financeHeaderVersion\": 1,\n    \"projectId\": \"03-07417\","
                + "\n    \"changeRequestIds\": \""+MTRID+"\",\n    \"materialRequestId\": null,"
                + "\n    \"mailFormIds\": \"L8983833\",\n    \"functionGroupId\": \"9531\","
                + "\n    \"functionGroupSuffix\": null,\n    \"dfuObjectNumber\": null,"
                + "\n    \"originatorId\": null,\n    \"originatorName\": null,"
                + "\n    \"originatorDepartment\": null,\n    \"criticality\": null,\n    \"issuerId\": null,"
                + "\n    \"issuerName\": null,\n    \"companyCode\": \"JP40\","
                + "\n    \"wbsCode\": \"L1G10-10210-03-01-01\",\n    \"costCenter\": \"0000010101\","
                + "\n    \"glAccount\": \"659261\",\n    \"internalOrderNoSAP\": null,"
                + "\n    \"procureResponsibility\": \"PROCURER\",\n    \"status\": \"WAIT_TO_PROCURE\","
                + "\n    \"warehouseComment\": \"Warehouse Comment\",\n    \"maxPrice\": null,"
                + "\n    \"pPartAffiliation\": \"V\",\n    \"pPartNumber\": \""+partNumber+"\","
                + "\n    \"pPartName\": \"BRACKET\",\n    \"pPartModification\": null,"
                + "\n    \"pPartVersion\": \"P02\",\n    \"requisitionId\": null,"
                + "\n    \"orderNo\": \""+OrderNumber+"\",\n    \"referenceGroups\": null,"
                + "\n    \"dangerousGoods\": \"1\",\n    \"procureType\": \"INTERNAL\","
                + "\n    \"buyerCode\": null,\n    \"buyerName\": null,\n    \"supplierCounterPartID\": \"9\","
                + "\n    \"requiredStaDate\": \""+DateAfterSixMonths+"\",\n    \"supplierId\": \"NEWSUPPLIER\","
                + "\n    \"supplierOid\": null,\n    \"supplierType\": null,\n    \"supplierName\": \"InternalSupplier\","
                + "\n    \"unitPrice\": 0,\n    \"currency\": null,\n    \"procureInfo\": \"Information to purchase\","
                + "\n    \"additionalQuantity\": 10,\n    \"referenceIds\": \"Test Object\","
                + "\n    \"needIsChanged\": false,\n    \"partAlias\": null,\n    \"qualityDocumentId\": null,"
                + "\n    \"usageQty\": 12,\n    \"procureForwardedId\": null,\n    \"procureForwardedName\": null,"
                + "\n    \"procureForwardedTeam\": null,\n    \"forwardedForDC\": false,\n    \"modularHarness\": null,"
                + "\n    \"purchaseOrganisationCode\": null,\n    \"purchaseOrganisationName\": null,"
                + "\n    \"forStock\": false,\n    \"referenceGps\": \"111\",\n    \"procureQty\": 12,"
                + "\n    \"orderStaDate\": \""+Currentdate+"\",\n    \"hasUnread\": false,"
                + "\n    \"procureFailureDate\": \"1970-01-01T01:00:00\",\n    \"procureCommmentExist\": false,"
                + "\n    \"unitOfPrice\": 1,\n    \"outboundLocationId\": null,\n    \"outboundLocationName\": null,"
                + "\n    \"fromStockQty\": 0,\n    \"fromStockProjectQty\": 0,\n    \"statusFlag\": \"Please Select\","
                + "\n    \"edited\": \"true\",\n    \"generalComment\": null,\n    \"borrow\": false,"
                + "\n    \"procureRequestId\": null,\n    \"updateForMailForm\": null,\n    \"materialUserId\": null,"
                + "\n    \"borrowFromStockQty\": 0,\n    \"borrowFromOrderPlacedQty\": 0,"
                + "\n    \"informationToPurchase\": \"Information to purchase\",\n    \"materialControllerId\": null,"
                + "\n    \"materialControllerName\": null,\n    \"materialController\": \"A238540-Nandigam Raju Gautham\","
                + "\n    \"partStatus\": null,\n    \"partAliasDomain\": null,\n    \"disableOutBoundLocation\": false,"
                + "\n    \"suffix\": null,\n    \"shipToId\": null,\n    \"qjIds\": null,\n    \"pmrIds\": \"PMR ID\","
                + "\n    \"tossIds\": null,\n    \"infoToInternalProcurer\": null,\n    \"spareTypeProcurement\": false,"
                + "\n    \"orderCancelled\": false\n}";
        return procurePost;
        
    }
}
