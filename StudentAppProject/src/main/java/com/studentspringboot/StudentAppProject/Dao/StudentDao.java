package com.studentspringboot.StudentAppProject.Dao;

import com.studentspringboot.StudentAppProject.entities.Student;

import java.util.List;

public interface StudentDao {
    List<Student> givingAllStudents();
    Student getSingleStudent(Long id);
    Student addSingleStudent(Student student);
    Student updateSingleStudent(Student newStudent);
    void deleteSingleStudent(Long id);
    void deletingAllStudents();
}
