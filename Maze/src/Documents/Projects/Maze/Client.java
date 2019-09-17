package Documents.Projects.Maze;

import java.util.*;
import java.io.*;

public class Client {

    public static void main(String[] args) throws IOException {
        Maze labyrinth = new Maze();

        String file_name = "C:\\Users\\Connor'\\Documents\\maze.txt";

        try {
            readfile file = new readfile(file_name);
            String[] aryLines = file.OpenFile();

            int i;
            for (i=0; i < aryLines.length; i++){
                System.out.println(aryLines[i]);
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println (labyrinth); //Shows the maze in the terminal

        if (labyrinth.traverse ())
            System.out.println ("The maze was successfully traversed!");
        else
            System.out.println ("There is no possible path.");

        System.out.println (labyrinth);
    }
}
