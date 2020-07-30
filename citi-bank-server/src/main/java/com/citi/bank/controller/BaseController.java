package com.citi.bank.controller;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;

@RestController
@SessionAttributes("customerKey")
public class BaseController {

    @ModelAttribute("customerKey")
    public String resolveId(HttpServletRequest httpServletRequest) {

        Object principal = httpServletRequest.getSession().getAttribute("user");

        if(principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
        return "";
    }
}
