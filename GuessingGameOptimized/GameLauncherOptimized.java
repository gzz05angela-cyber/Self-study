package GuessingGameOptimized;

import java.util.ArrayList;
import java.util.List;

public class GameLauncherOptimized {
    public static void main(String[] args) {
        GuessGameOptimized game = new GuessGameOptimized();
        game.startGame();
    }
}

class PlayerOptimized {
    private String name;
    private int number;
    private boolean isRight;
    
    public PlayerOptimized(String name) {
        this.name = name;
        this.number = 0;
        this.isRight = false;
    }
    
    public void guess() {
        this.number = (int) (Math.random() * 10);
    }
    
    public int getNumber() {
        return number;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean isRight() {
        return isRight;
    }
    
    public void setRight(boolean isRight) {
        this.isRight = isRight;
    }
    
    public void reset() {
        this.isRight = false;
        this.number = 0;
    }
    
    @Override
    public String toString() {
        return name + " guessed " + number;
    }
}

class GuessGameOptimized {
    private static final int MAX_GUESS_RANGE = 10;
    private List<PlayerOptimized> players;
    private int targetNumber;
    
    public GuessGameOptimized() {
        players = new ArrayList<>();
        initializePlayers();
    }
    
    private void initializePlayers() {
        players.add(new PlayerOptimized("Alice"));
        players.add(new PlayerOptimized("Bob"));
        players.add(new PlayerOptimized("Charlie"));
    }
    
    public void startGame() {
        targetNumber = generateRandomNumber();
        System.out.println("I am thinking of a number between 0 and " + (MAX_GUESS_RANGE - 1) + "...");
        
        int round = 1;
        while (true) {
            System.out.println("\n=== Round " + round + " ===");
            System.out.println("Number to guess is " + targetNumber);
            
            // 所有玩家猜数字
            playRound();
            
            // 显示本轮猜测结果
            displayGuesses();
            
            // 检查是否有赢家
            if (hasWinner()) {
                announceWinner();
                break;
            } else {
                System.out.println("No one got it right. Players will have to try again.\n");
                resetPlayersForNextRound();
                round++;
            }
        }
    }
    
    private void playRound() {
        for (PlayerOptimized player : players) {
            player.guess();
        }
    }
    
    private void displayGuesses() {
        for (PlayerOptimized player : players) {
            System.out.println(player);
            if (player.getNumber() == targetNumber) {
                player.setRight(true);
            }
        }
    }
    
    private boolean hasWinner() {
        return players.stream().anyMatch(PlayerOptimized::isRight);
    }
    
    private void announceWinner() {
        System.out.println("\n🎉 We have a winner! 🎉");
        
        for (PlayerOptimized player : players) {
            if (player.isRight()) {
                System.out.println("✓ " + player.getName() + " got it right!");
            } else {
                System.out.println("✗ " + player.getName() + " got it wrong.");
            }
        }
        
        System.out.println("Game is over.");
        System.out.println("The number was " + targetNumber);
    }
    
    private void resetPlayersForNextRound() {
        for (PlayerOptimized player : players) {
            player.reset();
        }
    }
    
    private int generateRandomNumber() {
        return (int) (Math.random() * MAX_GUESS_RANGE);
    }
}