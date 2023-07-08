package com.arvs.epgs.service;

import java.util.List;

import com.arvs.epgs.model.Attendence;
import com.arvs.epgs.model.Employee;
import com.arvs.epgs.model.Site;
import com.arvs.epgs.payload.AttendenceDto;


public interface AttendenceService {
	
	AttendenceDto createAttendence(AttendenceDto attendenceDto,Long siteId,Long employeeId);

	AttendenceDto updateAttendence(AttendenceDto attendence,Long attendenceId);

    void deleteAttendence(Long attendenceId);
    
    List<AttendenceDto> getAllAttendences();
    
    AttendenceDto getAttendenceById(Long attendenceId);
    
    List<AttendenceDto> getAttendencesBySite(Long siteId);
    
    List<AttendenceDto> getAttendencesByEmployee(Long employeeId);
    List<AttendenceDto> findByDateBetween(java.sql.Date start,java.sql.Date end);
    List<AttendenceDto> findByEmployeeAndDateBetween(java.sql.Date start,java.sql.Date end,Long employeeId);

}
