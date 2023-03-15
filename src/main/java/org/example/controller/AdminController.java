package org.example.controller;

import org.example.dto.Book;
import org.example.dto.Student;
import org.example.service.BookService;
import org.example.service.StudentBookService;
import org.example.service.UserService;
import org.example.util.Container;
import org.example.util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    @Autowired
    private StudentBookService studentBookService;

    public void adminMenu() {
        boolean b = true;
        while (b) {
            System.out.println("1 => Book list\n2 => Add book\n3 => Delete book\n4 => Student List\n5 => Add Student" +
                    "\n6 => Delete student\n7 => Student Taken book\n8 => BookTaken History\n0 => Exit");
            System.out.print("Enter action: ");
            int action = ScannerUtil.IntScanner.nextInt();
            switch (action) {
                case 0:
                    b = false;
                    break;
                case 1:
                    bookList();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    deleteBook();
                    break;
                case 4:
                    studentList();
                    break;
                case 5:
                    addStudent();
                    break;
                case 6:
                    deleteStudent();
                    break;
                case 7:
                    studentTakenBook();
                    break;
                case 8:
                    bookTakenHistory();
                    break;
            }
        }
    }

    /*book*/
    public void bookList() {
        bookService.bookList();
    }

    public void addBook() {
        System.out.print("Enter title: ");
        String title = ScannerUtil.StringScanner.next();
        System.out.print("Enter author: ");
        String author = ScannerUtil.StringScanner.next();
        System.out.print("Enter amount: ");
        Integer amount = ScannerUtil.IntScanner.nextInt();
        Book book = new Book(title, author, amount);
        bookService.addBook(book);
    }

    public void deleteBook() {
        System.out.printf("Enter id: ");
        Integer id = ScannerUtil.IntScanner.nextInt();
        bookService.deleteBook(id);
    }

    /*student*/

    public void studentList() {
        userService.studentList();
    }

    public void addStudent() {
        System.out.print("Enter name: ");
        String name = ScannerUtil.StringScanner.next();
        System.out.print("Enter surname: ");
        String surname = ScannerUtil.StringScanner.next();
        System.out.print("Enter phone: ");
        String phone = ScannerUtil.StringScanner.next();
        Student student = new Student(name, surname, phone);
        userService.addStudent(student);
    }

    public void deleteStudent() {
        System.out.printf("Enter id: ");
        Integer id = ScannerUtil.IntScanner.nextInt();
        userService.deleteStudent(id);
    }

    /*statistic*/

    public void studentTakenBook() {
        studentBookService.studentTakenBook();
    }

    public void bookTakenHistory() {
    }
}
