package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class DealerHand {
	
		private List<Card> dealerHand= new ArrayList<>();
		private List<Card> dealerVisibleHand= new ArrayList<>();
		private int dealerSum;
		private int dealerVisibleSum;
		private Card card1;
		
		private PlayerHand ph=new PlayerHand();

		public void DealerHand(Card dealCard) {
			if(this.dealerHand.isEmpty()) {
				card1=dealCard;
			}else {
				this.dealerVisibleHand.add(dealCard);
			}
			this.dealerHand.add(dealCard);
			this.dealerSum += dealCard.getValue();
			this.dealerVisibleSum +=this.dealerSum-card1.getValue();
		}
		
		boolean dealerTrigger=true;
		public boolean dealerDecision(Deck deck) {
			if (dealerSum < 17) {
				Card card = deck.dealCard();
				DealerHand(card);
				
			} else if (getDealerSum() >= 17 && getDealerSum() <= 21) {
				System.out.println("The dealer stayed.");
				dealerTrigger=false;
				
			} else if (getDealerSum() > 21) {
				System.out.println("Dealer busted!");
				System.out.println("You win!!!");
				System.out.println(toStringActual());
				dealerTrigger = false;
			}
			
			return dealerTrigger;
			
		}

		public List<Card> getDealerHand() {
			return dealerHand;
		}

		public void setDealerHand(List<Card> dealerHand) {
			this.dealerHand = dealerHand;
		}

		public int getDealerSum() {
			return dealerSum;
		}

		public void setDealerSum(int dealerSum) {
			this.dealerSum = dealerSum;
		}

		public int getDealerVisableSum() {
			return dealerVisibleSum;
		}

		public void setDealerVisableSum(int dealerVisibleSum) {
			this.dealerVisibleSum = dealerVisibleSum;
		}

		
		public String toStringActual() {
			return "DealerHand: " + dealerHand + ", dealerSum=" + dealerSum + "]";
		}

		@Override
		public String toString() {
			return "DealerHand: Facedown card, " + dealerVisibleHand + ", dealerVisibleSum=" + dealerVisibleSum
					+ "]";
		}


		
		
		

}
