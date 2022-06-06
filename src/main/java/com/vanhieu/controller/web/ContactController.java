package com.vanhieu.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {

    @GetMapping("/webpage/contact")
    public String showContactPage(Model model) {

        model.addAttribute("idActive", "contactPage");
        return "views/web/contact";
    }
}
