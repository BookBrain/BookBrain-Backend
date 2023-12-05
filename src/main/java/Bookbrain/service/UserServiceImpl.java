package bookinventory.service;

import bookinventory.dto.request.LoginRequest;
import bookinventory.dto.request.RegistrationRequest;
import bookinventory.dto.response.LoginResponse;
import bookinventory.dto.response.RegistrationResponse;
import bookinventory.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    @Override
    public RegistrationResponse register(RegistrationRequest request) {
        return null;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        return null;
    }
}
