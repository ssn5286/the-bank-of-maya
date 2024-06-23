package com.bankofmaya.service.impl;

import com.bankofmaya.dto.BankResponseDTO;
import com.bankofmaya.dto.UserRequestDTO;

public interface UserServiceInterface {

    public BankResponseDTO createAccount(UserRequestDTO userRequestDTO);

}
