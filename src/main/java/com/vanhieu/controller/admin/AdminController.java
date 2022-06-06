package com.vanhieu.controller.admin;

import com.vanhieu.dto.CategoryDto;
import com.vanhieu.service.ICategoryService;
import com.vanhieu.util.ViewModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/admin/home")
    public String showAdminPage() {

        List<CategoryDto> categories = categoryService.findAll();
        ViewModelUtils.setCategories(categories);
        return "views/admin/home";
    }
}
