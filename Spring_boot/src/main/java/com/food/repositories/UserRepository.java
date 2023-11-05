package com.food.repositories;

import com.food.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.username=?1 and u.password=?2")
    User findByUsernameAndUserPassword(String username, String userPassword);
    @Query("select u from User u where u.username=?1")

    User findByUsername(String username);
}
