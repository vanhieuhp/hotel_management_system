package com.vanhieu.controller.admin;


import com.vanhieu.dto.BookingDto;
import com.vanhieu.service.IBookingService;
import com.vanhieu.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BookingOfAdminController {

    @Autowired
    private IBookingService bookingService;

    @GetMapping("/admin/booking/list")
    public String showBookingListPage(@RequestParam("page") int page,
                               @RequestParam("limit") int limit,
                               HttpServletRequest request,
                               Model model) {
        BookingDto bookingModel = new BookingDto();
        Pageable pageable = PageRequest.of(page - 1, limit);
        if (bookingService.findAllComplete(pageable).size() == 0 && page > 1) {
            page --;
            pageable = PageRequest.of(page - 1, limit);
        }
        bookingModel.setListResult(bookingService.findAllComplete(pageable));
        bookingModel.setTotalItem(bookingService.countComplete());
        bookingModel = PageUtils.getModel(bookingModel, page, limit);

        model.addAttribute("bookingModel", bookingModel);
        return "views/admin/booking/list";
    }

    @GetMapping("/admin/booking/checkin")
    public String showCheckInListPage(@RequestParam("page") int page,
                               @RequestParam("limit") int limit,
                               HttpServletRequest request,
                               Model model) {
        BookingDto bookingModel = new BookingDto();
        Pageable pageable = PageRequest.of(page - 1, limit);
        if (bookingService.findAllCheckin(pageable).size() == 0 && page > 1) {
            page --;
            pageable = PageRequest.of(page - 1, limit);
        }
        bookingModel.setListResult(bookingService.findAllCheckin(pageable));
        bookingModel.setTotalItem(bookingService.countCheckin());
        bookingModel = PageUtils.getModel(bookingModel, page, limit);

        model.addAttribute("bookingModel", bookingModel);
        return "views/admin/booking/checkin";
    }

    @GetMapping("/admin/booking/checkout")
    public String showCheckOutListPage(@RequestParam("page") int page,
                                      @RequestParam("limit") int limit,
                                      HttpServletRequest request,
                                      Model model) {
        BookingDto bookingModel = new BookingDto();
        Pageable pageable = PageRequest.of(page - 1, limit);
        if (bookingService.findAllCheckout(pageable).size() == 0 && page > 1) {
            page --;
            pageable = PageRequest.of(page - 1, limit);
        }
        bookingModel.setListResult(bookingService.findAllCheckout(pageable));
        bookingModel.setTotalItem(bookingService.countCheckout());
        bookingModel = PageUtils.getModel(bookingModel, page, limit);

        model.addAttribute("bookingModel", bookingModel);
        return "views/admin/booking/checkout";
    }
}
