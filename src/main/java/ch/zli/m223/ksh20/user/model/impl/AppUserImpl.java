package ch.zli.m223.ksh20.user.model.impl;

import ch.zli.m223.ksh20.user.model.AppUser;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name="AppUser")
public class AppUserImpl implements AppUser {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String passwordHash;

    private String firstName;

    private String shureName;

    @Column(
        nullable = false, 
        unique = true)
    private String email;

        public AppUserImpl(
        String firstName, String shureName,
        String email, String password
    ) {
        this.firstName  = firstName;
        this.shureName  = shureName;
        this.email  = email;
        this.passwordHash  = password;
        
        passwordHash = password; // DODO: hash it
    }

    /** For JPA use only */
    protected AppUserImpl() {}

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getUserName() {
        return email;
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }
    
    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getShureName() {
        return shureName;
    }
}
