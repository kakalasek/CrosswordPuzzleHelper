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

    /**
     * Calls a query to search in the database for desired record. Uses fields from its Panel. If any of the field's string sets a warning, the method returns with no query performed
     * @throws SQLException If something goes wrong
     */
    private void search() throws SQLException {
        warningLabel.setText(""); //clears the warning label

        switch (legendInput(requestField.getText())) { //checks if the legend doesn't set any warnings
            case 1:
                warningLabel.setText("Request is empty!");
                return;
            case 2:
                warningLabel.setText("Invalid Request!");
                return;
            case 3:
                warningLabel.setText("Request is too long!");
                return;
        }
        switch (numOfLettersInput(numOfLettersField.getText())) { //checks if the number of letters doesn't set any warnings
            case 1:
                warningLabel.setText("Number of letters is empty!");
                return;
            case 2:
                warningLabel.setText("Invalid Number of letters!");
                return;
            case 3:
                warningLabel.setText("Number of letters is too long!");
                return;
        }

        ArrayList<String> queryResultsWord = databaseHandler.executeAndReturn(basicSearch(requestField.getText().toLowerCase(), numOfLettersField.getText().toLowerCase(), "word"), "word");
        ArrayList<String> queryResultsLegend = databaseHandler.executeAndReturn(basicSearch(requestField.getText().toLowerCase(), numOfLettersField.getText().toLowerCase(), "legend"), "legend");

        resultPane.clearLabels(); //clears labels before every new search result
        for (int i = 0; i < queryResultsWord.size(); i++) {
            resultPane.setLabelText(i, queryResultsLegend.get(i) + ": " + queryResultsWord.get(i));
        }
    }
}
