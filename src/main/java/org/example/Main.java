package org.example;

import org.example.mainframe.Frame;
import org.example.sideframes.remove.RemovePanel;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Frame frame = new Frame();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}