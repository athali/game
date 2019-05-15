package com.tennis.game.repository;

import java.util.ArrayList;
import java.util.List;

import com.tennis.game.domain.Game;
import com.tennis.game.domain.SetMatch;
import com.tennis.game.util.GamePoints;

public class SetRepositoryImpl implements SetCustomMethods {

	@Override
	public String getScore(SetMatch set) {
		int nbrGamesPlayer1=0;
		int nbrGamesPlayer2=0;
		List<Game> games = new ArrayList<Game>();
		games= set.getGames();
		for(Game game:games) {
			if(translateScore(game.getPointsPlayerOne())> translateScore(game.getPointsPlayerTwo())) nbrGamesPlayer1++;
			
			else if(translateScore(game.getPointsPlayerTwo())> translateScore(game.getPointsPlayerOne())) nbrGamesPlayer2++; 
		}
			
		return set.getPlayerOne().getName() +" has  " + nbrGamesPlayer1 +"  games  and "+ set.getPlayerTwo().getName()+ " has  " + nbrGamesPlayer2;
	}

	@Override
	public String playWithHighestScore(SetMatch set) {
		int nbrGamesPlayer1=0;
		int nbrGamesPlayer2=0;
		String highest="undefined";
		List<Game> games = new ArrayList<Game>();
		games= set.getGames();
		for(Game game:games) {
			if(translateScore(game.getPointsPlayerOne())> translateScore(game.getPointsPlayerTwo())) nbrGamesPlayer1++;
			
			else if(translateScore(game.getPointsPlayerTwo())> translateScore(game.getPointsPlayerOne())) nbrGamesPlayer2++; 
		}
		if 	(nbrGamesPlayer1 > nbrGamesPlayer2) highest=set.getPlayerOne().getName();
		else if (nbrGamesPlayer1 < nbrGamesPlayer2) highest=set.getPlayerTwo().getName();
		return highest;
	}

	@Override
	public String getWinner(SetMatch set) {
		int nbrGamesPlayer1=0;
		int nbrGamesPlayer2=0;
		String winner="undefined";
		List<Game> games = new ArrayList<Game>();
		games= set.getGames();
		for(Game game:games) {
			if(translateScore(game.getPointsPlayerOne())> translateScore(game.getPointsPlayerTwo())) nbrGamesPlayer1++;
			
			else if(translateScore(game.getPointsPlayerTwo())> translateScore(game.getPointsPlayerOne())) nbrGamesPlayer2++; 
		}
		if ((nbrGamesPlayer1 >= 6 && nbrGamesPlayer2<=4) || nbrGamesPlayer1 >6 && nbrGamesPlayer2<=5) winner=set.getPlayerOne().getName();
		else if((nbrGamesPlayer2 >= 6 && nbrGamesPlayer1<=4) || nbrGamesPlayer2 >6 && nbrGamesPlayer1<=5) winner=set.getPlayerTwo().getName();
		return winner;
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
