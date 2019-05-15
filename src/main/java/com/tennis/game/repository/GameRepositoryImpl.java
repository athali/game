package com.tennis.game.repository;

import com.tennis.game.domain.Game;
import com.tennis.game.util.GamePoints;

public class GameRepositoryImpl implements GameCustomMethods {

	@Override
	public String getScore(Game game) {
		if (hasWinner(game)) {
			return playerWithHighestScore(game) + " wins";
		}
		
		if (hasAdvantage(game)) { 
			return "Advantage " + playerWithHighestScore(game); 
		}
		
		if (isDeuce(game))
			return "Deuce";
		
		if(translateScore(game.getPointsPlayerOne()) == translateScore(game.getPointsPlayerTwo())) {
			return game.getPointsPlayerOne() + " all";
		}
		
		return game.getPointsPlayerOne()+ " and " + game.getPointsPlayerTwo();
	}

	@Override
	public boolean isDeuce(Game game) {

		return translateScore(game.getPointsPlayerOne()) >= 3 && translateScore(game.getPointsPlayerTwo()) == translateScore(game.getPointsPlayerOne());
	}

	@Override
	public String playerWithHighestScore(Game game) {
		if (translateScore(game.getPointsPlayerOne())> translateScore(game.getPointsPlayerTwo())) {
			return game.getPlayerOne().getName();
		} else {
			return game.getPlayerTwo().getName();
		}
	}

	@Override
	public boolean hasWinner(Game game) {
		if(translateScore(game.getPointsPlayerTwo()) > 3 && translateScore(game.getPointsPlayerTwo()) >= translateScore(game.getPointsPlayerOne()) + 2 )
			return true;
		if(translateScore(game.getPointsPlayerOne()) > 3 && translateScore(game.getPointsPlayerOne()) >= translateScore(game.getPointsPlayerTwo()) + 2)
			return true;
		return false;
	}

	@Override
	public boolean hasAdvantage(Game game) {
		if ( translateScore(game.getPointsPlayerTwo()) >= 4 &&  translateScore(game.getPointsPlayerTwo()) == ( translateScore(game.getPointsPlayerOne())+ 1))
			return true;
		if (translateScore(game.getPointsPlayerOne()) >= 4 &&  translateScore(game.getPointsPlayerOne()) == ( translateScore(game.getPointsPlayerTwo()) + 1))
			return true;
		
		return false;
	}
	
	private int translateScore(GamePoints points) {
		switch (points) {
		case FORTY:
			return 3;
		case THIRTY:
			return 2;
		case FIFTEEN: 
			return 1;
		case LOVE:
			return 0;
		}
		throw new IllegalArgumentException("Undefinied number points: " + points);
	}

}
