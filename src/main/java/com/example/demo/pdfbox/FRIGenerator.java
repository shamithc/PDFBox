package com.example.demo.pdfbox;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.Cell;
import be.quodlibet.boxable.HorizontalAlignment;
import be.quodlibet.boxable.Row;
import be.quodlibet.boxable.VerticalAlignment;
import java.awt.Color;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class FRIGenerator {

  public void generate() throws IOException {

    PDDocument doc = new PDDocument();
    pageOne(doc);
    pageTwo(doc);
    pageThree(doc);
    pageFour(doc);
    doc.save("src/main/resources/fri.pdf");
    doc.close();
  }

  private void pageOne(PDDocument doc) throws IOException {
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
    logoCreation(doc, cont, startX, startY);
    yOffset -= 40;
    createHeading(cont, fontBold, startX, yOffset, leading);
    createContent(cont, width, font);
    drawPageOneTable(doc, myPage);
    cont.close();
  }

  private void pageTwo(PDDocument doc) throws IOException {
    PDPage myPage = new PDPage();
    doc.addPage(myPage);
    PDRectangle mediabox = myPage.getMediaBox();
    float margin = 75;
    float startX = mediabox.getLowerLeftX() + margin;
    float startY = mediabox.getUpperRightY() - margin;
    float width = mediabox.getWidth() - 2 * margin;
    PDType1Font fontBold = PDType1Font.TIMES_BOLD;
    PDType1Font font = PDType1Font.TIMES_ROMAN;
    float yOffset = startY;
    PDPageContentStream cont = new PDPageContentStream(doc, myPage);
    logoCreation(doc, cont, startX, startY);
    yOffset -= 40;
    drawPageTwoTable(doc, myPage);
    float fontSize = 12;
    float leading = 1.5f * fontSize;
    createComment(doc, myPage);
    additionalInfoTable(doc, myPage);
    smeInfoTable(doc, myPage);
    smeFacilityInfo(doc, myPage);
    cont.close();
  }

  private void pageThree(PDDocument doc) throws IOException {
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
    logoCreation(doc, cont, startX, startY);
    yOffset -= 40;
    drawPageThreeTable(doc, myPage);
    cont.close();
  }

  private void drawPageThreeTable(PDDocument doc, PDPage myPage)
      throws IOException {
    float margin = 75;
    float yStartNewPage = myPage.getMediaBox().getHeight() - (2 * margin);
    float tableWidth = myPage.getMediaBox().getWidth() - (2 * margin);
    boolean drawContent = true;
    float yStart = yStartNewPage;
    float bottomMargin = 70;
    float yPosition = 700;
    BaseTable table =
        new BaseTable(yPosition, yStartNewPage, bottomMargin, tableWidth,
            margin, doc, myPage, true, drawContent);
    float defaultRowHeight = 24f;
    Row<PDPage> headerRow = table.createRow(defaultRowHeight);
    Cell<PDPage> cell = headerRow.createCell(100,
        "<b>History of SME funding with Validus</b><br><br><br>"
            + "<b>Closed Facilities:</b><br><br><br>"
            + "<b>First facility funded on 27/2/2020</b><br><br>"
            + "<b>SGD 349,300 funded and repaid over 10 facilities.</b><br><br>"
            + "<b>Open Facilities:</b>");

    cell.setTopBorderStyle(null);
    cell.setValign(VerticalAlignment.MIDDLE);
    cell.setBottomPadding((float) 340);

    float margin1 = 75 + 5;
    float yStartNewPage1= myPage.getMediaBox().getHeight() - (4 * margin);
    float tableWidth1 = myPage.getMediaBox().getWidth() - (2 * margin) - 5;
    boolean drawContent1 = true;
    float yStart1 = yStartNewPage;
    float bottomMargin1 = 70;
    float yPosition1 = 600;

    BaseTable innertable1 =
        new BaseTable(yPosition1, yStartNewPage1, bottomMargin1, tableWidth1,
            margin1, doc, myPage, true, drawContent1);
    float innerDefaultRowHeight = 24f;
    Row<PDPage> rowEntry2 = innertable1.createRow(innerDefaultRowHeight);
    cell = rowEntry2.createCell(25, "<b>Fac. #</b>");
    cell =
        rowEntry2.createCell(25, "<b>Funded amount<br>(SGD)</b>");
    cell =
        rowEntry2.createCell(25, "<b>Repayment date</b>");
    cell =
        rowEntry2.createCell(22, "<b>Repayment status</b>");
    Row<PDPage> rowEntry3 = innertable1.createRow(innerDefaultRowHeight);
    cell = rowEntry3.createCell(25, "20102");
    cell =
        rowEntry3.createCell(25, "7,200.00");
    cell =
        rowEntry3.createCell(25, "18/01/2021");
    cell =
        rowEntry3.createCell(22, "Not yet Due");
    Row<PDPage> rowEntry4 = innertable1.createRow(innerDefaultRowHeight);
    cell = rowEntry4.createCell(25, "20285");
    cell =
        rowEntry4.createCell(25, "16,500.00");
    cell =
        rowEntry4.createCell(25, "04/02/2021");
    cell =
        rowEntry4.createCell(22, "Not yet Due");
    Row<PDPage> rowEntry5 = innertable1.createRow(innerDefaultRowHeight);
    cell = rowEntry5.createCell(25, "20351");
    cell =
        rowEntry5.createCell(25, "16,900.00");
    cell =
        rowEntry5.createCell(25, "10/12/2020");
    cell =
        rowEntry5.createCell(22, "Not yet Due");
    Row<PDPage> rowEntry6 = innertable1.createRow(innerDefaultRowHeight);
    cell = rowEntry6.createCell(25, "20352");
    cell =
        rowEntry6.createCell(25, "2,800.00");
    cell =
        rowEntry6.createCell(25, "10/12/2020");
    cell =
        rowEntry6.createCell(22, "Not yet Due");
    Row<PDPage> rowEntry7 = innertable1.createRow(innerDefaultRowHeight);
    cell = rowEntry7.createCell(25, "20374");
    cell =
        rowEntry7.createCell(25, "55,700.00");
    cell =
        rowEntry7.createCell(25, "18/02/2021");
    cell =
        rowEntry7.createCell(22, "Not yet Due");
    Row<PDPage> rowEntry8 = innertable1.createRow(innerDefaultRowHeight);
    cell = rowEntry8.createCell(25, "20553");
    cell =
        rowEntry8.createCell(25, "48,800.00");
    cell =
        rowEntry8.createCell(25, "28/02/2021");
    cell =
        rowEntry8.createCell(22, "Not yet Due");
    Row<PDPage> rowEntry9 = innertable1.createRow(innerDefaultRowHeight);
    cell = rowEntry9.createCell(25, "20679");
    cell =
        rowEntry9.createCell(25, "9,200.0");
    cell =
        rowEntry9.createCell(25, "06/01/2021");
    cell =
        rowEntry9.createCell(22, "Not yet Due");
    Row<PDPage> rowEntry10 = innertable1.createRow(30);
  cell = rowEntry10.createCell(100,
        "<b>Repayment Schedule</b>");
    cell.setBorderStyle(null);
    cell.setAlign(HorizontalAlignment.LEFT);
    innertable1.draw();
    tenureTable(doc,myPage);
    Row<PDPage> headerRow2 = table.createRow(defaultRowHeight);
    cell = headerRow2.createCell(100,
        "<b>This Facility Request is governed by Singapore laws.</b>");
    cell.setValign(VerticalAlignment.MIDDLE);
    table.addHeaderRow(headerRow);
    table.draw();
  }


  private void tenureTable(PDDocument doc, PDPage myPage) throws IOException {

    float margin1 = 75 + 5;
    float yStartNewPage1= myPage.getMediaBox().getHeight() - (4 * margin1);
    float tableWidth1 = myPage.getMediaBox().getWidth() - (2 * margin1) - 5;
    boolean drawContent1 = true;
    float yStart1 = yStartNewPage1;
    float bottomMargin1 = 70;
    float yPosition1 = 380;

    BaseTable table =
        new BaseTable(yPosition1, yStartNewPage1, bottomMargin1, tableWidth1,
            margin1, doc, myPage, true, drawContent1);
    float defaultRowHeight = 24f;
    Row<PDPage> headerRow = table.createRow(defaultRowHeight);
    Cell<PDPage>  cell = headerRow.createCell(16, "<b>Tenure</b>");
    cell =
        headerRow.createCell(16, "<b>Principal<br>(SGD</b>");
    cell =
        headerRow.createCell(16, "<b>Interest -<br>Total (SGD)</b>");
    cell =
        headerRow.createCell(16, "<b>Validus commission<br>(Inclusive of GST)(SGD</b>");
    cell =
        headerRow.createCell(16, "<b>Net Interest to<br>Investor (SGD</b>");
    cell =
        headerRow.createCell(21, "<b>Total<br>(SGD</b>");
    Row<PDPage> row1 = table.createRow(defaultRowHeight);
    cell = row1.createCell(16, "150<br>Days");
    cell =
        row1.createCell(16, "76,600.0");
    cell =
        row1.createCell(16, "7,660.00");
    cell =
        row1.createCell(16, "1,639.24");
    cell =
        row1.createCell(16, "6,020.76");
    cell =
        row1.createCell(21, "82,620.76");
    Row<PDPage> row2 = table.createRow(defaultRowHeight);
    cell = row2.createCell(100,
        "<b>Important information on Validus Invoice Financing and this Facility Request</b>");
    cell.setValign(VerticalAlignment.MIDDLE);
    cell.setTextColor(Color.blue);
    cell.setBottomBorderStyle(null);
    cell.setRightBorderStyle(null);
    cell.setLeftBorderStyle(null);
    table.addHeaderRow(headerRow);
    table.draw();
  }

  private void pageFour(PDDocument doc) throws IOException {
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
    logoCreation(doc, cont, startX, startY);
    yOffset -= 40;
    drawPageFourTable(doc, myPage);
    cont.close();
  }

  private void createComment(PDDocument doc, PDPage myPage) throws IOException {
    float margin = 75;
    float yStartNewPage = myPage.getMediaBox().getHeight() - (2 * margin);
    float tableWidth = myPage.getMediaBox().getWidth() - (2 * margin);
    boolean drawContent = true;
    float yStart = yStartNewPage;
    float bottomMargin = 70;
    float yPosition = 590;
    BaseTable table =
        new BaseTable(yPosition, yStartNewPage, bottomMargin, tableWidth,
            margin, doc, myPage, true, drawContent);
    float defaultRowHeight = 24f;
    Row<PDPage> headerRow = table.createRow(defaultRowHeight);
    Cell<PDPage> cell = headerRow.createCell(100,
        "*Declining interest structure - Interest accrual on the outstanding principal");
    cell.setBorderStyle(null);
    table.addHeaderRow(headerRow);
    table.draw();
  }

  private void drawPageFourTable(PDDocument doc, PDPage myPage)
      throws IOException {

    float margin = 75;
    float yStartNewPage = myPage.getMediaBox().getHeight() - (2 * margin);
    float tableWidth = myPage.getMediaBox().getWidth() - (2 * margin);
    boolean drawContent = true;
    float yStart = yStartNewPage;
    float bottomMargin = 70;
    float yPosition = 700;
    BaseTable table =
        new BaseTable(yPosition, yStartNewPage, bottomMargin, tableWidth,
            margin, doc, myPage, true, drawContent);
    float defaultRowHeight = 24f;
    Row<PDPage> headerRow = table.createRow(defaultRowHeight);
    Cell<PDPage> cell = headerRow.createCell(100,
        "<b>ANECAN ENGINEERING SERVICES PTE. LTD</b>");
    cell.setValign(VerticalAlignment.MIDDLE);
    Row<PDPage> rowEntry = table.createRow(defaultRowHeight);
    cell = rowEntry.createCell(25, "<b>Key financial indicators from"
        + "financial statements (as"
        + "disclosed by SME)</b>");
    cell =
        rowEntry.createCell(25, "<b>FY2019" + "FINANCIALS" + "31-12-2020</b>");
    cell =
        rowEntry.createCell(25, "<b>FY2018" + "FINANCIALS" + "31-12-2019</b>");
    cell =
        rowEntry.createCell(25, "<b>FY2017" + "FINANCIALS" + "31-12-2018</b>");
    Row<PDPage> rowEntry1 = table.createRow(defaultRowHeight);
    cell = rowEntry1.createCell(100, "");
    Row<PDPage> rowEntry2 = table.createRow(defaultRowHeight);
    cell = rowEntry2.createCell(25, "<b>Revenue</b>");
    cell =
        rowEntry2.createCell(25, "$3,384,885.00");
    cell =
        rowEntry2.createCell(25, "$762,829.00");
    cell =
        rowEntry2.createCell(25, "$363,362.00");
    Row<PDPage> rowEntry3 = table.createRow(defaultRowHeight);
    cell = rowEntry3.createCell(25, "<b>COGS & Others Expenses</b>");
    cell =
        rowEntry3.createCell(25, "$3,073,480.00");
    cell =
        rowEntry3.createCell(25, "$687,750.00");
    cell =
        rowEntry3.createCell(25, "$491,599.0");
    Row<PDPage> rowEntry4 = table.createRow(defaultRowHeight);
    cell = rowEntry4.createCell(25,
        "<b>Net Ordinary/Comprehensive" + "Income</b>");
    cell =
        rowEntry4.createCell(25, "$311,405.00");
    cell =
        rowEntry4.createCell(25, "$75,079.00");
    cell =
        rowEntry4.createCell(25, "($128,237.00 )");
    Row<PDPage> rowEntry5 = table.createRow(defaultRowHeight);
    cell = rowEntry5.createCell(100, "");
    Row<PDPage> rowEntry6 = table.createRow(defaultRowHeight);
    cell = rowEntry6.createCell(25,
        "<b>Total Assets</b>");
    cell =
        rowEntry6.createCell(25, "$1,145,416.00");
    cell =
        rowEntry6.createCell(25, "$530,628.00");
    cell =
        rowEntry6.createCell(25, "$148,031.00");
    Row<PDPage> rowEntry7 = table.createRow(defaultRowHeight);
    cell = rowEntry7.createCell(25,
        "<b>Total Liabilities</b>");
    cell =
        rowEntry7.createCell(25, "$2,251,334.00");
    cell =
        rowEntry7.createCell(25, "$1,947,951.00");
    cell =
        rowEntry7.createCell(25, "$1,640,433.00");

    Row<PDPage> rowEntry8 = table.createRow(defaultRowHeight);
    cell = rowEntry8.createCell(25,
        "<b>Total Equity</b>");
    cell =
        rowEntry8.createCell(25, "($1,105,918.00 )");
    cell =
        rowEntry8.createCell(25, "($1,417,323.00 )");
    cell =
        rowEntry8.createCell(25, "($1,492,402.00 )");

    table.addHeaderRow(headerRow);
    table.draw();
  }

  private void smeInfoTable(PDDocument doc, PDPage myPage) throws IOException {

    float margin = 75;
    float yStartNewPage = myPage.getMediaBox().getHeight() - (2 * margin);
    float tableWidth = myPage.getMediaBox().getWidth() - (2 * margin);
    boolean drawContent = true;
    float yStart = yStartNewPage;
    float bottomMargin = 70;
    float yPosition = 450;
    BaseTable table =
        new BaseTable(yPosition, yStartNewPage, bottomMargin, tableWidth,
            margin, doc, myPage, true, drawContent);
    float defaultRowHeight = 24f;
    Row<PDPage> headerRow = table.createRow(defaultRowHeight);
    Cell<PDPage> cell = headerRow.createCell(100,
        "<b>Other Information on SME</b>");
    cell.setValign(VerticalAlignment.MIDDLE);

    HashMap<String, String> tableRawData = new HashMap<>();
    tableRawData.put("<b>Industry</b>", "Marine");
    tableRawData.put("<b>Years in operation</b>", "9");
    tableRawData.put("<b>Name of relevant debtor</b>",
        "DYNA-MAC ENGINEERING SERVICES PTE LT");
    tableRawData.put("<b>Invoice amount (in aggregate)</b>",
        "S$ 95,770.4");

    for (Map.Entry<String, String> entry : tableRawData.entrySet()) {
      Row<PDPage> rowEntry = table.createRow(defaultRowHeight);
      cell = rowEntry.createCell(50, entry.getKey());
      cell = rowEntry.createCell(50, entry.getValue());
    }

    table.addHeaderRow(headerRow);
    table.draw();
  }

  private void smeFacilityInfo(PDDocument doc, PDPage myPage)
      throws IOException {
    float margin = 75;
    float yStartNewPage = myPage.getMediaBox().getHeight() - (2 * margin);
    float tableWidth = myPage.getMediaBox().getWidth() - (2 * margin);
    boolean drawContent = true;
    float yStart = yStartNewPage;
    float bottomMargin = 70;
    float yPosition = 300;
    BaseTable table =
        new BaseTable(yPosition, yStartNewPage, bottomMargin, tableWidth,
            margin, doc, myPage, true, drawContent);
    float defaultRowHeight = 24f;
    Row<PDPage> headerRow = table.createRow(defaultRowHeight);
    Cell<PDPage> cell = headerRow.createCell(100,
        "<b>Documents Relevant:</b>");
    cell.setValign(VerticalAlignment.MIDDLE);
    Row<PDPage> headerRow1 = table.createRow(100);
    cell = headerRow1.createCell(100,
        "<ul>Business Profile Search of SME</ul><br><br><br><br>"
            + "<ul>Financial statements of SME</ul>");
    cell.setValign(VerticalAlignment.MIDDLE);
    cell.setTextColor(Color.blue);
    cell.setBottomBorderStyle(null);
    table.addHeaderRow(headerRow);
    table.draw();
  }

  private void additionalInfoTable(PDDocument doc, PDPage myPage)
      throws IOException {

    float margin = 75;
    float yStartNewPage = myPage.getMediaBox().getHeight() - (2 * margin);
    float tableWidth = myPage.getMediaBox().getWidth() - (2 * margin);
    boolean drawContent = true;
    float yStart = yStartNewPage;
    float bottomMargin = 70;
    float yPosition = 530;
    BaseTable table =
        new BaseTable(yPosition, yStartNewPage, bottomMargin, tableWidth,
            margin, doc, myPage, true, drawContent);
    float defaultRowHeight = 24f;
    Row<PDPage> headerRow = table.createRow(defaultRowHeight);
    Cell<PDPage> cell = headerRow.createCell(100,
        "<b>Additional Information</b>");
    cell.setValign(VerticalAlignment.MIDDLE);
    cell.setAlign(HorizontalAlignment.CENTER);

    HashMap<String, String> tableRawData = new HashMap<>();
    tableRawData.put(
        "<b>Security / Guarantee</b><br><br>A Personal Guarantee executed or to be executed by directors of the SME",
        "");

    for (Map.Entry<String, String> entry : tableRawData.entrySet()) {
      Row<PDPage> rowEntry = table.createRow(defaultRowHeight);
      cell = rowEntry.createCell(100, entry.getKey());
    }

    table.addHeaderRow(headerRow);
    table.draw();
  }

  private void drawPageTwoTable(PDDocument doc, PDPage myPage)
      throws IOException {
    float margin = 75;
    float yStartNewPage = myPage.getMediaBox().getHeight() - (2 * margin);
    float tableWidth = myPage.getMediaBox().getWidth() - (2 * margin);
    boolean drawContent = true;
    float yStart = yStartNewPage;
    float bottomMargin = 70;
    float yPosition = 700;
    BaseTable table =
        new BaseTable(yPosition, yStartNewPage, bottomMargin, tableWidth,
            margin, doc, myPage, true, drawContent);
    float defaultRowHeight = 24f;
    Row<PDPage> headerRow = table.createRow(defaultRowHeight);
    HashMap<String, String> tableRawData = new HashMap<>();
    tableRawData.put("<b>Insurance Premium payable: </b>",
        "This facility is non-insured");
    tableRawData.put("<b>Administration Fees: </b>",
        "21.4000% of all Interest Rate payments or any"
            + "other payments received in the Escrow Account in"
            + "accordance with the corresponding Transaction"
            + "Document (Inclusive of GST");
    tableRawData.put("<b>Interest Structure*: </b>", "Declining Balance");

    for (Map.Entry<String, String> entry : tableRawData.entrySet()) {
      Row<PDPage> rowEntry = table.createRow(defaultRowHeight);
      Cell<PDPage> cell = rowEntry.createCell(50, entry.getKey());
      cell = rowEntry.createCell(50, entry.getValue());
    }
    table.addHeaderRow(headerRow);
    table.draw();
  }

  private void drawPageOneTable(PDDocument doc, PDPage myPage)
      throws IOException {
    float margin = 75;
    float yStartNewPage = myPage.getMediaBox().getHeight() - (2 * margin);
    float tableWidth = myPage.getMediaBox().getWidth() - (2 * margin);
    boolean drawContent = true;
    float yStart = yStartNewPage;
    float bottomMargin = 70;
    float yPosition = 520;
    BaseTable table =
        new BaseTable(yPosition, yStartNewPage, bottomMargin, tableWidth,
            margin, doc, myPage, true, drawContent);
    float defaultRowHeight = 24f;
    Row<PDPage> headerRow = table.createRow(defaultRowHeight);
    Cell<PDPage> cell = headerRow.createCell(50,
        "Name of SME : ANECAN ENGINEERING<br><br>SERVICES PTE.LTD");
    cell.setValign(VerticalAlignment.MIDDLE);
    cell = headerRow.createCell(50, "UEN : 201106826M");
    cell.setValign(VerticalAlignment.MIDDLE);

    HashMap<Integer, String> productMap = new HashMap<>();
    productMap.put(1, "Invoice Finacing AR(Disclosed)");
    productMap.put(2, "Invoice Finacing AR(No Disclosed)");
    productMap.put(3, "Purchase Order Financing");
    productMap.put(4, "Working Capital Financing");
    productMap.put(5, "Corporate Vendor Financing");

    Row<PDPage> productTypeRow = table.createRow(50);
    StringBuilder str = new StringBuilder();
    str.append("<b>Type of Facility Application:</b><br><br>");
    for (Map.Entry<Integer, String> entry : productMap.entrySet()) {
      str.append(entry.getValue());
      str.append("<br><br>");
    }
    cell = productTypeRow.createCell(100, str.toString());

    HashMap<String, String> tableRawData = new HashMap<>();
    tableRawData.put("<b>Requested Amount:</b>", "S$ 76,600.00");
    tableRawData.put("<b>Investment Threshold:</b>", "80%");
    tableRawData.put("<b>Expected Tenor of Investment:</b>",
        "5 month(s) from date of disbursal");
    tableRawData.put("<b>Interest Rate:</b>",
        "2.00% calculated per day basi");
    tableRawData.put("<b>Interest Structure*: </b>", "Declining Balance");
    tableRawData.put("<b>Administration Fees: </b>",
        "21.4000% of all Interest Rate payments or any"
            + "other payments received in the Escrow Account in"
            + "accordance with the corresponding Transaction"
            + "Document (Inclusive of GST");
    tableRawData.put("<b>Insurance Premium payable: </b>",
        "This facility is non-insured");
    for (Map.Entry<String, String> entry : tableRawData.entrySet()) {
      Row<PDPage> rowEntry = table.createRow(defaultRowHeight);
      cell = rowEntry.createCell(50, entry.getKey());
      cell = rowEntry.createCell(50, entry.getValue());
    }

    table.addHeaderRow(headerRow);
    table.draw();
  }

  private void createContent(PDPageContentStream cont, float width,
      PDType1Font font)
      throws IOException {
    Paragraph paragraph = new Paragraph();
    String text =
        "Terms  defined  and  the  rules  of  interpretation  in  the  Investors’  Terms  and  Conditions  have  the  same  meaning"
            + "and effect in this Facility Request unless a different meaning is ascribed to it here.";
    paragraph.addParagraph(cont, width, 0, -12, text, true, font);
    text =
        "The terms in this Facility Request shall be read together with the terms of the Investors’ Terms and Conditions in"
            + "relation to this Facility Request and the terms of the Investors’ Terms and Conditions shall apply to this Facility"
            + "Request as if set out herein, mutatis mutandis.";
    paragraph.addParagraph(cont, width, 0, -12, text, true, font);
    text =
        "For the avoidance of doubt, the terms of the Investors’ Terms and Conditions shall continue to apply to us/me in"
            + "our/my dealings through the Platform and our/my Account.";
    paragraph.addParagraph(cont, width, 0, -12, text, true, font);
    text =
        "We/I acknowledge that this Facility Request is not an offer but an invitation to offer and that the submission of an"
            + "Investment Commitment constitutes an irrevocable offer from us/me under the terms of the Investors’ Terms and"
            + "Conditions and the terms herein";
    paragraph.addParagraph(cont, width, 0, -12, text, true, font);
  }

  private void createHeading(PDPageContentStream cont, PDType1Font fontBold,
      float startX, float yOffset, float leading)
      throws IOException {
    cont.beginText();
    cont.setFont(fontBold, 15.0f);
    cont.newLineAtOffset(startX, yOffset);
    yOffset -= leading;
    cont.showText("FACILITY REQUEST");
    cont.newLineAtOffset(0, -leading);
  }

  private PDPageContentStream logoCreation(PDDocument doc,
      PDPageContentStream cont, float startX, float startY)
      throws IOException {
    float yOffset = startY;
    yOffset = startY;
    yOffset -= 2;
    PDImageXObject pdImage = PDImageXObject.createFromFile(
        "src/main/resources/static/validus-new.png", doc);
    cont.drawImage(pdImage, startX, startY, 200, 40);
    return cont;
  }
}

