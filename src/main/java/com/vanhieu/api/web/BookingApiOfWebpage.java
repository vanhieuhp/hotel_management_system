package com.vanhieu.api.web;

import com.vanhieu.dto.BookingDto;
import com.vanhieu.service.IBookingService;
import com.vanhieu.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
public class BookingApiOfWebpage {

    @Autowired
    private IBookingService bookingService;

    @Autowired
    private ICustomerService customerService;

    @PostMapping("/api/webpage/booking")
    public BookingDto createBooking(@RequestBody BookingDto bookingDto) {
        return bookingService.save(bookingDto);
    }

    @PostMapping("/api/webpage/findBooking")
    public BookingDto findBookingByCustomerId(@RequestBody BookingDto bookingDto) {
        List<BookingDto> results = bookingService.findByCustomerId(bookingDto.getCustomerId());
        Collections.reverse(results);
        return results.get(0);
    }

}
