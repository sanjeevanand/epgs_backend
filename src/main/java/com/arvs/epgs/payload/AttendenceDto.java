package com.arvs.epgs.payload;

import java.sql.Date;

import com.arvs.epgs.model.Employee;
import com.arvs.epgs.model.Site;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class AttendenceDto {
	
	private long attandenceId;
	@NotEmpty
	private String day;
	
	private Date date;
	@NotEmpty
	private String status;
	
	private float hours;
	private char overTime;
	private float overTimeHours;
//	@NotEmpty
	private String startFrom;
//	@NotEmpty
	private String endTo;
	
	private float conveyanceExpenses;
	
	private float advance;
	
	private String remarks;
	
	private SiteDto siteDto;
	
	private EmployeeDto employeeDto;
	

}
