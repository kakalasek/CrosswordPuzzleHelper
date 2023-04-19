package org.example.utilities;

public class InputInspector {

    /**
     * Checks if a string meets the requirements to be a legend
     * @param input The string which you want to inspect
     * @return returns "1" if the string is blank, "2" if the string is in the wrong format, "3" if the string is too long. Otherwise, returns "0"
     */
    public static int legendInput(String input) {
        if (input.equals("")) {
            return 1;
        }else if(!input.matches("[A-Za-zěščřžýáíéňťúůóďĚŠČŘŽÝÁÍÉŮÚĎŤÓŇ\\s]+") || input.contains("\t") || input.contains("\n")){
            return 2;
        }else if(input.length() > 99){
            return 3;
        }

        return 0;
    }

    /**
     * Checks if a string meets the requirements to be a number of letters
     * @param input The string which you want to inspect
     * @return returns "1" if the string is blank, "2" if the string is in the wrong format, "3" if the string is too long. Otherwise, returns "0"
     */
    public static int numOfLettersInput(String input){
        if (input.equals("")) {
            return 1;
        }else if(!input.matches("\\d+") || (Integer.parseInt(input) < 1)){
            return 2;
        }else if(input.length() > 2){
            return 3;
        }
        return 0;
    }

    /**
     * Checks if a string meets the requirements to be a word
     * @param input The string which you want to inspect
     * @return returns "1" if the string is blank, "2" if the string is in the wrong format, "3" if the string is too long. Otherwise, returns "0"
     */
    public static int wordInput(String input){
        if (input.equals("")) {
            return 1;
        }else if(!input.matches("[A-Za-zěščřžýáíéňťúůóďĚŠČŘŽÝÁÍÉŮÚĎŤÓŇ]+")){
            return 2;
        }else if(input.length() > 99){
            return 3;
        }

        return 0;
    }
}
