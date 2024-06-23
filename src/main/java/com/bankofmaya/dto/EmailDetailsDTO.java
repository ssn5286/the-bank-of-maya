package com.bankofmaya.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetailsDTO {
    private String receipient;
    private String messageBody;
    private String subject;
    private String attachment;
}
