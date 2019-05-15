package com.tennis.game.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tennis.game.domain.Match;
@Repository
public interface MatchRepository extends CrudRepository<Match, Long>{

}
