package com.example.service;

import com.example.dao.UserDAO;
import com.example.model.User;

public class UserService {
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public String createUser (User user) {
        return userDAO.createUser (user);
    }

    public String updateUser (User user) {
        return userDAO.updateUser (user);
    }

    public User getUser(String email) {
        return userDAO.getUser (email);
    }

    public String deleteUser (String email) {
        return userDAO.deleteUser (email);
    }
}