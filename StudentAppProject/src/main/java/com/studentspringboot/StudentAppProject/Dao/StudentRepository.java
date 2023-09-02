package com.studentspringboot.StudentAppProject.Dao;

import com.studentspringboot.StudentAppProject.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {


}
