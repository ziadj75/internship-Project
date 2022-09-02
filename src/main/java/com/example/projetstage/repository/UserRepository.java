package com.example.projetstage.repository;

import com.example.projetstage.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
    User findUserByEmail(String email);
    List<User> findUserByLastLoginDate(Date login);
    List<User> findAll();
    @Query("select c from User c where hour(c.lastLoginDate) = :hour And minute(c.lastLoginDate)=:minute")
    List<User> pointagePeerDeadLine(@Param("hour") int hour ,@Param("minute") int minute);

}
