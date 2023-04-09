package org.example.sideframes.add;

import org.example.sideframes.SidePanel;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static org.example.utilities.TextHandler.*;
import static org.example.queries.InsertQueries.*;
import static org.example.utilities.FileHandler.*;

public class AddPanel extends SidePanel implements ActionListener {
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
        addButton.addActionListener(this);
        this.add(addButton);

        fileLabel = new JLabel("Enter a path to a csv file:");
        fileLabel.setBounds(250, 60, getTextWidth(fileLabel), getTextHeight(fileLabel));
        this.add(fileLabel);

        fileField = new JTextField();
        fileField.setBounds(250, 80, 200, 30);
        this.add(fileField);

        fileAddButton = new JButton("Add from file");
        fileAddButton.setBounds(250, 140, 150, 30);
        fileAddButton.addActionListener(this);
        this.add(fileAddButton);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == addButton){
            databaseHandler.execute(insertOne(legendField.getText(), numOfLettersField.getText(), wordField.getText()));
        }else if(actionEvent.getSource() == fileAddButton){
            ArrayList<String[]> valueSet = CSV_to_array(fileField.getText());
            for(String[] values : valueSet){
                databaseHandler.execute(insertOne(values[0], values[1], values[2]));
            }
        }
    }
}