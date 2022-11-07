package telran.java2022.user.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;
import telran.java2022.post.model.Post;
import telran.java2022.user.dao.UserRepository;
import telran.java2022.user.dto.*;
import telran.java2022.user.dto.exceptions.UserAlreadyExistsException;
import telran.java2022.user.dto.exceptions.UserNotFoundException;
import telran.java2022.user.dto.exceptions.WrongPasswordException;
import telran.java2022.user.model.User;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    final UserRepository userRepository;
    final ModelMapper modelMapper;
    @Override
    public UserDto register(RegisterDto registerDto)  {
        User user = userRepository.findById(registerDto.getLogin()).orElse(null);
        if(user == null){
            throw new UserAlreadyExistsException();
        }
        user = modelMapper.map(registerDto, User.class);
        userRepository.save(user);
        return modelMapper.map(user,UserDto.class);

    }

    @Override
    public UserDto login(LoginDto loginDto) {
        User user = userRepository.findById(loginDto.getLogin()).orElseThrow(() -> new UserNotFoundException(loginDto.getLogin()));
        if(!loginDto.getPassword().equals(user.getPassword())){
            throw new WrongPasswordException();
        }
        return modelMapper.map(user,UserDto.class);
    }

    @Override
    public UserDto deleteUser(String login) {
        User user = userRepository.findById(login).orElseThrow(() -> new UserNotFoundException(login));
        userRepository.deleteById(login);
        return modelMapper.map(user,UserDto.class);
    }

    @Override
    public UserDto updateUser(String login, UpdateUserDto updateUserDto) {
        User user = userRepository.findById(login).orElseThrow(() -> new UserNotFoundException(login));
        user.update(updateUserDto.getFirstName(),updateUserDto.getLastName());
        userRepository.save(user);
        return modelMapper.map(user,UserDto.class);
    }

    @Override
    public UserRolesDto addRole(String login, String role) {
        User user = userRepository.findById(login).orElseThrow(() -> new UserNotFoundException(login));
        user.addRole(role);
        userRepository.save(user);
        return modelMapper.map(user,UserRolesDto.class);
    }

    @Override
    public UserRolesDto deleteRole(String login, String role) {
        User user = userRepository.findById(login).orElseThrow(() -> new UserNotFoundException(login));
        user.removeRole(role);
        userRepository.save(user);
        return modelMapper.map(user,UserRolesDto.class);
    }

    @Override
    public void changePassword(LoginDto loginDto) {
        User user = userRepository.findById(loginDto.getLogin()).orElseThrow(() -> new UserNotFoundException(loginDto.getLogin()));
        user.setPassword(loginDto.getPassword());
        userRepository.save(user);

    }
}
