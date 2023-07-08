package com.arvs.epgs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arvs.epgs.model.Employee;
import com.arvs.epgs.payload.ApiResponse;
import com.arvs.epgs.payload.EmployeeDto;
import com.arvs.epgs.payload.SiteDto;
import com.arvs.epgs.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeDto>> fetchAll(){
		List<EmployeeDto> employees = employeeService.getAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
		
	}
	
	  // build create User REST API
    @PostMapping("/employees")
    public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto employeeDto){
    	EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    
    @PutMapping("/employees/{employeeId}")
	public ResponseEntity<EmployeeDto> updateEmployee(@Valid @RequestBody EmployeeDto employeeDto,@PathVariable Long employeeId){
    	EmployeeDto employeeDtoObj =    employeeService.updateEmployee(employeeDto, employeeId);
		
		return ResponseEntity.ok(employeeDtoObj);
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public ResponseEntity<ApiResponse> deleteEmployee(@PathVariable Long employeeId ){
		employeeService.deleteEmployee(employeeId);
		return new ResponseEntity(new ApiResponse("Employee deleted Successfully",true),HttpStatus.OK);
		
	}
	
    
    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long employeeId){
    	EmployeeDto employee = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
	

}
