package org.example.service;

import org.example.dto.Book;
import org.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired

    private BookRepository bookRepository;


    public void bookList() {
        bookRepository.bookList().forEach(System.out::println);
    }

    public void addBook(Book book) {
        System.out.println(bookRepository.addBook(book));
    }

    public void deleteBook(Integer id) {
        Book book = bookRepository.getByBookId(id).get(0);
        if (book == null) {
            System.out.printf("bot fount book");
            return;
        }
        System.out.print(bookRepository.deleteBook(id));
    }

    public void returnBook(Integer id) {
        System.out.println(bookRepository.getByBookId(id).get(0));
    }

    public void orderBook(String title) {

    }
}
