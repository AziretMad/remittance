package com.company.remittance.services.impl;

import com.company.remittance.dto.CredentialsDto;
import com.company.remittance.entities.User;
import com.company.remittance.services.AuthService;
import com.company.remittance.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;

    @Override
    public String login(CredentialsDto credentials) {
        User user = userService.get(credentials.getUsername());
        return "remittances";
    }

    @Override
    public void logout() {

    }
}
