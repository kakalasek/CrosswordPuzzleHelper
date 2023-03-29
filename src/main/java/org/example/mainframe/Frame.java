package org.example.mainframe;

import javax.swing.*;

public class Frame extends JFrame {

    public Frame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("CrosswordPuzzleHelper");
        this.setResizable(false);

        this.add(new Panel());
        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
