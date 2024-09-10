package com.main.repository;

import com.main.entity.Course;
import com.main.entity.CourseMaterial;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;


@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private  CourseMaterialRepository courseMaterialRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void saveCourseMaterial(){
        CourseMaterial courseMaterial=CourseMaterial.builder()
                .url("www.oracle.com")
                .build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void saveMappingObject(){
        CourseMaterial courseMaterial=CourseMaterial.builder()
                .url("java documentation")
                .build();
        courseMaterialRepository.save(courseMaterial);
        Course course=Course.builder()
                .courseMaterial(courseMaterial)
                .title("Java SE 11")
                .credit("100")
                .build();
        courseRepository.save(course);
        System.out.println("course = " + course);
        System.out.println("courseMaterial = " + courseMaterial);
    }


}