package org.example.utilities;

import javax.swing.*;

public class TextHandler {

    /**
     * Calculates the height of text of a JLabel
     * @param label The JLabel of which you want to know the text height
     * @return The height of text of the JLabel
     */
    public static int getTextHeight(JLabel label){
        return label.getFontMetrics(label.getFont()).getHeight();
    }

    /**
     * Calculates the width of text of a JLabel
     * @param label The JLabel of which you want to know the width
     * @return The width of text of the JLabel
     */
    public static int getTextWidth(JLabel label){
        return label.getFontMetrics(label.getFont()).stringWidth(label.getText());
    }

}
