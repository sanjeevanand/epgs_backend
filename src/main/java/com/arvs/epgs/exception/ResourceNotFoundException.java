package com.arvs.epgs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

//@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter
@Setter
public class ResourceNotFoundException  extends RuntimeException{
	
private static final long serialVersionUID = 1L;

String resourceName;
String fieldName;
String fieldValue;

public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
	super(String.format("%s not found with %s : %s",resourceName,fieldName,fieldValue));
	this.resourceName = resourceName;
	this.fieldName = fieldName;
	this.fieldValue = fieldValue;
}
	
	

}
