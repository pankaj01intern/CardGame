package com;

import com.deckexception.CardsNotAvailable;
import com.deckexception.DeckFullException;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public interface DeckCards {

    //shuffle the Deck
    void shuffleDeck(CopyOnWriteArrayList<String> list);
    //Get cards from Deck and give to the players
    List<String> getCardsFromDeck(int numberOfCards) throws CardsNotAvailable;
    //Take cards from players and put it to the Deck
    void returnCardsToDeck(int numberOfCards) throws DeckFullException;
    //Print the Remaining Cards from Deck
    void printAllCardsFromDeck(List<String> deck);



}
