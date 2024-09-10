package com.main.repository;

import com.main.entity.Guardian;
import com.main.entity.Student;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
class GuardianRepositoryTest {

    @Autowired
    private GuardianRepository guardianRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    public void saveGuardian(){

        Guardian guardian = Guardian.builder()
                .guardianName("grandPa")
                .mobileNumber("9491278037")
                .guardianGmail("venkateshmadireddy123@gmail.com")
                .build();
        guardianRepository.save(guardian);
        Student student=Student.builder()
                .guardian(guardian)
                .emailId("venkateshmadireddy123@gmail.com")
                .firstName("venkatesh")
                .lastName("madireddy")
                .build();
        studentRepository.save(student);
        System.out.println("student = " + student);
        System.out.println("guardian = " + guardian);

    }

}