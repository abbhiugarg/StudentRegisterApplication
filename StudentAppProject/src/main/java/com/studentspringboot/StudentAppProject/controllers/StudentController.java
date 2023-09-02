package com.studentspringboot.StudentAppProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studentspringboot.StudentAppProject.entities.Student;
import com.studentspringboot.StudentAppProject.services.StudentService;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudents(){
        return this.studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable Long id){
        return this.studentService.getSingleStudent(id);
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        return this.studentService.addStudent(student);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student newStudent){
        return this.studentService.updateStudent(newStudent);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id){
        this.studentService.deleteStudent(id);
    }

    @DeleteMapping("/students")
    public void deleteAllStudents(){
        this.studentService.deleteAll();
    }
}
