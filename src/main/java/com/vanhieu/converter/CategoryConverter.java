package com.vanhieu.converter;

import com.vanhieu.dto.CategoryDto;
import com.vanhieu.entity.CategoryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {

    ModelMapper mapper = new ModelMapper();

    public CategoryDto toDto(CategoryEntity entity) {
        CategoryDto dto = mapper.map(entity, CategoryDto.class);
        return dto;
    }

    public CategoryEntity toEntity(CategoryDto dto) {
        CategoryEntity entity = mapper.map(dto, CategoryEntity.class);
        if (dto.getViewToBeach().equals("Yes")) {
            entity.setViewToBeach(1);
        } else {
            entity.setViewToBeach(0);
        }
        return entity;
    }

    public CategoryEntity toEntity(CategoryEntity entity, CategoryDto dto) {
        entity.setViewToBeach(dto.getViewToBeach());
        entity.setImage(dto.getImage());
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        entity.setNumOfBed(dto.getNumOfBed());
        entity.setNumOfPool(dto.getNumOfPool());
        entity.setStatus(dto.getStatus());
        entity.setPricePerDay(dto.getPricePerDay());
        return entity;
    }
}
