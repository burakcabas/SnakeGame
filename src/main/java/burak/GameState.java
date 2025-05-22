// File: GameState.java
package burak;

public class GameState {
    private boolean running;
    private int score;

    public GameState() {
        reset();
    }

    public void reset() {
        running = true;
        score = 0;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        score++;
    }
}