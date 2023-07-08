package com.arvs.epgs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.arvs.epgs.dao.UserDao;
import com.arvs.epgs.exception.ResourceNotFoundException;
import com.arvs.epgs.model.Site;
import com.arvs.epgs.model.User;
import com.arvs.epgs.payload.SiteDto;
import com.arvs.epgs.payload.UserDto;
@Service
public class UserServiceImpl implements UserService {
    
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	

	
	@Override
	public UserDto createUser(UserDto user) {
		// TODO Auto-generated method stub
		
		User user1 = this.modelMapper.map(user, User.class);
		User saveUser = userDao.save(user1);
		return modelMapper.map(saveUser, UserDto.class);
	}

	@Override
	public UserDto updateUser(UserDto user, long userId) {
		// TODO Auto-generated method stub
		User user1 = userDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User"," Id ",""+userId));
		User userObj = modelMapper.map(user, User.class);
		userObj.setUserId(user1.getUserId());
		User saveUser = userDao.save(userObj);
		
		return modelMapper.map(saveUser, UserDto.class);
	}

	@Override
	public UserDto getuserById(long userId) {
		// TODO Auto-generated method stub
		User user = userDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User"," Id ",""+userId));
		
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUser() {
		// TODO Auto-generated method stub
		List<User> users = userDao.findAll();
		List<UserDto> userDtos = users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(long userId) {
		// TODO Auto-generated method stub
		User user = userDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User"," Id ",""+userId));
		userDao.delete(user);
		
	}

}
