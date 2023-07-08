package com.arvs.epgs.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class SiteDto {
	
	private Long siteId;
	@NotEmpty
	@Size(min=4 , message="Site contains more than 4 character !")
	private String siteName;
	@NotEmpty
	private String address;

}
