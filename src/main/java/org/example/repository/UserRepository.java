package org.example.repository;


import org.example.dto.Student;
import org.example.util.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Student getByPhoneNumber(String next) {
        String sql = String.format("SELECT * FROM student Where phone = ", next);
        List<Student> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        if (list.size() > 0) {
            Container.student = list.get(0);
            return list.get(0);
        }
        return null;
    }
}
