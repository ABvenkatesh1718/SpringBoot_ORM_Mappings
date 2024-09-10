package com.main.entity;

import com.main.repository.CourseRepository;
import com.main.repository.GuardianRepository;
import com.main.repository.StudentRepository;
import com.main.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class AddingData {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void addStudentData(){

        Guardian guardian=Guardian.builder()
                .guardianName("guardian")
                .guardianGmail("gurandian@gmail.com")
                .mobileNumber(String.valueOf(123456778))
                .build();
        Student student=Student.builder()
                .emailId("student@gmail.com")
                .firstName("firstName")
                .lastName("lastName")
                .guardian(guardian)
                .build();
        studentRepository.save(student);


        CourseMaterial courseMaterial=CourseMaterial
                .builder()
                .url("courseMaterial")
                .build();
        Teacher teacher=Teacher.builder()
                .firstName("firstName")
                .lastName("lastName")
                .build();

        Course course=Course.builder()
                .courseMaterial(courseMaterial)
                .teacher(teacher)
                .student(student)
                .credit("10")
                .title("java")
                .build();
        courseRepository.save(course);
        student.setListOfCourses(List.of(course));
        studentRepository.save(student);


    }

}