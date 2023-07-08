/**
 * 
 */
package com.arvs.epgs.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arvs.epgs.dao.ExpenceDao;
import com.arvs.epgs.dao.SiteDao;
import com.arvs.epgs.exception.ResourceNotFoundException;
import com.arvs.epgs.model.Attendence;
import com.arvs.epgs.model.Expence;
import com.arvs.epgs.model.Site;
import com.arvs.epgs.payload.AttendenceDto;
import com.arvs.epgs.payload.EmployeeDto;
import com.arvs.epgs.payload.ExpenceDto;
import com.arvs.epgs.payload.SiteDto;

/**
 * @author SANJEEV
 *
 */
@Service
public class ExpenceServiceImpl implements ExpenceService {
	
	@Autowired
	private ExpenceDao expenceDao;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ExpenceDto createExpence(ExpenceDto expenceDto) {
		// TODO Auto-generated method stub
		Expence expence = modelMapper.map(expenceDto, Expence.class);
		expence =   expenceDao.save(expence);
		return modelMapper.map(expence, ExpenceDto.class);
	}

	@Override
	public ExpenceDto getExpenceById(Long expenceId) {
		// TODO Auto-generated method stub
		Expence expence = expenceDao.findById(expenceId).orElseThrow(()-> new ResourceNotFoundException("ExpenceId"," Id ",""+expenceId));
		
		return modelMapper.map(expence, ExpenceDto.class);
	}

	@Override
	public ExpenceDto updateExpence(ExpenceDto expenceDto, Long expenceId) {
		// TODO Auto-generated method stub
		Expence expence = expenceDao.findById(expenceId).orElseThrow(()-> new ResourceNotFoundException("Expence"," Id ",""+expenceId));
		Expence expenceObj = modelMapper.map(expenceDto, Expence.class);
		expenceObj.setExpenceId(expence.getExpenceId());
		Expence savedExpence = expenceDao.save(expenceObj);
		
		return modelMapper.map(savedExpence, ExpenceDto.class);
	}

	@Override
	public void deleteExpence(Long expenceId) {
		// TODO Auto-generated method stub
		Expence expence = expenceDao.findById(expenceId).orElseThrow(()-> new ResourceNotFoundException("Expence"," Id ",""+expenceId));
		expenceDao.delete(expence);
	}

	@Override
	public List<ExpenceDto> getAllExpences() {
		// TODO Auto-generated method stub
		List<Expence> expences = expenceDao.findAll();
		List<ExpenceDto> expenceDtos = expences.stream().map(expence -> modelMapper.map(expence, ExpenceDto.class)).collect(Collectors.toList());
		Collections.sort(expenceDtos,
				(obj1, obj2) -> ((int)obj2.getExpenceId()) - ((int)obj1.getExpenceId()) );
		return expenceDtos;
	}

	@Override
	public List<ExpenceDto> findByDateBetween(Date start, Date end) {
		// TODO Auto-generated method stub
		List<Expence> expences = expenceDao.findByDateBetween(start, end);
			
			List<ExpenceDto> expencesDtos =  new ArrayList<>();
			expences.forEach(a->{
				ExpenceDto obj =new ExpenceDto();
					obj= modelMapper.map(a,ExpenceDto.class);
					//obj.setExpenceDto(modelMapper.map(a.getEmployee(), EmployeeDto.class));
					expencesDtos.add(obj);
				});
			Collections.sort(expencesDtos,
					(obj1, obj2) -> ((int)obj2.getExpenceId()) - ((int)obj1.getExpenceId()) );
			
				return expencesDtos;
	}

}
