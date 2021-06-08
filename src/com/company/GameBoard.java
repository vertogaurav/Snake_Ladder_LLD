package com.company;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GameBoard {
    private Dice dice;
    private Queue<Player> nextTurn;
    private List<Jumper> snake;
    private List<Jumper> ladder;
    private Map<String, Integer> playercurrentPosition;
    int boardSize;

    public GameBoard(Dice dice, Queue<Player> nextTurn, List<Jumper> snake, List<Jumper> ladder, Map<String, Integer> playercurrentPosition, int boardSize) {
        this.dice = dice;
        this.nextTurn = nextTurn;
        this.snake = snake;
        this.ladder = ladder;
        this.playercurrentPosition = playercurrentPosition;
        this.boardSize = boardSize;
    }

    public void startGame() {
        while (nextTurn.size() > 1) {
            Player player = nextTurn.poll();
            System.out.println("Roll the dice -> " + player.getPlayerName());
            int currentPosition = playercurrentPosition.get(player.getPlayerName());

            int dicevalue = dice.rollDice();
            int nextcell = currentPosition + dicevalue;
            System.out.println(dicevalue);

            if (nextcell == 100) {
                System.out.println(player.getPlayerName() + " WIN");
            } else if (nextcell > 100) {
                nextTurn.offer(player);
            } else {
                int[] nextposition = new int[1];
                boolean[] b = new boolean[1];

                nextposition[0] = nextcell;
                snake.forEach(v -> {
                    if (v.startPoint == nextcell) {
                        nextposition[0] = v.endPoint;
                    }
                });
                if (nextposition[0] != nextcell) {
                    System.out.println(player.getPlayerName() + " Bitten BY Snake");
                }

                ladder.forEach(v -> {
                    if (v.startPoint == nextcell) {
                        nextposition[0] = v.endPoint;
                        b[0] = true;
                    }
                });
                if (nextcell != nextposition[0] && b[0]) {
                    System.out.println(player.getPlayerName() + "Climb Ladder");
                }
                if (nextposition[0] == boardSize)
                    System.out.println(player.getPlayerName() + "WON");

                else {
                    playercurrentPosition.put(player.getPlayerName(), nextposition[0]);
                    System.out.println(player.getPlayerName() + " is at position " + nextposition[0]);
                    nextTurn.offer(player);
                }
            }
        }
    }
}
