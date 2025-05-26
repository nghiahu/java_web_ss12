package com.example.session12.repository.student;

import com.example.session12.config.ConnectionDB;
import com.example.session12.dto.Student;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepositoryImp implements StudentRepository {

    @Override
    public List<Student> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Student> students = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call getAllStudent()}");
            callSt.execute();
            ResultSet rs = callSt.getResultSet();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setDob(rs.getDate("dob").toLocalDate());
                students.add(student);
            }
            return students;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return students;
    }

    @Override
    public Student findById(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Student student = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call searchStdById(?)}");
            callSt.setInt(1, id);
            callSt.execute();
            ResultSet rs = callSt.getResultSet();
            if (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setDob(rs.getDate("dob").toLocalDate());
                return student;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return student;
    }

    @Override
    public boolean save(Student student) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call createStudent(?,?,?)}");
            callSt.setString(1, student.getName());
            callSt.setString(2, student.getEmail());
            callSt.setDate(3, Date.valueOf(student.getDob()));
            callSt.execute();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call deleteStudent(?)}");
            callSt.setInt(1, id);
            callSt.execute();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public boolean update(Student student) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call editStudent(?,?,?,?)}");
            callSt.setInt(1, student.getId());
            callSt.setString(2, student.getName());
            callSt.setString(3, student.getEmail());
            callSt.setDate(4, Date.valueOf(student.getDob()));
            callSt.execute();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }
}
