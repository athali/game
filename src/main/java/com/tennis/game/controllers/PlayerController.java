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
import com.tennis.game.domain.Player;
import com.tennis.game.dtos.PlayerDto;
import com.tennis.game.repository.GameRepository;
import com.tennis.game.repository.PlayerRepository;
import com.tennis.game.util.GamePoints;

@RestController
public class PlayerController {
	@Autowired
	PlayerRepository playerRepository;
	@Autowired
	GameRepository gameRepository;

	@GetMapping("/players")
	public List<PlayerDto> retrieveAllPlayers() {

		List<PlayerDto> dtos = new ArrayList<PlayerDto>();
		List<Player> players = new ArrayList<Player>();
		players = (List<Player>) playerRepository.findAll();

		for (Player player : players) {
			PlayerDto dto = new PlayerDto();
			dto.setId(player.getId());
			dto.setName(player.getName());
			dto.setMatchAsPlayerOne(player.getMatchAsPlayerOne());
			dto.setMatchAsPlayerTwo(player.getMatchAsPlayerTwo());
			dto.setPlayerSide(player.getPlayerSide());
			dtos.add(dto);
		}

		return dtos;
	}

	@DeleteMapping("/player/{id}")
	public void deletePlayer(@PathVariable long id) {
		playerRepository.deleteById(id);
	}

	@PostMapping("/players/new")
	public void newPlayer(@RequestBody PlayerDto dto) {
		Player player = new Player();

		player.setName(dto.getName());
		player.setMatchAsPlayerOne(dto.getMatchAsPlayerOne());
		player.setMatchAsPlayerTwo(dto.getMatchAsPlayerTwo());
		player.setPlayerSide(dto.getPlayerSide());

		playerRepository.save(player);

	}

	@PutMapping("players/{id}")
	public PlayerDto updatePlayer(@RequestBody PlayerDto dto, @PathVariable long id) {
		Player player = new Player();

		Optional<Player> optionalEntity = playerRepository.findById(id);
		player = optionalEntity.get();
		player.setName(dto.getName());
		player.setMatchAsPlayerOne(dto.getMatchAsPlayerOne());
		player.setMatchAsPlayerTwo(dto.getMatchAsPlayerTwo());
		player.setPlayerSide(dto.getPlayerSide());
		playerRepository.save(player);

		Player playerDB = new Player();
		PlayerDto returnDto = new PlayerDto();
		Optional<Player> optionalDB = playerRepository.findById(id);
		playerDB = optionalDB.get();
		returnDto.setId(playerDB.getId());
		returnDto.setName(playerDB.getName());
		returnDto.setMatchAsPlayerOne(playerDB.getMatchAsPlayerOne());
		returnDto.setMatchAsPlayerTwo(playerDB.getMatchAsPlayerTwo());
		returnDto.setPlayerSide(playerDB.getPlayerSide());
		return returnDto;
	}

	@PostMapping("/player/{idGame}/{points}")
	public void addPoints(@RequestBody PlayerDto dto, @PathVariable long idGame, @PathVariable GamePoints points) {
		Game game = new Game();
		Optional<Game> optionalEntity = gameRepository.findById(idGame);
		game = optionalEntity.get();
		playerRepository.addPoints(game, points, dto.getName());

	}

}
