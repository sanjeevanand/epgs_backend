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

import com.arvs.epgs.exception.ResourceNotFoundException;
import com.arvs.epgs.model.Site;
import com.arvs.epgs.payload.ApiResponse;
import com.arvs.epgs.payload.SiteDto;
import com.arvs.epgs.service.SiteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class SiteController {
	
	@Autowired
	private SiteService siteService;
	
	@PostMapping("/sites")
	public ResponseEntity<SiteDto> createSite(@Valid @RequestBody SiteDto siteDto) {
		
		SiteDto siteDtoObj = siteService.createSite(siteDto);
		 return new ResponseEntity<>(siteDtoObj, HttpStatus.CREATED);
	}
	
	@PutMapping("/sites/{siteId}")
	public ResponseEntity<SiteDto> updateSite(@Valid @RequestBody SiteDto siteDto,@PathVariable Long siteId){
		SiteDto siteDtoObj =    siteService.updateSite(siteDto, siteId);
		
		return ResponseEntity.ok(siteDtoObj);
	}
	
	@DeleteMapping("/sites/{siteId}")
	public ResponseEntity<ApiResponse> deleteSite(@PathVariable Long siteId ){
		siteService.deleteSite(siteId);
		return new ResponseEntity(new ApiResponse("Sites deleted Successfully",true),HttpStatus.OK);
		
	}
	
	@GetMapping("/sites")
	public ResponseEntity<List<SiteDto>> getAll(){
		return ResponseEntity.ok(siteService.getAllSites());
		
	}
	
	@GetMapping("/sites/{siteId}")
	public ResponseEntity<SiteDto> getfindById(@PathVariable Long siteId){
		return ResponseEntity.ok(siteService.getSiteById(siteId));
		
	}
	
	/*
	 * @GetMapping("/sites") public ResponseEntity<List<Site>> fetchAll(){
	 * 
	 * List<Site> sites = siteService.getAllSites(); return new
	 * ResponseEntity<>(sites,HttpStatus.OK); }
	 * 
	 * @GetMapping("/sites/{id}") public ResponseEntity<Site>
	 * getSiteById(@PathVariable Long id){ Site obj = siteService.getSiteById(id);
	 * if (null!=obj) { return new ResponseEntity<>(obj, HttpStatus.OK); } else {
	 * return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
	 * 
	 * }
	 * 
	 * @PutMapping("sites/{id}") public ResponseEntity<Site>
	 * updateSite(@PathVariable Long id,@RequestBody Site site){ Site obj =
	 * siteService.getSiteById(id); if(null!=obj) {
	 * 
	 * obj.setSiteName(site.getSiteName()); obj.setAddress(site.getAddress()); obj =
	 * siteService.updateSite(obj); return new ResponseEntity<>(obj, HttpStatus.OK);
	 * } else { return new ResponseEntity<>(HttpStatus.NOT_FOUND); } }
	 * 
	 * @DeleteMapping("/sites/{id}") public ResponseEntity<Map<String, Boolean>>
	 * delete(@PathVariable Long id){
	 * 
	 * Map<String,Boolean> response = new HashMap<>();
	 * 
	 * 
	 * Site site = siteService.getSiteById(id);
	 * 
	 * if(null!=site) { siteService.deleteSite(id); response.put("deleted",
	 * Boolean.TRUE);
	 * 
	 * }else {
	 * 
	 * throw new ResourceNotFoundException("Site not exist with id :" + id); }
	 * 
	 * 
	 * 
	 * return new ResponseEntity<>(response,HttpStatus.NOT_FOUND); }
	 */
}
