package com.example.controller;

import com.example.dto.StudentDTO;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping(value = "/create")
    public StudentDTO create(@RequestBody StudentDTO studentDTO) {
        return studentService.crate(studentDTO);
    }

    @GetMapping("/list")
    public List<StudentDTO> getAll() {
        List<StudentDTO> list = studentService.getAll();
        return list;
    }

    @GetMapping(value = "/get/{id}")
    public StudentDTO getById(@PathVariable("id") Integer id) {
        return studentService.getById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        return studentService.delete(id);
    }

    @PutMapping(value = "/update/{id}")
    public Boolean update(@PathVariable("id") Integer id, @RequestBody StudentDTO studentDTO) {
        return studentService.update(id, studentDTO);
    }

}
