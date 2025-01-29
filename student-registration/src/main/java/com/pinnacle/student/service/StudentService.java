package com.pinnacle.student.service;

import com.pinnacle.student.model.Student;
import com.pinnacle.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getStudentsByCourse(String course) {
        
        return studentRepository.findAll();
    }

    public List<Student> getStudentsByBalanceFees(Double balanceFees) {
       
        return studentRepository.findAll(); 
    }
}
