package com.example.entity;

import com.example.entity.enums.StudentStatus;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;
@Getter
@Setter
@Entity(name = "student_book")
public class StudentBookEntity {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "book_id")
    private Integer bookId;
    @CreationTimestamp
    private Timestamp createdDate;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StudentStatus status;
    @Column(name = "returned_date")
    private Timestamp returnedDate;
    @Column(name = "duration")
    private Integer duration;
}
