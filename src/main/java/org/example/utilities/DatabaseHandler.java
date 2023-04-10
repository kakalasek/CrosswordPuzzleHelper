package org.example.utilities;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseHandler{
    private Connection connection;
    private Statement statement;

    public void execute(String query) throws SQLException{
            statement.execute(query);
    }

    public ArrayList<String> executeAndReturn(String query) throws SQLException{
            ArrayList<String> output = new ArrayList<String>();
            ResultSet queryResults = statement.executeQuery(query);

            while(queryResults.next()){
                output.add(queryResults.getString("word"));
            }

            return output;
    }

    public DatabaseHandler(String databaseURL, String user, String password) throws SQLException{
            connection = DriverManager.getConnection(databaseURL, user, password);
            statement = connection.createStatement();
    }
}