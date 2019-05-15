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

import com.tennis.game.domain.SetMatch;
import com.tennis.game.dtos.SetDto;
import com.tennis.game.repository.SetRepository;

@RestController
public class SetController {
	@Autowired
	SetRepository setRepository;
	@GetMapping("/sets")
	public List<SetDto> retrieveAllSets() {

		List<SetDto> dtos = new ArrayList<SetDto>();
		List<SetMatch> sets = new ArrayList<SetMatch>();
		sets = (List<SetMatch>) setRepository.findAll();

		for (SetMatch set : sets) {
			SetDto dto = new SetDto();
			dto.setId(set.getId());
			dto.setPlayerOne(set.getPlayerOne());
			dto.setPlayerTwo(set.getPlayerTwo());
			dto.setMatch(dto.getMatch());			
			dtos.add(dto);
		}

		return dtos;
	}
	
	@DeleteMapping("/set/{id}")
	public void deleteSet(@PathVariable long id) {
		setRepository.deleteById(id);
	}

	@PostMapping("/sets/new")
	public void newSet(@RequestBody SetDto dto) {
		SetMatch set = new SetMatch();
		set.setPlayerOne(dto.getPlayerOne());
		set.setPlayerTwo(dto.getPlayerTwo());
		set.setMatch(dto.getMatch());		
		setRepository.save(set);

	}

	@PutMapping("set/{id}")
	public SetDto updateSet(@RequestBody SetDto dto, @PathVariable long id) {
		SetMatch set = new SetMatch();

		Optional<SetMatch> optionalEntity = setRepository.findById(id);
		set = optionalEntity.get();
		
		set.setPlayerOne(dto.getPlayerOne());
		set.setPlayerTwo(dto.getPlayerTwo());
		set.setMatch(dto.getMatch());
		
		setRepository.save(set);

		SetMatch setDB = new SetMatch();
		SetDto returnDto = new SetDto();
		Optional<SetMatch> optionalDB = setRepository.findById(id);
		setDB = optionalDB.get();
		
		returnDto.setId(setDB.getId());
		returnDto.setPlayerOne(setDB.getPlayerOne());
		returnDto.setPlayerTwo(setDB.getPlayerTwo());
		returnDto.setMatch(setDB.getMatch());
		
		return returnDto;
	}
	@GetMapping("/sets/scores/{id}")
	public String getScore(@PathVariable long id) {
		
		String score="Undifined";
		SetMatch set = new SetMatch();

		Optional<SetMatch> optionalEntity = setRepository.findById(id);
		set = optionalEntity.get();
		score = setRepository.getScore(set);
		return score;
	}

}
