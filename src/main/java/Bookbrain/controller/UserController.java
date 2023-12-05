package Bookbrain.controller;

import Bookbrain.dto.request.LoginRequest;
import Bookbrain.dto.request.RegistrationRequest;
import Bookbrain.dto.response.LoginResponse;
import Bookbrain.dto.response.RegistrationResponse;
import Bookbrain.model.Book;
import Bookbrain.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/book")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<RegistrationResponse> register(@RequestBody RegistrationRequest request){
        var response = userService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        var response = userService.login(loginRequest);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("search")
    public ResponseEntity<List<Book>> searchBook(@RequestParam String book){
        List<Book> bookSearch = userService.search(book);
        return ResponseEntity.status(HttpStatus.OK).body(bookSearch);
    }

}
