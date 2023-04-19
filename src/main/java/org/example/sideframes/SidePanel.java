package org.example.sideframes;

import org.example.utilities.DatabaseHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static org.example.utilities.InputInspector.*;

public abstract class SidePanel extends JPanel implements ActionListener {
    public SidePanel() throws SQLException {
        this.setPreferredSize(new Dimension(500, 400));
        this.setLayout(null);
        setUp();
    }

    protected abstract void setUp();
    protected DatabaseHandler databaseHandler = new DatabaseHandler("jdbc:postgresql://localhost:5432/crosswordpuzzle_db", "postgres", "postgres");

    /**
     * Sets the warning label if a string doesn't pass the inspection. String for this method is acquired from a JTextField
     * @param text The text on your warning
     * @param warningLabel The label on which the warning should be set on
     * @param inputField The field which contains the inspected string
     * @param typeOfField Accepts values from 0-2. "0" is for legend, "1" is for numberOfLetters, "2" is for word"
     * @return "1" if the field is empty, "2" if the string in the field doesn't meet the desired requirements, "3" if the string in the field is too long. Returns "0" if string in the field is alright
     * @throws IllegalArgumentException If somehow an unexpected number got into the typeOfField parameter
     */
    protected int setWarnings(String text, JLabel warningLabel, JTextField inputField, int typeOfField){
        if(typeOfField > 2) { //checks if there is not an invalid number for the type of field
            throw new IllegalArgumentException("Type of field not found");
        }
        int inspection;

        switch(typeOfField){ //depending on the type of the field, the according inspection is chosen and carried out
            case 0: inspection = legendInput(inputField.getText());
                break;
            case 1: inspection = numOfLettersInput(inputField.getText());
                break;
            case 2: inspection = wordInput(inputField.getText());
                break;
            default: inspection = 0;
        }

        switch(inspection){ //according to results of the previous inspection, either the warning text is set and an error code (matching the return value of the inspection) is returned or no warning is set and "0" is returned
            case 1: warningLabel.setText(text + " is empty!");
                return 1;
            case 2: warningLabel.setText("Invalid " + text + "!");
                return 2;
            case 3: warningLabel.setText(text + " is too long!");
                return 3;
            default:
                return 0;
        }
    }
}
