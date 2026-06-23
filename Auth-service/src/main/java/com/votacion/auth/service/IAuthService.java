package com.votacion.auth.service;

import com.votacion.auth.dto.AuthResponse;
import com.votacion.auth.dto.LoginRequest;
import com.votacion.auth.dto.RegisterRequest;

public interface IAuthService {

    String register(RegisterRequest request);
    AuthResponse login(LoginRequest request);

}
