package org.example.sideframes.add;

import org.example.sideframes.SidePanel;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.example.utilities.TextHandler.*;
import static org.example.queries.InsertQueries.*;
import static org.example.utilities.FileHandler.*;
import static org.example.utilities.InputInspector.*;

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
    JLabel warningLabel;

    public AddPanel() throws SQLException {
    }

    protected void setUp() {
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

        warningLabel = new JLabel();
        warningLabel.setForeground(Color.RED);
        warningLabel.setBounds(10, 310, 450, getTextHeight(warningLabel));
        this.add(warningLabel);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            if (actionEvent.getSource() == addButton) {
                add();

            } else if (actionEvent.getSource() == fileAddButton) {
                addFromFile();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }catch (IOException e){
            warningLabel.setText("Invalid file path or file!");
        }
    }

    private void add() throws SQLException {
        warningLabel.setText("");

        if (setWarnings("Legend", warningLabel, legendField, 0) > 0) {
            return;
        } else if (setWarnings("Number of letters", warningLabel, numOfLettersField, 1) > 0) {
            return;
        } else if (setWarnings("Word", warningLabel, wordField, 2) > 0) {
            return;
        }

        databaseHandler.execute(insertOne(legendField.getText().toLowerCase(), numOfLettersField.getText().toLowerCase(), wordField.getText().toLowerCase()));
    }

    private void addFromFile() throws SQLException, IOException {
        warningLabel.setText("");

        ArrayList<String[]> valueSet = CSV_to_array(fileField.getText().toLowerCase());
        for (String[] values : valueSet) {
            databaseHandler.execute(insertOne(values[0].toLowerCase(), values[1].toLowerCase(), values[2].toLowerCase()));
        }
    }
}