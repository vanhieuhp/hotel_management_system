package com.vanhieu.api.web;

import com.vanhieu.dto.BookingDto;
import com.vanhieu.service.IMailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailApiOfWebpage {

    @Autowired
    private IMailSenderService senderService;

    @PostMapping("/api/webpage/mail")
    public void sendMail(@RequestBody BookingDto bookingDto) {
        StringBuilder body = new StringBuilder("");
        body.append("Your Hotel Booking\n\n");
        body.append("Customer info \n");
        body.append("Your name: " + bookingDto.getCustomerBooking().getFullName() + "\n");
        body.append("Your Email: " + bookingDto.getCustomerBooking().getEmail() + "\n");
        body.append("Your Identity: " + bookingDto.getCustomerBooking().getIdentity() + "\n");
        body.append("Your Phone Number: " + bookingDto.getCustomerBooking().getPhoneNumber() + "\n");

        body.append("Your booking info \n");
        body.append("Category: " + bookingDto.getBookingRoom().getCategory().getName() + "\n");
        body.append("Room Number: " + bookingDto.getBookingRoom().getRoomNumber() + "\n");
        body.append("Start Stay Day: " + bookingDto.getStartStayDay() + "\n");
        body.append("Last Stay Day: " + bookingDto.getLastStayDay() + "\n");
        body.append("Number of stay day: " + bookingDto.getNumOfStay() + "\n");
        body.append("Price Per Day: $" + bookingDto.getBookingRoom().getCategory().getPricePerDay() + "\n");
        body.append("Total Price: $" + bookingDto.getTotal() + "\n");
        body.append("Thank you for your booking!");

        senderService.sendEmail(bookingDto.getCustomerBooking().getEmail(),
                "Booking successfully", body.toString());
    }
}
