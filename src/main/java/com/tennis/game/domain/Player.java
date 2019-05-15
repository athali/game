package com.tennis.game.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tennis.game.util.PlayerSide;
@Entity
@Table(name="player")

public class Player implements Serializable {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="playerOne", fetch=FetchType.EAGER)
	private List<Match> matchAsPlayerOne;
	@OneToMany(mappedBy="playerTwo", fetch=FetchType.EAGER)
	private List <Match> matchAsPlayerTwo;
	@Column(name="side")
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
		return "Player [id=" + id + ", name=" + name + ", matchAsPlayerOne=" + matchAsPlayerOne + ", matchAsPlayerTwo="
				+ matchAsPlayerTwo + ", playerSide=" + playerSide + "]";
	}
	
	

}
