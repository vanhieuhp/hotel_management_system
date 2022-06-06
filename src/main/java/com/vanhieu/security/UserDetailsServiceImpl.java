package com.vanhieu.security;

import com.vanhieu.dto.UserDto;
import com.vanhieu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto user = userService.getUserByUsername(username);
        if (user == null) {
            System.out.println("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
//            List<GrantedAuthority> grantList = new ArrayList<>();
//            GrantedAuthority authority = new SimpleGrantedAuthority(user.getRoles().get(0).getCode());
//            grantList.add(authority);
//
//            UserDetails userDetails = new User(user.getUsername(), user.getPassword(), grantList);
//            return userDetails;
        } else {
            System.out.println("User found in the database: " + username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getCode()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
