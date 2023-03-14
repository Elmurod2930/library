package org.example.service;

import org.example.controller.UserController;
import org.example.dto.Student;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserController userController;

    public void login(String next) {
        Student student = userRepository.getByPhoneNumber(next);
        if (student == null) {
            System.out.print("not fount student");
        }
        userController.userMenu();
    }
}
