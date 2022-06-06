package com.vanhieu.converter;

import com.vanhieu.dto.ImageOfCateDto;
import com.vanhieu.entity.CategoryEntity;
import com.vanhieu.entity.ImageOfCateEntity;
import com.vanhieu.util.ViewModelUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ImageOfCateConverter {

    ModelMapper mapper = new ModelMapper();

    public ImageOfCateEntity toEntity(ImageOfCateDto dto) {
        ImageOfCateEntity entity = mapper.map(dto, ImageOfCateEntity.class);
        CategoryEntity category = ViewModelUtils.getCategoryEntities().get(dto.getCategoryId()-1);
        entity.setCategoryImage(category);
        return entity;
    }

    public ImageOfCateDto toDto(ImageOfCateEntity entity) {
        ImageOfCateDto dto = mapper.map(entity, ImageOfCateDto.class);
        dto.setCategoryId(Math.toIntExact(entity.getCategoryImage().getId()));
        dto.setCategory(ViewModelUtils.getCategories().get(dto.getCategoryId()-1));
        return dto;
    }
}
