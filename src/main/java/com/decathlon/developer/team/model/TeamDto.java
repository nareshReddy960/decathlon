package com.decathlon.developer.team.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

public class TeamDto {
	

	 @NotNull
	 private String teamName;
	
	  private List<DeveloperDto> developers;

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public List<DeveloperDto> getDevelopers() {
		return developers;
	}

	public void setDevelopers(List<DeveloperDto> developers) {
		this.developers = developers;
	}

}
