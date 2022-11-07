package telran.java2022.user.dto;

import lombok.Getter;

import java.util.List;
import java.util.Set;
@Getter
public class UserRolesDto {
    String login;
    Set<String> roles;
}
