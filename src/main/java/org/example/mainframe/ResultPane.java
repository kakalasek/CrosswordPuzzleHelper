package org.example.mainframe;

import javax.swing.*;
import java.awt.*;

public class ResultPane extends JPanel {
    private JLabel[] resultArray = new JLabel[12];

    public ResultPane(){
        this.setLayout(null);
        setUp();
    }

    private void setUp() {
        int y = 10;

        for(int i = 0; i < resultArray.length; i++){
            resultArray[i] = new JLabel();
            resultArray[i].setBounds(10, y, 480, 30);
            this.add(resultArray[i]);

            y += 50;
        }
    }

    public void setLabelText(int index, String text){
        resultArray[index].setText(text);
    }

    public void clearLabels(){
        for(int i = 0; i < resultArray.length; i++){
            resultArray[i].setText("");
        }
    }
}