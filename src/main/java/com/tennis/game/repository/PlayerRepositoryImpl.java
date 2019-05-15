package com.tennis.game.repository;

import com.tennis.game.domain.Game;
import com.tennis.game.util.GamePoints;
import com.tennis.game.util.PlayerSide;

public class PlayerRepositoryImpl implements PlayerCustomMethods {

	@Override
	public void addPoints(Game game, GamePoints points, String name) {
		if(game.getPlayerOne().getName().equals(name)) game.setPointsPlayerOne(points);
		else if (game.getPlayerTwo().getName().equals(name)) game.setPointsPlayerTwo(points);
		
	}

}
