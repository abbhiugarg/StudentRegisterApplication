package com.studentspringboot.StudentAppProject.services;

import com.studentspringboot.StudentAppProject.entities.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getSingleStudent(Long id);
    Student addStudent(Student student);
    Student updateStudent(Student newStudent);
    void deleteStudent(Long id);
    void deleteAll();
}
