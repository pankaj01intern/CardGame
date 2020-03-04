package com;

import com.deckexception.CardsNotAvailable;
import com.deckexception.DeckFullException;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class DeckCardsImpl implements DeckCards {

    private List<String> numberOfCardsRemovedFromDeck = new CopyOnWriteArrayList<>();;

    @Override
    public void shuffleDeck(CopyOnWriteArrayList<String> cardsOfList) {
       Collections.shuffle(cardsOfList);
       Deck.cardsOfList=new CopyOnWriteArrayList<>();
       Deck.cardsOfList.addAll(cardsOfList);

    }

    @Override
    public List<String> getCardsFromDeck(int numberOfCards) throws CardsNotAvailable{
        if(Deck.cardsOfList.size() >= numberOfCards){
            for(int i=0;i<numberOfCards;i++)
                numberOfCardsRemovedFromDeck.add(Deck.cardsOfList.remove(0));

            System.out.println("Congratulations! The Players has been added to the game successfully ");
        }
        else{
            try {
                throw new CardsNotAvailable("No more than 52 players are allowed in this game ");
            }catch (CardsNotAvailable ex){
                System.out.println(ex.getMessage());
            }
        }

        return numberOfCardsRemovedFromDeck;
    }

    @Override
    public void returnCardsToDeck(int numberOfCards) throws DeckFullException {
        if(numberOfCardsRemovedFromDeck != null && numberOfCardsRemovedFromDeck.size() >= numberOfCards){
            for(int i=0;i<numberOfCards;i++)
                Deck.cardsOfList.add(numberOfCardsRemovedFromDeck.remove(0));

            System.out.println("Congratulations! The Players has been removed from the game successfully ");
        }
        else{
            try {
                throw new DeckFullException("Players are not available to remove, Please add first ");
            }catch (DeckFullException ex){
                System.out.println(ex.getMessage());
            }
        }

    }

    @Override
    public void printAllCardsFromDeck(List<String> deck) {
        for(int i=0;i<deck.size();i++)
            System.out.println(deck.get(i));

    }
}
