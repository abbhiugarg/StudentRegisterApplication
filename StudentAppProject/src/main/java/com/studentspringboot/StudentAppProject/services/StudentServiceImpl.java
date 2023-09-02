package com.studentspringboot.StudentAppProject.services;

import com.studentspringboot.StudentAppProject.Dao.StudentRepository;
import com.studentspringboot.StudentAppProject.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudents(){
        return this.studentRepository.findAll();
    }
    @Override
    public Student getSingleStudent(Long id){
        Student student = null;
        Optional<Student> optStudent= this.studentRepository.findById(id);
        student = optStudent.get();
        return student;
    }
    @Override
    public Student addStudent(Student student){
        System.out.println(this.studentRepository.save(student));
        return this.studentRepository.save(student);
    }
    @Override
    public Student updateStudent(Student newStudent){
        Long id= newStudent.getId();
        Student existingStudent = getSingleStudent(id);
        if (existingStudent != null) {
            return this.studentRepository.save(newStudent);
        }
        else {
            return null;
        }
    }
    @Override
    public void deleteStudent(Long id){
        this.studentRepository.deleteById(id);
    }
    @Override
    public void deleteAll(){
        this.studentRepository.deleteAll();
    }
}
