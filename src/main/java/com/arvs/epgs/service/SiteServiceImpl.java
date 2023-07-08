package com.arvs.epgs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.arvs.epgs.dao.SiteDao;
import com.arvs.epgs.exception.ResourceNotFoundException;
import com.arvs.epgs.model.Site;
import com.arvs.epgs.payload.SiteDto;

@Service
public class SiteServiceImpl implements SiteService {

	@Autowired
	private SiteDao siteDao;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
    private JavaMailSender mailSender;

	@Override
	public SiteDto createSite(SiteDto siteDto) {
		// TODO Auto-generated method stub
		Site site = this.modelMapper.map(siteDto, Site.class);
		Site savedSite = siteDao.save(site);
		/*
		 * String from = "bricksmbco@gmail.com"; String to =
		 *
		 * 
		 * SimpleMailMessage message = new SimpleMailMessage();
		 * 
		 * message.setFrom(from); message.setTo(to);
		 * message.setSubject("This is a plain text email");
		 * message.setText("Hello guys! This is a plain text email.");
		 * 
		 * mailSender.send(message);
		 */
		return modelMapper.map(savedSite, SiteDto.class);
	}

	@Override
	public SiteDto getSiteById(Long siteId) {
		// TODO Auto-generated method stub
		Site site = siteDao.findById(siteId).orElseThrow(()-> new ResourceNotFoundException("Site"," Id ",""+siteId));
		
		return modelMapper.map(site, SiteDto.class);
	}

	@Override
	public SiteDto updateSite(SiteDto siteDto, Long siteId) {
		// TODO Auto-generated method stub
		Site site = siteDao.findById(siteId).orElseThrow(()-> new ResourceNotFoundException("Site"," Id ",""+siteId));
		Site siteObj = modelMapper.map(siteDto, Site.class);
		siteObj.setSiteId(site.getSiteId());
		Site savedSite = siteDao.save(siteObj);
		
		return modelMapper.map(savedSite, SiteDto.class);
	}

	@Override
	public void deleteSite(Long SiteId) {
		// TODO Auto-generated method stub
		Site site = siteDao.findById(SiteId).orElseThrow(()-> new ResourceNotFoundException("Site"," Id ",""+SiteId));
		siteDao.delete(site);
	}

	@Override
	public List<SiteDto> getAllSites() {
		// TODO Auto-generated method stub
		
		List<Site> sites = siteDao.findAll();
		List<SiteDto> siteDtos = sites.stream().map(site -> modelMapper.map(site, SiteDto.class)).collect(Collectors.toList());
		return siteDtos;
	}
	
	/*
	 * public void delete(Site site) { siteDao.delete(site); }
	 * 
	 * @Override public Site createSite(Site site) { // TODO Auto-generated method
	 * stub return siteDao.save(site); }
	 * 
	 * @Override public Site getSiteById(Long siteId) { // TODO Auto-generated
	 * method stub try { Optional<Site> site = siteDao.findById(siteId);
	 * 
	 * return site.get();} catch(NoSuchElementException e ) { return null; }
	 * 
	 * 
	 * 
	 * }
	 * 
	 * @Override public List<Site> getAllSites() { // TODO Auto-generated method
	 * stub return siteDao.findAll(); }
	 * 
	 * @Override public Site updateSite(Site site) { // TODO Auto-generated method
	 * stub siteDao.findById(site.getSiteId()).orElseThrow(()-> new
	 * ResourceNotFoundException("Site Not Exists")); return siteDao.save(site);
	 * 
	 * }
	 * 
	 * @Override public void deleteSite(Long SiteId) { // Site obj =
	 * siteDao.deleteById(SiteId); siteDao.deleteById(SiteId);
	 * 
	 * }
	 */
}
