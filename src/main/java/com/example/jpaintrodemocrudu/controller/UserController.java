package com.example.jpaintrodemocrudu.controller;

import com.example.jpaintrodemocrudu.dto.UserDto;
import com.example.jpaintrodemocrudu.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }


    @PostMapping("/user-create")
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto){
        userService.createUser(userDto);
        return ResponseEntity.ok("User created successfully");
    }


    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer id){
        return ResponseEntity.ok(userService.getUserById(id));
    }


    @GetMapping("/get-all-users")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }


    @PutMapping("/change-user-name")
    public ResponseEntity<String> changeUserInfoById(@RequestParam Integer id, @RequestParam String newName){
        userService.changeUserInfoById(newName, id);
        return ResponseEntity.ok("Name was changed");
    }

    @GetMapping("/get-all-users-by-name")
    public ResponseEntity<List<UserDto>> getAllUserByName(@RequestParam String name){
        return ResponseEntity.ok(userService.getAllUserByName(name));
    }
}
