package com.tennis.game.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tennis.game.domain.Game;

@Repository
public interface GameRepository  extends CrudRepository<Game, Long>, GameCustomMethods{

}
