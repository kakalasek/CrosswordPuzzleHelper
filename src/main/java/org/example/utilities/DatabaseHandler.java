package org.example.utilities;

import java.sql.*;

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

    public ResultSet executeAndReturn(String query){
        try {
            return statement.executeQuery(query);
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