package com;

import com.deckexception.CardsNotAvailable;
import com.deckexception.DeckFullException;

import java.util.List;

public interface Players {
    //Add Players to the Game
    void addPlayers(int number,DeckCards deckCards) throws CardsNotAvailable;
    //Remove Players from the Game
    void removePlayers(int number, DeckCards deckCards) throws DeckFullException;
}
