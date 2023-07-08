package com.arvs.epgs.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arvs.epgs.dao.AttendenceDao;
import com.arvs.epgs.dao.EmployeeDao;
import com.arvs.epgs.dao.SiteDao;
import com.arvs.epgs.exception.ResourceNotFoundException;
import com.arvs.epgs.model.Attendence;
import com.arvs.epgs.model.Employee;
import com.arvs.epgs.model.Site;
import com.arvs.epgs.payload.AttendenceDto;
import com.arvs.epgs.payload.EmployeeDto;
import com.arvs.epgs.payload.SiteDto;

import jakarta.transaction.Transactional;

@Service
public class AttendenceServiceImpl implements AttendenceService {

	@Autowired
	private AttendenceDao attendenceDao;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private SiteDao siteDao;

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public AttendenceDto createAttendence(AttendenceDto attendenceDto, Long siteId, Long employeeId) {
		// TODO Auto-generated method stub
		Site site = siteDao.findById(siteId)
				.orElseThrow(() -> new ResourceNotFoundException("Site", " Id ", "" + siteId));
		Employee employee = employeeDao.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", " Id ", "" + employeeId));

		Attendence attendence = this.modelMapper.map(attendenceDto, Attendence.class);

		attendence.setSite(site);
		attendence.setEmployee(employee);
		Attendence savedAttendence = attendenceDao.save(attendence);
		savedAttendence.getEmployee();
		AttendenceDto x = modelMapper.map(savedAttendence, AttendenceDto.class);

		return modelMapper.map(x, AttendenceDto.class);
	}

	@Override
	public AttendenceDto updateAttendence(AttendenceDto attendence, Long attendenceId) {
		// TODO Auto-generated method stub
		return null;

	}

	@Override
	public void deleteAttendence(Long attendenceId) {
		// TODO Auto-generated method stub
		Attendence attendence = attendenceDao.findById(attendenceId).orElseThrow(()-> new ResourceNotFoundException("Attendence"," Id ",""+attendenceId));
		attendenceDao.delete(attendence);
	}

	@Override
	public List<AttendenceDto> getAllAttendences() {
		// TODO Auto-generated method stub
		List<Attendence> attendences = attendenceDao.findAll();
		// System.out.println(attendences.toString());

		// List<AttendenceDto> attendenceDtos = attendences.stream().map(a ->
		// modelMapper.map(a, AttendenceDto.class)).collect(Collectors.toList());
		// System.out.println(attendenceDtos.toString());
		List<AttendenceDto> attendenceDtos = new ArrayList<>();
		attendences.forEach(a -> {
			AttendenceDto obj = new AttendenceDto();
			obj = modelMapper.map(a, AttendenceDto.class);
			obj.setEmployeeDto(modelMapper.map(a.getEmployee(), EmployeeDto.class));
			attendenceDtos.add(obj);
		});
		Collections.sort(attendenceDtos,
				(obj1, obj2) -> ((int) obj2.getAttandenceId()) - ((int) obj1.getAttandenceId()));
		return attendenceDtos;
	}

	@Override
	public AttendenceDto getAttendenceById(Long attendenceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AttendenceDto> getAttendencesBySite(Long siteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AttendenceDto> getAttendencesByEmployee(Long employeeId) {
		// TODO Auto-generated method stub
		Employee employee = employeeDao.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", " Id ", "" + employeeId));
		List<Attendence> attendence = attendenceDao.findByEmployee(employee);
		List<AttendenceDto> attendenceDtos = attendence.stream()
				.map(attendenceObj -> modelMapper.map(attendenceObj, AttendenceDto.class)).collect(Collectors.toList());
		return attendenceDtos;
	}

	@Override
	public List<AttendenceDto> findByDateBetween(Date start, Date end) {
		// TODO Auto-generated method stub
		List<Attendence> attendences = attendenceDao.findByDateBetween(start, end);
		attendenceDao.findAll();
		List<AttendenceDto> attendenceDtos = new ArrayList<>();
		attendences.forEach(a -> {
			AttendenceDto obj = new AttendenceDto();
			obj = modelMapper.map(a, AttendenceDto.class);
			obj.setEmployeeDto(modelMapper.map(a.getEmployee(), EmployeeDto.class));
			attendenceDtos.add(obj);
		});
		return attendenceDtos;
	}

	@Override
	public List<AttendenceDto> findByEmployeeAndDateBetween(Date start, Date end, Long employeeId) {
		// TODO Auto-generated method stub

		List<Attendence> attendences = attendenceDao.findByEmployeeAndDateBetween(start, end, employeeId);

		List<AttendenceDto> attendenceDtos = new ArrayList<>();
		attendences.forEach(a -> {
			AttendenceDto obj = new AttendenceDto();
			obj = modelMapper.map(a, AttendenceDto.class);
			obj.setEmployeeDto(modelMapper.map(a.getEmployee(), EmployeeDto.class));
			attendenceDtos.add(obj);
		});
		return attendenceDtos;
	}

	/*
	 * @Override public Attendence createAttendence(Attendence attendence) { // TODO
	 * Auto-generated method stub return attendenceDao.save(attendence); }
	 * 
	 * @Override public Attendence getAttendenceById(Long attendenceId) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public List<Attendence> getAllAttendences() { // TODO
	 * Auto-generated method stub return attendenceDao.findAll(); }
	 * 
	 * @Override public Attendence updateAttendence(Attendence attendence) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public void deleteAttendence(Long attendenceId) { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 */
}
