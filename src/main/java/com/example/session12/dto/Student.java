package com.example.session12.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class Student {
    private int id;
    @NotBlank(message = "Tên sinh viên không được để trống") @NotNull
    private String name;
    @NotNull @NotBlank(message = "Email không được để trống")
    @Email(message = "Email phải đúng định dạng")
    private String email;
    @Past(message = "Ngày sinh phải là một ngày trong quá khứ")
    @NotNull(message = "Ngày sinh không được để trống")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;


    public Student() {
    }

    public Student(int id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
