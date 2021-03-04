package com.decathlon.developer.team;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.decathlon.developer.team.model.CustomException;
import com.decathlon.developer.team.model.TeamDto;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/teams")
public class TeamController {
	
@Autowired
private TeamService teamService;

@PostMapping
public int createTeam(@Valid @RequestBody TeamDto tdto) throws CustomException{
	return teamService.createteam(tdto);
}

@PostMapping("{teamId}/alert")
public void alertMembers( @PathVariable int teamId) {
	 teamService.alertMembers(teamId);
	
}




}
