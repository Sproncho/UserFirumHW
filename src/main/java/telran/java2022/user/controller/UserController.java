package telran.java2022.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.web.bind.annotation.*;
import telran.java2022.user.dto.*;
import telran.java2022.user.service.UserService;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class UserController {

    final UserService userService;

    @PostMapping("/register")
    public UserDto register(@RequestBody RegisterDto registerDto) {
        return userService.register(registerDto);
    }

    @PostMapping("/login")
    public UserDto login(@RequestBody LoginDto loginDto) {
        return userService.login(loginDto);
    }

    @DeleteMapping("/user/{user}")
    public UserDto deleteUser(@PathVariable String user) {
        return userService.deleteUser(user);
    }

    @PutMapping("/user/{user}")
    public UserDto updateUser(@PathVariable String user,@RequestBody UpdateUserDto updateUserDto) {
        return userService.updateUser(user,updateUserDto);
    }

    @PutMapping("/user/{user}/role/{role}")
    public UserRolesDto addRole(@PathVariable String user,@PathVariable String role) {
        return userService.addRole(user,role);
    }

    @DeleteMapping("/user/{user}/role/{role}")
    public UserRolesDto deleteRole(String user, String role) {
        return userService.deleteRole(user,role);
    }

    @PutMapping("/password")
    public void changePassword(@RequestBody LoginDto loginDto) {
        userService.changePassword(loginDto);
    }
}
