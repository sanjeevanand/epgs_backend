package com.arvs.epgs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.arvs.epgs.payload.ApiResponse;
import com.arvs.epgs.payload.AttendenceDto;
import com.arvs.epgs.payload.EmployeePaymentDto;
import com.arvs.epgs.payload.ExpenceDto;
import com.arvs.epgs.payload.ExpenceSumDto;
import com.arvs.epgs.service.ExpenceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class ExpenceController {
	
	@Autowired
	private ExpenceService expenceService;
	
	@PostMapping("/expences")
	public ResponseEntity<ExpenceDto> createExpences(@Valid @RequestBody ExpenceDto expenceDto) {
		
		ExpenceDto expenceObj = expenceService.createExpence(expenceDto);
		 return new ResponseEntity<>(expenceObj, HttpStatus.CREATED);
	}
	
	@PutMapping("/expences/{expenceId}")
	public ResponseEntity<ExpenceDto> updateExpence(@Valid @RequestBody ExpenceDto expenceDto,@PathVariable Long expenceId){
		ExpenceDto expenceDtoObj =    expenceService.updateExpence(expenceDto, expenceId);
		
		return ResponseEntity.ok(expenceDtoObj);
	}
	
	@DeleteMapping("/expences/{expenceId}")
	public ResponseEntity<ApiResponse> deleteExpence(@PathVariable Long expenceId ){
		expenceService.deleteExpence(expenceId);
		return new ResponseEntity(new ApiResponse("Sites deleted Successfully",true),HttpStatus.OK);
		
	}
	
	@GetMapping("/expences")
	public ResponseEntity<List<ExpenceDto>> getAll(){
		return ResponseEntity.ok(expenceService.getAllExpences());
		
	}
	
	@GetMapping("/expences/{expenceId}")
	public ResponseEntity<ExpenceDto> getfindById(@PathVariable Long expenceId){
		return ResponseEntity.ok(expenceService.getExpenceById(expenceId));
		
	}
	
	@GetMapping("/expences/{startdate}/to/{enddate}")
	public ResponseEntity<Map<String, Object>> fetchByEmployeeIDBetweenStartEnd(@PathVariable java.sql.Date startdate,@PathVariable java.sql.Date enddate){
	//	List<AttendenceDto> attendences = attendenceService.findByEmployeeAndDateBetween(startdate, enddate,employeeId);
		List<ExpenceDto> expences = expenceService.findByDateBetween(startdate, enddate);
		System.out.println("size"+expences.size());
		ExpenceSumDto obj = createReportData(expences);
		Map<String, Object> map = new HashMap<>();
		map.put("a",obj);
		map.put("expences",expences);
		return new ResponseEntity<>(map, HttpStatus.OK);
		
	}
	private ExpenceSumDto createReportData(List<ExpenceDto> expences) {
		
		ExpenceSumDto obj = new ExpenceSumDto();
		float totalExpence = expences.stream().map(expence->expence.getExpenceAmount()).reduce(0f,(a,b)->a+b);
		obj.setSumAmount(totalExpence);
		obj.setName("Expences");
		return obj;
	}
}
