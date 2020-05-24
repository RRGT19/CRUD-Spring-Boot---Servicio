package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * We are using JPA to interact with the database.
 */
@Repository
public interface IStudentRepository extends CrudRepository<Student, Integer> {
}
