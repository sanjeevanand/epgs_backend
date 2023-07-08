package com.arvs.epgs.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
	private Long employeeId;
	@NotBlank
	private String name;
	@NotBlank
	private String mobile1;
	
	private String mobile2;
	@Email
	private String email;
	@NotBlank
	private String address;
	@NotBlank
	private String role;
	@NotBlank
	private String type;
	@NotNull
	private float salary;
	
	private float dailyWaseAmount;

}
