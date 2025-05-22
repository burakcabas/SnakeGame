// File: InputHandler.java
package burak;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter {
    private Snake snake;
    private GameState gameState;
    private GamePanel gamePanel;
    private GameFrame parentFrame;

    public InputHandler(Snake snake, GameState gameState, GamePanel gamePanel, GameFrame parentFrame) {
        this.snake = snake;
        this.gameState = gameState;
        this.gamePanel = gamePanel;
        this.parentFrame = parentFrame;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                if (gameState.isRunning()) {
                    snake.setDirection(Direction.LEFT);
                }
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                if (gameState.isRunning()) {
                    snake.setDirection(Direction.RIGHT);
                }
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                if (gameState.isRunning()) {
                    snake.setDirection(Direction.UP);
                }
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                if (gameState.isRunning()) {
                    snake.setDirection(Direction.DOWN);
                }
                break;
            case KeyEvent.VK_SPACE:
                if (!gameState.isRunning()) {
                    gamePanel.startNewGame();
                }
                break;
            case KeyEvent.VK_ESCAPE:
                parentFrame.showMenu();
                break;
        }
    }
}