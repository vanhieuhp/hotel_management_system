package com.vanhieu.controller.web;

import com.vanhieu.util.ViewModelUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BookingOfWebpageController {

    @GetMapping("/webpage/booking")
    public String bookingPage(Model model, HttpServletRequest request) {

        if (request.getParameter("category") != null) {
            int categoryId = Integer.parseInt(request.getParameter("category"));
            model.addAttribute("test", categoryId);
        }
        model.addAttribute("categories", ViewModelUtils.getCategories());
        model.addAttribute("idActive", "bookingPage");

        return "views/web/booking";
    }
}
