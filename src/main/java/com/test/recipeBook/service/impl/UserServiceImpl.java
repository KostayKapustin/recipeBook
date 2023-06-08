package com.test.recipeBook.service.impl;

import com.test.recipeBook.model.User;
import com.test.recipeBook.repository.UserRepository;
import com.test.recipeBook.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Override
    public User findByUsername(String name) {
        return null;
    }

    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getByLogin(String login) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User u = getByLogin(login);
        if (Objects.isNull(u)) {
            throw new UsernameNotFoundException(String.format("User %s is not found", login));
        }
        return new org.springframework.security.core.userdetails.User(
                u.getLogin(),
                u.getPassword(),
                true,
                true,
                true,
                true,
                new HashSet<>());
    }
}
