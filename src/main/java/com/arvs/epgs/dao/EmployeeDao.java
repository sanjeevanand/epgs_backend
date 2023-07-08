package com.arvs.epgs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arvs.epgs.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long> {

}
