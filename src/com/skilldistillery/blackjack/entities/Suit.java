package com.skilldistillery.blackjack.entities;

public enum Suit {
	
HEARTS("Hearts"),
SPADES("Spades"),
CLUBS("Clubs"),
DIAMONDS("Diamonds");
	
	Suit(String suit){
		name=suit;
	}
	
	private String name;


public String getName() {
	return name;
}


@Override
public String toString() {
	return this.name;
}
}
