package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> deckOfCards;

	public Deck() {
		deckOfCards = new ArrayList<>();

		Suit[] suit = Suit.values();
		Rank[] rank = Rank.values();

		for (int i = 0; i < rank.length; i++) {

			for (int j = 0; j < suit.length; j++) {
				Card aCard = new Card(suit[j], rank[i]);
				deckOfCards.add(aCard);
			}
		}

	}

	public Deck(List<Card> deck) {
		this.deckOfCards = deck;
	}

	public int checkDeckSize() {
		return deckOfCards.size();
	}

	public Card dealCard() {
		Card card = deckOfCards.remove(0);
		return card;
	}

	public void shuffle() {
		Collections.shuffle(deckOfCards);
	}

}
