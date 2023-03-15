package org.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.Status;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "studentBook")
public class StudentBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "book_id")
    private Integer bookId;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @Column(name = "status")

    private String status;
    @Column(name = "returned_date")
    private LocalDateTime returnedDate;
    @Column(name = "duration")
    private Integer duration;
}
