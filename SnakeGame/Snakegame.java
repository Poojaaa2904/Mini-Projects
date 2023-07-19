package SnakeGame;

import javax.swing.*;

public class Snakegame extends JFrame {

    Snakegame() {
        super("Snake Game");
        add(new Board());
        pack();

        setLocationRelativeTo(null);
        setResizable(false);
    }

    public static void main(String[] args) {
        new Snakegame().setVisible(true);
    }
}