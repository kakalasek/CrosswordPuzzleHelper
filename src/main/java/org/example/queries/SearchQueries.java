package org.example.queries;

public class SearchQueries {

    public static String basicSearch(String legend, String numOfLetters){
        return "SELECT word " +
                "FROM central " +
                "WHERE legend='" + legend + "' AND number_of_letters='" + numOfLetters + "';";
    }
}
