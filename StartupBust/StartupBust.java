package StartupBust;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class StartupBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<Startup> startups = new ArrayList<Startup>();
    private int numOfGuesses = 0;
    private static final int GRID_SIZE = 7;

    private void setUpGame(){
        Startup one = new Startup();
        one.setName("A");
        Startup two = new Startup();
        two.setName("B");
        Startup three = new Startup();
        three.setName("C");
        startups.add(one);
        startups.add(two);
        startups.add(three);

        System.out.println("Your goal is to sink three Startups on a " + GRID_SIZE + "x" + GRID_SIZE + " grid.");
        System.out.println("A,B,C");
        System.out.println("try to sink them all in the fewest number of guesses");

        for (Startup startup: startups){
            ArrayList<String> newLocation = helper.placeStartup(3, GRID_SIZE);
            startup.setLocationCells(newLocation);
        }
    }

    private void startPlaying(){
        while(!startups.isEmpty()){
            String userGuess = helper.getUserInput("Enter a guess");
            if (isValidGuess(userGuess)){
                checkUserGuess(userGuess);
            } else {
                System.out.println("Invalid guess.");
            }
        }
        finishGame();
    }

    private boolean isValidGuess(String guess){
        if (guess == null || guess.length()<2 || guess.length()>3){
            return false;
        }

        guess = guess.toUpperCase();
        char col = guess.charAt(0);
        String rowStr = guess.substring(1);

        if (col < 'A' || col > 'G'){
            return false;
        }

        try{
            int row = Integer.parseInt(rowStr);
            return row>= 1 && row<=7;
        } catch (NumberFormatException e){
            return false;
        }
    }

    private void checkUserGuess(String userGuess){
        numOfGuesses++;
        String result = "miss";

        for (int i = 0; i<startups.size();i++){
            Startup startup = startups.get(i);
            result = startup.checkYourself(userGuess);
            if (result.equals("hit")){
                break;
            }
            if (result.equals("kill")){
                startups.remove(startup);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame(){
        System.out.println("all startups are dead! your stock is now worthless");
        if (numOfGuesses <= 18){
            System.out.println("it only took you"+numOfGuesses+"guesses");
            System.out.println("you got out before your options sank.");
        } else {
            System.out.println("Took you long enough." +numOfGuesses+"guesses");
            System.out.println("Fish are dancing with your options.");
        }
    }

    public static void main (String[] args){
        StartupBust game = new StartupBust();
        game.setUpGame();
        game.startPlaying();
    }
}

class GameHelper{
    private static final int GRID_SIZE = 7;
    private Random random = new Random();
    private ArrayList<String> usedLocations = new ArrayList<String>();

    public String getUserInput(String prompt){
        System.out.println(prompt +":");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public ArrayList<String> placeStartup(int size, int gridSize){
        // simple placement: create sequential cell names like 1,2,3 ... as strings
        ArrayList<String> cells = new ArrayList<String>();
        int maxAttempts = 100;

        while (maxAttempts>0 && cells.size()<size){
            maxAttempts--;
            cells.clear();

            int col = random.nextInt(gridSize);
            int row = random.nextInt(gridSize);

            int direction = random.nextInt(2);

            ArrayList<String> potentialCells = new ArrayList<String>();
            boolean valid = true;

            for (int i=0; i<size; i++){
                int newCol = col;
                int newRow = row;

                if (direction == 0){
                    newCol = col+i;
                } else {
                    newRow = row +i;
                }

                if (newCol>= gridSize||newRow>= gridSize){
                    valid = false;
                    break;
                }

                String cell = convertToCoordinate(newCol, newRow);

                if (usedLocations.contains(cell)){
                    valid = false;
                    break;
                }

                potentialCells.add(cell);
            }

            if (valid){
                cells.addAll(potentialCells);
                usedLocations.addAll(cells);
            }
        }

        if (cells.isEmpty()){
            cells = fallbackPlacement(size);
        }

        return cells;
    }

    private String convertToCoordinate(int col, int row){
        char colLetter = (char)('A'+ col);
        return colLetter + Integer.toString(row+1);
    }

    private ArrayList<String> fallbackPlacement(int size){
        ArrayList< String> cells = new ArrayList<String>();
        for (int row = 0; row < GRID_SIZE; row ++){
            for (int col = 0; col < GRID_SIZE - size +1; col++){
                String cell = convertToCoordinate(col,row);
                if (!usedLocations.contains(cell)){
                    boolean available = true;
                    ArrayList<String> tempCells = new ArrayList<String>();
                    for (int i = 0; i< size;i++){
                        String checkCell = convertToCoordinate(col+i,row);
                        if (usedLocations.contains(checkCell)){
                            available = false;
                            break;
                        }
                        tempCells.add(checkCell);
                    }
                    if (available){
                        cells.addAll(tempCells);
                        usedLocations.addAll(cells);
                        return cells;
                    }
                }
            }
        }
        return cells;
    }
}

class Startup{
    private ArrayList<String> locationCells;
    private String name;
    
    public void setLocationCells(ArrayList<String> loc){
        locationCells = loc;
    }
     
    public void setName(String n){
        name = n;
    }

    public String getName(){
        return name;
    }

    public String checkYourself(String userInput){
        String result = "miss";
        int index = locationCells.indexOf(userInput);
        if (index >= 0){
            locationCells.remove(index);
            if (locationCells.isEmpty()){
                result = "kill";
                System.out.println("Ouch! You sunk"+name+":<");
            } else {
                result = "hit";
            }
        }
        return result;
    }
}