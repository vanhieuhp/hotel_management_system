package com.vanhieu.converter;

import com.vanhieu.dto.CategoryDto;
import com.vanhieu.dto.RoomDto;
import com.vanhieu.entity.CategoryEntity;
import com.vanhieu.entity.RoomEntity;
import com.vanhieu.util.ViewModelUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomConverter {

    @Autowired
    private CategoryConverter categoryConverter;

    ModelMapper mapper = new ModelMapper();

    public RoomDto toDto(RoomEntity entity) {
        RoomDto dto = mapper.map(entity, RoomDto.class);
        dto.setCategoryId(entity.getCategoryOfRoom().getId());
        CategoryDto category = ViewModelUtils.getCategories().get((int) (dto.getCategoryId()-1));
        dto.setCategory(category);
        return dto;
    }

    public RoomEntity toEntity(RoomDto dto) {
        RoomEntity entity = mapper.map(dto, RoomEntity.class);
        CategoryEntity category = ViewModelUtils.getCategoryEntities().get((int) (dto.getCategoryId()-1));
        entity.setCategoryOfRoom(category);
        return entity;
    }

    public RoomEntity toEntity(RoomEntity entity, RoomDto dto) {
        entity.setRoomNumber(dto.getRoomNumber());
        entity.setStatus(dto.getStatus());
        CategoryEntity category = ViewModelUtils.getCategoryEntities().get((int) (dto.getCategoryId()-1));
        entity.setCategoryOfRoom(category);
        return entity;
    }
}
