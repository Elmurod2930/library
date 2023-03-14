package org.example.controller;

import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.example.util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;
    public void menu() {
        System.out.println("1 => Login\n0 => Exit");
        System.out.print("Enter action: ");
        int action = ScannerUtil.IntScanner.nextByte();
        switch (action) {
            case 0: login(); break;
            case 1: break;
        }
    }
    public void login(){
        System.out.print("Enter phone number: ");
        userService.login(ScannerUtil.StringScanner.next());
    }
}
