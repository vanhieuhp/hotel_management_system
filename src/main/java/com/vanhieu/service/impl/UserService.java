package com.vanhieu.service.impl;

import com.vanhieu.converter.UserConverter;
import com.vanhieu.dto.UserDto;
import com.vanhieu.entity.UserEntity;
import com.vanhieu.repository.RoleRepository;
import com.vanhieu.repository.UserRepository;
import com.vanhieu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserConverter userConverter;

    @Autowired
    RoleRepository roleRepository;

    @Override
    @Transactional
    public UserDto getUserByUsername(String username) {
        UserEntity userEntity = userRepository.getUserByUsername(username, 1);
        if (userEntity != null) {
            return userConverter.toDto(userEntity);
        }
        return null;
    }

    @Override
    public UserDto getUserByEmail(String email) {
        UserEntity userEntity = userRepository.getUserByEmail(email, 1);
        if (userEntity != null) {
            return userConverter.toDto(userEntity);
        }
        return null;
    }

    @Override
    public UserDto getUserByUsernameAndEmail(String username, String email) {
        UserEntity userEntity = userRepository.getUserByUsernameAndEmail(username , email, 1);
        if (userEntity != null) {
            return userConverter.toDto(userEntity);
        }
        return null;
    }

    @Override
    @Transactional
    public UserDto save(UserDto userDto) {
//        userDto.setStatus(1);
//        userDto.setPassword(SecuredPasswordGenerator.generator(userDto.getPassword()));
//        RoleEntity roleEntity =  roleRepository.getOne(2L);
//        List<RoleEntity> roles = new ArrayList<>();
//        roles.add(roleEntity);
//        UserEntity userEntity = userConverter.toEntity(userDto);
//        userEntity.setRoles(roles);
//        userEntity = userRepository.save(userEntity);
//        userDto = userConverter.toDto(userEntity);
//        return userDto;
        return null;
    }

    @Transactional
    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            userRepository.deleteById(id);
        }
    }

    @Override
    public UserDto getOne(Long id) {
        UserEntity entity = userRepository.getOne(id);
        UserDto dto = userConverter.toDto(entity);
        return dto;
    }

    @Override
    @Transactional
    public void changePassword(UserDto userDto, String password) {
//        UserEntity userEntity = userRepository.getUserByUsernameAndEmail(userDto.getUsername(), userDto.getEmail(), 1);
//        userEntity.setPassword(SecuredPasswordGenerator.generator(password));
//        userRepository.save(userEntity);
    }
}
