package org.example.sideframes.addframe;

import org.example.sideframes.SidePanel;

import javax.swing.*;
import java.awt.*;

import static org.example.Utilities.TextHandler.*;

public class AddPanel extends SidePanel {
    JLabel explainLabel;
    JLabel legendLabel;
    JTextField legendField;
    JLabel numOfLettersLabel;
    JTextField numOfLettersField;
    JLabel wordLabel;
    JTextField wordField;
    JButton addButton;
    JLabel fileLabel;
    JTextField fileField;
    JButton fileAddButton;

    protected void setUp(){
        explainLabel = new JLabel("Add records by using fields or by using a csv file");
        explainLabel.setBounds(10, 20, getTextWidth(explainLabel), getTextHeight(explainLabel));
        this.add(explainLabel);

        legendLabel = new JLabel("Enter the legend:");
        legendLabel.setBounds(10, 60, getTextWidth(legendLabel), getTextHeight(legendLabel));
        this.add(legendLabel);

        legendField = new JTextField();
        legendField.setBounds(10, 80, 150, 30);
        this.add(legendField);

        numOfLettersLabel = new JLabel("Enter the number of letters:");
        numOfLettersLabel.setBounds(10, 120, getTextWidth(numOfLettersLabel), getTextHeight(numOfLettersLabel));
        this.add(numOfLettersLabel);

        numOfLettersField = new JTextField();
        numOfLettersField.setBounds(10, 140, 50, 30);
        this.add(numOfLettersField);

        wordLabel = new JLabel("Enter the word: ");
        wordLabel.setBounds(10, 180, getTextWidth(wordLabel), getTextHeight(wordLabel));
        this.add(wordLabel);

        wordField = new JTextField();
        wordField.setBounds(10, 200, 150, 30);
        this.add(wordField);

        addButton = new JButton("Add");
        addButton.setBounds(10, 260, 100, 30);
        this.add(addButton);

        fileLabel = new JLabel("Enter a path to a csv file:");
        fileLabel.setBounds(250, 60, getTextWidth(fileLabel), getTextHeight(fileLabel));
        this.add(fileLabel);

        fileField = new JTextField();
        fileField.setBounds(250, 80, 200, 30);
        this.add(fileField);

        fileAddButton = new JButton("Add from file");
        fileAddButton.setBounds(250, 140, 150, 30);
        this.add(fileAddButton);
    }
}
