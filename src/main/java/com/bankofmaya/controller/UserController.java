package com.bankofmaya.controller;

import com.bankofmaya.dto.BankResponseDTO;
import com.bankofmaya.dto.UserRequestDTO;
import com.bankofmaya.service.impl.UserServiceImpl;
import com.bankofmaya.service.impl.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")

public class UserController {

    @Autowired
    UserServiceInterface userService;

    @PostMapping
    public BankResponseDTO createAccount(@RequestBody UserRequestDTO userRequestDTO){
        return userService.createAccount(userRequestDTO);
    }



}
