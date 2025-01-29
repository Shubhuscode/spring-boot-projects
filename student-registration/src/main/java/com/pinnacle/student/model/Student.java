package com.pinnacle.student.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;

    private String studentName;
    private String studentCollege;
    private String studentAddress;
    private String studentContactNo;
    private String studentParentContactNo;
    private String course;
    private Double paidFees = 0.0;  
    private Double balanceFees = 0.0;  
    
    private String name;
    private double feesAmount;

    
    public Student() {
    }

    
    public Student(Long studentId, String studentName, String studentCollege, String studentAddress,
                   String studentContactNo, String studentParentContactNo, String course, 
                   Double paidFees, Double balanceFees) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentCollege = studentCollege;
        this.studentAddress = studentAddress;
        this.studentContactNo = studentContactNo;
        this.studentParentContactNo = studentParentContactNo;
        this.course = course;
        this.paidFees = paidFees;
        this.balanceFees = balanceFees;
    }

    // Constructor
    public Student(String name, String course) {
        this.name = name;
        this.course = course;
    }

  
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCollege() {
        return studentCollege;
    }

    public void setStudentCollege(String studentCollege) {
        this.studentCollege = studentCollege;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentContactNo() {
        return studentContactNo;
    }

    public void setStudentContactNo(String studentContactNo) {
        this.studentContactNo = studentContactNo;
    }

    public String getStudentParentContactNo() {
        return studentParentContactNo;
    }

    public void setStudentParentContactNo(String studentParentContactNo) {
        this.studentParentContactNo = studentParentContactNo;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Double getBalanceFees() {
        return balanceFees == null ? 0.0 : balanceFees;  
    }

    public void setBalanceFees(Double balanceFees) {
        this.balanceFees = balanceFees;
    }

    public Double getPaidFees() {
        return paidFees == null ? 0.0 : paidFees;  
    }

    public void setPaidFees(Double paidFees) {
        this.paidFees = paidFees;
    }
   
    // Getters
    public String getName() {
        return name;
    }
    
    public double getFeesAmount() {
        return feesAmount;
    }

    public void setFeesAmount(double feesAmount) {
        this.feesAmount = feesAmount;
    }

    

}
