package com.vanhieu.pdf;

import com.vanhieu.dto.BookingDto;
import com.vanhieu.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class BookingPDF {

    @Autowired
    private IBookingService bookingService;

    @GetMapping("/admin/booking/pdf")
    public void exportBookingToPDF(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=booking_"+currentDate+".pdf";

        Long id = Long.valueOf(request.getParameter("id"));
        BookingDto bookingDto = bookingService.getOne(id);

        BookingPDFExporter bookingPDFExporter = new BookingPDFExporter(bookingDto);
        bookingPDFExporter.export(response);
    }


}
