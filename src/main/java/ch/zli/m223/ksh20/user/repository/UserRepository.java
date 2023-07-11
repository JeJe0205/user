package ch.zli.m223.ksh20.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.ksh20.user.model.AppUser;
import ch.zli.m223.ksh20.user.model.impl.AppUserImpl;

public interface UserRepository extends JpaRepository<AppUserImpl, Long> {

    public default AppUser insertUser(String firstName, String shureName, String email, String password) {
        return save(new AppUserImpl(firstName, shureName, email, password));
    }

    public Optional<AppUser> findByEmail(String email);
}
