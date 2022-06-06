package com.vanhieu.service.impl;

import com.vanhieu.converter.CustomerConverter;
import com.vanhieu.dto.CustomerDto;
import com.vanhieu.entity.CustomerEntity;
import com.vanhieu.repository.CustomerRepository;
import com.vanhieu.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerConverter customerConverter;

    @Override
    public List<CustomerDto> findAll(Pageable pageable) {
        List<CustomerEntity> entities = customerRepository.findAll(pageable).getContent();
        List<CustomerDto> results = new ArrayList<>();
        for (CustomerEntity entity : entities) {
            CustomerDto dto = customerConverter.toDto(entity);
            results.add(dto);
        }
        return results;
    }

    @Override
    public CustomerDto findByIdentity(String identity) {
        CustomerEntity customerEntity = customerRepository.findByIdentity(identity);
        if (customerEntity == null) {
            return null;
        }else {
            return customerConverter.toDto(customerEntity);
        }
    }

    @Override
    public CustomerDto findByEmail(String email) {
        return customerConverter.toDto(customerRepository.findByEmail(email));
    }

    @Override
    public int count() {
        return (int) customerRepository.count();
    }

    @Override
    @Transactional
    public CustomerDto save(CustomerDto dto) {
        CustomerEntity entity = customerConverter.toEntity(dto);
        return customerConverter.toDto(customerRepository.save(entity));
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            customerRepository.deleteById(id);
        }
    }

    @Override
    public CustomerDto getOne(Long id) {
        return customerConverter.toDto(customerRepository.getOne(id));
    }
}
