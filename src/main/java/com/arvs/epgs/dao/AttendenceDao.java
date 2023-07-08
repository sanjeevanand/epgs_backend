package com.arvs.epgs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arvs.epgs.model.Attendence;
import com.arvs.epgs.model.Employee;
import com.arvs.epgs.model.Site;

public interface AttendenceDao extends JpaRepository<Attendence, Long> {
	
	List<Attendence> findByEmployee(Employee employee);
	List<Attendence> findBySite(Site site);
	List<Attendence> findByDateBetween(java.sql.Date start,java.sql.Date end);
	@Query(value="SELECT * FROM attendence where employee_id = :employeeId and date between :start and :end", nativeQuery=true)
	List<Attendence> findByEmployeeAndDateBetween(java.sql.Date start,java.sql.Date end,Long employeeId);

}
