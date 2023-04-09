package org.example.sideframes.remove;

import org.example.sideframes.SidePanel;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.utilities.TextHandler.*;
import static org.example.queries.RemoveQueries.*;

public class RemovePanel extends SidePanel implements ActionListener {
    JLabel explainLabel;
    JLabel legendLabel;
    JTextField legendField;
    JLabel wordLabel;
    JTextField wordField;
    JButton removeButton;

    protected void setUp(){
        explainLabel = new JLabel("Remove a record by providing its legend and word");
        explainLabel.setBounds(10, 10, getTextWidth(explainLabel), getTextHeight(explainLabel));
        this.add(explainLabel);

        legendLabel = new JLabel("Enter the legend:");
        legendLabel.setBounds(10, 50, getTextWidth(legendLabel), getTextHeight(legendLabel));
        this.add(legendLabel);

        legendField = new JTextField();
        legendField.setBounds(10, 70, 150, 30);
        this.add(legendField);

        wordLabel = new JLabel("Enter the word");
        wordLabel.setBounds(250, 50, getTextWidth(wordLabel), getTextHeight(wordLabel));
        this.add(wordLabel);

        wordField = new JTextField();
        wordField.setBounds(250, 70, 150, 30);
        this.add(wordField);

        removeButton = new JButton("Remove");
        removeButton.setBounds(10, 120, 100,  30);
        removeButton.addActionListener(this);
        this.add(removeButton);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == removeButton){
            databaseHandler.execute(removeOne(legendField.getText(), wordField.getText()));
        }
    }
}
