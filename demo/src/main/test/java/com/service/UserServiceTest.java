package com.example.service;

import com.example.dao.UserDAO;
import com.example.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserDAO userDAO;

    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userDAO);
    }

    @Test
    void testCreateUser () {
        User user = new User("John Doe", "john@example.com", "USER");
        when(userDAO.createUser (user)).thenReturn("User  created successfully: John Doe");

        String result = userService.createUser (user);

        assertEquals("User  created successfully: John Doe", result);
        verify(userDAO, times(1)).createUser (user);
    }

    @Test
    void testUpdateUser () {
        User user = new User("John Doe", "john@example.com", "USER");
        when(userDAO.updateUser (user)).thenReturn("User  updated successfully: John Doe");

        String result = userService.updateUser (user);

        assertEquals("User  updated successfully: John Doe", result);
        verify(userDAO, times(1)).updateUser (user);
    }

    @Test
    void testGetUser () {
        User user = new User("John Doe", "john@example.com", "USER");
        when(userDAO.getUser ("john@example.com")).thenReturn(user);

        User result = userService.getUser ("john@example.com");

        assertEquals(user, result);
        verify(userDAO, times(1)).getUser ("john@example.com");
    }

    @Test
    void testDeleteUser () {
        when(userDAO.deleteUser ("john@example.com")).thenReturn("User  deleted successfully: john@example.com");

        String result = userService.deleteUser ("john@example.com");

        assertEquals("User  deleted successfully: john@example.com", result);
        verify(userDAO, times(1)).deleteUser ("john@example.com");
    }
}