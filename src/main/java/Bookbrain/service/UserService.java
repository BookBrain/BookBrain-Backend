package Bookbrain.service;


import Bookbrain.dto.request.LoginRequest;
import Bookbrain.dto.request.RegistrationRequest;
import Bookbrain.dto.response.LoginResponse;
import Bookbrain.dto.response.RegistrationResponse;
import Bookbrain.model.Book;

import java.util.List;

public interface UserService {

    RegistrationResponse register(RegistrationRequest request);

    LoginResponse login(LoginRequest loginRequest);
    List<Book> search(String books);
}
