package com.example.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author kai·yang
 * @Date 2023/5/6 14:46
 */
public class Snake extends JPanel {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private static final int UNIT_SIZE = 20;
    private static final int INITIAL_LENGTH = 3;

    private int[] x;
    private int[] y;
    private int length;
    private int direction;
    private boolean isMoving;

    private int foodX;
    private int foodY;
    private boolean hasFood;

    public Snake() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.black);
        setFocusable(true);

        x = new int[WIDTH * HEIGHT];
        y = new int[WIDTH * HEIGHT];
        length = INITIAL_LENGTH;
        direction = KeyEvent.VK_RIGHT;
        isMoving = false;
        hasFood = false;
        generateFood();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                processKeyPress(e.getKeyCode());
            }
        });

        initializeSnake();
    }

    private void initializeSnake() {
        for (int i = 0; i < length; i++) {
            x[i] = (WIDTH / 2) - (i * UNIT_SIZE);
            y[i] = HEIGHT / 2;
        }
    }

    public void processKeyPress(int keyCode) {
        if (keyCode == KeyEvent.VK_UP && direction != KeyEvent.VK_DOWN) {
            direction = KeyEvent.VK_UP;
        } else if (keyCode == KeyEvent.VK_DOWN && direction != KeyEvent.VK_UP) {
            direction = KeyEvent.VK_DOWN;
        } else if (keyCode == KeyEvent.VK_LEFT && direction != KeyEvent.VK_RIGHT) {
            direction = KeyEvent.VK_LEFT;
        } else if (keyCode == KeyEvent.VK_RIGHT && direction != KeyEvent.VK_LEFT) {
            direction = KeyEvent.VK_RIGHT;
        }
        isMoving = true;
    }

    public void move() {
        if (isMoving) {
            for (int i = length - 1; i > 0; i--) {
                x[i] = x[i - 1];
                y[i] = y[i - 1];
            }

            if (direction == KeyEvent.VK_UP) {
                y[0] -= UNIT_SIZE;
            } else if (direction == KeyEvent.VK_DOWN) {
                y[0] += UNIT_SIZE;
            } else if (direction == KeyEvent.VK_LEFT) {
                x[0] -= UNIT_SIZE;
            } else if (direction == KeyEvent.VK_RIGHT) {
                x[0] += UNIT_SIZE;
            }
        }
    }

    public boolean checkCollision() {
        for (int i = length - 1; i > 0; i--) {
            if (x[0] == x[i] && y[0] == y[i]) {
                return true;
            }
        }
        if (x[0] < 0 || x[0] >= WIDTH || y[0] < 0 || y[0] >= HEIGHT) {
            return true;
        }
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawSnake(g);
        drawFood(g);
    }

    private void drawSnake(Graphics g) {
        g.setColor(Color.green);
        for (int i = 0; i < length; i++) {
            g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
        }
    }


    private void generateFood() {
        int maxX = WIDTH / UNIT_SIZE;
        int maxY = HEIGHT / UNIT_SIZE;

        foodX = (int) (Math.random() * maxX) * UNIT_SIZE;
        foodY = (int) (Math.random() * maxY) * UNIT_SIZE;

        hasFood = true;
    }

    private void checkFoodCollision() {
        if (x[0] == foodX && y[0] == foodY) {
            length++;
            hasFood = false;
            generateFood();
        }
    }


    private void drawFood(Graphics g) {
        if (hasFood) {
            g.setColor(Color.red);
            g.fillRect(foodX, foodY, UNIT_SIZE, UNIT_SIZE);
        }
    }

    public void update() {
        move();
        checkFoodCollision();
        checkCollision();
        repaint();
    }

}
