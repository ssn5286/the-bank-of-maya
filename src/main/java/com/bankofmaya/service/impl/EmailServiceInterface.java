package com.bankofmaya.service.impl;

import com.bankofmaya.dto.EmailDetailsDTO;

public interface EmailServiceInterface {
    void sendEmailAlert(EmailDetailsDTO emailDetailsDTO);
}
