package org.example.sideframes;

import org.example.utilities.DatabaseHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static org.example.utilities.InputInspector.*;

public abstract class SidePanel extends JPanel implements ActionListener {
    public SidePanel(){
        this.setPreferredSize(new Dimension(500, 400));
        this.setLayout(null);
        setUp();
    }

    protected abstract void setUp();
    protected DatabaseHandler databaseHandler = new DatabaseHandler("jdbc:postgresql://localhost:5432/crosswordpuzzle_db", "postgres", "postgres");

    protected int setWarnings(String text, JLabel warningLabel, JTextField inputField, int typeOfField){
        int inspection;

        switch(typeOfField){
            case 0: inspection = legendInput(inputField.getText());
                break;
            case 1: inspection = numOfLettersInput(inputField.getText());
                break;
            case 2: inspection = wordInput(inputField.getText());
                break;
            default: inspection = 0;
        }

        switch(inspection){
            case 1: warningLabel.setText(text + " is empty!");
                return 1;
            case 2: warningLabel.setText("Invalid " + text);
                return 2;
            case 3: warningLabel.setText("Too many characters in " + text + "!");
                return 3;
            default:
                return 0;
        }
    }
}
