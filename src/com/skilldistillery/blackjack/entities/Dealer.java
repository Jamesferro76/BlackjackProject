package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dealer extends Player{
	
	private Deck deck = new Deck();

		private boolean dealerTrigger=true;
		
		public boolean playerDecision() {
			
			if (this.getHand().getHandValue()< 17) {
				dealToPlayer(deck.dealCard(), this);
				
			} else if (this.getHand().getHandValue()>= 17 && this.getHand().getHandValue() <= 21) {
				System.out.println("The dealer stayed.");
				dealerTrigger=false;
				
			} else if (this.getHand() instanceof BlackjackHand && ((BlackjackHand)(this.getHand())).isBust()) {
				System.out.println("Dealer busted!");
				System.out.println("You win!!!");
				System.out.println(getHand());
				dealerTrigger = false;
			}
			
			return dealerTrigger;
			
		}

		
		public void dealerSetUp(Player player ) {
			deck.shuffle();
			System.out.println("Player card 1: " + dealToPlayer(deck.dealCard(), player));
			dealToPlayer(deck.dealCard(), this);
			System.out.println("Dealer card is face down.");
			System.out.println("Player card 2: " + dealToPlayer(deck.dealCard(), player));
			System.out.println("Dealer card 2: " + dealToPlayer(deck.dealCard(), this));
		}
		
		
		public Card dealToPlayer(Card card, Player player ) {
			player.getHand().addCard(card);
			return card;
		}
		
		public Card dealToPlayer(Player player) {
			Card card= deck.dealCard();
			player.getHand().addCard(card);
			return card;
		}
		
		public String toString() {
			return "Dealer [hand=" + this.getHand() + " sum: "+ this.getHand().getHandValue() + "]";
		}

}
