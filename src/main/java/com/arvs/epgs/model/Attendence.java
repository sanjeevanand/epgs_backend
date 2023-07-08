package com.arvs.epgs.model;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "attendence")
public class Attendence {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long attandenceId;
	private String day;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String status;
	private float hours;
	private char overTime;
	private float overTimeHours;
	private String startFrom;
	private String endTo;
	private float conveyanceExpenses;
	private float advance;
	private String remarks;
	
	
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id")
    private Employee employee;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="site_id")
    private Site site; 
    
	 public long getAttandenceId() {
		return attandenceId;
	}
	public void setAttandenceId(long attandenceId) {
		this.attandenceId = attandenceId;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public char getOverTime() {
		return overTime;
	}
	public void setOverTime(char overTime) {
		this.overTime = overTime;
	}
	public float getHours() {
		return hours;
	}
	public void setHours(float hours) {
		this.hours = hours;
	}
	public String getStartFrom() {
		return startFrom;
	}
	public void setStartFrom(String startFrom) {
		this.startFrom = startFrom;
	}
	public String getEndTo() {
		return endTo;
	}
	public void setEndTo(String endTo) {
		this.endTo = endTo;
	}
	public float getConveyanceExpenses() {
		return conveyanceExpenses;
	}
	public void setConveyanceExpenses(float conveyanceExpenses) {
		this.conveyanceExpenses = conveyanceExpenses;
	}
	public float getAdvance() {
		return advance;
	}
	public void setAdvance(float advance) {
		this.advance = advance;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	
	
	
	
	public float getOverTimeHours() {
		return overTimeHours;
	}
	public void setOverTimeHours(float overTimeHours) {
		this.overTimeHours = overTimeHours;
	}
	@Override
	public String toString() {
		return "Attendence [attandenceId=" + attandenceId + ", day=" + day + ", date=" + date + ", status=" + status
				+ ", overTime=" + overTime + ", hours=" + hours + ", startFrom=" + startFrom + ", endTo=" + endTo
				+ ", conveyanceExpenses=" + conveyanceExpenses + ", advance=" + advance + ", remarks=" + remarks
				+ ", employee=" + employee + ", site=" + site + "]";
	}
	
	
	

}
