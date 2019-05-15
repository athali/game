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

import com.tennis.game.domain.Game;
import com.tennis.game.dtos.GameDto;
import com.tennis.game.repository.GameRepository;

@RestController
public class GameController {
	@Autowired
	GameRepository gameRepository;

	@GetMapping("/games")
	public List<GameDto> retrieveAllGames() {

		List<GameDto> dtos = new ArrayList<GameDto>();
		List<Game> games = new ArrayList<Game>();
		games = (List<Game>) gameRepository.findAll();

		for (Game game : games) {
			GameDto dto = new GameDto();
			dto.setId(game.getId());
			dto.setPlayerOne(game.getPlayerOne());
			dto.setPlayerTwo(game.getPlayerTwo());
			dto.setPointsPlayerOne(game.getPointsPlayerOne());
			dto.setPointsPlayerTwo(game.getPointsPlayerTwo());
			dto.setSetMatch(game.getSetMatch());
			dtos.add(dto);
		}

		return dtos;
	}

	@DeleteMapping("/game/{id}")
	public void deleteGame(@PathVariable long id) {
		gameRepository.deleteById(id);
	}

	@PostMapping("/games/new")
	public void newGame(@RequestBody GameDto dto) {
		Game game = new Game();
		game.setPlayerOne(dto.getPlayerOne());
		game.setPlayerTwo(dto.getPlayerTwo());
		game.setPointsPlayerOne(dto.getPointsPlayerOne());
		game.setPointsPlayerTwo(dto.getPointsPlayerTwo());
		game.setSetMatch(dto.getSetMatch());
		gameRepository.save(game);

	}

	@PutMapping("games/{id}")
	public GameDto updateGame(@RequestBody GameDto dto, @PathVariable long id) {
		Game game = new Game();

		Optional<Game> optionalEntity = gameRepository.findById(id);
		game = optionalEntity.get();
		game.setPlayerOne(dto.getPlayerOne());
		game.setPlayerTwo(dto.getPlayerTwo());
		game.setPointsPlayerOne(dto.getPointsPlayerOne());
		game.setPointsPlayerTwo(dto.getPointsPlayerTwo());
		game.setSetMatch(dto.getSetMatch());
		gameRepository.save(game);

		Game gameDB = new Game();
		GameDto returnDto = new GameDto();
		Optional<Game> optionalDB = gameRepository.findById(id);
		gameDB = optionalDB.get();
		returnDto.setId(gameDB.getId());
		returnDto.setPlayerOne(gameDB.getPlayerOne());
		returnDto.setPlayerTwo(gameDB.getPlayerTwo());
		returnDto.setPointsPlayerOne(gameDB.getPointsPlayerOne());
		returnDto.setPointsPlayerTwo(gameDB.getPointsPlayerTwo());
		returnDto.setSetMatch(gameDB.getSetMatch());
		return returnDto;
	}

	@GetMapping("/games/scores/{id}")
	public String getScoresOfGame(@PathVariable long id) {
		Game game = new Game();
		Optional<Game> optionalEntity = gameRepository.findById(id);
		game = optionalEntity.get();
		return gameRepository.getScore(game);
	}

}
