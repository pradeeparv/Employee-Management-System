package com.techsquare.Employee_Management_System.Service;

import java.util.List;

import com.techsquare.Employee_Management_System.Model.EmployeeDto;

public interface EmployeeService 
{
	public String addemployee(EmployeeDto employeedto)throws Exception;
	public List<EmployeeDto> getallemployee()throws Exception;
	 public String deleteemployee(String name)throws Exception;
	 public EmployeeDto getemployee(String name)throws Exception;
	 public String updateemployee(EmployeeDto employeedto)throws Exception;
}
