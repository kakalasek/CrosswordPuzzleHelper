package org.example.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.example.utilities.InputInspector.*;

public class FileHandler {

    /**
     * Makes an arraylist of arrays of strings out of a CSV file with a specific format
     * @param filePath Path to the CSV file
     * @return Returns an arraylist of arrays of strings, each with three elements
     * @throws IOException If either the filepath is invalid or the CSV file doesn't meet the format
     */
    public static ArrayList<String[]> CSV_to_array(String filePath) throws IOException{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line = "";
            ArrayList<String[]> output = new ArrayList<String[]>();
            String[] temp;

            while((line = bufferedReader.readLine()) != null){ //Initializes string "line" and checks if it's not null
                if((temp = line.split(",")).length == 3 && (legendInput(temp[0]) + numOfLettersInput(temp[1]) + wordInput(temp[2])) == 0){ //Checks if the file has the right format
                        output.add(line.split(",")); //splits the line with commas and add to the output list
                }else{
                    bufferedReader.close();
                    throw new IOException(); //Returns an exception if the file is not in the right format
                }
            }

            bufferedReader.close();

            return output;
    }
}
