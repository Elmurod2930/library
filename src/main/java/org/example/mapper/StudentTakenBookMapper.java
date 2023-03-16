package org.example.mapper;

import org.example.dto.Book;
import org.example.dto.Book;
import org.example.dto.Student;
import org.example.dto.Student;
import org.example.dto.StudentTakenBook;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentTakenBookMapper implements RowMapper<StudentTakenBook> {
    @Override
    public StudentTakenBook mapRow(ResultSet rs, int rowNum) throws SQLException {
        StudentTakenBook dto = new StudentTakenBook();
        dto.setId(rs.getInt("id"));
        dto.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());

        Student student = new Student();
        student.setId(rs.getInt("sId"));
        student.setName(rs.getString("sName"));
        student.setSurname(rs.getString("sSurname"));
        dto.setStudent(student);

        Book bookDTO = new Book();
        bookDTO.setId(rs.getInt("bId"));
        bookDTO.setTitle(rs.getString("bTitle"));
        bookDTO.setAuthor(rs.getString("bAuthor"));
        dto.setBook(bookDTO);
        return dto;
    }
}
