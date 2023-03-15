package org.example.repository;


import org.example.dto.Student;
import org.example.util.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.lang.module.ResolutionException;
import java.sql.*;
import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Student getByPhoneNumber(String phone) {
        try {
            String sql = String.format("SELECT * FROM student Where phone = '%s'", phone);
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library_db", "postgres", "1234");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
//        Student student = (Student) jdbcTemplate.queryForList(sql, Student.class);
            if (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setPhone(resultSet.getString("phone"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setVisible(resultSet.getBoolean("visible"));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Student> studentlist() {
        String sql = "select * from student";
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        return studentList;
    }

    public int changeVisible(Integer id) {
        String sql = "update student set visible=true";
        return jdbcTemplate.update(sql);
    }

    public int addStudent(Student student) {
        String sql = "insert into student(name,surname,phone,visible,created_date) values('%s','%s','%s',true,now())";
        sql = String.format(sql, student.getName(), student.getSurname(), student.getPhone());
        return jdbcTemplate.update(sql);
    }

    public Student getById(Integer id) {
        String sql = "select * from student where id = " + id;
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Student.class));
    }

    public int deleteStudent(Integer id) {
        String sql = "update student set visible=false";
        return jdbcTemplate.update(sql);
    }
}
