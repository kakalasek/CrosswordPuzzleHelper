package org.example.sideframes.add;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class AddPanelTest {

    @Test
    void throwsWarningIfLegendIsBlank(){
        try {
            AddPanel addPanel = new AddPanel();
            addPanel.legendField.setText("");
            addPanel.wordField.setText("text");
            addPanel.numOfLettersField.setText("1");
            addPanel.addButton.doClick();
            assertEquals("Legend is empty!", addPanel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwsWarningIfNumOfLettersIsBlank(){
        try {
            AddPanel addPanel = new AddPanel();
            addPanel.legendField.setText("text");
            addPanel.wordField.setText("text");
            addPanel.numOfLettersField.setText("");
            addPanel.addButton.doClick();
            assertEquals("Number of letters is empty!", addPanel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwsWarningIfWordIsBlank(){
        try {
            AddPanel addPanel = new AddPanel();
            addPanel.legendField.setText("text");
            addPanel.wordField.setText("");
            addPanel.numOfLettersField.setText("1");
            addPanel.addButton.doClick();
            assertEquals("Word is empty!", addPanel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwsWarningIfLegendIsTooLong(){
        try {
            AddPanel addPanel = new AddPanel();
            addPanel.legendField.setText("longlegendlonglegendlonglegendlonglegendlonglFHHHHHHHHHHHHHIEČČÁŠÝČÍÉÉÝĚÍŠÝÉoŠŠČČŘŘŠ  ngl  eg endlonglegendlonglegendlonglegendlonglegendlonglegendlonglegendlonglegendlonglegendlonglegendlonglegendlonglegendlonglegendlonglegend");
            addPanel.wordField.setText("text");
            addPanel.numOfLettersField.setText("1");
            addPanel.addButton.doClick();
            assertEquals("Legend is too long!", addPanel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwsWarningIfNumOfLettersIsTooLong(){
        try {
            AddPanel addPanel = new AddPanel();
            addPanel.legendField.setText("text");
            addPanel.wordField.setText("text");
            addPanel.numOfLettersField.setText("125");
            addPanel.addButton.doClick();
            assertEquals("Number of letters is too long!", addPanel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwsWarningIfWordIsTooLong(){
        try {
            AddPanel addPanel = new AddPanel();
            addPanel.legendField.setText("text");
            addPanel.wordField.setText("longlegendlonglegendlonglegendlonglegendlonglFHHHHHHHHHHHHHIEČČÁŠÝČÍÉÉÝĚÍŠÝÉoŠŠČČŘŘŠwORDDDDDDooojriendlonglegendlonglegendlonglegendlonglegendlonglegendlonglegendlonglegendlonglegendlonglegendlonglegendlonglegendlonglegendlonglegend");
            addPanel.numOfLettersField.setText("1");
            addPanel.addButton.doClick();
            assertEquals("Word is too long!", addPanel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwsWarningIfLegendIsInvalid(){
        try {
            AddPanel addPanel = new AddPanel();
            addPanel.legendField.setText("Hi 3 there\t");
            addPanel.wordField.setText("text");
            addPanel.numOfLettersField.setText("1");
            addPanel.addButton.doClick();
            assertEquals("Invalid Legend!", addPanel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwsWarningIfNumOfLettersIsInvalid(){
        try {
            AddPanel addPanel = new AddPanel();
            addPanel.legendField.setText("text");
            addPanel.wordField.setText("text");
            addPanel.numOfLettersField.setText("a3");
            addPanel.addButton.doClick();
            assertEquals("Invalid Number of letters!", addPanel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwsWarningIfWordIsInvalid(){
        try {
            AddPanel addPanel = new AddPanel();
            addPanel.legendField.setText("text");
            addPanel.wordField.setText("I am invalid4");
            addPanel.numOfLettersField.setText("1");
            addPanel.addButton.doClick();
            assertEquals("Invalid Word!", addPanel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwsWarningIfFilepathIsInvalid(){
        try {
            AddPanel addPanel = new AddPanel();
            addPanel.fileField.setText("IAmAnInvalidPath");
            addPanel.fileAddButton.doClick();
            assertEquals("Invalid file path or file!", addPanel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwsWarningIfFileIsInvalid(){
        try {
            AddPanel addPanel = new AddPanel();
            addPanel.fileField.setText("src/test/java/org/example/utilities/InvalidCSV");
            addPanel.fileAddButton.doClick();
            assertEquals("Invalid file path or file!", addPanel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}