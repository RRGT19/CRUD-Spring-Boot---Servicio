package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Methods that will be called by different endpoints calls.
 */
@RestController
public class StudentController {

  // Required dependencies
  private final StudentServiceImpl service;

  // Constructor-based dependency injection
  @Autowired
  public StudentController(StudentServiceImpl service) {
    this.service = service;
  }

  @GetMapping()
  private List<Student> getAllPersons() {
    return service.getAll();
  }

  @GetMapping("/{id}")
  private Student getStudentById(@PathVariable int id) {
    return service.getStudentById(id);
  }

  @DeleteMapping("/{id}")
  private void delete(@PathVariable int id) {
    service.delete(id);
  }

  @PostMapping
  private void save(@RequestBody Student student) {
    service.save(student);
  }

  @PutMapping
  private void update(@RequestBody Student student) {
    service.update(student);
  }

}
