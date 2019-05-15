package com.tennis.game.dtos;

import java.util.List;
import com.tennis.game.domain.Game;
import com.tennis.game.domain.Match;
import com.tennis.game.domain.Player;

public class SetDto {
	
	private Long id;
	private List<Game> games;
	private Match match;
	private Player playerOne;
	private Player playerTwo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Game> getGames() {
		return games;
	}
	public void setGames(List<Game> games) {
		this.games = games;
	}
	public Match getMatch() {
		return match;
	}
	public void setMatch(Match match) {
		this.match = match;
	}
	public Player getPlayerOne() {
		return playerOne;
	}
	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}
	public Player getPlayerTwo() {
		return playerTwo;
	}
	public void setPlayerTwo(Player playerTwo) {
		this.playerTwo = playerTwo;
	}
	@Override
	public String toString() {
		return "SetDto [id=" + id + ", games=" + games + ", match=" + match + ", playerOne=" + playerOne
				+ ", playerTwo=" + playerTwo + "]";
	}
	
}
