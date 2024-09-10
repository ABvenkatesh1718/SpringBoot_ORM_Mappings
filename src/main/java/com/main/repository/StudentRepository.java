package com.main.repository;

import com.main.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
   Optional<Student> findByFirstName(String firstName);

}
