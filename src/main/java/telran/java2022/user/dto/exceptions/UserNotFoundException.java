package telran.java2022.user.dto.exceptions;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@ResponseStatus(HttpStatus.NOT_FOUND)

public class UserNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1952550028444204207L;
    public UserNotFoundException(String login){
        super("user with login <"+  login + "> not found");
    }
}
