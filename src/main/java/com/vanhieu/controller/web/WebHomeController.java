package com.vanhieu.controller.web;

import com.vanhieu.service.ICategoryService;
import com.vanhieu.service.IImageOfCateService;
import com.vanhieu.util.ViewModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebHomeController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IImageOfCateService imageOfCateService;

    @GetMapping("/webpage/home")
    public String showWebpage(Model model) {
        if (ViewModelUtils.getCategories() == null) {
            ViewModelUtils.setCategories(categoryService.findAll());
            ViewModelUtils.setImageOfCategories(imageOfCateService.findAll());
        }
        model.addAttribute("categories", ViewModelUtils.getCategories());
        model.addAttribute("imageOfCategories", ViewModelUtils.getImageOfCategories());
        model.addAttribute("idActive", "homePage");

        return "views/web/home";
    }
}
