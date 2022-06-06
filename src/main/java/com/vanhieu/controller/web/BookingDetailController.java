package com.vanhieu.controller.web;

import com.vanhieu.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BookingDetailController {

    @Autowired
    private IBookingService bookingService;

    @GetMapping("/webpage/bookingDetail")
    public String showBookingDetailPage(Model model, HttpServletRequest request) {

        if (request.getParameter("bookingId") != null) {
            Long id = Long.valueOf(request.getParameter("bookingId"));
            model.addAttribute("booking", bookingService.getOne(id));
        }
        model.addAttribute("idActive", "bookingDetailPage");

        return "views/web/bookingDetail";
    }
}
