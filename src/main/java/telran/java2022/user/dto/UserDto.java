package telran.java2022.user.dto;

import lombok.Getter;

import java.util.List;
import java.util.Set;

@Getter
public class UserDto {
    String login;
    String firstName;
    String lastName;
    Set<String> roles;
}
