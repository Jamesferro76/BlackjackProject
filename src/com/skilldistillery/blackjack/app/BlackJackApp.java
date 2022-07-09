package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.DealerHand;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.PlayerHand;

public class BlackJackApp {

	Deck deck = new Deck();
	PlayerHand ph = new PlayerHand();

	DealerHand dh = new DealerHand();

	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();
		app.run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		setUp();
		
		if(ph.getPlayerSum()>21) {
			System.out.println("Bust! You lost!");
			System.out.println(ph.toString());
			
		}else if(ph.getPlayerSum()==21){
			System.out.println("You got a 21! You won!");
		}else {
		
		do{
			displayVisibleHands();
		}while(ph.playerDecision(sc, deck));
		
		if(ph.getPlayerSum()>21) {
			System.out.println("Bust! You lost!");
			System.out.println(ph.toString());
			
		}else if(ph.getPlayerSum()==21){
			System.out.println("You got a 21! You won!");
		}else {
		do {
			displayActualHands();
		}while(dh.dealerDecision(deck));
		
		if(ph.getPlayerSum()<=21&&dh.getDealerSum()<=21) {
			displayActualHands();
			verdict();
		}
		}
		}
	}

	private void setUp() {

		deck.shuffle();
		ph.PlayerHand(deck.dealCard());
		dh.DealerHand(deck.dealCard());
		ph.PlayerHand(deck.dealCard());
		dh.DealerHand(deck.dealCard());

	}

	private void displayVisibleHands() {
		System.out.println(ph.toString());
		System.out.println();
		System.out.println(dh.toString());
		System.out.println();
	}

	private void displayActualHands() {
		System.out.println(ph.toString());
		System.out.println();
		System.out.println(dh.toStringActual());
		System.out.println();
	}

	private void verdict() {
		if (ph.getPlayerSum() >= dh.getDealerSum()) {
			System.out.println("*****************************************");
			System.out.println("The dealer has 17 or over and must stay.");
			System.out.println("You win! Great Job!");
			System.out.println("*****************************************");
		} else if (dh.getDealerSum() > ph.getPlayerSum()) {
			System.out.println("*****************************************");
			System.out.println("The dealer has over 17 and must stay.");
			System.out.println("You lost! Terrible Job!");
			System.out.println("*****************************************");
		}
	}

}
