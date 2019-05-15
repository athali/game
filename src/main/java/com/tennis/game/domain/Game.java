package com.tennis.game.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tennis.game.util.GamePoints;

@Entity
@Table(name="game")
public class Game  implements Serializable{
	@Id @GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private GamePoints pointsPlayerOne=GamePoints.LOVE;
	@Enumerated(EnumType.STRING)
	private GamePoints pointsPlayerTwo = GamePoints.LOVE;
	@ManyToOne @JoinColumn(name="set_id")
	private SetMatch setMatch;
	@ManyToOne @JoinColumn(name="playerOne")
	private Player playerOne;
	@ManyToOne @JoinColumn(name="playerTwo")
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
		return "Game [id=" + id + ", pointsPlayerOne=" + pointsPlayerOne + ", pointsPlayerTwo=" + pointsPlayerTwo
				+ ", setMatch=" + setMatch + ", playerOne=" + playerOne + ", playerTwo=" + playerTwo + "]";
	}
	
	
	
	

}
