package com.example.demo.service;

import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Exposing methods that will be called from the controller which interact with the repository.
 */
@Service
public class StudentServiceImpl {

  // Required dependencies
  private final IStudentRepository repository;

  // Constructor-based dependency injection
  @Autowired
  public StudentServiceImpl(IStudentRepository repository) {
    this.repository = repository;
  }

  public List<Student> getAll() {
    List<Student> students = new ArrayList<>();
    repository.findAll().forEach(s -> students.add(s));
    return students;
  }

  public Student getStudentById(int id) {
    Optional<Student> student = repository.findById(id);
    if (student.isPresent()) return student.get();
    else throw new StudentNotFoundException("Usuario no encontrado");
  }

  public void save(Student student) {
    repository.save(student);
  }

  public void update(Student student) {
    Optional<Student> currentStudent = repository.findById(student.getId());
    if (currentStudent.isPresent()) repository.save(student);
    else throw new StudentNotFoundException("Usuario no encontrado");
  }

  public void delete(int id) {
    Optional<Student> currentStudent = repository.findById(id);
    if (currentStudent.isPresent()) repository.deleteById(id);
    else throw new StudentNotFoundException("Usuario no encontrado");
  }

}
