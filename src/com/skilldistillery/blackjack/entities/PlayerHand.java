package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.blackjack.app.BlackJackApp;

public class PlayerHand {
	
	private List<Card> playerHand= new ArrayList<>();
	private int playerSum;
	private String userInput=null;

	public void PlayerHand(Card dealCard) {
		this.playerHand.add(dealCard);
		this.playerSum += dealCard.getValue();
	}
	
	boolean trigger=true;
	public boolean playerDecision(Scanner sc, Deck deck) {

		boolean playerTrigger=true;
		while(playerTrigger) {
		System.out.println("Would you like to Hit or Stay?");
		String userInput = sc.nextLine();

		switch (userInput) {
		case "hit":
		case "Hit":
		case "H":
		case "h":
			playerTrigger=false;
			Card card = deck.dealCard();
			PlayerHand(card);
			System.out.println(card);
			break;

		case "Stay":
		case "stay":
		case "S":
		case "s":
			System.out.println("You decided to stay");
			trigger= false;
			playerTrigger=false;
			break;
		default:
			System.out.println("That was not a redable response. Please try again.");
			break;
		}
		}
		if (getPlayerSum() < 21) {
			toString();
		} else if (getPlayerSum() > 21) {
			trigger = false;

		} else if (getPlayerSum() == 21) {
			trigger = false;
		}
	
	return trigger;
}

	public PlayerHand() {
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
