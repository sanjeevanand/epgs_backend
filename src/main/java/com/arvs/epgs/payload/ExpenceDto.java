package com.arvs.epgs.payload;

import java.sql.Date;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ExpenceDto {
	
	private long expenceId;
	
	private float expenceAmount;
	@NotEmpty
	private String expenceDescription;
	private String expenceCategory;
	private Date createdAt;
	private Date updatedAt;

}
