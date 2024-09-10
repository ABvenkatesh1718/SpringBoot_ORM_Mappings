package com.main.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
public class Course {

    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 2
    )
    @Id
    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Integer id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String credit;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_material")
    private CourseMaterial courseMaterial;

    @ManyToOne
    private Student student;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name="course_instructor")
    private Teacher teacher;


}


