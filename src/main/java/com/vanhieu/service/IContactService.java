package com.vanhieu.service;

import com.vanhieu.dto.ContactDto;

public interface IContactService {

    int count();
    ContactDto save(ContactDto contactDto);
    void delete(Long[] ids);
}
