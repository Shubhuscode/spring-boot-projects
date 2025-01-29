package com.pinnacle.student.controller;

import com.pinnacle.student.model.Student;
import com.pinnacle.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @Autowired
    private StudentRepository studentRepository;
    @GetMapping("/")
    public String home(Model model) {
        long totalStudents = studentRepository.count(); // Get total number of students
        
        // Get the number of students who have paid fees and have no balance
        long paidStudents = studentRepository.countByPaidFeesGreaterThanAndBalanceFeesEquals(0, 0); 
        
        // Get the number of students with a balance
        long balanceStudents = studentRepository.countByBalanceFeesGreaterThan(0);
        
        // Get the number of fully paid students (balanceFees == 0 and paidFees > 0)
        long fullyPaidStudents = studentRepository.countByPaidFeesGreaterThanAndBalanceFeesEquals(0, 0); 

        // Add data to the model
        model.addAttribute("totalStudents", totalStudents);
        model.addAttribute("paidStudents", paidStudents);  // Paid students with balance 0
        model.addAttribute("balanceStudents", balanceStudents);  // Students with balance fees > 0
        model.addAttribute("fullyPaidStudents", fullyPaidStudents); // Fully paid students count
        model.addAttribute("welcomeMessage", "Welcome to the Student Management System!");

        return "home"; // return home.html
    }



    @GetMapping("/courses")
    public String viewCourses(Model model) {
        // Retrieve the list of students
        List<Student> students = studentRepository.findAll();

        // Group students by course
        Map<String, List<Student>> studentsByCourse = students.stream()
                .collect(Collectors.groupingBy(Student::getCourse)); // Group by the 'course' field

        // Add the grouped students to the model
        model.addAttribute("studentsByCourse", studentsByCourse);

        return "courses";  // Return the Thymeleaf template for courses
    }


    // View Paid Students: Display all students who have paid fees
//    @GetMapping("/paid-students")
//    public String viewPaidStudents(Model model) {
//        List<Student> paidStudents = studentRepository.findByPaidFeesGreaterThan(0); // Direct query to get paid students
//        model.addAttribute("students", paidStudents); // Add list of paid students
//        return "students-list"; // return students-list.html
//    }
    
    @GetMapping("/paid-students")
    public String viewPaidStudents(Model model) {
        // Retrieve students who have paid all their fees (paidFees > 0 and balanceFees == 0)
        List<Student> paidStudents = studentRepository.findByPaidFeesGreaterThanAndBalanceFeesEquals(0, 0); 
        model.addAttribute("students", paidStudents); // Add list of fully paid students
        return "students-list"; // Return the Thymeleaf template for displaying students
    }

    // View Balance Students: Display all students who have a balance fee
    @GetMapping("/balance-students")
    public String viewBalanceStudents(Model model) {
        List<Student> balanceStudents = studentRepository.findByBalanceFeesGreaterThan(0); // Direct query to get balance students
        model.addAttribute("students", balanceStudents); // Add list of balance students
        return "students-list"; // return students-list.html
    }
}
