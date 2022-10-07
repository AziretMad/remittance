package com.company.remittance.services;

import com.company.remittance.config.auth.CustomUserDetails;

public interface AuthService {
    CustomUserDetails getCurrentUser();
}
