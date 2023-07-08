package com.arvs.epgs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arvs.epgs.dao.EmployeeDao;
import com.arvs.epgs.exception.ResourceNotFoundException;
import com.arvs.epgs.model.Employee;
import com.arvs.epgs.model.Site;
import com.arvs.epgs.payload.EmployeeDto;
import com.arvs.epgs.payload.SiteDto;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Service
@Transactional
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		Employee employee = this.modelMapper.map(employeeDto, Employee.class);
		Employee savedEmployee = employeeDao.save(employee);
		return modelMapper.map(savedEmployee, EmployeeDto.class);
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto,Long employeeId) {
		// TODO Auto-generated method stub
		Employee employee = employeeDao.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Site"," Id ",""+employeeId));
		Employee employeeObj = modelMapper.map(employeeDto, Employee.class);
		employeeObj.setEmployeeId(employee.getEmployeeId());
		Employee savedEmployee = employeeDao.save(employeeObj);
		
		return modelMapper.map(savedEmployee, EmployeeDto.class);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		// TODO Auto-generated method stub
		Employee employee = employeeDao.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee"," Id ",""+employeeId));
		employeeDao.delete(employee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		// TODO Auto-generated method stub
		Employee employee = employeeDao.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee"," Id ",""+employeeId));
		
		return modelMapper.map(employee, EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees = employeeDao.findAll();
		List<EmployeeDto> employeeDtos = employees.stream().map(employee -> modelMapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());
		return employeeDtos;
	}
	
	/*
	 * @Override public Employee createEmployee(Employee employee) { // TODO
	 * Auto-generated method stub return employeeDao.save(employee); }
	 * 
	 * @Override public Employee getEmployeeById(Long employeeId) { // TODO
	 * Auto-generated method stub return employeeDao.findById(employeeId).get(); }
	 * 
	 * @Override public List<Employee> getAllEmployees() { return
	 * employeeDao.findAll(); }
	 * 
	 * @Override public Employee updateEmployee(Employee employee) { // TODO
	 * Auto-generated method stub employeeDao.findById(employee.getEmployeeId());
	 * 
	 * return null; }
	 * 
	 * @Override public void deleteEmployee(Long employeeId) { // TODO
	 * Auto-generated method stub employeeDao.deleteById(employeeId); }
	 */
}
