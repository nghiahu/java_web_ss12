package com.example.session12.service.student;

import com.example.session12.dto.Student;
import com.example.session12.repository.student.StudentRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRepositoryImp studentRepositoryImp;

    @Override
    public List<Student> findAll() {
        return studentRepositoryImp.findAll();
    }

    @Override
    public Student findById(int id) {
        return studentRepositoryImp.findById(id);
    }

    @Override
    public boolean save(Student student) {
        return studentRepositoryImp.save(student);
    }

    @Override
    public boolean update(Student student) {
        return studentRepositoryImp.update(student);
    }

    @Override
    public boolean delete(int id) {
        return studentRepositoryImp.delete(id);
    }
}
