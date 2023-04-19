package org.example.sideframes;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SideFrame extends JFrame{

    private static SideFrame instance;

    private SideFrame(String title, JPanel panel){
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle(title);
        this.setResizable(false);

        this.add(panel);
        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                instance = null;
            }
        });
    }

    public static SideFrame getInstance(String title, JPanel panel){
        if(instance == null){
            instance = new SideFrame(title, panel);
        }
        return instance;
    }

}
