package com.arvs.epgs.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arvs.epgs.model.Attendence;
import com.arvs.epgs.model.Employee;
import com.arvs.epgs.payload.ApiResponse;
import com.arvs.epgs.payload.AttendenceDto;
import com.arvs.epgs.payload.EmployeeDto;
import com.arvs.epgs.payload.EmployeePaymentDto;
import com.arvs.epgs.service.AttendenceService;
import com.arvs.epgs.service.EmployeeService;
import com.arvs.epgs.util.DatabaseUtil;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class AttendenceController {
	
	@Autowired
	private DatabaseUtil databaseUtil;
	
	@Autowired
	private AttendenceService attendenceService;
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/attendences")
	public ResponseEntity<List<AttendenceDto>> fetchAll(){
		List<AttendenceDto> attendences = attendenceService.getAllAttendences();
		return new ResponseEntity<>(attendences, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/attendences/{attandenceId}")
	public ResponseEntity<ApiResponse> deleteSite(@PathVariable Long attandenceId ){
		attendenceService.deleteAttendence(attandenceId);
		return new ResponseEntity(new ApiResponse("Attandence deleted Successfully",true),HttpStatus.OK);
		
	}
	@GetMapping("/attendences/{startdate}/to/{enddate}")
	public ResponseEntity<List<AttendenceDto>> fetchAllBetweenStartEnd(@PathVariable Date startdate,@PathVariable Date enddate){
		List<AttendenceDto> attendences = attendenceService.findByDateBetween(startdate, enddate);
		return new ResponseEntity<>(attendences, HttpStatus.OK);
		
	}
	@GetMapping("/attendences/employee/{employeeId}/{startdate}/to/{enddate}")
	public ResponseEntity<Map<String, Object>> fetchByEmployeeIDBetweenStartEnd(@PathVariable java.sql.Date startdate,@PathVariable java.sql.Date enddate,@PathVariable Long employeeId){
		List<AttendenceDto> attendences = attendenceService.findByEmployeeAndDateBetween(startdate, enddate,employeeId);
		System.out.println("size"+attendences.size());
		EmployeePaymentDto obj = createReportData(attendences,employeeId);
		Map<String, Object> map = new HashMap<>();
		map.put("a",obj);
		map.put("attendences",attendences);
		return new ResponseEntity<>(map, HttpStatus.OK);
		
	}
	@GetMapping("/attendences/employee/{employeeId}/{startdate}/to/{enddate}/p")
	public ResponseEntity<List<AttendenceDto>> fetchByEmployeeIDBetweenStartEnd1(@PathVariable java.sql.Date startdate,@PathVariable java.sql.Date enddate,@PathVariable Long employeeId){
		List<AttendenceDto> attendences = attendenceService.findByDateBetween(startdate, enddate);
		return new ResponseEntity<>(attendences, HttpStatus.OK);
		
	}
	@PostMapping("/attendences/site/{siteId}/employee/{employeeId}")
    public ResponseEntity<AttendenceDto> createAttendence(@Valid @RequestBody AttendenceDto attendencedDto,@PathVariable Long siteId,@PathVariable Long employeeId){
		
		AttendenceDto savedattendenceDto = attendenceService.createAttendence(attendencedDto,siteId,employeeId);
		
        return new ResponseEntity<AttendenceDto>(savedattendenceDto, HttpStatus.CREATED);
    }
	
	@GetMapping("/employees/{employeeId}/attendences")
	public ResponseEntity<List<AttendenceDto>> getAttendenceByEmployee(@PathVariable Long employeeId){
		
		
		List<AttendenceDto> attendenceDtos = attendenceService.getAttendencesByEmployee(employeeId);
		return new ResponseEntity<List<AttendenceDto>>(attendenceDtos,HttpStatus.OK);
		
	}
	
	@GetMapping("/attendences/init")
	public String initAttendence(){
		LocalDate localdate = LocalDate.now();
		localdate=localdate.minusDays(30);
		   OffsetDateTime offsetDT = OffsetDateTime.now();  
		   offsetDT= offsetDT.minusDays(30);
		for(int i=0;i<31;i++) {
		AttendenceDto attendencedDto = new AttendenceDto();
		attendencedDto.setStatus("P");
	//	Instant instant = localdate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
		//Date res = (Date) Date.from(instant);
		//java.sql.Date sqlDate = java.sql.Date.valueOf( localDate );
		attendencedDto.setDate(Date.valueOf(localdate.plusDays(i)));
		attendencedDto.setDay(offsetDT.plusDays(i).getDayOfWeek().toString());
		attendencedDto.setOverTime('N');
		attendencedDto.setHours(8.0f);
		attendencedDto.setStartFrom("Noida");
		attendencedDto.setEndTo("Noida");
		attendencedDto.setConveyanceExpenses(0.0f);
		attendencedDto.setAdvance(100);
		attendencedDto.setRemarks("CASH");
		AttendenceDto savedattendenceDto = attendenceService.createAttendence(attendencedDto,2L,2L);
		System.out.println("inserted 1"+savedattendenceDto.toString());
	//	.attendencedDto..plusDays(i);
		//localdate.plusDays(i);
		}
		return "success";
		
	}
	
	private EmployeePaymentDto createReportData(List<AttendenceDto> attendences,Long employeeId) {
		//totalWorkingDays workingHours absent present overTimeHours  advance conveyanceExpenses
				//List<AttendenceDto> attendencesList = attendences.stream().filter(a->a.getEmployeeDto().getEmployeeId()==employeeId).collect(Collectors.toList());
			//	System.out.println("size->"+attendencesList.size());
				EmployeePaymentDto employeePaymentDto = new EmployeePaymentDto();
				long totalWorkingDays = attendences.stream().count();
				float workingHours = attendences.stream().map(x->x.getHours()).reduce(0f, (a, b) -> a + b);
				long absent = attendences.stream().map(x->x.getStatus().equalsIgnoreCase("A")).filter(x->x==true).count();
				long present = attendences.stream().map(x->x.getStatus().equalsIgnoreCase("P")).filter(x->x==true).count();
				float overTimeHours = attendences.stream().map(attendence->attendence.getOverTimeHours()).reduce(0f, (a,b) -> a+b);
				float conveyanceExpenses = attendences.stream().map(x->x.getConveyanceExpenses()).reduce(0f, (a,b)->a+b);
				float advance  = attendences.stream().map(x->x.getAdvance()).reduce(0f, (a,b)->a+b);
				//System.out.println("workingDay->"+workingDay);
				EmployeeDto emp = employeeService.getEmployeeById(employeeId);
				employeePaymentDto = mapper.map(emp, EmployeePaymentDto.class);
				employeePaymentDto.setTotalWorkingDays(totalWorkingDays);
				employeePaymentDto.setWorkingHours(workingHours);
				employeePaymentDto.setAbsent(absent);
				employeePaymentDto.setPresent(present);
				employeePaymentDto.setOverTimeHours(overTimeHours);
				employeePaymentDto.setConveyanceExpenses(conveyanceExpenses);
				employeePaymentDto.setAdvance(advance);
				float perHourSalried = employeePaymentDto.getSalary()/(30*8);
				float perHourDaily = employeePaymentDto.getDailyWaseAmount()/8;
				float payment = 0.0f;
				
				if(employeePaymentDto.getType().equalsIgnoreCase("Permanent"))
				{
					//payment = (workingHours<=208)?((perHourSalried * workingHours)+(perHourSalried * overTimeHours)+conveyanceExpenses-advance):((perHourSalried * 208)+(perHourSalried * overTimeHours)+conveyanceExpenses-advance);
				    payment = (perHourSalried * workingHours)+(perHourSalried * overTimeHours)+conveyanceExpenses-advance;
				}
				else if(employeePaymentDto.getType().equalsIgnoreCase("Daily")) {
					payment = (perHourDaily * workingHours)+(perHourDaily * overTimeHours)+conveyanceExpenses-advance;
					
				}
				
				employeePaymentDto.setNetPayment(payment);
		return employeePaymentDto;
	}
	@GetMapping("/backup")
	public String startBackup() throws IOException, InterruptedException{
		String filenameBackup = "Backup"+(new java.util.Date()).toString()+".sql";
		String s =(databaseUtil.backup("epgs", "epgs", "epgs", "bck.sql")==true)?"True":"False";
	return s;
	}
	@GetMapping("/restore")
	public String startrestore() throws IOException, InterruptedException{
		String s =(databaseUtil.restore("epgs", "epgs", "epgs","back.sql" )==true)?"True":"False";
	return s;
	}
}
