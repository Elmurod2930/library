package org.example.util;

import org.example.dto.Book;
import org.example.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Container {
    @Autowired
    public static Student student = null;
}
