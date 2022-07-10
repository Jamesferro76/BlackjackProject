package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.blackjack.app.BlackJackApp;

public class Player {

	private String userInput = null;

	boolean trigger = true;

	private Hand hand = new BlackjackHand();
	
	public Player() {
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	@Override
	public String toString() {
		return "Player " + this.getHand();
	}

}
