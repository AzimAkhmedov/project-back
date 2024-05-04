package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository  extends JpaRepository<User, Long>{

    @Query("SELECT u FROM User u WHERE u.passportNumber = :passportNumber AND u.password = :password")
    User findByPassportNumberAndPassword(@Param("passportNumber") String passportNumber, @Param("password") String password);


}
