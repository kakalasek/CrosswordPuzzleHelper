package org.example.mainframe;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    JLabel requestLabel;
    JTextField request;
    JLabel numOfLettersLabel;
    JTextField numOfLetters;
    public Panel(){
        this.setPreferredSize(new Dimension(1000, 700));
        setUp();
    }

    private void setUp(){
        requestLabel = new JLabel("Enter your request:");
        request = new JTextField();

        numOfLettersLabel = new JLabel("Enter the number of letters:");
        numOfLetters = new JTextField();
    }
}
