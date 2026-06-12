package com.amor.application.usecases;

import com.amor.application.dto.AuthResponse;
import com.amor.application.dto.LoginRequest;

public interface AuthUseCase {
    AuthResponse login(LoginRequest request);
}
