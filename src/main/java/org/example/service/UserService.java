package org.example.service;

import org.example.controller.AdminController;
import org.example.controller.UserController;
import org.example.dto.Book;
import org.example.dto.Student;
import org.example.enums.StudentStatus;
import org.example.repository.BookRepository;
import org.example.repository.StudentBookRepository;
import org.example.repository.UserRepository;
import org.example.util.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserController userController;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AdminController adminController;
    @Autowired
    private StudentBookRepository studentBookRepository;

    public void login(String phone) {
        Student student = userRepository.getByPhoneNumber(phone);
        Container.student = student;
        if (student == null) {
            System.out.print("not fount student");
        }
//        adminController.adminMenu();
        userController.userMenu();
    }

    public void bookList() {
        List<Book> books = bookRepository.bookList();
        books.forEach(System.out::println);
    }

    public void takeBook(int id) {
        Book book = bookRepository.getByBookId(id).get(0);
        if (book.getAmount() == 0) {
            System.out.println("bunaqa kitob qolmagan");
            return;
        }
//        if (bookRepository.takenBook().size() > 4) {
//            System.out.println("5 tadan ortiq kitob olish mumkin emas");
//            return;
//        }
        System.out.println(bookRepository.takeBook(book));
    }

    public void takenBook() {
        bookRepository.takenBook().forEach(System.out::println);
    }

    public void studentList() {
        userRepository.studentlist().forEach(System.out::println);
    }

    public void addStudent(Student student) {
        Student studentObj = userRepository.getByPhoneNumber(student.getPhone());
        if (studentObj != null) {
            System.out.print(userRepository.changeVisible(studentObj.getId()));
        }
        System.out.print(userRepository.addStudent(student));
    }

    public void deleteStudent(Integer id) {
        Student student = userRepository.getById(id);
        if (student == null) {
            System.out.printf("not fount student");
        }
        System.out.println(userRepository.deleteStudent(id));
    }

    public void history() {
        studentBookRepository.getStudentBookInfoList().forEach(System.out::println);
    }
}
