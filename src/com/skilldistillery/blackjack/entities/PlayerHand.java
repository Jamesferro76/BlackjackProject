package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class PlayerHand  {
	
	private List<Card> playerHand = new ArrayList<>();
	private int playerSum;

	public void PlayerHand(Card dealCard) {
		this.playerHand.add(dealCard);
		this.playerSum += dealCard.getValue();
	}
	
	public List<Card> getPlayerHand() {
		return playerHand;
	}

	public void setPlayerHand(List<Card> playerHand) {
		this.playerHand = playerHand;
	}

	public int getPlayerSum() {
		return playerSum;
	}

	public void setPlayerSum(int playerSum) {
		this.playerSum = playerSum;
	}
	@Override
	public String toString() {
		return "PlayerHand: " + playerHand + ", playerSum=" + playerSum + "]";
	}

}
