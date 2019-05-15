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
@Table(name="match")
public class Match implements Serializable {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="playerOne")
	private Player playerOne;
	@ManyToOne
	@JoinColumn(name="playerTwo")
	private Player playerTwo;
	
	@OneToMany(mappedBy="match", fetch=FetchType.EAGER)
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
		return "Match [id=" + id + ", playerOne=" + playerOne + ", playerTwo=" + playerTwo + ", sets=" + sets + "]";
	}
	

}
