package com.main.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data
public class Teacher {

    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName="teacher_sequence",
            allocationSize=2
    )

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "teacher_sequence")
    private Integer id;
    private String firstName;
    private String lastName;
    @OneToOne(mappedBy = "teacher")
    private Course course;

}
