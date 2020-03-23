package com.start.service;

import com.start.dao.UserDao;
import com.start.model.dto.UserDto;
import com.start.model.entities.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }


    public void delete(long id) {
        userDao.deleteById(id);
    }


    public User findOne(String username) {
        return userDao.findByUsername(username);
    }


    public User findById(Long id) {
        Optional<User> optionalUser = userDao.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return  null;
        }
    }


    public User save(UserDto user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setAge(user.getAge());
        newUser.setSalary(user.getSalary());
        return userDao.save(newUser);
    }

}
