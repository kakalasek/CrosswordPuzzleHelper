package org.example.sideframes;

import javax.swing.*;
import java.awt.*;

public abstract class SidePanel extends JPanel {
    public SidePanel(){
        this.setPreferredSize(new Dimension(500, 400));
        this.setLayout(null);
        setUp();
    }

    protected abstract void setUp();
}
