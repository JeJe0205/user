package ch.zli.m223.ksh20.user.controller.rest.dto;

import ch.zli.m223.ksh20.user.model.AppUser;

public class UserDto {
    public String firstName;
    public String shureName;
    public String email;

    public UserDto(AppUser user) {
        firstName = user.getFirstName();
        shureName =user.getShureName();
        email = user.getUserName();
    }
}
