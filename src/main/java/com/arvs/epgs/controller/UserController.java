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
import com.arvs.epgs.payload.UserDto;
import com.arvs.epgs.service.SiteService;
import com.arvs.epgs.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/users")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		
		UserDto userDto1 = userService.createUser(userDto);
		 return new ResponseEntity<>(userDto1, HttpStatus.CREATED);
	}
	
	@PutMapping("/users/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable Long userId){
		UserDto userDtoObj =    userService.updateUser(userDto, userId);
		
		return ResponseEntity.ok(userDtoObj);
	}
	
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long userId ){
		userService.deleteUser(userId);
		return new ResponseEntity(new ApiResponse("Users deleted Successfully",true),HttpStatus.OK);
		
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> getAll(){
		return ResponseEntity.ok(userService.getAllUser());
		
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<UserDto> getfindById(@PathVariable Long userId){
		return ResponseEntity.ok(userService.getuserById(userId));
		
	}
	
	
}
