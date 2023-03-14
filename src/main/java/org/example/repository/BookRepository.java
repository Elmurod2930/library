package org.example.repository;

import org.example.dto.Book;
import org.example.dto.StudentBook;
import org.example.util.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Book> bookList() {
        String sql = String.format("select * from books");
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
        return bookList;
    }

    public Integer takeBook(Book book) {
        String sql = String.format("update books set amount = '%d' where id = '%d'", (book.getAmount() - 1), book.getId());
        return jdbcTemplate.update(sql);
    }

    public List<Book> getByBookId(int id) {
        String sql = String.format("select * from books where id ='%d'", id);
        List<Book> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
        return list;
    }

    public List<StudentBook> takenBook() {
        String sql = String.format("select * from studentBook where student_id ='%d'", Container.student.getId());
        List<StudentBook> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StudentBook.class));
        return list;
    }
}
