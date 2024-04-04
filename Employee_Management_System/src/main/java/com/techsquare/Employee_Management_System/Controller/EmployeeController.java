package com.techsquare.Employee_Management_System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techsquare.Employee_Management_System.Model.EmployeeDto;
import com.techsquare.Employee_Management_System.Service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employees")
public class EmployeeController 
{
	@Autowired
	private EmployeeServiceImpl employeeservice;
	
	
	@PostMapping("/addemployee")
	public ResponseEntity<String> addemployee(@RequestBody EmployeeDto employeedto)throws Exception
	{
		
		ResponseEntity<String> response=null;
		try {
			String serviceresponse=employeeservice.addemployee(employeedto);
			response=new ResponseEntity<String>(serviceresponse,HttpStatus.CREATED);
		}
		catch(Exception e) {
			if(e.getMessage()!=null) {
				String msg="Service not created successfully";
				response=new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
			}
		}
		return response;
		
	}
	
	@GetMapping("/getallemployee")
	public ResponseEntity<List<EmployeeDto>> getallemployee()throws Exception
	{
		ResponseEntity<List<EmployeeDto>>response=null;
		try {
			List<EmployeeDto> serviceresponse=employeeservice.getallemployee();
			for(EmployeeDto employee:serviceresponse) {
				System.out.println("Id: " +employee.getId());
				System.out.println("Name: "+employee.getName());
				System.out.println("emailId: "+employee.getEmailId());
				System.out.println("date: "+employee.getDate());
				System.out.println("gender: "+employee.getGender());
				System.out.println("phonenumber: "+employee.getPhoneNumber());
				System.out.println("salary: "+employee.getSalary());
				System.out.println("employeestatus: "+employee.getEmployeeStatus());
				System.out.println();
				
			}
		    response=new ResponseEntity<>(serviceresponse,HttpStatus.OK);
		}
		catch(Exception e) {
			   throw e;
			}
		
		
		return response;
		
	}
	
	@DeleteMapping("/deleteemployee")
	public ResponseEntity<String> deleteemployee(@RequestParam String name)throws Exception
	{
		ResponseEntity<String> response=null;
		try {
			String serviceresponse=employeeservice.deleteemployee(name);
			response=new ResponseEntity<String>(serviceresponse,HttpStatus.OK);
		}
		catch(Exception e) {
			if(e.getMessage()!=null) {
				String msg="Service not deleted successfully";
				response=new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
			}
		}
		return response;
		
	}
	
	@GetMapping("/getemployee")
	public ResponseEntity<EmployeeDto> getemployee(@RequestParam String name)throws Exception
	{
		ResponseEntity<EmployeeDto> response=null;
		try {
			EmployeeDto employeedto=employeeservice.getemployee(name);
			System.out.println(employeedto.getId());
			System.out.println(employeedto.getName());
			System.out.println(employeedto.getEmailId());
			System.out.println(employeedto.getGender());
			System.out.println(employeedto.getDate());
			System.out.println(employeedto.getSalary());
			System.out.println(employeedto.getPhoneNumber());
			System.out.println(employeedto.getEmployeeStatus());
			response=new ResponseEntity<>(employeedto,HttpStatus.OK);
		}
		catch(Exception e) {
			throw e;
		}
		return response;
		
	}
	
	@PutMapping("/updateemployee")
	public ResponseEntity<String> updateemployee(@RequestBody EmployeeDto employeedto)throws Exception
	{
		ResponseEntity<String> response=null;
		try {
			String serviceresponse=employeeservice.updateemployee(employeedto);
			response=new ResponseEntity<String>(serviceresponse,HttpStatus.OK);
		}
		catch(Exception e) {
			if(e.getMessage()!=null) {
				String msg="Service not updated successfully";
				response=new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
			}
		}
		return response;
		
	}
	
}
