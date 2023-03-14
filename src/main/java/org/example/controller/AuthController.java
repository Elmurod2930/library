package org.example.controller;

import org.example.service.UserService;
import org.example.util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;

    public void menu() {
        boolean b = true;
        while (b) {
            System.out.println("\n1 => Login\n0 => Exit");
            System.out.print("Enter action: ");
            int action = ScannerUtil.IntScanner.nextInt();
            switch (action) {
                case 1:
                    login();
                    break;
                case 0:
                    b = false;
                    break;
                default:
                    System.out.println("mazgimisan");
            }
        }
    }

    public void login() {
        System.out.print("Enter phone number: ");
        userService.login(ScannerUtil.StringScanner.next());
    }
}
