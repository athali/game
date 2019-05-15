package com.tennis.game.repository;

import com.tennis.game.domain.Game;
import com.tennis.game.util.GamePoints;

public interface PlayerCustomMethods {
	
	public void addPoints(Game game, GamePoints points, String name);

}
