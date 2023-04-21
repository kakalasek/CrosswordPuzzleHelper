package org.example.queries;

public class SearchQueries {

    public static String basicSearch(String legend, String numOfLetters, String select){
        return "SELECT " + select + " " +
                "FROM central " +
                "WHERE legend LIKE '%" + legend + "%' AND number_of_letters='" + numOfLetters + "' ";
    }
}
