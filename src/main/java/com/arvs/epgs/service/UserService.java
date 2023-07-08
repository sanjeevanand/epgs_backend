package com.arvs.epgs.service;

import java.util.List;

import com.arvs.epgs.payload.UserDto;

import com.arvs.epgs.payload.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user,long userId);
	UserDto getuserById(long userId);
	List<UserDto> getAllUser();
	void deleteUser(long userId);

}
