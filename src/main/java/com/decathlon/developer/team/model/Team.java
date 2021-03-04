package com.decathlon.developer.team.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="teams")
public class Team {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teamId;
	
    @NotNull
	private String teamName;
    
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    List<Developer> developers= new ArrayList<>();

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public List<Developer> getDevelopers() {
		return developers;
	}

	public void setDevelopers(List<Developer> developers) {
		this.developers = developers;
	}
	 
	 
	
}
