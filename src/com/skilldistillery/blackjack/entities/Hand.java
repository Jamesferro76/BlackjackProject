package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	
	List<Card> hand;

	public Hand() {
		super();
		hand= new ArrayList<>();
	}
	
	public void addCard(Card card) {
		hand.add(card);
	}
	
	public void clear() {
		hand.removeAll(hand);
	}
	
	public abstract int getHandValue();

	@Override
	public String toString() {
		return "Hand [hand=" + hand + "]";
	}
	
	

}
