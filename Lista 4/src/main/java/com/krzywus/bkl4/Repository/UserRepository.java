package com.krzywus.bkl4.Repository;

import com.krzywus.bkl4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}
