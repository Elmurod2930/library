package org.example.controller;

import org.example.service.BookService;
import org.example.service.UserService;
import org.example.util.Container;
import org.example.util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    public void userMenu() {
        boolean b = true;
        while (b) {
            System.out.println("1 => Book list\n2 => Take book\n" +
                    "3 => Taken book\n4 => Return book\n5 => History\n6 => Order book\n0 => Exit");

            System.out.print("Enter action: ");
            int action = ScannerUtil.IntScanner.nextByte();
            switch (action) {
                case 0:
                    b = false;
                    break;
                case 1:
                    bookList();
                    break;
                case 2:
                    takeBook();
                    break;
                case 3:
                    takenBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    history();
                    break;
                case 6:
                    orderBook();
                    break;
            }
        }
    }

    public void bookList() {
        System.out.println("*****Book list*****");
        userService.bookList();
    }

    public void takeBook() {
        System.out.print("Enter book id: ");
        userService.takeBook(ScannerUtil.IntScanner.nextInt());
    }

    public void takenBook() {
        userService.takenBook();
    }

    public void returnBook() {
        System.out.print("Enter book id: ");
        Integer id = ScannerUtil.IntScanner.nextInt();
        bookService.returnBook(id);
    }

    public void history() {
        userService.history();
    }

    public void orderBook() {
        System.out.print("Enter title: ");
        String title = ScannerUtil.StringScanner.next();
        bookService.orderBook(title);
    }

}
