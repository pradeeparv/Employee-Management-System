package com.techsquare.Employee_Management_System.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techsquare.Employee_Management_System.Entity.Employee;
import com.techsquare.Employee_Management_System.Model.EmployeeDto;
import com.techsquare.Employee_Management_System.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
   @Autowired
   private EmployeeRepository employeerepo;
   
   public String addemployee(EmployeeDto employeedto)throws Exception
   {
	Optional<Employee> optional=employeerepo.findByname(employeedto.getName());
	if(optional.isPresent()) {
		throw new Exception("Service already created");
	}
	   
	Employee employee=new Employee();
	employee.setName(employeedto.getName());
	employee.setEmailId(employeedto.getEmailId());
	employee.setDate(employeedto.getDate());
	employee.setGender(employeedto.getGender());
	employee.setSalary(employeedto.getSalary());
	employee.setPhoneNumber(employeedto.getPhoneNumber());
	employee.setEmployeeStatus(employeedto.getEmployeeStatus());
	employeerepo.save(employee);
	
	return employee.getName();
	   
   }
   
   public List<EmployeeDto> getallemployee()throws Exception
   {
	List<EmployeeDto> optional=new ArrayList<>();
	List<Employee> employee=employeerepo.findAll();
	
	for(Employee emp:employee) {
		
		EmployeeDto employeedto=new EmployeeDto();
		employeedto.setId(emp.getId());
		employeedto.setName(emp.getName());
		employeedto.setEmailId(emp.getEmailId());
		employeedto.setDate(emp.getDate());
		employeedto.setGender(emp.getGender());	
		employeedto.setSalary(emp.getSalary());
		employeedto.setPhoneNumber(emp.getPhoneNumber());
		employeedto.setEmployeeStatus(emp.getEmployeeStatus());
		optional.add(employeedto);
	}
	
	return optional;
	   
   }
   
   public String deleteemployee(String name)throws Exception
   {
	 Optional<Employee> optional=employeerepo.findByname(name);
	 employeerepo.delete(optional.get());
	return name;
	   
   }
   
   public EmployeeDto getemployee(String name)throws Exception
   {
	Optional<Employee> optional=employeerepo.findByname(name);
	
	if(optional.isPresent()) {
		Employee employ=optional.get();
		EmployeeDto employeedto=new EmployeeDto();
		
		employeedto.setId(employ.getId());
		employeedto.setName(employ.getName());
		employeedto.setEmailId(employ.getEmailId());
		employeedto.setDate(employ.getDate());
		employeedto.setGender(employ.getGender());
		employeedto.setSalary(employ.getSalary());
		employeedto.setPhoneNumber(employ.getPhoneNumber());
		employeedto.setEmployeeStatus(employ.getEmployeeStatus());
		return employeedto;
	}
	else
	{
		throw new Exception("Service not found"+name);
	}	   
   }
   
   public String updateemployee(EmployeeDto employeedto)throws Exception{
	
	   Optional<Employee> optional=employeerepo.findByname(employeedto.getName());
	   if(optional.isEmpty()) {
	   
		   throw new Exception("Service not created");
	   }
	   Employee employee=optional.get();
	   employee.setId(employeedto.getId());
	   employee.setName(employeedto.getName());
	   employee.setEmailId(employeedto.getEmailId());
	   employee.setDate(employeedto.getDate());
	   employee.setGender(employeedto.getGender());
	   employee.setSalary(employeedto.getSalary());
	   employee.setPhoneNumber(employeedto.getPhoneNumber());
	   employee.setEmployeeStatus(employeedto.getEmployeeStatus());
	   employeerepo.save(employee);
	  
	   return employee.getName();
	   
   }
}
