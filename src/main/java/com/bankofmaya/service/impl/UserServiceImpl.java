package com.bankofmaya.service.impl;

import com.bankofmaya.dto.AccountInfoDTO;
import com.bankofmaya.dto.BankResponseDTO;
import com.bankofmaya.dto.EmailDetailsDTO;
import com.bankofmaya.dto.UserRequestDTO;
import com.bankofmaya.entity.UserEntity;
import com.bankofmaya.repository.UserRepository;
import com.bankofmaya.utils.AccountUtilReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmailServiceInterface emailServiceInterface;

    @Override
    public BankResponseDTO createAccount(UserRequestDTO userRequestDTO) {
//        Create an account - save account to database
//        Check if user already exists
        System.out.println(userRepository.existsByEmail(userRequestDTO.getEmail()));


        if (userRepository.existsByEmail(userRequestDTO.getEmail())){
            return BankResponseDTO.builder()
                    .responseCode(AccountUtilReturn.ACCOUNT_EXISTS_CODE)
                            .responseMessage(AccountUtilReturn.ACOUNT_EXISTS_MESSAGE)
                    .accountInfoDTO(null).
                    build();


        }

//        if (userRepository.existsByPhoneNumber(userRequestDTO.getPhoneNumber())){
//            return BankResponseDTO.builder()
//                    .responseCode(AccountUtilReturn.ACCOUNT_EXISTS_CODE)
//                    .responseMessage(AccountUtilReturn.ACOUNT_EXISTS_MESSAGE)
//                    .build();
//        }

        UserEntity newUser = UserEntity.builder()
                        .firstName(userRequestDTO.getFirstName())
                                .lastName(userRequestDTO.getLastName())
                                        .otherName(userRequestDTO.getOtherName())
                                                .gender(userRequestDTO.getGender())
                                                        .address(userRequestDTO.getAddress())
                                                                .stateOfOrigin(userRequestDTO.getStateOfOrigin())
                .accountNumber(AccountUtilReturn.createAccountNumber())
                .accountBalance(BigDecimal.ZERO)
                .email(userRequestDTO.getEmail())
                .phoneNumber(userRequestDTO.getPhoneNumber())
                .alternativePhoneNumber(userRequestDTO.getAlternativePhoneNumber())
                .status("Active")
                .build()
                ;
        UserEntity savedUser = userRepository.save(newUser);
        EmailDetailsDTO email = EmailDetailsDTO.builder()
                .receipient(savedUser.getEmail())
                .subject("New Account Created for you " + savedUser.getFirstName() + " " + savedUser.getLastName() + " " + savedUser.getOtherName())
                .messageBody("Congrats! You account at Bank of Maya has been created" + "\nAccount Details shown below\n" + "Name  : " + savedUser.getFirstName() + " " + savedUser.getLastName() + " " + savedUser.getOtherName() +
                        "\n Account Number   : " + savedUser.getAccountNumber())
                .build();

        emailServiceInterface.sendEmailAlert(email);
        return BankResponseDTO.builder()
                .responseCode(AccountUtilReturn.ACCOUNT_CREATION_CODE)
                .responseMessage(AccountUtilReturn.ACCOUNT_CREATION_MESSAGE)
                .accountInfoDTO(AccountInfoDTO.builder()
                                .accountName(savedUser.getFirstName() + " " + savedUser.getLastName() + " " + savedUser.getOtherName())
                                        .accountBalance(savedUser.getAccountBalance())
                                                .accountNumber(savedUser.getAccountNumber())
                        .build())
                .build();
    }






}
