package org.example.utilities;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseHandler{
    private Connection connection;
    private Statement statement;

    public void execute(String query){
        try {
            statement.execute(query);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<String> executeAndReturn(String query){
        try {
            ArrayList<String> output = new ArrayList<String>();
            ResultSet queryResults = statement.executeQuery(query);

            while(queryResults.next()){
                output.add(queryResults.getString("word"));
            }

            return output;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public DatabaseHandler(String databaseURL, String user, String password){
        try {
            connection = DriverManager.getConnection(databaseURL, user, password);
            statement = connection.createStatement();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}