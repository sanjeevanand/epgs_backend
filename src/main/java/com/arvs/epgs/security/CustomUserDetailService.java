package com.arvs.epgs.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.arvs.epgs.dao.UserDao;
import com.arvs.epgs.exception.ResourceNotFoundException;
import com.arvs.epgs.model.User;
@Service
public class CustomUserDetailService implements UserDetailsService{
	
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =  userDao.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("User"," Email ",""+username));
		return user;
	}

}

