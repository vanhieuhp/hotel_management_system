package com.vanhieu.service.impl;

import com.vanhieu.converter.ContactConverter;
import com.vanhieu.dto.ContactDto;
import com.vanhieu.entity.ContactEntity;
import com.vanhieu.repository.ContactRepository;
import com.vanhieu.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ContactService implements IContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ContactConverter contactConverter;

    @Override
    public int count() {
        return (int) contactRepository.count();
    }

    @Override
    @Transactional
    public ContactDto save(ContactDto contactDto) {
        ContactEntity entity = contactConverter.toEntity(contactDto);
        entity.setStatus(1);
        entity = contactRepository.save(entity);
        return contactConverter.toDto(contactRepository.save(entity));
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids){
            ContactEntity entity = (ContactEntity) contactRepository.getById(id);
            entity.setStatus(0);
            contactRepository.save(entity);
        }
    }
}
