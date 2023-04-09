package org.example.queries;

public class AlterQueries {

    public static String alterOne(String legend, String word, String newLegend, String newWord){
        if(newLegend.equals("")){
            return "UPDATE central " +
                    "SET word='" + newWord + "', number_of_letters='" + newWord.length() + "' " +
                    "WHERE legend='" + legend + "' AND word='" + word + "';";
        }else if(newWord.equals("")){
            return "UPDATE central " +
                    "SET legend='" + newLegend + "' " +
                    "WHERE legend='" + legend + "' AND word='" + word + "';";
        }else{
            return "UPDATE central " +
                    "SET legend='" + newLegend + "', number_of_letters='" + newWord.length() + "', word='" + newWord + "' " +
                    "WHERE legend='" + legend + "' AND word='" + word + "';";
        }
    }
}
