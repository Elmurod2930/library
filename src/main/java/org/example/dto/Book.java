package org.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "publishYear")
    private LocalDateTime publishYear;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "visible")
    private Boolean visible;

    public Book(String title, String author, Integer amount) {
        this.title = title;
        this.author = author;
        this.amount = amount;
        this.visible=true;
    }

}
