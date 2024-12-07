package com.svi.warcard;
import java.util.ArrayList;

public class PlayerCard {
	private String cardvalue;
    private int person;
    private int rank;

    //public PlayerCard(int person, int rank) {
    public PlayerCard(String cardvalue, int rank) {
    	this.cardvalue = cardvalue;
        //this.person = person;
        this.rank = rank;
    }

    public int getPerson() {return person;}
    public String getCardvalue() {return cardvalue;}
    public int getRank() {return rank;}

    public void setPerson(int person) {this.person = person;}
    public void setCardvalue(String cardvalue) {this.cardvalue = cardvalue;}
    public void setRank(int rank) {this.rank = rank;}

    @Override
    //public String toString() {return "Person: " + person + ", Rank: " + rank;}
    public String toString() {return "Card: " + cardvalue + ", Rank: " + rank;}
}
