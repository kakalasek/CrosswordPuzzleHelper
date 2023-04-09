package org.example.sideframes;

import org.example.utilities.DatabaseHandler;

import javax.swing.*;
import java.awt.*;

public abstract class SidePanel extends JPanel {
    public SidePanel(){
        this.setPreferredSize(new Dimension(500, 400));
        this.setLayout(null);
        setUp();
    }

    protected abstract void setUp();
    protected DatabaseHandler databaseHandler = new DatabaseHandler("jdbc:postgresql://localhost:5432/crosswordpuzzle_db", "postgres", "postgres");
}
