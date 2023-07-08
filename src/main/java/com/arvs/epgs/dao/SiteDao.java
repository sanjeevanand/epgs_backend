package com.arvs.epgs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arvs.epgs.model.Site;

public interface  SiteDao  extends JpaRepository<Site, Long>{

}
