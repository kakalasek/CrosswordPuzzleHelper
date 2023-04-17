package org.example.mainframe;

import org.example.sideframes.add.AddPanel;
import org.example.sideframes.alter.AlterPanel;
import org.example.sideframes.remove.RemovePanel;
import org.example.utilities.DatabaseHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.example.utilities.TextHandler.*;
import static org.example.sideframes.SideFrame.getInstance;
import static org.example.queries.SearchQueries.*;
import static org.example.utilities.InputInspector.*;

public class Panel extends JPanel implements ActionListener {
    DatabaseHandler databaseHandler = new DatabaseHandler("jdbc:postgresql://localhost:5432/crosswordpuzzle_db", "postgres", "postgres");
    JLabel requestLabel;
    JTextField requestField;
    JLabel numOfLettersLabel;
    JTextField numOfLettersField;
    JButton searchButton;
    JLabel editLabel;
    JButton addButton;
    JButton removeButton;
    JButton alterButton;
    ResultPane resultPane;
    JLabel warningLabel;
    public Panel() throws SQLException {
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
        searchButton.addActionListener(this);
        this.add(searchButton);

        editLabel = new JLabel("Alter the database:");
        editLabel.setBounds(50, 300, getTextWidth(editLabel), getTextHeight(editLabel));
        this.add(editLabel);

        addButton = new JButton("Add");
        addButton.setBounds(50, 325, 100, 30);
        addButton.addActionListener(this);
        this.add(addButton);

        removeButton = new JButton("Remove");
        removeButton.setBounds(50,380, 100, 30);
        removeButton.addActionListener(this);
        this.add(removeButton);

        alterButton = new JButton("Alter");
        alterButton.setBounds(50, 435, 100, 30);
        alterButton.addActionListener(this);
        this.add(alterButton);

        resultPane = new ResultPane();
        resultPane.setBounds(500, 0, 500, 700);
        this.add(resultPane);

        warningLabel = new JLabel();
        warningLabel.setForeground(Color.RED);
        warningLabel.setBounds(50, 220, 400, getTextHeight(warningLabel));
        this.add(warningLabel);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent){
        try {
            if (actionEvent.getSource() == addButton) {
                getInstance("Add", new AddPanel());

            } else if (actionEvent.getSource() == removeButton) {
                getInstance("Remove", new RemovePanel());

            } else if (actionEvent.getSource() == alterButton) {
                getInstance("Alter", new AlterPanel());

            } else if (actionEvent.getSource() == searchButton) {
                search();
            }
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    private void search() throws SQLException {
        warningLabel.setText("");

        switch (legendInput(requestField.getText())) {
            case 1:
                warningLabel.setText("Legend is empty!");
                return;
            case 2:
                warningLabel.setText("Invalid Legend text!");
                return;
            case 3:
                warningLabel.setText("Too many characters in Legend!");
                return;
        }
        switch (numOfLettersInput(numOfLettersField.getText())) {
            case 1:
                warningLabel.setText("Number of letters is empty!");
                return;
            case 2:
                warningLabel.setText("Invalid Number of letters!");
                return;
            case 3:
                warningLabel.setText("Too many numbers in Number of letters!");
                return;
        }

        ArrayList<String> queryResults = databaseHandler.executeAndReturn(basicSearch(requestField.getText().toLowerCase(), numOfLettersField.getText().toLowerCase()));

        resultPane.clearLabels();
        for (int i = 0; i < queryResults.size(); i++) {
            resultPane.setLabelText(i, queryResults.get(i));
        }
    }
}
