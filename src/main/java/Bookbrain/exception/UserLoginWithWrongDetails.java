package Bookbrain.exception;

public class UserLoginWithWrongDetails extends RuntimeException {
    public UserLoginWithWrongDetails(String message) {
        super(message);
    }
}
