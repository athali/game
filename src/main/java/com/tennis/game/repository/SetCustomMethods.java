package com.tennis.game.repository;

import com.tennis.game.domain.SetMatch;

public interface SetCustomMethods {
	public String getScore(SetMatch set);
	public String playWithHighestScore (SetMatch set);
	public String getWinner(SetMatch set);

}
