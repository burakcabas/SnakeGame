// File: GameSettings.java
package burak;

public class GameSettings {
    private boolean soundEnabled = true;
    private float volume = 0.7f;
    private int gameSpeed = 5;

    public boolean isSoundEnabled() {
        return soundEnabled;
    }

    public void setSoundEnabled(boolean soundEnabled) {
        this.soundEnabled = soundEnabled;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = Math.max(0, Math.min(1, volume));
    }

    public int getGameSpeed() {
        return gameSpeed;
    }

    public void setGameSpeed(int gameSpeed) {
        this.gameSpeed = Math.max(1, Math.min(10, gameSpeed));
    }

    public int getGameDelay() {
        // Convert speed (1-10) to delay (150-50ms)
        return 200 - (gameSpeed * 15);
    }
}