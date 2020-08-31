package com.company;

import javax.swing.*;
import java.awt.*;

public class GameForm extends JFrame {

    private JPanel mainPanel;
    private JPanel leftSidePanel;
    private JPanel rightSidePanel;
    private JButton[][] leftSideButtons = new JButton[10][10];
    private JButton[][] rightSideButtons = new JButton[10][10];

    public GameForm(String title) throws HeadlessException {
        super(title);
        this.setResizable(false);
        this.setSize(1000, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void start() {
        this.setVisible(true);
        initGame();
    }

    private void initGame() {
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0,0, 1000, 500);



        leftSidePanel = new JPanel();
        rightSidePanel = new JPanel();

        leftSidePanel.setLayout(null);
        rightSidePanel.setLayout(null);

        leftSidePanel.setBackground(Color.GRAY);
        rightSidePanel.setBackground(Color.LIGHT_GRAY);

        leftSidePanel.setBounds(0,0,500, 500);
        rightSidePanel.setBounds(500,0, 500, 500);

        createButtonsForPanel(leftSidePanel, Color.BLUE, leftSideButtons);
        createButtonsForPanel(rightSidePanel, Color.RED, rightSideButtons);

        mainPanel.add(leftSidePanel);
        mainPanel.add(rightSidePanel);

        this.setContentPane(mainPanel);

        redrawFields();
    }

    private void createButtonsForPanel(JPanel panel, Color color, JButton[][] buttons) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                JButton btn = new JButton();
                btn.setBounds(x, y, 50, 50);
                btn.setBackground(color);

                panel.add(btn);
                buttons[i][j] = btn;

                x += 50;
            }

            y += 50;
            x = 0;
        }
    }

    private void redrawFields() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                leftSideButtons[i][j].setBackground(Color.GREEN);
            }
        }
    }
}
