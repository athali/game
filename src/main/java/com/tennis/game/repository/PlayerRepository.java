package com.tennis.game.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tennis.game.domain.Player;
@Repository
public interface PlayerRepository extends CrudRepository<Player, Long>, PlayerCustomMethods {
	public Player findByName(String name);

}
