package Bookbrain.service;


import Bookbrain.dto.request.LoginRequest;
import Bookbrain.dto.request.RegistrationRequest;
import Bookbrain.dto.response.LoginResponse;
import Bookbrain.dto.response.RegistrationResponse;
import Bookbrain.exception.UserAlreadyExistException;
import Bookbrain.exception.UserLoginWithWrongDetails;
import Bookbrain.model.Book;
import Bookbrain.model.User;
import Bookbrain.repository.BookRepository;
import Bookbrain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final BookRepository bookRepository;

  @Override
    public RegistrationResponse register(RegistrationRequest registerRequest) {
        if (userAlreadyExists(registerRequest.getUsername())){
            throw new UserAlreadyExistException(registerRequest.getUsername() + " User Already exist");
        }

        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());

        userRepository.save(user);
        RegistrationResponse response = new RegistrationResponse();
        response.setMessage("Registration Successful");
        return response;
    }

    private boolean userAlreadyExists(String username) {
      return userRepository.findByUsername(username).isPresent();
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        boolean isAuthenticated = authenticate(username, password);
        if (!isAuthenticated) {
            throw new UserLoginWithWrongDetails("Invalid credentials");
        }
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setMessage("Login successful");
        return loginResponse;
    }

    public boolean authenticate(String username, String password){
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Book> search(String books) {
        return bookRepository.findAll()
                .stream()
                .filter(book -> book.getTitle().contains(books.trim()))
                .collect(Collectors.toList());
    }


}
