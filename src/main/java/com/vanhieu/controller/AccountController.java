package com.vanhieu.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class AccountController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "views/security/login";
    }

    @GetMapping(value = "/register")
    public String showRegisterPage() {
        return "views/security/register";
    }

    @GetMapping(value = "/forgetPassword")
    public String showForgetPasswordPage() {
        return "views/security/forgetPassword";
    }

    @GetMapping("/logout")
    public String logOut(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "views/security/login";
    }

}
