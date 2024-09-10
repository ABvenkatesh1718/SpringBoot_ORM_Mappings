package com.main.repository;

import com.main.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest

class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student st1 = Student.builder()
                .firstName("venkatesh")
                .lastName("madireddy")
                .emailId("venkateshmadireddy123@gamil.com")
                .build();
        Student st2 = Student.builder()
                .firstName("srinivas")
                .lastName("madireddy")
                .emailId("venkateshmadireddy123@gmail.com")
                .build();
        studentRepository.saveAll(List.of(st1, st2));
    }

    @Test
    public void getStudents(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void getStudentById(){
        Student student1 = studentRepository.findById(2).get();
        System.out.println("student1 = " + student1);
    }

    @Test
    public void findByFirstName(){
        Optional<Student> srinivas = studentRepository.findByFirstName("srinivas");
        srinivas.ifPresent(System.out::println);
    }

}
