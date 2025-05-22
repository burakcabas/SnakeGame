// File: Snake.java
package burak;

import java.awt.*;
import java.util.ArrayList;

public class Snake {
    private ArrayList<Point> body;
    private Direction direction;
    private int unitSize;
    private boolean shouldGrow;

    public Snake(int unitSize) {
        this.unitSize = unitSize;
        this.body = new ArrayList<>();
        this.direction = Direction.RIGHT;
        this.shouldGrow = false;
        reset();
    }

    public void reset() {
        body.clear();
        body.add(new Point(0, 0));
        direction = Direction.RIGHT;
        shouldGrow = false;
    }

    public void move() {
        Point head = new Point(body.get(0));

        switch (direction) {
            case UP:
                head.y -= unitSize;
                break;
            case DOWN:
                head.y += unitSize;
                break;
            case LEFT:
                head.x -= unitSize;
                break;
            case RIGHT:
                head.x += unitSize;
                break;
        }

        body.add(0, head);

        if (!shouldGrow) {
            body.remove(body.size() - 1);
        } else {
            shouldGrow = false;
        }
    }

    public void grow() {
        shouldGrow = true;
    }

    public void setDirection(Direction newDirection) {
        if (!direction.isOpposite(newDirection)) {
            this.direction = newDirection;
        }
    }

    public boolean checkSelfCollision() {
        Point head = body.get(0);
        for (int i = 1; i < body.size(); i++) {
            if (head.equals(body.get(i))) {
                return true;
            }
        }
        return false;
    }

    public void draw(Graphics g) {
        for (int i = 0; i < body.size(); i++) {
            Point segment = body.get(i);
            if (i == 0) {
                g.setColor(Color.GREEN);
            } else {
                g.setColor(new Color(45, 180, 0));
            }
            g.fillRect(segment.x, segment.y, unitSize, unitSize);
            g.setColor(Color.DARK_GRAY);
            g.drawRect(segment.x, segment.y, unitSize, unitSize);
        }
    }

    public Point getHead() {
        return body.get(0);
    }
}