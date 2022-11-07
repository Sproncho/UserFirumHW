package telran.java2022.user.service;

import telran.java2022.user.dto.*;

public interface UserService {
    UserDto register(RegisterDto registerDto) throws Exception;
    UserDto login(LoginDto loginDto);
    UserDto deleteUser(String login);
    UserDto updateUser(String login, UpdateUserDto updateUserDto);
    UserRolesDto addRole(String login, String role);
    UserRolesDto deleteRole(String login, String role);
    void changePassword(LoginDto loginDto);
}
