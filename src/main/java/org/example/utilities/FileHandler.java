package org.example.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {

    public static ArrayList<String[]> CSV_to_array(String filePath){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line = "";
            ArrayList<String[]> output = new ArrayList<String[]>();

            while((line = bufferedReader.readLine()) != null){
                output.add(line.split(","));
            }

            return output;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
