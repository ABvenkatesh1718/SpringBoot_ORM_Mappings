package com.main.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
public class Student{

    @SequenceGenerator(
            name="student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 10
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Integer id;
    private String firstName;
    private String lastName;
    @Column(nullable = false)
    private String emailId;
    @OneToOne(
            cascade = CascadeType.ALL,orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "guarian_id",referencedColumnName = "id")
    private Guardian guardian;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name="course_purchased_by_student")
    private List<Course>listOfCourses;



}
