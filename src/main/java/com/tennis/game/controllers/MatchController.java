package com.tennis.game.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tennis.game.domain.Match;
import com.tennis.game.dtos.MatchDto;
import com.tennis.game.repository.MatchRepository;

@RestController
public class MatchController {
	@Autowired
	MatchRepository matchRepository;
	
	@GetMapping("/matchs")
	public List<MatchDto> retrieveAllMatchs() {

		List<MatchDto> dtos = new ArrayList<MatchDto>();
		List<Match> matchs = new ArrayList<Match>();
		matchs = (List<Match>) matchRepository.findAll();

		for (Match match : matchs) {
			MatchDto dto = new MatchDto();
			dto.setId(match.getId());
			dto.setPlayerOne(match.getPlayerOne());
			dto.setPlayerTwo(match.getPlayerTwo());
			dto.setSets(match.getSets());			
			dtos.add(dto);
		}

		return dtos;
	}

	@DeleteMapping("/match/{id}")
	public void deleteMatch(@PathVariable long id) {
		matchRepository.deleteById(id);
	}

	@PostMapping("/matchs/new")
	public void newMatch(@RequestBody MatchDto dto) {
		Match match = new Match();
		match.setPlayerOne(dto.getPlayerOne());
		match.setPlayerTwo(dto.getPlayerTwo());
		match.setSets(dto.getSets());
		matchRepository.save(match);
	}

	@PutMapping("match/{id}")
	public MatchDto updateMatch(@RequestBody MatchDto dto, @PathVariable long id) {
		Match match = new Match();
		Optional<Match> optionalEntity = matchRepository.findById(id);
		match = optionalEntity.get();		
		match.setPlayerOne(dto.getPlayerOne());
		match.setPlayerTwo(dto.getPlayerTwo());
		match.setSets(dto.getSets());
		matchRepository.save(match);
		Match matchDB = new Match();
		MatchDto returnDto = new MatchDto();
		Optional<Match> optionalDB = matchRepository.findById(id);
		matchDB = optionalDB.get();
		returnDto.setPlayerOne(matchDB.getPlayerOne());
		returnDto.setPlayerTwo(matchDB.getPlayerTwo());
		returnDto.setSets(matchDB.getSets());
		return returnDto;
	}

}
