package com.studentspringboot.StudentAppProject.services;

import com.studentspringboot.StudentAppProject.Dao.StudentDao;
import com.studentspringboot.StudentAppProject.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentdao;
    @Override
    public List<Student> getAllStudents(){
        return this.studentdao.givingAllStudents();
    }
    @Override
    public Student getSingleStudent(Long id){
        return this.studentdao.getSingleStudent(id);
    }
    @Override
    public Student addStudent(Student student){
        return this.studentdao.addSingleStudent(student);
    }
    @Override
    public Student updateStudent(Student newStudent){
        return this.studentdao.updateSingleStudent(newStudent);
    }
    @Override
    public void deleteStudent(Long id){
        this.studentdao.deleteSingleStudent(id);
    }
    @Override
    public void deleteAll(){
        this.studentdao.deletingAllStudents();
    }
}
