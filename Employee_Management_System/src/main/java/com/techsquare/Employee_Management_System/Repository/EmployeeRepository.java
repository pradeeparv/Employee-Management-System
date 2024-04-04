package com.techsquare.Employee_Management_System.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techsquare.Employee_Management_System.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{

	Optional<Employee> findByname(String name);

}