package com.vanhieu.api.web;

import com.vanhieu.dto.CustomerDto;
import com.vanhieu.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerApiOfWebpage {

    @Autowired
    private ICustomerService customerService;

    @PostMapping("/api/webpage/customer")
    public CustomerDto createCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.save(customerDto);
    }

    @PostMapping("/api/webpage/findCustomer")
    public CustomerDto getCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto customer = customerService.findByIdentity(customerDto.getIdentity());
        if (customer != null) {
            return customer;
        } else {
            return null;
        }
    }
}
