package com.example.demo.controller;

import com.example.demo.pdfbox.FRSGenerator;
import com.example.demo.pdfbox.FRSPDFVariables;
import com.example.demo.pdfbox.PDFGenerator;
import com.example.demo.pdfbox.Paragraph;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class HelloController {

    @GetMapping("/helloWorld")
    public String hellWorld() throws IOException {
//        new PDFGenerator().generate();
//        new PDFGenerator().generateV1();
//        new Paragraph().generate();
        new FRSGenerator().generate(generateAndUploadFRSDocument());
        return "Hello World!";
    }


    private HashMap<String, Object> generateAndUploadFRSDocument(){
        // Call LMS service to get Response at the time of integration
        HashMap<String, Object> frsPayload = new HashMap<>();
        HashMap<Integer, String> facilityType = new HashMap<>();
        HashMap<Integer, Object> repaymentSchedule = new HashMap<>();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        List<LookupValue> facilityCategory = new ArrayList<>();
        facilityCategory.add(new LookupValue(1, "Invoice Finacing AR(Disclosed)"));
        facilityCategory.add(new LookupValue(2, "Invoice Finacing AR(No Disclosed)"));
        facilityCategory.add(new LookupValue(3, "Purchase Order Financing"));
        facilityCategory.add(new LookupValue(4, "Working Capital Financing"));
        frsPayload.put(FRSPDFVariables.FACILITY_ID, 1234456);
        frsPayload.put(FRSPDFVariables.SME_NAME, "IMPEX MARINE (S) PTE LTD");
        frsPayload.put(FRSPDFVariables.SME_UEN, "1900089G");
        frsPayload.put(FRSPDFVariables.FUNDED_AMT, "S$ 80,000.00");
        frsPayload.put(FRSPDFVariables.TENURE_OFFERED, "3 (Months)");
        frsPayload.put(FRSPDFVariables.INTEREST_RATE, "2.50%, calculated per day basis");
        frsPayload.put(FRSPDFVariables.INTEREST_STRUCTURE, "Declining Balance");
        frsPayload.put(FRSPDFVariables.LATE_PAYMENT_FEES, "1.00% of outstanding installment due");
        frsPayload.put(FRSPDFVariables.FUNDING_FEE, "3.2100% of the Funded Amount (Inclusive of GST)");
        frsPayload.put(FRSPDFVariables.GENERATED_DATE, format.format(date));
        frsPayload.put(FRSPDFVariables.VALIDUS_AMT, "S$ 2,568.00");
        frsPayload.put(FRSPDFVariables.SME_AMT, " S$ 77,432.00");

        Iterator<LookupValue> iterator = facilityCategory.iterator();
        while (iterator.hasNext()) {
            LookupValue lkVal = iterator.next();
            facilityType.put(lkVal.getValueId(), lkVal.getDisplayName());
        }

        frsPayload.put(FRSPDFVariables.FACILITY_TYPE, facilityType);

        // TODO remove it and change logic based on API contract
        int[] utilArray = {1, 2, 3};

        PrimitiveIterator.OfInt iterator1 = Arrays.stream(utilArray).iterator();
        while (iterator1.hasNext()){
            Integer next = iterator1.next();
            String[] innerArray = new String[2];
            innerArray[0] = "28/11/2020";
            innerArray[1] = "S$ 28,010.97";
            repaymentSchedule.put(next, innerArray);
        }
        frsPayload.put(FRSPDFVariables.REPAYMENT_SCHEDULE, repaymentSchedule);
        frsPayload.put(FRSPDFVariables.CHECKED_PRODUCT_TYPE, 2789);

        return frsPayload;
    }



}
