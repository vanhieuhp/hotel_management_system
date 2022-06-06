package com.vanhieu.api.admin;

import com.vanhieu.dto.BookingDto;
import com.vanhieu.dto.RoomDto;
import com.vanhieu.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookingApiOfAdmin {

    @Autowired
    private IBookingService bookingService;

    @PutMapping("/api/admin/booking/checkin")
    public void bookingCheckin(@RequestBody Long id) {
        bookingService.checkIn(id);
    }

    @PutMapping("/api/admin/booking/checkout")
    public void bookingCheckout(@RequestBody Long id) {
        bookingService.checkOut(id);
    }

    @GetMapping("/api/admin/booking/list")
    public String bookingList(@RequestParam("page") int page,
                              @RequestParam("limit") int limit,
                              @RequestParam("status") String status,
                              HttpServletRequest request) {
        Pageable pageable = PageRequest.of(page - 1, limit);
        List<BookingDto> bookings = new ArrayList<>();
        switch (status) {
            case "checkin":
                bookings  = bookingService.findAllCheckin(pageable);
                break;
            case "checkout":
                bookings = bookingService.findAllCheckout(pageable);
                break;
            case "list":
                bookings = bookingService.findAllComplete(pageable);
                break;
        }

        StringBuilder string = new StringBuilder("<tbody id=\"table_body\">");
        for (BookingDto booking : bookings) {
            string.append("" +
                    "<tr>\n" +
                    "   <td>"+booking.getId()+"</td>\n" +
                    "   <td>"+booking.getBookingRoom().getCategory().getName()+"</td>\n" +
                    "   <td>"+booking.getBookingRoom().getRoomNumber()+"</td>\n" +
                    "   <td>"+booking.getStartStayDay()+"</td>\n" +
                    "   <td>"+booking.getLastStayDay()+"</td>\n" +
                    "   <td>"+booking.getNumOfStay()+"</td>\n" +
                    "   <td>$"+booking.getTotal()+"</td>\n" +
                    "   <td>"+booking.getCustomerBooking().getFullName()+"</td>\n" +
                    "   <td>\n" +
                    "   <a onclick=checkin("+booking.getId()+") class=\"btn btn-primary btn-user\" data-toggle=\"tooltip\"\n" +
                    "      title=\"Check In\" > <i class=\"fa-solid fa-circle-check\"></i>\n" +
                    "   </a>\n" +
                    "   </td>\n" +
                    "</tr>");
        }
        string.append("</tbody");
        return string.toString();
    }

}
