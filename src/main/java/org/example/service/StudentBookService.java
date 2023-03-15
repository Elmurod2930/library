package org.example.service;

import org.example.repository.StudentBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentBookService {
    @Autowired
    private StudentBookRepository studentBookRepository;
    public void studentTakenBook() {
        studentBookRepository.studentTakenBook();
    }
}
