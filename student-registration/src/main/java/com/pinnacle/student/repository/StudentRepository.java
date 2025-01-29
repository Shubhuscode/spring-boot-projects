package com.pinnacle.student.repository;

import com.pinnacle.student.model.Student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
	 // Method to get the count of students who paid fees
    long countByPaidFeesGreaterThan(double amount);

    // Method to get the count of students who have a balance
    long countByBalanceFeesGreaterThan(double amount);

    // Method to get count of students who paid the full amount (balanceFees == 0)
    long countByPaidFeesGreaterThanAndBalanceFeesEquals(double paidAmount, double balanceAmount);

    // Method to get students who have paid fees
    List<Student> findByPaidFeesGreaterThan(double amount);

    // Method to get students who have balance fees
    List<Student> findByBalanceFeesGreaterThan(double amount);

    // Method to get students who have paid all their fees (balanceFees == 0)
    List<Student> findByPaidFeesGreaterThanAndBalanceFeesEquals(double paidAmount, double balanceAmount);

    
    
    
}
