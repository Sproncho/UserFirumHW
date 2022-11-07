package telran.java2022.user.dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class WrongPasswordException extends RuntimeException{
    private static final long serialVersionUID = 3952550028444204207L;
    public WrongPasswordException() {
        super("wrong password");
    }
}
