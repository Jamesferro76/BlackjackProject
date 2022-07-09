package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackjackHand;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BlackJackApp {

	private Player player = new Player();

	private Dealer dealer = new Dealer();

	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();
		app.run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		dealer.dealerSetUp(player);

		// In case you win or lose from the first draw.
		if(checkPlayer()) {}else {

//		Actually playing the game. Player's decisions
			do {
				displayVisibleHands();
			} while (hit(sc));

			if(checkPlayer()) {}else {
//		Player's turn is over. Dealer's turn to go!
				do {
					displayActualHands();
				} while (dealer.playerDecision());

//		Both Player and Dealer have finished. Who won?
				if (player.getHand().getHandValue() <= 21 && dealer.getHand().getHandValue() <= 21) {
					displayActualHands();
					verdict();
				}
			}
		}
	}

	private void displayVisibleHands() {
		System.out.println("---------------------------------------------------------------");
		System.out.println(player.getHand());
		System.out.println("---------------------------------------------------------------");
	}

	private void displayActualHands() {
		System.out.println("---------------------------------------------------------------");
		System.out.println(player);
		System.out.println(dealer);
		System.out.println("---------------------------------------------------------------");
	}

	private void verdict() {
		System.out.println("*****************************************");
		if (player.getHand().getHandValue() >= dealer.getHand().getHandValue()) {
			System.out.println("The dealer has " + dealer.getHand().getHandValue() + " and must stay.");
			System.out.println("You win! Great Job!");
		} else if (player.getHand().getHandValue() < dealer.getHand().getHandValue()) {
			System.out.println("The dealer has " + dealer.getHand().getHandValue() + " and must stay.");
			System.out.println("You lost! Terrible Job!");
		} else if (player.getHand().getHandValue()==dealer.getHand().getHandValue()) {
			System.out.println("The dealer has "+ dealer.getHand().getHandValue() + " and you have " + player.getHand().getHandValue() +".");
			System.out.println("DRAW! Nobody wins, and you give all your money to the developer!");
		}
		System.out.println("*****************************************");
	}

	public boolean hit(Scanner sc) {

		boolean trigger = true;
		boolean errorTrigger = true;
		while (errorTrigger) {
			System.out.println("Would you like to Hit or Stay?");
			String userInput = sc.nextLine();

			switch (userInput) {
			case "hit":
			case "Hit":
			case "H":
			case "h":
				errorTrigger = false;
				System.out.println(dealer.dealToPlayer(player));
				break;

			case "Stay":
			case "stay":
			case "S":
			case "s":
				System.out.println("You decided to stay");
				trigger = false;
				errorTrigger = false;
				break;
			default:
				System.out.println("That was not a redable response. Please try again.");
				break;
			}

		}
		if(player.getHand() instanceof BlackjackHand && ((BlackjackHand) (player.getHand())).isBust()) {
			return false;
		}else if(player.getHand().getHandValue()==21) {
			System.out.println("You have 21 and must stay");
			return false;
		}
		return trigger;
	}
	
	public boolean checkPlayer() {
		boolean gameOver= true;
		if (player.getHand() instanceof BlackjackHand && ((BlackjackHand) (player.getHand())).isBust()) {
	
		System.out.println("Bust! You lost! Bad Draw...");
		System.out.println(player.getHand());

	} else if (player.getHand() instanceof BlackjackHand && ((BlackjackHand) (player.getHand())).isBlackjack()) {
		System.out.println("You got a 21! You won! Lucky Draw!!!");
	}
	else {
		gameOver=false;
		
	}
		return gameOver;
}
}
