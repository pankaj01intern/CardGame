package com;

import com.deckexception.CardsNotAvailable;
import com.deckexception.DeckFullException;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PlayersImpl implements Players {

    public static List<String> listOfPlayers=new CopyOnWriteArrayList<>();
    @Override
    public void addPlayers(int number,DeckCards deckCards) throws CardsNotAvailable {
        listOfPlayers =deckCards.getCardsFromDeck(number);
    }

    @Override
    public void removePlayers(int numberToRemove, DeckCards deckCards) throws DeckFullException {
        deckCards.returnCardsToDeck(numberToRemove);
    }

}
