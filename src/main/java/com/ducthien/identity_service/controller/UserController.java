package com.ducthien.identity_service.controller;

import com.ducthien.identity_service.dto.request.APIResponse;
import com.ducthien.identity_service.dto.request.UserCreationRequest;
import com.ducthien.identity_service.dto.request.UserUpdateRequest;
import com.ducthien.identity_service.entity.User;
import com.ducthien.identity_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    APIResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        APIResponse<User> Apiresponse = new APIResponse<>();
        Apiresponse.setResult(userService.createUser(request));
        return Apiresponse;
    }
    @GetMapping
    List<User> getUsers() {
        return userService.getUsers();
    }
    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") String userId) {
        return userService.getUser(userId);
    }
    @PutMapping("/{userId}")
    User updateUser(@PathVariable String userId,@RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }
    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "User deleted";
    }
}
