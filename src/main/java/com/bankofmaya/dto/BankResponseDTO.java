package com.bankofmaya.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankResponseDTO {

    private String responseCode;
    private String responseMessage;
    private AccountInfoDTO accountInfoDTO;
}
