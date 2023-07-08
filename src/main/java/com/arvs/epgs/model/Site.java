package com.arvs.epgs.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "site")

public class Site {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long siteId;
	private String siteName;
	private String address;
	
	 @OneToMany(mappedBy="site", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	 private Set<Attendence> attendences;
	
	public Long getSiteId() {
		return siteId;
	}
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set<Attendence> getAttendences() {
		return attendences;
	}
	public void setAttendences(Set<Attendence> attendences) {
		this.attendences = attendences;
	}

	
}
