package org.example.mainframe;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    JLabel requestLabel;
    JTextField requestField;
    JLabel numOfLettersLabel;
    JTextField numOfLettersField;
    JButton searchButton;
    public Panel(){
        this.setPreferredSize(new Dimension(1000, 700));
        this.setLayout(null);
        setUp();
    }

    private void setUp(){

        requestLabel = new JLabel("Enter your request:");
        requestLabel.setBounds(50, 25, getTextWidth(requestLabel), getTextHeight(requestLabel));
        this.add(requestLabel);

        requestField = new JTextField();
        requestField.setBounds(50, 50, 250, 30);
        this.add(requestField);

        numOfLettersLabel = new JLabel("Enter the number of letters:");
        numOfLettersLabel.setBounds(50, 100, getTextWidth(numOfLettersLabel), getTextHeight(numOfLettersLabel));
        this.add(numOfLettersLabel);

        numOfLettersField = new JTextField();
        numOfLettersField.setBounds(50 + getTextWidth(numOfLettersLabel), 125, 50, 30);
        this.add(numOfLettersField);

        searchButton = new JButton("Search");
        searchButton.setBounds(50, 175, 100, 30);
        searchButton.setFont(searchButton.getFont().deriveFont(Font.BOLD));
        this.add(searchButton);
    }

    private int getTextHeight(JLabel label){
        return label.getFontMetrics(label.getFont()).getHeight();
    }
    private int getTextWidth(JLabel label){
        return label.getFontMetrics(label.getFont()).stringWidth(label.getText());
    }
}
