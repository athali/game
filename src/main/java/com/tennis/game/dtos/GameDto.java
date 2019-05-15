package com.tennis.game.dtos;


import com.tennis.game.domain.Player;
import com.tennis.game.domain.SetMatch;
import com.tennis.game.util.GamePoints;

public class GameDto {
	private Long id;
	private GamePoints pointsPlayerOne=GamePoints.LOVE;
	private GamePoints pointsPlayerTwo = GamePoints.LOVE;
	private SetMatch setMatch;
	private Player playerOne;
	private Player playerTwo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public GamePoints getPointsPlayerOne() {
		return pointsPlayerOne;
	}
	public void setPointsPlayerOne(GamePoints pointsPlayerOne) {
		this.pointsPlayerOne = pointsPlayerOne;
	}
	public GamePoints getPointsPlayerTwo() {
		return pointsPlayerTwo;
	}
	public void setPointsPlayerTwo(GamePoints pointsPlayerTwo) {
		this.pointsPlayerTwo = pointsPlayerTwo;
	}
	public SetMatch getSetMatch() {
		return setMatch;
	}
	public void setSetMatch(SetMatch setMatch) {
		this.setMatch = setMatch;
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
		return "GameDto [id=" + id + ", pointsPlayerOne=" + pointsPlayerOne + ", pointsPlayerTwo=" + pointsPlayerTwo
				+ ", setMatch=" + setMatch + ", playerOne=" + playerOne + ", playerTwo=" + playerTwo + "]";
	}
	
	

}
