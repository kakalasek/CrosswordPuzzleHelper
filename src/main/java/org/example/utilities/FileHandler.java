package org.example.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.example.utilities.InputInspector.*;

public class FileHandler {

    public static ArrayList<String[]> CSV_to_array(String filePath) throws IOException{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line = "";
            ArrayList<String[]> output = new ArrayList<String[]>();
            String[] temp;

            while((line = bufferedReader.readLine()) != null){
                if((temp = line.split(",")).length == 3 && (legendInput(temp[0]) + numOfLettersInput(temp[1]) + wordInput(temp[2])) == 0){
                        output.add(line.split(","));
                }else{
                    throw new IOException();
                }
            }

            bufferedReader.close();

            return output;
    }
}
