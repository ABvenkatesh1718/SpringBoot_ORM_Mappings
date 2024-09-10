package com.main.repository;

import com.main.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;
    @Test
    public void saveCourse(){
        Course myCourse = Course.builder()
                .title("java")
                .credit("10")
                .build();
        courseRepository.save(myCourse);
    }

}