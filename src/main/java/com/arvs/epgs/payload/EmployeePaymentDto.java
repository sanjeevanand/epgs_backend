package com.arvs.epgs.payload;

import java.sql.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class EmployeePaymentDto {
 
	private Long employeeId;
	
	private String name;
	
	private String mobile1;
	
	private String mobile2;
	
	private String email;
	
	private String address;
	
	private String role;
	
	private String type;
	
	private float salary;
	
	private float dailyWaseAmount;
	
	
	
	private long totalWorkingDays;
	private float workingHours;
	private long absent;
	private long present;
	private float overTimeHours;
	private float advance;
	private float conveyanceExpenses;
	private float netPayment;
	
}
