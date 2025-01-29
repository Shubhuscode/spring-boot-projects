package com.pinnacle.student.controller;

import com.pinnacle.student.model.Student;
import com.pinnacle.student.repository.StudentRepository;
import com.pinnacle.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;

    
    @GetMapping
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "list"; 
    }

    
    @GetMapping("/new")
    public String showStudentForm(Model model) {
        model.addAttribute("student", new Student()); 
        return "form"; 
    }

    
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student, RedirectAttributes redirectAttributes) {
        if (student.getStudentId() != null && student.getStudentId() > 0) {
           
            studentService.saveStudent(student);
            redirectAttributes.addFlashAttribute("message", "Student updated successfully!");
        } else {
           
            studentService.saveStudent(student);
            redirectAttributes.addFlashAttribute("message", "Student registered successfully!");
        }
        return "redirect:/students"; 
    }

    
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return "redirect:/students"; 
        }
        model.addAttribute("student", student); 
        return "form"; 
    }

    
    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        studentService.deleteStudent(id); 
        redirectAttributes.addFlashAttribute("message", "Student deleted successfully!");
        return "redirect:/students"; 
    }

   
//    @PostMapping("/payfees/{id}")
//    public String payFees(@PathVariable Long id, RedirectAttributes redirectAttributes) {
//        Student student = studentRepository.findById(id)
//            .orElseThrow(() -> new RuntimeException("Student not found"));
//
//        Double balanceFees = student.getBalanceFees();
//        Double paidFees = student.getPaidFees();
//
//        
//        if (balanceFees > 0) {
//            student.setPaidFees(paidFees + balanceFees); 
//            student.setBalanceFees(0.0); 
//
//            studentRepository.save(student); 
//            redirectAttributes.addFlashAttribute("message", "Fees paid successfully!");
//        }
//
//        return "redirect:/students";  
//    }
    
    @GetMapping("/students/{id}/payfees")
    public String showStudentForm(@PathVariable Long id, Model model) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        model.addAttribute("student", student);  // Pass the full student object
        return "payfees";  // Template name
    }

    
    @GetMapping("/pay/{id}")
    public String showPayFeesPage(@PathVariable Long id, Model model) {
        Student student = studentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Student not found"));

        model.addAttribute("student", student); // Pass student data to the page
        return "payfees";  // Return the payment page template
    }
    
    @PostMapping("/payfees/{id}")
    public String payFees(@PathVariable Long id, @RequestParam(required = false) Double payFees, RedirectAttributes redirectAttributes) {
        if (payFees == null) {
            redirectAttributes.addFlashAttribute("message", "PayFees is required.");
            return "redirect:/students";
        }

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Double balanceFees = student.getBalanceFees();
        Double paidFees = student.getPaidFees();

        if (payFees > balanceFees) {
            redirectAttributes.addFlashAttribute("message", "Payment exceeds the balance fees.");
        } else {
            student.setPaidFees(paidFees + payFees);
            student.setBalanceFees(balanceFees - payFees);
            studentRepository.save(student);
            redirectAttributes.addFlashAttribute("message", "Fees paid successfully!");
        }

        return "redirect:/students";
    }





}
