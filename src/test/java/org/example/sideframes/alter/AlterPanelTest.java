package org.example.sideframes.alter;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class AlterPanelTest {

    @Test
    void throwsWarningIfExistingLegendIsBlank(){
            try {
                AlterPanel alterPanel = new AlterPanel();
                alterPanel.legendField_exist.setText("");
                alterPanel.wordField_exist.setText("text");
                alterPanel.legendField_new.setText("text");
                alterPanel.wordField_new.setText("text");
                alterPanel.alterButton.doClick();
                assertEquals("Existing legend is empty!", alterPanel.warningLabel.getText());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }

    @Test
    void throwsWarningIfExistingLegendIsInvalid(){
        try {
            AlterPanel alterPanel = new AlterPanel();
            alterPanel.legendField_exist.setText("there\t34^l");
            alterPanel.wordField_exist.setText("text");
            alterPanel.legendField_new.setText("text");
            alterPanel.wordField_new.setText("text");
            alterPanel.alterButton.doClick();
            assertEquals("Invalid Existing legend!", alterPanel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwsWarningIfExistingLegendIsTooLong(){
        try {
            AlterPanel alterPanel = new AlterPanel();
            alterPanel.legendField_exist.setText("longwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongwordlongword");
            alterPanel.wordField_exist.setText("text");
            alterPanel.legendField_new.setText("text");
            alterPanel.wordField_new.setText("text");
            alterPanel.alterButton.doClick();
            assertEquals("Existing legend is too long!", alterPanel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwsWarningIfExistingWordIsBlank(){
        try {
            AlterPanel alterPanel = new AlterPanel();
            alterPanel.legendField_exist.setText("text");
            alterPanel.wordField_exist.setText("");
            alterPanel.legendField_new.setText("text");
            alterPanel.wordField_new.setText("text");
            alterPanel.alterButton.doClick();
            assertEquals("Existing word is empty!", alterPanel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwsWarningIfExistingWordIsInvalid(){
        try {
            AlterPanel alterPanel = new AlterPanel();
            alterPanel.legendField_exist.setText("text");
            alterPanel.wordField_exist.setText("te xt");
            alterPanel.legendField_new.setText("text");
            alterPanel.wordField_new.setText("text");
            alterPanel.alterButton.doClick();
            assertEquals("Invalid Existing word!", alterPanel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwsWarningIfExistingWordIsTooLong(){
        try {
            AlterPanel alterPanel = new AlterPanel();
            alterPanel.legendField_exist.setText("text");
            alterPanel.wordField_exist.setText("texttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttext");
            alterPanel.legendField_new.setText("text");
            alterPanel.wordField_new.setText("text");
            alterPanel.alterButton.doClick();
            assertEquals("Existing word is too long!", alterPanel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwsWarningIfBothNewLegendAndNewWordAreBlank(){
        try {
            AlterPanel alterPanel = new AlterPanel();
            alterPanel.legendField_exist.setText("text");
            alterPanel.wordField_exist.setText("text");
            alterPanel.legendField_new.setText("");
            alterPanel.wordField_new.setText("");
            alterPanel.alterButton.doClick();
            assertEquals("Both New legend and New word are empty!", alterPanel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwsWarningIfNewLegendIsInvalid(){
        try {
            AlterPanel alterPanel = new AlterPanel();
            alterPanel.legendField_exist.setText("text");
            alterPanel.wordField_exist.setText("text");
            alterPanel.legendField_new.setText("te\txt");
            alterPanel.wordField_new.setText("text");
            alterPanel.alterButton.doClick();
            assertEquals("Invalid New legend!", alterPanel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwsWarningIfNewLegendIsTooLong(){
        try {
            AlterPanel alterPanel = new AlterPanel();
            alterPanel.legendField_exist.setText("text");
            alterPanel.wordField_exist.setText("text");
            alterPanel.legendField_new.setText("texttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttext");
            alterPanel.wordField_new.setText("text");
            alterPanel.alterButton.doClick();
            assertEquals("New legend is too long!", alterPanel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwsWarningIfNewWordIsInvalid(){
        try {
            AlterPanel alterPanel = new AlterPanel();
            alterPanel.legendField_exist.setText("text");
            alterPanel.wordField_exist.setText("text");
            alterPanel.legendField_new.setText("text");
            alterPanel.wordField_new.setText("Hi there 4394l'");
            alterPanel.alterButton.doClick();
            assertEquals("Invalid New word!", alterPanel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwsWarningIfNewWordIsTooLong(){
        try {
            AlterPanel alterPanel = new AlterPanel();
            alterPanel.legendField_exist.setText("text");
            alterPanel.wordField_exist.setText("text");
            alterPanel.legendField_new.setText("text");
            alterPanel.wordField_new.setText("texttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttext");
            alterPanel.alterButton.doClick();
            assertEquals("New word is too long!", alterPanel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}