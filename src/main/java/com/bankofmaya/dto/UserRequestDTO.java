package com.bankofmaya.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO
{
    private String firstName;
    private String lastName;
    private String otherName;
    private String gender;

    private String address;

    private String stateOfOrigin;


    private String email;

    private String phoneNumber;
    private String alternativePhoneNumber;

}
