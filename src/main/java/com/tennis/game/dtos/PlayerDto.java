package com.tennis.game.dtos;

import java.util.List;
import com.tennis.game.domain.Match;
import com.tennis.game.util.PlayerSide;

public class PlayerDto {
	private Long id;
	private String name;
	private List<Match> matchAsPlayerOne;
	private List <Match> matchAsPlayerTwo;
	private PlayerSide playerSide;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Match> getMatchAsPlayerOne() {
		return matchAsPlayerOne;
	}
	public void setMatchAsPlayerOne(List<Match> matchAsPlayerOne) {
		this.matchAsPlayerOne = matchAsPlayerOne;
	}
	public List<Match> getMatchAsPlayerTwo() {
		return matchAsPlayerTwo;
	}
	public void setMatchAsPlayerTwo(List<Match> matchAsPlayerTwo) {
		this.matchAsPlayerTwo = matchAsPlayerTwo;
	}
	public PlayerSide getPlayerSide() {
		return playerSide;
	}
	public void setPlayerSide(PlayerSide playerSide) {
		this.playerSide = playerSide;
	}
	@Override
	public String toString() {
		return "PlayerDto [id=" + id + ", name=" + name + ", matchAsPlayerOne=" + matchAsPlayerOne
				+ ", matchAsPlayerTwo=" + matchAsPlayerTwo + ", playerSide=" + playerSide + "]";
	}
	
}
