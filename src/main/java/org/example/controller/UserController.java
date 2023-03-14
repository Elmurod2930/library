package org.example.controller;

import org.example.service.UserService;
import org.example.util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    private ScannerUtil scannerUtil;
    public void userMenu() {
        System.out.println("1 => Book list\n2 => Take book\n" +
                "3 => Taken book\n4 => Return book\n5 => History\n6 => Order book\n0 => Exit");

        System.out.print("Enter action: ");
        int action = ScannerUtil.IntScanner.nextByte();
        switch (action) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
    }
    public void bookList(){
        System.out.println("*****Book list*****");
       // userService.bookList();
    }
}
