package Bookbrain.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegistrationRequest {

    private String username;
    private String password;
}
