package com.example.session12.controller;

import com.example.session12.dto.Student;
import com.example.session12.service.student.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class StudentController {

    @Autowired
    private StudentServiceImp studentServiceImp;

    @GetMapping("listStudent")
    public String listStudent(Model model) {
        model.addAttribute("students", studentServiceImp.findAll());
        return "listStudent";
    }

    @GetMapping("addStudent")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "addStudent";
    }

    @GetMapping("editStudent")
    public String editStudent(@RequestParam("id") int id, Model model) {
        model.addAttribute("student", studentServiceImp.findById(id));
        return "editStudent";
    }

    @PostMapping("student-save")
    public String saveStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addStudent";
        }else {
            studentServiceImp.save(student);
            return "redirect:/listStudent";
        }
    }
    @PostMapping("student-edit")
    public String updateStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "editStudent";
        }
        studentServiceImp.update(student);
        return "redirect:/listStudent";
    }

    @GetMapping("delStudent")
    public String deleteStudent(@RequestParam("id") int id) {
        studentServiceImp.delete(id);
        return "redirect:/listStudent";
    }
}
