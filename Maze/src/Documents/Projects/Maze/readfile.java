package Documents.Projects.Maze;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.*;

public class readfile {

    private String path;
//Creating the var for the file path
    public readfile(String file_path){
        path = file_path;
    }
//opens the file and reads the txt and adjusts based on size
    public String[] OpenFile() throws IOException{
        FileReader fr = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fr);

        int numberOfLines = readLines();
        String[] textData = new String[numberOfLines];

        int i;
//keeps going for as many lines as there are, and inputs the file into an array to store
        for (i=0; i < numberOfLines; i++){
            textData[i] = textReader.readLine();
        }

        textReader.close();
        return textData;
    }
// Reads how many lines there are as long as the reading the next line isn't null
    int readLines() throws IOException {

        FileReader file_to_read = new FileReader(path);
        BufferedReader bf = new BufferedReader(file_to_read);

        String aLine;
        int numberOfLines = 0;

        while (( aLine = bf.readLine()) != null) {
            numberOfLines++;
        }
        bf.close();

        return numberOfLines;
    }
}
