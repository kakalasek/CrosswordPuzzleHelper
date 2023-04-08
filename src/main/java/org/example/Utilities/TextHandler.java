package org.example.Utilities;

import javax.swing.*;

public class TextHandler {

    public static int getTextHeight(JLabel label){
        return label.getFontMetrics(label.getFont()).getHeight();
    }

    public static int getTextWidth(JLabel label){
        return label.getFontMetrics(label.getFont()).stringWidth(label.getText());
    }
}
