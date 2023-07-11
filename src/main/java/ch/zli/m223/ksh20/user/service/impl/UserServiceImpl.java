package ch.zli.m223.ksh20.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zli.m223.ksh20.user.model.AppUser;
import ch.zli.m223.ksh20.user.repository.UserRepository;
import ch.zli.m223.ksh20.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public List<AppUser> getUserList() {
        return new ArrayList<>(userRepository.findAll());
    }

    @Override
    public AppUser getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public boolean addUser(
        String firstName, String shureName, 
        String email, String password
    ) {
        if (email == null || email.isBlank()) return false;
        if (password == null || password.isBlank()) return false;

        if (userRepository.findByEmail(email).isPresent()) return false;

        userRepository.insertUser(firstName, shureName, email, password);
        return true;
    }
    
}
