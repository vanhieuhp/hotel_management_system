package com.vanhieu.service;

import com.vanhieu.dto.CustomerDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<CustomerDto> findAll(Pageable pageable);
    CustomerDto findByIdentity(String identity);
    CustomerDto findByEmail(String email);
    int count();
    CustomerDto save(CustomerDto dto);
    void delete(Long[] ids);
    CustomerDto getOne(Long id);
}
