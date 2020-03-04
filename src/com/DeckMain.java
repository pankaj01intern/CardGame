package com;

import com.deckexception.CardsNotAvailable;
import com.deckexception.DeckFullException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

//Main Class

public class DeckMain {
    public static void main(String[] args) throws IOException, CardsNotAvailable, DeckFullException, InterruptedException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        Deck deck=Deck.getInstance();
        DeckCardsImpl deckCards = new DeckCardsImpl();
        PlayersImpl players = new PlayersImpl();
        PlayGame playGame = new PlayGame();

        while(true) {
            System.out.println("Which step do you want to perform, Please Enter the step...");
            System.out.println("1. Add Players ");
            System.out.println("2. Remove Players ");
            System.out.println("3. Shuffle the Deck ");
            System.out.println("4. Print all the cards present in the deck ");
            System.out.println("5. Start the game ");
            System.out.println("6. Print the card each player is holding ");
            System.out.println("7. Find the Winner of the game ");
            System.out.println("8. Finish the Game ");
            int option = Integer.parseInt(br.readLine());
            switch (option) {
                //Add Players
                //Each Players will have 1 Card Only
                case 1:
                    System.out.println("How many Players do you want to add, Please enter the number of player ");
                    int number = Integer.parseInt(br.readLine());
                    players.addPlayers(number,deckCards);
                    break;

                //Remove Players
                case 2:
                    System.out.println("How many Players do you want to remove, Please enter the number of player ");
                    int numberToRemove = Integer.parseInt(br.readLine());
                    players.removePlayers(numberToRemove,deckCards);
                    break;

                //Shuffle the Deck
                case 3:
                    System.out.println("Shuffling Done!");
                    deckCards.shuffleDeck(Deck.cardsOfList);
                    System.out.println("Current Deck size is "+Deck.cardsOfList.size());
                    break;

                //Print all remaining cards from Deck
                case 4:
                    deckCards.printAllCardsFromDeck(Deck.cardsOfList);
                    break;

                //Start the Game
                case 5:
                    if(PlayersImpl.listOfPlayers.size() > 1)
                        playGame.startGame();
                    else
                        System.out.println("No Players found in the game. Please add the players first by selecting option 1 ");
                    break;

                //Print the each Players holding card
                case 6:
                    PlayGame.printPlayerHoldingCard();
                    break;

                //Find the Winner of the Game
                case 7:
                    PlayGame.winnerOfGame();
                    break;

                //Finish the Game
                case 8:
                    int size=52-Deck.cardsOfList.size();
                    players.removePlayers(size,deckCards);
                    System.out.println("Thank you for the Playing. All the Cards has been added to the Deck successfully and the current Deck size is "+
                            Deck.cardsOfList.size());
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please enter valid option to perform the step");

            }

            System.out.println();
        }

    }
}
