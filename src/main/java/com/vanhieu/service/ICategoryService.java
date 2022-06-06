package com.vanhieu.service;

import com.vanhieu.dto.CategoryDto;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ICategoryService {

    CategoryDto getOne(Long id);
    List<CategoryDto> findAll();
    int count();
    CategoryDto getByCode(String categoryCode);
    CategoryDto save(CategoryDto dto);
    CategoryDto update(CategoryDto dto);
    List<CategoryDto> getByViewBeach(String viewBeach);
    void delete(Long[] ids);
}
