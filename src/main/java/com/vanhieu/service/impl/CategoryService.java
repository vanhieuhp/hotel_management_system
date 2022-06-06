package com.vanhieu.service.impl;

import com.vanhieu.converter.CategoryConverter;
import com.vanhieu.dto.CategoryDto;
import com.vanhieu.entity.CategoryEntity;
import com.vanhieu.repository.CategoryRepository;
import com.vanhieu.service.ICategoryService;
import com.vanhieu.util.ViewModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryConverter categoryConverter;

    @Override
    public CategoryDto getOne(Long id) {
        return categoryConverter.toDto(categoryRepository.getById(id));
    }

    @Override
    public List<CategoryDto> findAll() {
        List<CategoryDto> results = new ArrayList<>();
        List<CategoryEntity> entities = (List<CategoryEntity>) categoryRepository.findAll();
        ViewModelUtils.setCategoryEntities(entities);
        for (CategoryEntity category : entities) {
            results.add(categoryConverter.toDto(category));
        }
        return results;
    }

    @Override
    public int count() {
        return (int) categoryRepository.count();
    }

    @Override
    public CategoryDto getByCode(String code) {
        CategoryEntity entity = categoryRepository.getByCode(code);
        return categoryConverter.toDto(entity);
    }

    @Override
    @Transactional
    public CategoryDto save(CategoryDto dto) {
        CategoryEntity entity = categoryConverter.toEntity(dto);
        CategoryEntity item = categoryRepository.save(entity);
        return categoryConverter.toDto(item);
    }

    @Override
    @Transactional
    public CategoryDto update(CategoryDto dto) {
        if (dto.getId() != null) {
            CategoryEntity entity = ViewModelUtils.getCategoryEntities().get((int) (dto.getId() - 1));
            entity = categoryConverter.toEntity(entity, dto);
            CategoryEntity item = categoryRepository.save(entity);
            return categoryConverter.toDto(item);
        }
        return null;
    }

    @Override
    public List<CategoryDto> getByViewBeach(String viewBeach) {
        Integer transferViewBeach = 0;
        if (viewBeach.equals("Yes")) {
            transferViewBeach = 1;
        }
        List<CategoryEntity> entities = categoryRepository.getByViewBeach(transferViewBeach);
        List<CategoryDto> results = new ArrayList<>();
        for (CategoryEntity entity : entities) {
            CategoryDto dto = categoryConverter.toDto(entity);
            results.add(dto);
        }
        return results;
    }


    @Override
    @Transactional
    public void delete(Long[] ids) {
        for (Long id : ids) {
            categoryRepository.deleteById(id);
        }
    }
}
