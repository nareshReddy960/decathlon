package com.decathlon.developer.team;
import org.springframework.data.jpa.repository.JpaRepository;

import com.decathlon.developer.team.model.Team;

public interface TeamDao extends JpaRepository<Team,Integer>{

	Team  findFirstByOrderByTeamIdDesc();
	Team findByTeamId(int id);
}
