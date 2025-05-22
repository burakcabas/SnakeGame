// File: GameFrame.java
package burak;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private MenuPanel menuPanel;
    private GamePanel gamePanel;
    private SettingsPanel settingsPanel;
    private SoundManager soundManager;
    private GameSettings gameSettings;

    public GameFrame() {
        gameSettings = new GameSettings();
        soundManager = new SoundManager(gameSettings);

        initializeComponents();
        setupFrame();
    }

    private void initializeComponents() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        menuPanel = new MenuPanel(this);
        gamePanel = new GamePanel(this, soundManager, gameSettings);
        settingsPanel = new SettingsPanel(this, gameSettings);

        mainPanel.add(menuPanel, "MENU");
        mainPanel.add(gamePanel, "GAME");
        mainPanel.add(settingsPanel, "SETTINGS");
    }

    private void setupFrame() {
        this.add(mainPanel);
        this.setTitle("Enhanced Snake Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        showMenu();
    }

    public void showMenu() {
        cardLayout.show(mainPanel, "MENU");
        menuPanel.requestFocus();
    }

    public void showGame() {
        cardLayout.show(mainPanel, "GAME");
        gamePanel.requestFocus();
        gamePanel.startNewGame();
    }

    public void showSettings() {
        cardLayout.show(mainPanel, "SETTINGS");
        settingsPanel.requestFocus();
    }

    public SoundManager getSoundManager() {
        return soundManager;
    }
}