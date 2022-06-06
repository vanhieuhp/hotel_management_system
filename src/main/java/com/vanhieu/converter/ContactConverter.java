package com.vanhieu.converter;

import com.vanhieu.dto.ContactDto;
import com.vanhieu.entity.ContactEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ContactConverter {

    ModelMapper mapper = new ModelMapper();

    public ContactDto toDto(ContactEntity entity) {
        return mapper.map(entity, ContactDto.class);
    }
    public ContactEntity toEntity(ContactDto dto) {
        return mapper.map(dto, ContactEntity.class);
    }

}
