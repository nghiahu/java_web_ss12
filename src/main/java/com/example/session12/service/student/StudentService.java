package com.example.session12.service.student;

import com.example.session12.dto.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(int id);
    boolean save(Student student);
    boolean update(Student student);
    boolean delete(int id);
}
