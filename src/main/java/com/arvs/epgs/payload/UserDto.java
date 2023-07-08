package com.arvs.epgs.payload;

import java.sql.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.arvs.epgs.model.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class UserDto {
	private long userId;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String about;
	
	
    private Set<Role> roles = new HashSet<>();
}
