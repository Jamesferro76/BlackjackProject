package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class DealerHand {
	
	private List<Card> dealerHand= new ArrayList<>();
	private List<Card> dealerVisibleHand= new ArrayList<>();
	private int dealerSum;
	private int dealerVisibleSum;
	private Card card1;
	
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
