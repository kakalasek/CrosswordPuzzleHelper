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
        int y = 10; //starting Y value

        for(int i = 0; i < resultArray.length; i++){ //sets up the array of JLabels that are used to hold search results
            resultArray[i] = new JLabel();
            resultArray[i].setFont(new Font("Serif", Font.PLAIN, 20));
            resultArray[i].setBounds(10, y, 480, 35);
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