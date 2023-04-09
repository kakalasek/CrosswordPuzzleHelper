package org.example.mainframe;

import org.example.sideframes.add.AddPanel;
import org.example.sideframes.alter.AlterPanel;
import org.example.sideframes.remove.RemovePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.utilities.TextHandler.*;
import static org.example.sideframes.SideFrame.getInstance;

public class Panel extends JPanel implements ActionListener {
    JLabel requestLabel;
    JTextField requestField;
    JLabel numOfLettersLabel;
    JTextField numOfLettersField;
    JButton searchButton;
    JLabel editLabel;
    JButton addButton;
    JButton removeButton;
    JButton alterButton;
    public Panel(){
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
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent){
        if(actionEvent.getSource() == addButton) {
            getInstance("Add", new AddPanel());
        }else if(actionEvent.getSource() == removeButton){
            getInstance("Remove", new RemovePanel());
        }else if(actionEvent.getSource() == alterButton){
            getInstance("Alter", new AlterPanel());
        }
    }
}
