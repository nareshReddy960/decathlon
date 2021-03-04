package com.decathlon.developer.team.model;

import javax.validation.constraints.NotNull;

public class DeveloperDto {
	
	@NotNull
	private String Name;
	
	@NotNull 
	private String phoneNumber;
	
	private int teamId;

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

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	

}
