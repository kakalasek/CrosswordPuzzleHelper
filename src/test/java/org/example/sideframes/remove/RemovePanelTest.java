package org.example.sideframes.remove;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class RemovePanelTest {
    @Test
    void throwsWarningIfLegendIsBlank(){
        try {
            RemovePanel removePanel = new RemovePanel();
            removePanel.legendField.setText("");
            removePanel.wordField.setText("text");
            removePanel.removeButton.doClick();
            assertEquals("Legend is empty!", removePanel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwsWarningIfWordIsBlank(){
        try {
            RemovePanel removePanel = new RemovePanel();
            removePanel.legendField.setText("text");
            removePanel.wordField.setText("");
            removePanel.removeButton.doClick();
            assertEquals("Word is empty!", removePanel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwsWarningIfLegendIsInvalid(){
        try {
            RemovePanel removePanel = new RemovePanel();
            removePanel.legendField.setText("Invalid4text&");
            removePanel.wordField.setText("text");
            removePanel.removeButton.doClick();
            assertEquals("Invalid Legend!", removePanel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwsWarningIfWordIsInvalid(){
        try {
            RemovePanel removePanel = new RemovePanel();
            removePanel.legendField.setText("text");
            removePanel.wordField.setText("Invalid\twordčšš2");
            removePanel.removeButton.doClick();
            assertEquals("Invalid Word!", removePanel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwsWarningIfLegendIsTooLong(){
        try {
            RemovePanel removePanel = new RemovePanel();
            removePanel.legendField.setText("desetdesetdesetdesetesetdesetdesetdesetdesetdesetdeseřřřčž     tdesetesetdesetdesetdesetdesetdesetdesetdesetesetdesetdesetdesetdesetdesetdesetdesetesetdesetdesetdesetdesetdesetdesetdeDESETDESFRIJFIFNtdesetdesetdesetdesetesetdesetdesetdesetdesetdesetdesetdesetesetdesetdesetdeset");
            removePanel.wordField.setText("text");
            removePanel.removeButton.doClick();
            assertEquals("Legend is too long!", removePanel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void throwsWarningIfWordIsTooLong(){
        try {
            RemovePanel removePanel = new RemovePanel();
            removePanel.legendField.setText("text");
            removePanel.wordField.setText("KFJDJKFJFKDJFdkfjkdjfkdjfkjddfdhfkdHKFHKLFHDLKFHšžýžýščšýKFJDJKFJFKDJFdkfjkdjfkdjfkjddfdhfkdHKFHKLFHDLKFHšžýžýščšýKFJDJKFJFKDJFdkfjkdjfkdjfkjddfdhfkdHKFHKLFHDLKFHšžýžýščšýKFJDJKFJFKDJFdkfjkdjfkdjfkjddfdhfkdHKFHKLFHDLKFHšžýžýščšýKFJDJKFJFKDJFdkfjkdjfkdjfkjddfdhfkdHKFHKLFHDLKFHšžýžýščšý");
            removePanel.removeButton.doClick();
            assertEquals("Word is too long!", removePanel.warningLabel.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}