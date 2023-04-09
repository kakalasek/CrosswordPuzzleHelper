package org.example.queries;

public class RemoveQueries {

    public static String removeOne(String legend, String word){
        return "DELETE FROM central " +
                "WHERE legend='" + legend + "' AND word ='" + word + "';";
    }
}
