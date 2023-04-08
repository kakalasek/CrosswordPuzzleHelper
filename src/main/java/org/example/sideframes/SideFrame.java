package org.example.sideframes;

import org.example.sideframes.removeframe.RemovePanel;

import javax.swing.*;

public abstract class SideFrame extends JFrame{
    public SideFrame(String title, JPanel panel){
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle(title);
        this.setResizable(false);

        this.add(panel);
        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
