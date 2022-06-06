package com.vanhieu.repository;

import com.vanhieu.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    @Query("select c from CustomerEntity c where c.identity = ?1")
    CustomerEntity findByIdentity(String identity);

    @Query("select c from CustomerEntity c where c.email = ?1")
    CustomerEntity findByEmail(String email);
}
