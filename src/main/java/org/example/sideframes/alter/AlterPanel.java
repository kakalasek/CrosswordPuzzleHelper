package org.example.sideframes.alter;

import org.example.sideframes.SidePanel;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import static org.example.utilities.TextHandler.*;
import static org.example.queries.AlterQueries.*;

public class AlterPanel extends SidePanel{
    JLabel explainLabel;
    JLabel legendLabel_exist;
    JTextField legendField_exist;
    JLabel wordLabel_exist;
    JTextField wordField_exist;
    JLabel legendLabel_new;
    JTextField legendField_new;
    JLabel wordLabel_new;
    JTextField wordField_new;
    JButton alterButton;
    JLabel warningLabel;

    public AlterPanel() throws SQLException {
    }

    protected void setUp(){
        explainLabel = new JLabel("<html>Alter a record by providing the existing and new legend and word.<br>If one of the fields with new values is left blank,<br> that value is not altered.</html");
        explainLabel.setBounds(10, 10, 490, (int) (getTextHeight(explainLabel) * 3.1));
        this.add(explainLabel);

        legendLabel_exist = new JLabel("Enter the existing legend:");
        legendLabel_exist.setBounds(10, 80, getTextWidth(legendLabel_exist), getTextHeight(legendLabel_exist));
        this.add(legendLabel_exist);

        legendField_exist = new JTextField();
        legendField_exist.setBounds(10, 100, 150, 30);
        this.add(legendField_exist);

        wordLabel_exist = new JLabel("Enter the existing word:");
        wordLabel_exist.setBounds(250, 80, getTextWidth(wordLabel_exist), getTextHeight(wordLabel_exist));
        this.add(wordLabel_exist);

        wordField_exist = new JTextField();
        wordField_exist.setBounds(250, 100, 150, 30);
        this.add(wordField_exist);

        legendLabel_new = new JLabel("Enter new legend:");
        legendLabel_new.setBounds(10, 180, getTextWidth(legendLabel_new), getTextHeight(legendLabel_new));
        this.add(legendLabel_new);

        legendField_new = new JTextField();
        legendField_new.setBounds(10, 200, 150, 30);
        this.add(legendField_new);

        wordLabel_new = new JLabel("Enter new word:");
        wordLabel_new.setBounds(250, 180, getTextWidth(wordLabel_new), getTextHeight(wordLabel_new));
        this.add(wordLabel_new);

        wordField_new = new JTextField();
        wordField_new.setBounds(250, 200, 150, 30);
        this.add(wordField_new);

        alterButton = new JButton("Alter");
        alterButton.setBounds(10, 260, 100, 30);
        alterButton.addActionListener(this);
        this.add(alterButton);

        warningLabel = new JLabel();
        warningLabel.setForeground(Color.RED);
        warningLabel.setBounds(10, 310, 450, getTextHeight(warningLabel));
        this.add(warningLabel);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            if (actionEvent.getSource() == alterButton) {
               alter();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    /**
     * Calls a query to alter a record in the database. Uses fields from its AlterPanel. If any of the field's string sets a warning, this method will return without performing the query
     * @throws SQLException If something goes wrong
     */
    private void alter() throws SQLException {
        warningLabel.setText(""); //clears the warning label


        if (setWarnings("Existing legend", warningLabel, legendField_exist, 0) > 0 || setWarnings("Existing word", warningLabel, wordField_exist, 2) > 0 || setWarnings("New legend", warningLabel, legendField_new, 0) > 0 || setWarnings("New word", warningLabel, wordField_new, 2) > 0) { //checks if any field sets a warning
            if(setWarnings("New word", warningLabel, wordField_new, 2) == 1 && setWarnings("New legend", warningLabel, legendField_new, 0) == 1){ //checks if both new legend and new word are empty and if so, sets a special warning
                warningLabel.setText("Both New legend and New word are empty!");
                return;
            }else if(setWarnings("New word", warningLabel, wordField_new, 2) == 0 && setWarnings("New legend", warningLabel, legendField_new, 0) == 1){ //

            }else if(setWarnings("New word", warningLabel, wordField_new, 2) == 1 && setWarnings("New legend", warningLabel, legendField_new, 0) == 0){

            }else{
                return;
            }
        }

        databaseHandler.execute(alterOne(legendField_exist.getText().toLowerCase(), wordField_exist.getText().toLowerCase(), legendField_new.getText().toLowerCase(), wordField_new.getText().toLowerCase()));
    }
}
