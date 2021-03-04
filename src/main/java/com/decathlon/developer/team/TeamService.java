package com.decathlon.developer.team;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.decathlon.developer.team.model.CustomException;
import com.decathlon.developer.team.model.Developer;
import com.decathlon.developer.team.model.DeveloperDao;
import com.decathlon.developer.team.model.Team;
import com.decathlon.developer.team.model.TeamDto;

@Service
public class TeamService {

	@Autowired
	private TeamDao teamDao;
	
	@Autowired
	private DeveloperDao developerDao;
	
	
	private RestTemplate restTemplate;
	 @Autowired
	    public TeamService(RestTemplateBuilder restTemplateBuilder) {
	        restTemplate = restTemplateBuilder.build();
	    }
	
	  @Value("${msgUrl}")
	    private String msgUrl;
	
	public int createteam(TeamDto tdto) {
		// TODO Auto-generated method stub
		Team newTeam=new Team();
		if(tdto.getDevelopers().size()>0) {
		newTeam.setTeamName(tdto.getTeamName());
		teamDao.save(newTeam);
		List<Developer> developerList=new ArrayList<>();
		tdto.getDevelopers().forEach(dev->{
			Developer developer=new Developer();
			developer.setName(dev.getName());
			developer.setPhoneNumber(dev.getPhoneNumber());
			developer.setTeam(newTeam);
			developerDao.save(developer);
			
		});
		
	    
		}
		else {
			throwExceprtion("Team can not be created with out developers. Atleast one developer should be added");
		}

		return teamDao.findFirstByOrderByTeamIdDesc().getTeamId();
	}

	private void throwExceprtion(String msg) {
		throw new CustomException(msg);

		
	}

	public Object alertMembers(int teamId) {
		List<Developer> devList=teamDao.findByTeamId(teamId).getDevelopers();
		// TODO Auto-generated method stub
		devList.forEach(dev->{
			HttpHeaders headers = new HttpHeaders();
			headers.set("phoneNumber",dev.getPhoneNumber());
			headers.set("Accept", "application/json");
			HttpEntity entity = new HttpEntity(headers);
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://run.mocky.io/v3/fd99c100-f88a-4d70-aaf7-393dbbd5d99f");
			restTemplate.exchange(builder.build().encode().toUri(),
	                HttpMethod.POST, entity, String.class);	
		});
		

//	    RestTemplate restTemplate = new RestTemplate();
//	    String result = restTemplate.getForObject(msgUrl, String.class);
		return null;
	}

}
