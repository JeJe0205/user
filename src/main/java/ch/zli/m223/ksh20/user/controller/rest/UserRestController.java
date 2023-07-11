package ch.zli.m223.ksh20.user.controller.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zli.m223.ksh20.user.controller.rest.dto.UserDto;
import ch.zli.m223.ksh20.user.controller.rest.dto.UserInputDto;
import ch.zli.m223.ksh20.user.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {

    @Autowired
    private UserService userService;
    
    @PostMapping("/register")
    void register(@RequestBody UserInputDto user) {
        userService.addUser(
            user.firstName, user.shureName, 
            user.email, user.password
        );
    }

    @GetMapping()
    List<UserDto> getUserList() {
        return userService.getUserList().stream()
        .map( user -> new UserDto(user))
        .collect(Collectors.toList());
    }
}
