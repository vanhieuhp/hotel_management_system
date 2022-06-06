package com.vanhieu.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecuredPasswordGenerator {

    public static String generator(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String securedPassword = encoder.encode(password);
        return securedPassword;
    }
}
