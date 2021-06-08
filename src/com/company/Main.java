package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter no of Dice ");
        int noOfDice=scanner.nextInt();
        Dice dice=new Dice(noOfDice);

        System.out.println("Enter no of Player");
        int noOf_Player=scanner.nextInt();
        Queue<Player> allPlayer=new LinkedList<>();
        Map<String,Integer> playerCurrentPosition=new HashMap<>();
        for(int i=0;i<noOf_Player;i++)
        {
            Player player=new Player(scanner.next(),scanner.nextInt());
            playerCurrentPosition.put(player.getPlayerName(),0);
            allPlayer.offer(player);
        }

        System.out.println("Enter no of Snake");
        int no_Of_Snake=scanner.nextInt();
        List<Jumper> snakes=new ArrayList<>();
        for(int i=0;i<no_Of_Snake;i++)
        {
            Jumper snake=new Jumper(scanner.nextInt(),scanner.nextInt());
            snakes.add(snake);
        }


        System.out.println("Enter no of Ladder");
        int no_Of_Ladder=scanner.nextInt();
        List<Jumper> ladders=new ArrayList<>();
        for(int i=0;i<no_Of_Ladder;i++)
        {
            Jumper ladder=new Jumper(scanner.nextInt(),scanner.nextInt());
            ladders.add(ladder);
        }





        GameBoard gb=new GameBoard(dice,allPlayer,snakes,ladders,playerCurrentPosition,100);
        gb.startGame();

    }
}
