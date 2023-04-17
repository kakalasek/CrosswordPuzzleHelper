package org.example.utilities;

public class InputInspector {

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
