package org.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class Book {
    private Integer id;
    private String title;
    private String author;
    private LocalDateTime publishYear;
    private Integer amount;
    private Boolean visible;
}
