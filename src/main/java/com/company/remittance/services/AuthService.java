package com.company.remittance.services;

import com.company.remittance.dto.CredentialsDto;

public interface AuthService {
    String login(CredentialsDto credentials);
    void logout();
}
