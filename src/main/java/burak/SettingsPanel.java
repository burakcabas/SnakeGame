// File: SettingsPanel.java
package burak;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SettingsPanel extends JPanel {
    private GameFrame parentFrame;
    private GameSettings gameSettings;
    private JSlider volumeSlider, speedSlider;
    private JCheckBox soundEnabledBox;
    private JButton backButton;

    public SettingsPanel(GameFrame parentFrame, GameSettings gameSettings) {
        this.parentFrame = parentFrame;
        this.gameSettings = gameSettings;
        setupPanel();
        setupComponents();
        setupKeyListener();
    }

    private void setupPanel() {
        setPreferredSize(new Dimension(600, 600));
        setBackground(new Color(20, 20, 30));
        setLayout(new GridBagLayout());
        setFocusable(true);
    }

    private void setupComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);

        // Title
        JLabel titleLabel = new JLabel("SETTINGS");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(Color.GREEN);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        // Sound enabled
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        JLabel soundLabel = new JLabel("Sound Enabled:");
        soundLabel.setForeground(Color.WHITE);
        soundLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(soundLabel, gbc);

        gbc.gridx = 1;
        soundEnabledBox = new JCheckBox();
        soundEnabledBox.setSelected(gameSettings.isSoundEnabled());
        soundEnabledBox.setBackground(new Color(20, 20, 30));
        soundEnabledBox.addActionListener(e -> {
            gameSettings.setSoundEnabled(soundEnabledBox.isSelected());
            parentFrame.getSoundManager().updateSettings();
        });
        add(soundEnabledBox, gbc);

        // Volume
        gbc.gridy = 2;
        gbc.gridx = 0;
        JLabel volumeLabel = new JLabel("Volume:");
        volumeLabel.setForeground(Color.WHITE);
        volumeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(volumeLabel, gbc);

        gbc.gridx = 1;
        volumeSlider = new JSlider(0, 100, (int)(gameSettings.getVolume() * 100));
        volumeSlider.setBackground(new Color(20, 20, 30));
        volumeSlider.setForeground(Color.WHITE);
        volumeSlider.addChangeListener(e -> {
            gameSettings.setVolume(volumeSlider.getValue() / 100.0f);
            parentFrame.getSoundManager().updateSettings();
        });
        add(volumeSlider, gbc);

        // Speed
        gbc.gridy = 3;
        gbc.gridx = 0;
        JLabel speedLabel = new JLabel("Game Speed:");
        speedLabel.setForeground(Color.WHITE);
        speedLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(speedLabel, gbc);

        gbc.gridx = 1;
        speedSlider = new JSlider(1, 10, gameSettings.getGameSpeed());
        speedSlider.setBackground(new Color(20, 20, 30));
        speedSlider.setForeground(Color.WHITE);
        speedSlider.addChangeListener(e -> gameSettings.setGameSpeed(speedSlider.getValue()));
        add(speedSlider, gbc);

        // Back button
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        backButton = new JButton("BACK TO MENU");
        backButton.setPreferredSize(new Dimension(200, 40));
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBackground(Color.GREEN);
        backButton.setForeground(Color.BLACK);
        backButton.setFocusPainted(false);
        backButton.addActionListener(e -> parentFrame.showMenu());
        add(backButton, gbc);
    }

    private void setupKeyListener() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    parentFrame.showMenu();
                }
            }
        });
    }

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }
}