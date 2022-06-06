package com.vanhieu.converter;

import com.vanhieu.dto.CustomerDto;
import com.vanhieu.entity.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {

    ModelMapper mapper = new ModelMapper();

    public CustomerDto toDto(CustomerEntity entity) {
        CustomerDto customerDto = mapper.map(entity, CustomerDto.class);
        return customerDto;
    }

    public CustomerEntity toEntity(CustomerDto dto) {
        CustomerEntity entity = mapper.map(dto, CustomerEntity.class);
        return entity;
    }
}
