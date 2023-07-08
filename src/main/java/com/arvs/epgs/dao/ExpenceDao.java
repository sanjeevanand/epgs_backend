package com.arvs.epgs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.arvs.epgs.model.Expence;

public interface  ExpenceDao  extends JpaRepository<Expence, Long>{
	@Query(value="SELECT * FROM expence where  updated_at between :start and :end", nativeQuery=true)
	List<Expence> findByDateBetween(java.sql.Date start,java.sql.Date end);

}
