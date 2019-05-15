package com.tennis.game.repository;

import com.tennis.game.domain.Game;

public interface GameCustomMethods {
	
	public String getScore(Game game);
	public boolean isDeuce(Game game);
	public String playerWithHighestScore(Game game);
	public boolean hasWinner(Game game);
	public boolean hasAdvantage(Game game);
}
