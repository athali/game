package com.tennis.game.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tennis.game.domain.SetMatch;
@Repository
public interface SetRepository  extends CrudRepository<SetMatch, Long>, SetCustomMethods{

}
