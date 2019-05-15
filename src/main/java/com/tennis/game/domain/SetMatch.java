package com.tennis.game.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="set")
public class SetMatch implements Serializable {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	@OneToMany(mappedBy="setMatch", fetch =FetchType.EAGER)
	private List<Game> games;
	@ManyToOne @JoinColumn(name="match_id")
	private Match match;
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
		return "SetMatch [id=" + id + ", games=" + games + ", match=" + match + ", playerOne=" + playerOne
				+ ", playerTwo=" + playerTwo + "]";
	}
	
	
	

}
