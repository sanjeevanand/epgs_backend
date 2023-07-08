package com.arvs.epgs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arvs.epgs.model.Expence;
import com.arvs.epgs.payload.ExpenceDto;
import com.arvs.epgs.payload.SiteDto;


public interface ExpenceService {
	
	ExpenceDto createExpence(ExpenceDto site);

	ExpenceDto getExpenceById(Long expenceId);

	ExpenceDto updateExpence(ExpenceDto expenceDto,Long expenceId);

    void deleteExpence(Long expenceId);
    
    List<ExpenceDto> getAllExpences();
    List<ExpenceDto> findByDateBetween(java.sql.Date start,java.sql.Date end);

}
