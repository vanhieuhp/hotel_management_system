package com.vanhieu.controller.admin;

import com.vanhieu.dto.CategoryDto;
import com.vanhieu.service.ICategoryService;
import com.vanhieu.util.ViewModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CategoryOfAdminController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/admin/category/list")
    public String showCategoryList(Model model) {
        List<CategoryDto> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "views/admin/category/list";
    }

    @GetMapping("/admin/category/edit")
    public String showCategoryEdit(Model model, HttpServletRequest request) {
        if(request.getParameter("id") == null) {
            model.addAttribute("category",new CategoryDto());
        } else {
            int id = Integer.parseInt(request.getParameter("id"));
            model.addAttribute("category", ViewModelUtils.getCategories().get(id-1));
        }
        return "views/admin/category/edit";
    }
}
