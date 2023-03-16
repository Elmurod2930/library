package org.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
public class StudentTakenBook {
    private Integer id;
    private LocalDateTime createdDate;
    private Student student;
    private Book book;


}
