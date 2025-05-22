// File: SoundManager.java
package burak;

import javax.sound.sampled.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class SoundManager {
    private GameSettings gameSettings;
    private Clip eatSound, gameOverSound;

    public SoundManager(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
        initializeSounds();
    }

    private void initializeSounds() {
        try {
            // Create simple beep sounds programmatically
            eatSound = createBeepSound(800, 100); // High pitch, short duration
            gameOverSound = createBeepSound(300, 500); // Low pitch, longer duration
        } catch (Exception e) {
            System.out.println("Could not initialize sounds: " + e.getMessage());
        }
    }

    private Clip createBeepSound(float frequency, int duration) throws LineUnavailableException, IOException {
        int sampleRate = 44100;
        int samples = (int) (sampleRate * duration / 1000.0);
        byte[] buffer = new byte[samples * 2];

        for (int i = 0; i < samples; i++) {
            double angle = 2.0 * Math.PI * frequency * i / sampleRate;
            short sample = (short) (Math.sin(angle) * 32767 * 0.5);
            buffer[i * 2] = (byte) (sample & 0xFF);
            buffer[i * 2 + 1] = (byte) ((sample >> 8) & 0xFF);
        }

        AudioFormat format = new AudioFormat(sampleRate, 16, 1, true, false);
        AudioInputStream audioInputStream = new AudioInputStream(
                new ByteArrayInputStream(buffer), format, samples);

        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        return clip;
    }

    public void playEatSound() {
        playSound(eatSound);
    }

    public void playGameOverSound() {
        playSound(gameOverSound);
    }

    private void playSound(Clip clip) {
        if (clip != null && gameSettings.isSoundEnabled()) {
            try {
                if (clip.isRunning()) {
                    clip.stop();
                }
                clip.setFramePosition(0);

                // Set volume
                FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                float volume = gameSettings.getVolume();
                float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
                volumeControl.setValue(dB);

                clip.start();
            } catch (Exception e) {
                // Silently handle sound errors
            }
        }
    }

    public void updateSettings() {
        // Settings are applied when sounds are played
    }
}