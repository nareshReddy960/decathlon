package com.decathlon.developer.team.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="developers")
public class Developer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	@NotNull
	private String Name;
	
	@NotNull 
	private String phoneNumber;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "teamId")
    @NotNull
	private Team team;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
}
