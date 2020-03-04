package com;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PlayGame {

    private static List<String > listOfPlayers;
    private static List<String > listOfPlayers_dummy;

    public static void startGame() {

        listOfPlayers=new CopyOnWriteArrayList<>();
        listOfPlayers_dummy=new CopyOnWriteArrayList<>();
        listOfPlayers.addAll(PlayersImpl.listOfPlayers);
        listOfPlayers_dummy.addAll(listOfPlayers);
        Collections.sort(listOfPlayers,new SortComparator());
        System.out.print("Ready... ");
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("Set... ");
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Go... ");
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Congratulation! Game has been started ");
    }

    public static void printPlayerHoldingCard() {
        int size = listOfPlayers.size();
        if(size == 0)
            System.out.println("Please start the Game first by selecting option 5");
        else {
            System.out.println("Total " + size + " Players are in the game");
            int k = 1;
            for (int i = 0; i < size; i++) {
                System.out.println("Player " + k + " has  " + listOfPlayers_dummy.get(i) + " Card");
                k++;
            }
        }
    }

    public static void winnerOfGame() {
        int size=listOfPlayers.size();
        if(size == 0)
            System.out.println("Please start the Game first by selecting option 5");
        else {
            int index = -1;
            for (int i = 0; i < size; i++) {
                if (listOfPlayers.get(0).equals(listOfPlayers_dummy.get(i))) {
                    index = i + 1;
                    break;
                }
            }
            System.out.println("Winner of the game is Player " + index + " having Card : " + listOfPlayers.get(0));
        }
    }
}



class SortComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String ar[]=o1.split(" ");
        String ar2[]=o2.split(" ");
        //int n = ar[0].compareTo(ar2[0]);
        if(ar[0].equals(ar2[0])){
            if(ar[2].equals("spades"))
                return -1;
            else if(ar2[2].equals("spades"))
                return 1;
            else if(ar[2].equals("heart"))
                return -1;
            else if(ar2[2].equals("heart"))
                return 1;
            else if(ar[2].equals("club"))
                return -1;
            else if(ar2[2].equals("club"))
                return 1;
        }
        else{
            if(ar[0].equals("ace"))
                return -1;
            else if(ar2[0].equals("ace"))
                return 1;
            else if(ar[0].equals("king"))
                return -1;
            else if(ar2[0].equals("king"))
                return 1;
            else if(ar[0].equals("queen"))
                return -1;
            else if(ar2[0].equals("queen"))
                return 1;
            else if(ar[0].equals("jack"))
                return -1;
            else if(ar2[0].equals("jack"))
                return 1;
            else
                return  (Integer.parseInt(ar[0]) > Integer.parseInt(ar2[0])) ? -1:1;

        }
        return -100;
    }
}
