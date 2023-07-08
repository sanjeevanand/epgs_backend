package com.arvs.epgs.service;

import java.util.List;

import com.arvs.epgs.payload.SiteDto;

public interface SiteService {
	
	SiteDto createSite(SiteDto site);

	SiteDto getSiteById(Long siteId);

    SiteDto updateSite(SiteDto siteDto,Long siteId);

    void deleteSite(Long SiteId);
    
    List<SiteDto> getAllSites();
	

}
