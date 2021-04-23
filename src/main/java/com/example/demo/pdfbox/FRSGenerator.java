package com.example.demo.pdfbox;

import be.quodlibet.boxable.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FRSGenerator {

    public void generate(HashMap<String, Object> frsPayload) throws IOException {
        PDDocument doc = new PDDocument();
        pageOne(doc, frsPayload);
        pageTwo(doc, frsPayload);
        pageThree(doc, frsPayload);
        pageFour(doc, frsPayload);
        doc.save("src/main/resources/wwii-v1.pdf");
        doc.close();
    }


    public void pageOne(PDDocument doc, HashMap<String, Object> frsPayload) throws IOException {
        PDPage myPage = new PDPage();
        doc.addPage(myPage);
        PDRectangle mediabox = myPage.getMediaBox();
        float fontSize = 12;
        float leading = 1.5f * fontSize;
        float margin = 75;
        float width = mediabox.getWidth() - 2 * margin;
        float startX = mediabox.getLowerLeftX() + margin;
        float startY = mediabox.getUpperRightY() - margin;
        float yOffset = startY;
        PDType1Font font = PDType1Font.TIMES_ROMAN;
        PDType1Font fontBold = PDType1Font.TIMES_BOLD;
        PDPageContentStream cont = new PDPageContentStream(doc, myPage);
        float scale = 1f;
        PDImageXObject pdImage = PDImageXObject.createFromFile("src/main/resources/static/validus-new.png", doc);
        yOffset -= 40;
        cont.drawImage(pdImage, startX, startY, 200, 40);
        String text = "Terms defined and the rules of interpretation in the SMEs’ Terms and Conditions and " +
                "the Working Capital Financing Facility Terms and Conditions " +
                "have the same meaning and effect in this Facility Request " +
                "unless a different meaning is ascribed to it here.";

        cont.beginText();
        cont.setFont(fontBold, 15.0f);
        cont.newLineAtOffset(startX, yOffset);
        yOffset -= leading;
        cont.showText("FACILITY REQUEST");
        cont.newLineAtOffset(0, -leading);
        yOffset -= leading;
        Paragraph paragraph = new Paragraph();
        paragraph.addParagraph(cont, width, 0, -12, text, true, font);
        text = "The terms in this Facility Request shall be read together with the terms of the SMEs’ " +
                "Terms and Conditions. The terms of the SMEs’ Terms and " +
                "Conditions shall apply to this Facility Request as if set out herein mutatis mutandis .";
        paragraph.addParagraph(cont, width, 0, -12, text, true, font);
        text = "For the avoidance of doubt, the terms of the SMEs’ Terms and Conditions shall continue " +
                "to apply to us in our dealings through the Platform and " +
                "our Account.";
        paragraph.addParagraph(cont, width, 0, -12, text, true, font);
        drawPageOneTable(doc, myPage, frsPayload);
        cont.setFont(PDType1Font.TIMES_ROMAN, fontSize);
        cont.newLineAtOffset(startX, startY);
        yOffset -= leading;
        cont.setLeading(14.5f);
        cont.newLine();
        cont.endText();
        cont.close();
    }


    public void pageTwo(PDDocument doc, HashMap<String, Object> frsPayload) throws IOException {
        PDPage myPage = new PDPage();
        doc.addPage(myPage);
        PDRectangle mediabox = myPage.getMediaBox();
        float fontSize = 12;
        float leading = 1.5f * fontSize;
        float margin = 75;
        float width = mediabox.getWidth() - 2 * margin;
        float startX = mediabox.getLowerLeftX() + margin;
        float startY = mediabox.getUpperRightY() - margin;
        float yOffset = startY;
        PDPageContentStream cont = new PDPageContentStream(doc, myPage);
        PDType1Font font = PDType1Font.TIMES_ROMAN;
        PDType1Font fontBold = PDType1Font.TIMES_BOLD;
        yOffset = startY;
        PDImageXObject pdImage = PDImageXObject.createFromFile("src/main/resources/static/validus-new.png", doc);
        yOffset -= 2;
        cont.drawImage(pdImage, startX, startY, 200, 40);
        String text = "Important Information for Loan Repayments";
        cont.beginText();
        cont.setFont(fontBold, 15.0f);
        cont.newLineAtOffset(startX, yOffset);
        yOffset -= leading;
        cont.newLineAtOffset(0, -leading);
        Paragraph paragraph = new Paragraph();
        paragraph.addParagraph(cont, width, 0, -12, text, true, font);
        cont.endText();
        cont.beginText();
        cont.setFont(fontBold, 15.0f);
        cont.newLineAtOffset(startX, yOffset);
        yOffset -= leading;
        cont.newLineAtOffset(0, -leading);

        text = "Please note that for your convenience, Validus offers the following repayment options: Via 1) electronic funds transfer, or 2) cheque";
        paragraph.addParagraph(cont, width, 0, -12, text, true, font);

        text = "1) To make loan repayments via electronic funds transfer,please transfer to:";
        paragraph.addParagraph(cont, width, 0, -12, text, true, font);

        text = "Bank Name: DBS";
        paragraph.addParagraph(cont, width, 40, -12, text, true, font);

        text = "Account Name:Vistra Corporate Trust - Validus Capita";
        paragraph.addParagraph(cont, width, 0, -0, text, true, font);

        text = "Account Number:(your unique Validus Client Account Number 'VAN') ";
        paragraph.addParagraph(cont, width, 0, -0, text, true, font);

        text = "Bank Code:7171";
        paragraph.addParagraph(cont, width, 0, -0, text, true, font);

        text = "Branch Code:003";
        paragraph.addParagraph(cont, width, 0, -0, text, true, font);


        text = "2) For loan repayments via cheque deposit,please:";
        paragraph.addParagraph(cont, width, -40, -12, text, true, font);

        text = "Make payable to:Vistra Corporate Trust - Validus Capital";
        paragraph.addParagraph(cont, width, 40, -12, text, true, font);

        text = "Payee’s Account Number:003 952 668";
        paragraph.addParagraph(cont, width, 0, -0, text, true, font);

        text = "And, write your assigned ‘VAN:885-022-00225856 on the reverse of the cheque ";
        paragraph.addParagraph(cont, width, 0, -0, text, true, font);

        text = "We, IMPEX MARINE (S) PTE LTD agree:";
        paragraph.addParagraph(cont, width, -40, -12, text, true, font);

        text = "1. to be irrevocably bound by the SMEs’ Terms and Conditions and the terms of the SMEs’ " +
                "Working Capital Financing Facility Terms andConditions " +
                "attached herein and understand that these will apply to this Facility";
        paragraph.addParagraph(cont, width, 10, -7, text, true, font);

        text = "2. that  the  Funded  Amount  will  not  be  disbursed  to  us  until  and  unless  we  duly  " +
                "execute,  or  arrange  to  be  duly  executed,  and  deliver  to " +
                "Validus  the  relevant  security  documents  or  guarantees  (including,  without  " +
                "limitation,  those  set  out  above)  which  Validus  requires  us  to "
                + "execute (or arrange to be executed) and deliver";
        paragraph.addParagraph(cont, width, 0, -0, text, true, font);

        text = "3. that the Funded Amount once disbursed to us by Validus as agent for " +
                "certain Investors shall constitute a debt owing by us to Validus as " +
                "agent for such Investors, with such debt being due in accordance with the above, the SMEs’ Terms and Conditions and the terms of the"
                + "SMEs’ Working Capital Financing Facility Terms and Conditions";
        paragraph.addParagraph(cont, width, 0, -0, text, true, font);

        text = "4. that this is not a committed facility";
        paragraph.addParagraph(cont, width, 0, -0, text, true, font);

        text = "5. that Validus may apply the Funded Amount in satisfaction of any other Facility the SME has with Validus as " +
                "agent for Investors such that the actual amount received by us is less than the Funded Amount and " +
                "not withstanding this deduction, we remain liable to repay the full" + "Funded Amount (including applicable interests); and ";
        paragraph.addParagraph(cont, width, 0, -0, text, true, font);

        text = "6. to make payment of such debt in accordance to this Facility Request and upon receipt of a written demand by Validus acting as agent for " +
                "such  Investors,  at  any  time  in  accordance  with  the  terms  above,  the  SMEs’  " +
                "Terms  and  Conditions  and  the  SMEs’  Working  Capital" +
                "Financing Facility Terms and Conditions.";
        paragraph.addParagraph(cont, width, 0, -0, text, true, font);

        text = "We confirm:";
        paragraph.addParagraph(cont, width, -10, -12, text, true, font);

        text = "1. that the information set out in our Account profile and our previously submitted business " +
                "profile and constitutional documents remain true," + "accurate and correct";
        paragraph.addParagraph(cont, width, 10, -0, text, true, font);


        text = "2. the  accuracy,  authenticity  and  completeness  of  all  the  documents  and  information  submitted  " +
                "with  our  corresponding  Facility  Application " +
                "and such document and information is most current and up-to-date";
        paragraph.addParagraph(cont, width, 0, -0, text, true, font);

        text = "3. that the borrowing the Funded Amount would not breach or exceed any limit binding on us";
        paragraph.addParagraph(cont, width, 0, -0, text, true, font);


        text = "4. that no liquidation or dissolution proceedings with respect to us have been commenced " +
                "by any person or are intended or anticipated by us " +
                "and  no  order  or  resolution  for  the  winding  up  of  the  SME  has,  to  the  " +
                "best  of  our  knowledge  and  belief  having  made  all  reasonable" +
                "enquiries, been made, proposed or threatened";
        paragraph.addParagraph(cont, width, 0, -0, text, true, font);


        text =
                "5. that no appointment or notice of appointment of a receiver or judicial manager of the SME or any of its assets or property has been made"
                        + "or given or, to the best of our knowledge and belief having made reasonable enquiries, been proposed or threatened";
        paragraph.addParagraph(cont, width, 0, -0, text, true, font);
        text =
                "6. no Default is outstanding or would result from the SME receiving any Funded Amount";
        paragraph.addParagraph(cont, width, 0, -0, text, true, font);
        text =
                "7. that  there  has  been  no  material  adverse  change  or  prospective  material  adverse  change  in  the  status,  business,  assets,  conditions"
                        + "(financial or otherwise), operations, prospects or operating results of the SME.";
        paragraph.addParagraph(cont, width, 0, -0, text, true, font);
        cont.endText();
        cont.close();
    }

    public void pageThree(PDDocument doc, HashMap<String, Object> frsPayload) throws IOException {
        PDPage myPage = new PDPage();
        doc.addPage(myPage);
        PDRectangle mediabox = myPage.getMediaBox();
        float fontSize = 12;
        float leading = 1.5f * fontSize;
        float margin = 75;
        float width = mediabox.getWidth() - 2 * margin;
        float startX = mediabox.getLowerLeftX() + margin;
        float startY = mediabox.getUpperRightY() - margin;
        float yOffset = startY;
        PDType1Font font = PDType1Font.TIMES_ROMAN;
        PDType1Font fontBold = PDType1Font.TIMES_BOLD;
        PDPageContentStream cont = new PDPageContentStream(doc, myPage);

        float scale = 1f;
        PDImageXObject pdImage = PDImageXObject.createFromFile("src/main/resources/static/validus-new.png", doc);
        yOffset -= 2;

        cont.drawImage(pdImage, startX, startY, 200, 40);
        String text = "We further undertake to Validus";
        cont.beginText();
        cont.setFont(fontBold, 15.0f);
        cont.newLineAtOffset(startX, yOffset);
        cont.newLineAtOffset(0, -leading);

        Paragraph paragraph = new Paragraph();
        paragraph.addParagraph(cont, width, -10, -12, text, true, font);


        text = "1. to provide Validus a full set of our management accounts within six (6) weeks of the end of each calendar quarter unless otherwise notified"
                + "by Validus";
        paragraph.addParagraph(cont, width, 10, -0, text, true, font);

        text = "2. not to transact, assign or create any Security over any assets of the SME without Validus’s prior written consent in our Facility Application and";
        paragraph.addParagraph(cont, width, 0, -0, text, true, font);

        text = "3. to, upon request by Validus, provide Validus with our monthly reconciliation of our accounts.";
        paragraph.addParagraph(cont, width, 0, -0, text, true, font);

        text = "Please make this disbursement to the following accounts:";
        paragraph.addParagraph(cont, width, -10, -15, text, true, font);

        text = "S$ 2,568.00to Validus’ account:";
        paragraph.addParagraph(cont, width, 15, -2, text, true, fontBold);

        text = "Account Name: Validus Capital Pte. Ltd";
        paragraph.addParagraph(cont, width, 15, -0, text, true, font);

        text = "Bank Name: DBS SingaporeBank ";
        paragraph.addParagraph(cont, width, 0, -0, text, true, font);

        text = "Account No.: 003-953413-2";
        paragraph.addParagraph(cont, width, 0, -0, text, true, font);

        text = "Swift code: DBSSSGSG";
        paragraph.addParagraph(cont, width, 0, -0, text, true, font);

        text = "DBS Bank Ltd, 12 Marina Boulevard, DBS Asia Central, Marina Bay Financial Centre Tower 3";
        paragraph.addParagraph(cont, width, 0, -0, text, true, font);

        text = " S$ 77,432.00to SME’s account:";
        paragraph.addParagraph(cont, width, -15, -10, text, true, fontBold);

        text = "Account Name: IMPEX MARINE (S) PTE LTD";
        paragraph.addParagraph(cont, width, 15, -0, text, true, font);

        text = "Bank Name: DBS";
        paragraph.addParagraph(cont, width, 0, -0, text, true, font);

        text = "Bank Account No.: 033-006161-7";
        paragraph.addParagraph(cont, width, 0, -0, text, true, font);


        text = "In the presence of:";
        paragraph.addParagraph(cont, width, 250, -170, text, true, font);

        cont.endText();
        float signatureWidth = 150;
        yOffset = 250;

        drawLine(cont, startX, yOffset, startX + signatureWidth, 1);
        drawLine(cont, startX + 250, yOffset, 250 + startX + signatureWidth, 1);

        cont.beginText();
        cont.setFont(fontBold, 15.0f);
        cont.newLineAtOffset(startX, yOffset);

        text = "Signature and Company Stamp";
        paragraph.addParagraph(cont, width, 0, -10, text, true, fontBold);

        text = "This document is generated on 27/10/2020 for Facility ID: 20932";
        paragraph.addParagraph(cont, width, 250, 10, text, true, font);


        text = "This document is generated on 27/10/2020 for Facility ID: 20932";
        paragraph.addParagraph(cont, width, -250, -10, text, true, font);

        text = "Name : ";
        paragraph.addParagraph(cont, width, 250, 10, text, true, font);

        text = "Name: ";
        paragraph.addParagraph(cont, width, -250, -10, text, true, font);

        text = "Identification number: ";
        paragraph.addParagraph(cont, width, 250, 10, text, true, font);

        text = "Designation:";
        paragraph.addParagraph(cont, width, -250, -10, text, true, font);

        text = (String) frsPayload.get(FRSPDFVariables.SME_NAME);
        paragraph.addParagraph(cont, width, 0, -10, text, true, font);

        text = String.format("Date: %s", frsPayload.get(FRSPDFVariables.GENERATED_DATE));
        paragraph.addParagraph(cont, width, 0, -10, text, true, font);

        cont.endText();


        cont.close();
    }

    public void pageFour(PDDocument doc, HashMap<String, Object> frsPayload) throws IOException {
        PDPage myPage = new PDPage();
        doc.addPage(myPage);
        PDRectangle mediabox = myPage.getMediaBox();
        float fontSize = 12;
        float leading = 1.5f * fontSize;
        float margin = 75;
        float width = mediabox.getWidth() - 2 * margin;
        float startX = mediabox.getLowerLeftX() + margin;
        float startY = mediabox.getUpperRightY() - margin;
        float yOffset = startY;
        PDType1Font font = PDType1Font.TIMES_ROMAN;
        PDType1Font fontBold = PDType1Font.TIMES_BOLD;
        PDPageContentStream cont = new PDPageContentStream(doc, myPage);

        float scale = 1f;
        PDImageXObject pdImage = PDImageXObject.createFromFile("src/main/resources/static/validus-new.png", doc);
        yOffset -= 2;

        cont.drawImage(pdImage, startX, startY, 200, 40);

        String text = "SCHEDULE";
        cont.beginText();
        cont.setFont(fontBold, 15.0f);
        cont.newLineAtOffset(startX, yOffset);
        cont.newLineAtOffset(0, -leading);

        Paragraph paragraph = new Paragraph();
        paragraph.addParagraph(cont, width, 0, -12, text, true, font);

        text =  text = String.format("Funding Date: %s", frsPayload.get(FRSPDFVariables.GENERATED_DATE));
        paragraph.addParagraph(cont, width, 0, -12, text, true, font);

        cont.endText();

        drawPageFourTable(doc, myPage, frsPayload);


        cont.close();

    }

    private void drawLine(PDPageContentStream cont, float startX, float startY, float lineEndPoint, float lineWidth) throws IOException {
        //begin to draw our line
        cont.setLineWidth(lineWidth);
        cont.moveTo(startX, startY + -2);
        cont.lineTo(lineEndPoint, startY + -2);
        cont.stroke();
    }


    private void drawPageThreeTable(PDDocument doc, PDPage myPage2) throws IOException {

        float margin = 75;
        float yStartNewPage = myPage2.getMediaBox().getHeight() - (2 * margin);
        float tableWidth = myPage2.getMediaBox().getWidth() - (2 * margin);

        boolean drawContent = true;
        float yStart = yStartNewPage;
        float bottomMargin = 70;
        float yPosition = 550;

        BaseTable table =
                new BaseTable(yPosition, yStartNewPage, bottomMargin, tableWidth,
                        margin, doc, myPage2, true, drawContent);

        float defaultRowHeight = 28f;

        Row<PDPage> headerRow = table.createRow(defaultRowHeight);
        Cell<PDPage> cell = headerRow.createCell(50, "<b>Facility ID :</b>");
        //        cell.setBorderStyle(null);
        cell.setValign(VerticalAlignment.MIDDLE);
        cell = headerRow.createCell(50, "<b>20932</b>");
        cell.setValign(VerticalAlignment.MIDDLE);
        table.addHeaderRow(headerRow);

        Row<PDPage> row = table.createRow(defaultRowHeight);
        cell = row.createCell(50, "<b>Name of SME :</b> IMPEX MARINE (S) PTE LTD");
        cell = row.createCell(50, "<b>UEN</b>: 1900089G ");
    }

    private void drawPageOneTable(PDDocument doc, PDPage myPage, HashMap<String, Object> frsPayload) throws IOException {

        float margin = 75;
        //Dummy Table
        // starting y position is whole page height subtracted by top and bottom margin
        float yStartNewPage = myPage.getMediaBox().getHeight() - (2 * margin);
        // we want table across whole page width (subtracted by left and right margin ofcourse)
        float tableWidth = myPage.getMediaBox().getWidth() - (2 * margin);

        boolean drawContent = true;
        float yStart = yStartNewPage;
        float bottomMargin = 70;
        // y position is your coordinate of top left corner of the table
        float yPosition = 550;

        BaseTable table =
                new BaseTable(yPosition, yStartNewPage, bottomMargin, tableWidth,
                        margin, doc, myPage, true, drawContent);

        float defaultRowHeight = 28f;

        Row<PDPage> headerRow = table.createRow(defaultRowHeight);
        Cell<PDPage> cell = headerRow.createCell(50, "<b>Facility ID :</b>");
        //        cell.setBorderStyle(null);
        cell.setValign(VerticalAlignment.MIDDLE);
        cell = headerRow.createCell(50, String.format("<b>%s</b>", frsPayload.get(FRSPDFVariables.FACILITY_ID)));
        cell.setValign(VerticalAlignment.MIDDLE);
        table.addHeaderRow(headerRow);

        Row<PDPage> row = table.createRow(defaultRowHeight);
        cell = row.createCell(50, String.format("<b>Name of SME :</b> %s", frsPayload.get(FRSPDFVariables.SME_NAME)));
        cell = row.createCell(50, String.format("<b>UEN</b>: %s ", frsPayload.get("uen")));

        HashMap<Integer, String> facilityType = (HashMap<Integer, String>) frsPayload.get(FRSPDFVariables.FACILITY_TYPE);

        Row<PDPage> productTypeRow = table.createRow(50);
        StringBuilder str = new StringBuilder();
        str.append("<b>Type of Facility Application:</b><br><br>");
        for (Map.Entry<Integer, String> entry : facilityType.entrySet()) {
            str.append(entry.getValue());
            str.append("<br><br>");
        }
        cell = productTypeRow.createCell(100, str.toString());

        HashMap<String, String> tableRawData = new HashMap<>();
        tableRawData.put(  "<b>Funded Amount:</b>", (String) frsPayload.get(FRSPDFVariables.FUNDED_AMT));
        tableRawData.put("<b>Tenure Offered:</b>", (String) frsPayload.get(FRSPDFVariables.TENURE_OFFERED));
        tableRawData.put("<b>Tenure of Facility:</b>", "The Facility shall be repaid by us in accordance with the Schedule annexed.");
        tableRawData.put("<b>Interest Rate (per month):</b>", (String) frsPayload.get(FRSPDFVariables.INTEREST_RATE));
        tableRawData.put("<b>Interest Structure*: </b>", (String) frsPayload.get(FRSPDFVariables.INTEREST_STRUCTURE));
        tableRawData.put("<b>Late Payment Fee: </b>", (String) frsPayload.get(FRSPDFVariables.LATE_PAYMENT_FEES));
        tableRawData.put("<b>Funding Fee:: </b>", (String) frsPayload.get(FRSPDFVariables.FUNDING_FEE));
        for (Map.Entry<String, String> entry : tableRawData.entrySet()) {
            Row<PDPage> rowEntry = table.createRow(defaultRowHeight);
            cell = rowEntry.createCell(50, entry.getKey());
            cell = rowEntry.createCell(50, entry.getValue());
        }

        table.draw();

        //TODO - find position dynamically
        yPosition = 200;

        BaseTable guaranteeTable =
                new BaseTable(yPosition, yStartNewPage, bottomMargin, tableWidth,
                        margin, doc, myPage, true, drawContent);
        Row<PDPage> guaranteeRow = guaranteeTable.createRow(35);
        StringBuilder guaranteeTextBuilder = new StringBuilder();
        guaranteeTextBuilder.append("<b>Guarantee</b><br><br>");
        guaranteeTextBuilder.append(
                "A joint and several Personal Guarantee granted by each of our directors in favour of Validus Capital Pte. Ltd. as agent for certain Investors (<b>Validus</b>).");
        Cell<PDPage> guaranteeRowCell =
                guaranteeRow.createCell(100, guaranteeTextBuilder.toString());
        guaranteeTable.draw();
    }


    private void drawPageFourTable(PDDocument doc, PDPage myPage, HashMap<String, Object> frsPayload) throws IOException {
        float margin = 75;
        float yStartNewPage = myPage.getMediaBox().getHeight() - (2 * margin);
        float tableWidth = myPage.getMediaBox().getWidth() - (2 * margin);
        boolean drawContent = true;
        float bottomMargin = 70;
        float yPosition = 650;
        BaseTable table = new BaseTable(yPosition, yStartNewPage, bottomMargin, tableWidth, margin, doc, myPage, true, drawContent);

        float defaultRowHeight = 28f;

        Row<PDPage> headerRow = table.createRow(defaultRowHeight);
        Cell<PDPage> cell = headerRow.createCell(50, "<b>Repayment Dates</b>");
        //        cell.setBorderStyle(null);
        cell.setValign(VerticalAlignment.MIDDLE);
        cell.setAlign(HorizontalAlignment.CENTER);
        cell = headerRow.createCell(50, "<b>Amount payable on corresponding repayment date</b>");
        cell.setValign(VerticalAlignment.MIDDLE);
        cell.setAlign(HorizontalAlignment.CENTER);
        table.addHeaderRow(headerRow);

//        HashMap<String, String> tableRawData = new HashMap<>();
//        tableRawData.put("27/11/2020", "S$ 28,010.97");
//        tableRawData.put("28/11/2020", "S$ 28,010.97");
//        tableRawData.put("29/11/2020", "S$ 28,010.97");


        HashMap<Integer, Object> repaymentSchedule = (HashMap<Integer, Object>) frsPayload.get(FRSPDFVariables.REPAYMENT_SCHEDULE);


        for (Map.Entry<Integer, Object> entry : repaymentSchedule.entrySet()) {
            String[] repaymentValues = (String[]) entry.getValue();
            Row<PDPage> row = table.createRow(defaultRowHeight);

            for(int i = 0; i < repaymentValues.length; i++){
                cell =row.createCell(50, repaymentValues[i]);
                cell.setValign(VerticalAlignment.MIDDLE);
                cell.setAlign(HorizontalAlignment.CENTER);
            }


//            Row<PDPage> row = table.createRow(defaultRowHeight);
//            cell =row.createCell(50, entry.getKey());
//            cell.setValign(VerticalAlignment.MIDDLE);
//            cell.setAlign(HorizontalAlignment.CENTER);
//            cell = row.createCell(50, entry.getValue());
//            cell.setValign(VerticalAlignment.MIDDLE);
//            cell.setAlign(HorizontalAlignment.CENTER);
        }



        table.draw();

    }
}
