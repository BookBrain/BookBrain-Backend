package Bookbrain.service;

import Bookbrain.dto.request.LoginRequest;
import Bookbrain.dto.request.RegistrationRequest;
import Bookbrain.dto.response.LoginResponse;
import Bookbrain.dto.response.RegistrationResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    UserServiceImpl userService;
    @Test
    public void testThatUserCanRegister(){
        RegistrationRequest request = new RegistrationRequest();
        request.setUsername("Daniel");
        request.setPassword("Password");
        RegistrationResponse response = userService.register(request);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isNotNull();
    }

    @Test
    public void testThatUserCanLogin(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("Daniel");
        loginRequest.setPassword("Password");

        LoginResponse response = userService.login(loginRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isNotNull();
    }

}