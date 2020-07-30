package com.citi.bank.controller;

import com.citi.bank.domain.UserDetails;
import com.citi.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/app/data/user")
public class UserDetailsController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity getUser(@ModelAttribute("customerKey") String key) {
        final UserDetails userDetails = userService.getUser(key);
        return new ResponseEntity(userDetails, HttpStatus.OK);
    }
}
