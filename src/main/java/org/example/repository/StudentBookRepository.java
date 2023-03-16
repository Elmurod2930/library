package org.example.repository;

import org.example.dto.StudentTakenBook;
import org.example.mapper.StudentTakenBookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.Access;
import java.util.List;

@Repository

public class StudentBookRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void studentTakenBook() {
    }
    public List<StudentTakenBook> getStudentBookInfoList() {
        String sql = " select sb.id, sb.status, sb.created_date,   " + "  s.id as sId, s.name as sName, s.surname as sSurname, " + "  b.id as bId, b.title as bTitle, b.author as bAuthor " + " from studentbook sb inner join student as s on s.id = sb.student_id " + " inner join books as b on b.id = sb.book_id ";
        List<StudentTakenBook> list = jdbcTemplate.query(sql, new StudentTakenBookMapper());
        return list;
    }

}
