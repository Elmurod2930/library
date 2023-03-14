package org.example.service;

import org.example.controller.UserController;
import org.example.dto.Book;
import org.example.dto.Student;
import org.example.repository.BookRepository;
import org.example.repository.UserRepository;
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

    public void login(String next) {
        Student student = userRepository.getByPhoneNumber(next);
        if (student == null) {
            System.out.print("not fount student");
        }
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
        if (bookRepository.takenBook().size() > 4) {
            System.out.println("5 tadan ortiq kitob olish mumkin emas");
            return;
        }
        System.out.println(bookRepository.takeBook(book));
    }

    public void takenBook() {
        bookRepository.takenBook().forEach(System.out::println);
    }
}
