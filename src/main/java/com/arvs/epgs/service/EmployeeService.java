package com.arvs.epgs.service;

import java.util.List;

import com.arvs.epgs.model.Employee;
import com.arvs.epgs.payload.EmployeeDto;

public interface EmployeeService {
	
	    EmployeeDto createEmployee(EmployeeDto employeeDto);
	    
	    EmployeeDto updateEmployee(EmployeeDto employeeDto,Long employeeId);

	    void deleteEmployee(Long employeeId);

	    EmployeeDto getEmployeeById(Long employeeId);

	    List<EmployeeDto> getAllEmployees();

	   

}
