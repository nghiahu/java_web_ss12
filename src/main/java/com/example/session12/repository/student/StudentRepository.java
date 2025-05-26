package com.example.session12.repository.student;

import com.example.session12.dto.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
    Student findById(int id);
    boolean save(Student student);
    boolean delete(int id);
    boolean update(Student student);
}
