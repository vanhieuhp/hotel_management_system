package com.vanhieu.repository;

import com.vanhieu.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("SELECT u FROM UserEntity u WHERE u.username = ?1 AND u.status = ?2")
    UserEntity getUserByUsername(String username, int status);

    @Query("SELECT u FROM UserEntity u WHERE u.email = ?1 AND u.status = ?2")
    UserEntity getUserByEmail(String email, int status);

    @Query("SELECT u FROM UserEntity u WHERE u.username = ?1 AND u.email = ?2 AND u.status = ?3")
    UserEntity getUserByUsernameAndEmail(String username, String email, int status);
}
