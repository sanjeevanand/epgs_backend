package com.arvs.epgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arvs.epgs.payload.JwtAuthRequest;
import com.arvs.epgs.payload.JwtAuthResonse;
import com.arvs.epgs.payload.SiteDto;
import com.arvs.epgs.payload.UserDto;
import com.arvs.epgs.security.JwtTokenHelper;
import com.arvs.epgs.service.UserService;

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {
	
	
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private PasswordEncoder encoder;
	

    @PostMapping("/register")
    public ResponseEntity<UserDto>  registerStudent(@RequestBody UserDto userDto) {
    	userDto.setPassword(encoder.encode(userDto.getPassword()));
    	UserDto userDtoObj =	userService.createUser(userDto);
		 return new ResponseEntity<>(userDtoObj, HttpStatus.CREATED);
       
    }

    @PostMapping("/login")
    public String login(){
        return "Successfully logged in by user: "+SecurityContextHolder
        		.getContext().getAuthentication().getName();
    }
	@PostMapping("/login1")
	public ResponseEntity<JwtAuthResonse> createToken(@RequestBody JwtAuthRequest jwtAuthRequest) throws Exception{
		
		this.authenticate(jwtAuthRequest.getUsername(),jwtAuthRequest.getPassword());
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(jwtAuthRequest.getUsername());
		String token = this.jwtTokenHelper.generateToken(userDetails);
		JwtAuthResonse resonse = new JwtAuthResonse();
		resonse.setToken(token);
		return new ResponseEntity<JwtAuthResonse>(resonse,HttpStatus.OK);
		
	}

	private void authenticate(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);
		try {
		this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		
		}
		catch(DisabledException de) {
			throw new Exception("Disable user");
			
		}
	}

}
