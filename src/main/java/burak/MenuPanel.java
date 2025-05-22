// File: MenuPanel.java
package burak;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MenuPanel extends JPanel {
    private GameFrame parentFrame;
    private JButton playButton, settingsButton, exitButton;
    private int selectedIndex = 0;
    private JButton[] buttons;

    public MenuPanel(GameFrame parentFrame) {
        this.parentFrame = parentFrame;
        setupPanel();
        setupButtons();
        setupKeyListener();
    }

    private void setupPanel() {
        setPreferredSize(new Dimension(600, 600));
        setBackground(new Color(20, 20, 30));
        setLayout(new GridBagLayout());
        setFocusable(true);
    }

    private void setupButtons() {
        GridBagConstraints gbc = new GridBagConstraints();

        // Title
        JLabel titleLabel = new JLabel("SNAKE GAME");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
        titleLabel.setForeground(Color.GREEN);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 50, 0);
        add(titleLabel, gbc);

        // Buttons
        playButton = createMenuButton("PLAY");
        settingsButton = createMenuButton("SETTINGS");
        exitButton = createMenuButton("EXIT");

        buttons = new JButton[]{playButton, settingsButton, exitButton};

        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.gridy = 1;
        add(playButton, gbc);
        gbc.gridy = 2;
        add(settingsButton, gbc);
        gbc.gridy = 3;
        add(exitButton, gbc);

        // Action listeners
        playButton.addActionListener(e -> parentFrame.showGame());
        settingsButton.addActionListener(e -> parentFrame.showSettings());
        exitButton.addActionListener(e -> System.exit(0));

        updateButtonSelection();
    }

    private JButton createMenuButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(200, 50));
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        return button;
    }

    private void setupKeyListener() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_W:
                        selectedIndex = (selectedIndex - 1 + buttons.length) % buttons.length;
                        updateButtonSelection();
                        break;
                    case KeyEvent.VK_DOWN:
                    case KeyEvent.VK_S:
                        selectedIndex = (selectedIndex + 1) % buttons.length;
                        updateButtonSelection();
                        break;
                    case KeyEvent.VK_ENTER:
                    case KeyEvent.VK_SPACE:
                        buttons[selectedIndex].doClick();
                        break;
                    case KeyEvent.VK_ESCAPE:
                        System.exit(0);
                        break;
                }
            }
        });
    }

    private void updateButtonSelection() {
        for (int i = 0; i < buttons.length; i++) {
            if (i == selectedIndex) {
                buttons[i].setBackground(Color.GREEN);
                buttons[i].setForeground(Color.BLACK);
            } else {
                buttons[i].setBackground(Color.DARK_GRAY);
                buttons[i].setForeground(Color.WHITE);
            }
        }
    }

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }
}