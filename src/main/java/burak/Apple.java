// File: Apple.java
package burak;

import java.awt.*;
import java.util.Random;

public class Apple {
    private Point position;
    private int boardWidth;
    private int boardHeight;
    private int unitSize;
    private Random random;

    public Apple(int boardWidth, int boardHeight, int unitSize) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.unitSize = unitSize;
        this.random = new Random();
        this.position = new Point();
        generateNew();
    }

    public void generateNew() {
        position.x = random.nextInt(boardWidth / unitSize) * unitSize;
        position.y = random.nextInt(boardHeight / unitSize) * unitSize;
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.RED);
        g2d.fillOval(position.x, position.y, unitSize, unitSize);

        g2d.setColor(Color.PINK);
        g2d.fillOval(position.x + 5, position.y + 5, unitSize / 3, unitSize / 3);
    }

    public Point getPosition() {
        return new Point(position);
    }
}