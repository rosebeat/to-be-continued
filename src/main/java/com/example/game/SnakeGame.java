package com.example.game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author kai·yang
 * @Date 2023/5/6 14:43
 */
public class SnakeGame extends JFrame {

    private Snake snake;
    private Timer timer;
    private static final int DELAY = 150;

    public SnakeGame() {
        setTitle("贪吃蛇游戏");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        snake = new Snake();
        add(snake);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                snake.processKeyPress(e.getKeyCode());
            }
        });

        pack();
        setLocationRelativeTo(null);

        timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //snake.move();
                snake.update();
                if (snake.checkCollision()) {
                    gameOver();
                }
                repaint();
            }
        });
        timer.start();
    }

    private void gameOver() {
        timer.stop();
        JOptionPane.showMessageDialog(this, "游戏结束", "游戏结束", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SnakeGame().setVisible(true);
            }
        });
    }


}
