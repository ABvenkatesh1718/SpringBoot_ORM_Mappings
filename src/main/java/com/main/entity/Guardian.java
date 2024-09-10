package com.main.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString(exclude = "student")
public class Guardian {

    @SequenceGenerator(
            name="Guardian_sequence",
            sequenceName = "Guardian_sequence",
            allocationSize = 2
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Guardian_sequence"

    )

    private Integer id;
    private String guardianName;
    private String guardianGmail;
    private String mobileNumber;

    @OneToOne(mappedBy = "guardian")
    private Student student;


}
