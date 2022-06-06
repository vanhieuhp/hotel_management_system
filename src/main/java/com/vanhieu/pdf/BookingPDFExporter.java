package com.vanhieu.pdf;

import com.lowagie.text.Font;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.vanhieu.dto.BookingDto;
import com.vanhieu.dto.CustomerDto;
import com.vanhieu.dto.RoomDto;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

public class BookingPDFExporter {

    private BookingDto bookingDto;
    private RoomDto roomDto;
    private CustomerDto customerDto;

    public BookingPDFExporter(BookingDto bookingDto) {
        this.bookingDto = bookingDto;
        this.customerDto = bookingDto.getCustomerBooking();
        this.roomDto = bookingDto.getBookingRoom();
    }

    private void writeCustomerInfo(Document doc, Font font1, Font font2) {
        doc.open();

        Paragraph header = new Paragraph("hotel management system\n\n", font1);
        header.setAlignment(Paragraph.ALIGN_CENTER);
        doc.add(header);

        Paragraph paragraph = new Paragraph("****************************************************************************************************************\n");
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Paragraph customerHeader = new Paragraph("Customer\n", font2);
        doc.add(customerHeader);

        Paragraph fullName = new Paragraph("Full name: " + customerDto.getFullName() + "\n");
        doc.add(fullName);

        Paragraph email = new Paragraph("Email: " + customerDto.getEmail() + "\n");
        doc.add(email);

        Paragraph identity = new Paragraph("Identity: " + customerDto.getIdentity() + "\n");
        doc.add(identity);

        Paragraph phoneNumber = new Paragraph("Phone Number: " + customerDto.getPhoneNumber() + "\n\n");
        doc.add(phoneNumber);
        doc.add(paragraph);
    }

    private void writeBookingInfo(Document doc, Font font1, Font font2) {
        doc.open();
        Paragraph paragraph = new Paragraph("****************************************************************************************************************\n");
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Paragraph bookingHeader = new Paragraph("Booking\n", font2);
        doc.add(bookingHeader);

        Paragraph category = new Paragraph("Category: " + roomDto.getCategory().getName() + "\n");
        doc.add(category);

        Paragraph roomNumber = new Paragraph("Room Number: " + roomDto.getRoomNumber() + "\n");
        doc.add(roomNumber);

        Paragraph startStay = new Paragraph("Check in date: " + bookingDto.getStartStayDay() + "\n");
        doc.add(startStay);

        Paragraph lastStay = new Paragraph("Check out date: " + bookingDto.getLastStayDay() + "\n");
        doc.add(lastStay);

        Paragraph numOfStay = new Paragraph("Number of stay day: " + bookingDto.getNumOfStay() + "\n");
        doc.add(numOfStay);

        Paragraph pricePerDay = new Paragraph("Price per day: $" + roomDto.getCategory().getPricePerDay() + "\n");
        doc.add(pricePerDay);

        Paragraph totalPrice = new Paragraph("Total price: $" + bookingDto.getTotal() + "\n\n");
        doc.add(totalPrice);

        doc.add(paragraph);
    }

    private void writeTableData(PdfPTable table) {
        table.addCell(String.valueOf(bookingDto.getId()));
        table.addCell(bookingDto.getBookingRoom().getCategory().getName());
        table.addCell(bookingDto.getBookingRoom().getRoomNumber());
        table.addCell(String.valueOf(bookingDto.getStartStayDay()));
        table.addCell(String.valueOf(bookingDto.getLastStayDay()));
    }

    public void export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font1.setSize(30);
        font1.setColor(Color.BLUE);

        Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font2.setSize(20);

        writeCustomerInfo(document, font1, font2);
        writeBookingInfo(document, font1, font2);

//        PdfPTable table = new PdfPTable(5);
//        table.setWidthPercentage(100f);
//        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
//        table.setSpacingBefore(10);
        Paragraph thankYou = new Paragraph("Thank you, please visit again!");
        document.add(thankYou);

        document.close();
    }
}
