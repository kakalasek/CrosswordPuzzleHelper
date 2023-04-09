package org.example.queries;

public class InsertQueries {

    public static String insertOne(String legend, String numOfWords, String word){
        return "INSERT INTO central VALUES ('" +
                legend + "', '" +
                numOfWords + "', '" +
                word + "');";
    }
}
