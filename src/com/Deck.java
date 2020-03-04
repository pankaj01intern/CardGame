package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

//Singleton pattern Class
//Deck class containing all the 52 Cards

public class Deck {

    private static Deck deck=null;
    private static String[] suit = { "club", "diamonds", "heart", "spades" };
    private static String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace" };

    private static int SUITS = suit.length;
    private static int RANKS = rank.length;
    private static int CARDS = SUITS * RANKS;
    public static CopyOnWriteArrayList<String> cardsOfList=null;

    private static String[] ar = new String[CARDS];

    private Deck(){

    }

    public static Deck getInstance(){
        if(deck == null){
            deck=new Deck();
            for(int i = 0; i < RANKS; i++) {
                for (int j = 0; j < SUITS; j++) {
                    ar[SUITS*i + j] = rank[i] + " of " + suit[j];
                }
            }
            cardsOfList=new CopyOnWriteArrayList(Arrays.asList(ar));
        }


        return deck;
    }


}
