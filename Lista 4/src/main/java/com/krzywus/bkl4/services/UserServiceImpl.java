package com.krzywus.bkl4.services;

import com.krzywus.bkl4.Repository.UserRepository;
import com.krzywus.bkl4.model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor(onConstructor = @_(@Autowired))
@NoArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository repository;

    @Override
    public boolean registerNewUserAccount(final String username, final String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));

        return repository.save(user) != null;
    }

    @Override
    public boolean login(String username, String password) {
        User user = repository.findUserByUsername(username);
        if (user == null ) return false;
        return passwordEncoder.matches(password, user.getPassword());
    }
}
