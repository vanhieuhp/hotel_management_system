package com.vanhieu.service;

import com.vanhieu.dto.UserDto;

public interface IUserService {

    UserDto getUserByUsername(String username);
    UserDto getUserByEmail(String email);
    UserDto getUserByUsernameAndEmail(String username, String email);
    UserDto save(UserDto userDto);
    void delete(Long[] ids);
    UserDto getOne(Long id);
    void changePassword(UserDto userDto, String password);
}
