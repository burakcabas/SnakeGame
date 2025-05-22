// File: GamePanel.java
package burak;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {
    private static final int BOARD_WIDTH = 600;
    private static final int BOARD_HEIGHT = 600;
    private static final int UNIT_SIZE = 25;

    private Snake snake;
    private Apple apple;
    private GameState gameState;
    private Timer timer;
    private InputHandler inputHandler;
    private GameFrame parentFrame;
    private SoundManager soundManager;
    private GameSettings gameSettings;

    public GamePanel(GameFrame parentFrame, SoundManager soundManager, GameSettings gameSettings) {
        this.parentFrame = parentFrame;
        this.soundManager = soundManager;
        this.gameSettings = gameSettings;

        this.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);

        initializeGame();
        this.addKeyListener(inputHandler);
    }

    private void initializeGame() {
        snake = new Snake(UNIT_SIZE);
        apple = new Apple(BOARD_WIDTH, BOARD_HEIGHT, UNIT_SIZE);
        gameState = new GameState();
        inputHandler = new InputHandler(snake, gameState, this, parentFrame);
    }

    public void startNewGame() {
        snake.reset();
        apple.generateNew();
        gameState.reset();

        if (timer != null) {
            timer.stop();
        }
        timer = new Timer(gameSettings.getGameDelay(), this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        if (gameState.isRunning()) {
            apple.draw(g);
            snake.draw(g);
            drawScore(g);
        } else {
            drawGameOver(g);
        }
    }

    private void drawScore(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        FontMetrics metrics = getFontMetrics(g.getFont());
        String scoreText = "Score: " + gameState.getScore();
        g.drawString(scoreText, (BOARD_WIDTH - metrics.stringWidth(scoreText)) / 2, g.getFont().getSize());
    }

    private void drawGameOver(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Final Score
        g2d.setColor(Color.RED);
        g2d.setFont(new Font("Arial", Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g2d.getFont());
        String scoreText = "Final Score: " + gameState.getScore();
        g2d.drawString(scoreText, (BOARD_WIDTH - metrics1.stringWidth(scoreText)) / 2, BOARD_HEIGHT / 2 - 50);

        // Game Over text
        g2d.setFont(new Font("Arial", Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g2d.getFont());
        g2d.drawString("Game Over", (BOARD_WIDTH - metrics2.stringWidth("Game Over")) / 2, BOARD_HEIGHT / 2);

        // Instructions
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        FontMetrics metrics3 = getFontMetrics(g2d.getFont());
        String restartText = "Press SPACE to restart | ESC for menu";
        g2d.drawString(restartText, (BOARD_WIDTH - metrics3.stringWidth(restartText)) / 2, BOARD_HEIGHT / 2 + 100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameState.isRunning()) {
            snake.move();
            checkAppleCollision();
            checkCollisions();
        }
        repaint();
    }

    private void checkAppleCollision() {
        if (snake.getHead().equals(apple.getPosition())) {
            gameState.incrementScore();
            snake.grow();
            apple.generateNew();
            soundManager.playEatSound();
        }
    }

    private void checkCollisions() {
        Point head = snake.getHead();

        // Check wall collisions
        if (head.x < 0 || head.x >= BOARD_WIDTH || head.y < 0 || head.y >= BOARD_HEIGHT) {
            gameOver();
        }

        // Check self collision
        if (snake.checkSelfCollision()) {
            gameOver();
        }
    }

    private void gameOver() {
        gameState.setRunning(false);
        if (timer != null) {
            timer.stop();
        }
        soundManager.playGameOverSound();
    }

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }
}