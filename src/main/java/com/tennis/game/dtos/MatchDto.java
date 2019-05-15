package com.tennis.game.dtos;

import java.util.List;

import com.tennis.game.domain.Player;
import com.tennis.game.domain.SetMatch;

public class MatchDto {
    private Long id;
	private Player playerOne;
	private Player playerTwo;
	private List<SetMatch>  sets;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public List<SetMatch> getSets() {
		return sets;
	}
	public void setSets(List<SetMatch> sets) {
		this.sets = sets;
	}
	@Override
	public String toString() {
		return "MatchDto [id=" + id + ", playerOne=" + playerOne + ", playerTwo=" + playerTwo + ", sets=" + sets + "]";
	}
		

}
