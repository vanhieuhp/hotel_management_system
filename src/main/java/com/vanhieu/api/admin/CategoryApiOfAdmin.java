package com.vanhieu.api.admin;

import com.vanhieu.dto.CategoryDto;
import com.vanhieu.service.ICategoryService;
import com.vanhieu.service.IImageOfCateService;
import com.vanhieu.util.ViewModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryApiOfAdmin {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IImageOfCateService imageOfCategService;

    @PostMapping("/api/admin/category")
    public CategoryDto createCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto category = categoryService.save(categoryDto);
        ViewModelUtils.setCategories(categoryService.findAll());
        return category;
    }

    @PutMapping("/api/admin/category")
    public CategoryDto updateCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto category = categoryService.update(categoryDto);
        ViewModelUtils.setCategories(categoryService.findAll());
        ViewModelUtils.setImageOfCategories(imageOfCategService.findAll());
        return category;
    }

    @DeleteMapping("/api/admin/category")
    public void deleteCategory(@RequestBody Long[] ids) {
        categoryService.delete(ids);
    }
}
