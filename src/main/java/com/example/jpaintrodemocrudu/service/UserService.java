package com.example.jpaintrodemocrudu.service;

import com.example.jpaintrodemocrudu.dto.UserDto;
import com.example.jpaintrodemocrudu.enums.UserStatus;
import com.example.jpaintrodemocrudu.model.User;
import com.example.jpaintrodemocrudu.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public void createUser(UserDto userDto){
        User user = new User()
                .setUserName(userDto.name())
                .setSurName(userDto.surName())
                .setEmail(userDto.email())
                .setStatus(UserStatus.ACTIVE);
        userRepo.save(user);
    }

    public UserDto getUserById(Integer id){
        User user = userRepo.getReferenceById(id);
        return new UserDto(user.getUserName(), user.getSurName(), user.getEmail());
    }

    public List<UserDto> getAllUsers(){
       return userRepo.findAll().stream().map(user -> new UserDto(user.getUserName(), user.getSurName(), user.getEmail())).collect(Collectors.toList());
    }
    public void changeUserInfoById(String newName, Integer id){
        userRepo.updateUserInfoById(newName, id );
    }

    public List<UserDto> getAllUserByName(String name){
        return userRepo.findUserByUserName(name).stream()
                .map(user -> new UserDto(user.getUserName(), user.getSurName(), user.getEmail()))
                .collect(Collectors.toList());
    }
}
