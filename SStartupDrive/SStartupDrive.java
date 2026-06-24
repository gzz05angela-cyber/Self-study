package SStartupDrive;

import java.util.Scanner;

public class SStartupDrive {
    public static void main(String[] args){
        int numOfGuesses = 0;
        GameHelper helper = new GameHelper();
        SimpleStartup theStartup = new SimpleStartup();
        int randomNum = (int)(Math.random()*5);
        int [] locations = {randomNum, randomNum+1, randomNum+2};
        theStartup.setLocationCells(locations);
        boolean isAlive = true;

        while (isAlive){
            int guess = helper.getUserInput("Enter a number");
            String result = theStartup.checkYourself(guess);
            numOfGuesses++;
            if (result.equals("kill")){
                isAlive = false;
                System.out.println("You took" + numOfGuesses + "guesses");
            }
        }
    }
}

class SimpleStartup{
    private int[] locationCells;
    private int numOfHits=0;

    public void setLocationCells(int[] locs){
        locationCells = locs;
    }

    public String checkYourself (int guess){
        String result = "miss";
        for (int cell: locationCells){
            if (guess == cell){
                result = "hit";
                numOfHits++;
                break;
            }
        }
        if (numOfHits == locationCells.length){
            result = "kill";
        }
        System.out.println(result);
        return result;
    }
}

class GameHelper{
    public int getUserInput(String prompt){
        System.out.println(prompt +":");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}