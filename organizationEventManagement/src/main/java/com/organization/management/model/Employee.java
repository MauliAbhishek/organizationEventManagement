package com.organization.management.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="EMPLOYEES")
@DynamicInsert
@DynamicUpdate
public class Employee {

	@Id	@GeneratedValue(strategy= GenerationType.IDENTITY) private Long mid;	
	@NotNull @Size(max = 50) @Column(unique = true) private String name;
	@Column(name="join_date")
	@NotNull @Temporal(TemporalType.TIMESTAMP) private Date joinDate;
	@NotNull @Size(max = 50) @Column private String emailId;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "EMPLOYEE_EVENTS",
            joinColumns = { @JoinColumn(name = "MID") },
            inverseJoinColumns = { @JoinColumn(name = "EVENT_ID") })
    private Set<Event> events = new HashSet<>();
	
	public Long getMid() {
		return mid;
	}
	public void setMid(Long mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Set<Event> getEvents() {
		return events;
	}
	public void setEvents(Set<Event> events) {
		this.events = events;
	}
	
	
}
