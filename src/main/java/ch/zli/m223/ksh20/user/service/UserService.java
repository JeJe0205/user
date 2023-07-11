package ch.zli.m223.ksh20.user.service;

import java.util.List;

import ch.zli.m223.ksh20.user.model.AppUser;

public interface UserService {

    List<AppUser> getUserList();

    AppUser getUser(Long id);

    boolean addUser(
        String firstName, String shureName, 
        String email, String password
    );
    
}
