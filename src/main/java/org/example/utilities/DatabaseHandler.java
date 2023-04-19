package org.example.utilities;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseHandler{
    private Connection connection;
    private Statement statement;

    /**
     * Executes a query that does not return anything
     * @param query The query you wish to execute
     * @throws SQLException If something goes wrong
     */
    public void execute(String query) throws SQLException{
            statement.execute(query);
    }

    /**
     * Executes a query that returns something
     * @param query The query you wish to execute
     * @param column The name of the column from which you want to select
     * @return Returns arraylist of strings, each string represents one returned record
     * @throws SQLException If something goes wrong
     */
    public ArrayList<String> executeAndReturn(String query, String column) throws SQLException{
            ArrayList<String> output = new ArrayList<String>();
            ResultSet queryResults = statement.executeQuery(query);

            while(queryResults.next()){
                output.add(queryResults.getString(column));
            }

            return output;
    }

    public DatabaseHandler(String databaseURL, String user, String password) throws SQLException{
            connection = DriverManager.getConnection(databaseURL, user, password);
            statement = connection.createStatement();
    }
}