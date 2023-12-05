package Bookbrain.service;

import bookinventory.dto.request.LoginRequest;
import bookinventory.dto.request.RegistrationRequest;
import bookinventory.dto.response.LoginResponse;
import bookinventory.dto.response.RegistrationResponse;

public interface UserService {

    RegistrationResponse register(RegistrationRequest request);

    LoginResponse login(LoginRequest loginRequest);
}
