package org.example.mainframe;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class PanelTest {

    @Test
    void throwsWarningIfRequestIsBlank(){
        try {
            Panel panel = new Panel();
            panel.requestField.setText("");
            panel.numOfLettersField.setText("1");
            panel.searchButton.doClick();
            assertEquals("Request is empty!", panel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwsWarningIRequestIsInvalid(){
        try {
            Panel panel = new Panel();
            panel.requestField.setText("Hello3t h $ere\t");
            panel.numOfLettersField.setText("1");
            panel.searchButton.doClick();
            assertEquals("Invalid Request!", panel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwsWarningIfRequestIsTooLong(){
        try {
            Panel panel = new Panel();
            panel.requestField.setText("longTextlongTextlongTextlongTextlongTextlongTextlongTextlongTextlongTextlongTextlongTextlongTextlongTextlongTextlongTextlongTextlongTextlongTextlongTextlongTextlongTextlongTextlongTextlongTextlongText");
            panel.numOfLettersField.setText("1");
            panel.searchButton.doClick();
            assertEquals("Request is too long!", panel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwsWarningIfNumOfLettersIsBlank(){
        try {
            Panel panel = new Panel();
            panel.requestField.setText("text");
            panel.numOfLettersField.setText("");
            panel.searchButton.doClick();
            assertEquals("Number of letters is empty!", panel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwsWarningIfNumOfLettersIsInvalid(){
        try {
            Panel panel = new Panel();
            panel.requestField.setText("text");
            panel.numOfLettersField.setText("3a445");
            panel.searchButton.doClick();
            assertEquals("Invalid Number of letters!", panel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwsWarningIfNumOfLettersIsTooLong(){
        try {
            Panel panel = new Panel();
            panel.requestField.setText("text");
            panel.numOfLettersField.setText("123");
            panel.searchButton.doClick();
            assertEquals("Number of letters is too long!", panel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}