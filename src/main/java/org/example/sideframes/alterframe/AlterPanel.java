package org.example.sideframes.alterframe;

import org.example.sideframes.SidePanel;

import javax.swing.*;

import static org.example.Utilities.TextHandler.*;

public class AlterPanel extends SidePanel {
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
        this.add(alterButton);
    }
}
