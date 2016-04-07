package net.greenrivertech.bdizzle.learningnumbers;

import java.util.Random;

public class NumbersModel {

    //Fields
    private int leftNumber;
    private int rightNumber;

    private int totalGames;
    private int wins;

    //Constructor
    public NumbersModel(){
        totalGames = 0;
        wins = 0;
        generateNumbers();
    }

    public int getLeftNumber() {
        return leftNumber;
    }

    public int getRightNumber() {
        return rightNumber;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public int getWins() {
        return wins;
    }

    public void generateNumbers(){
        Random rand = new Random();
        leftNumber = rand.nextInt(10);
        rightNumber = rand.nextInt(10);
    }

    public boolean play(String choice){
        totalGames++;
        boolean bigger = choice.equals("left") ? leftNumber >= rightNumber : rightNumber >= leftNumber;

        if(bigger){
            wins++;
        }

        return bigger;
    }

}
