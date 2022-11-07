package telran.java2022.user.dto.exceptions;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@ResponseStatus(HttpStatus.CONFLICT)
public class UserAlreadyExistsException extends RuntimeException{
    private static final long serialVersionUID = 2952550028444204207L;

    public UserAlreadyExistsException(String login) {
        super("user with login <" + login + "> already exists");
    }
}
