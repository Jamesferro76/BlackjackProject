package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand{
	
	public void BlackjackHand(){
		
	}
	
	@Override
	public int getHandValue() {
		int sum=0;
		
		for (Card card : hand) {
			sum +=card.getValue();
		}
		return sum;
	}
	
	public boolean isBlackjack() {
		if(getHandValue()==21&&hand.size()==2) {
			return true;
		}
		return false;
	}
	
	public boolean isBust() {
		
		if(getHandValue()>21) {
			return true;
		}
			return false;
	}

	@Override
	public String toString() {
		return "[Hand=" + hand + " sum: "+ getHandValue() + "]";
	}
	

}
