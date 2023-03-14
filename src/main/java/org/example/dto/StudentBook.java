package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.Status;

import java.time.LocalDateTime;

@Setter
@Getter
public class StudentBook {
    private Integer id;
    private Integer studentId;
    private Integer bookId;
    private LocalDateTime createdDate;
    private Status status;
    private LocalDateTime returnedDate;
    private String duration;
}
