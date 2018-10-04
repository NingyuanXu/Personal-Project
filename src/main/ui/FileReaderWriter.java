package main.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReaderWriter {



    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("inputfile.txt"));
        PrintWriter writer = new PrintWriter("outputfile.txt","UTF-8");
        lines.add("Webwork4 Math200 2018.10.5,11:59pm Webwork 3");
        for (String line : lines) {
            ArrayList<String> partsOfLine = splitOnSpace(line);
            System.out.println("Content: " + partsOfLine.get(0) + " ");
            System.out.println("Course: " + partsOfLine.get(1) + " ");
            System.out.println("Date: " + partsOfLine.get(2) + " ");
            System.out.println("Type: " + partsOfLine.get(3) + " ");
            System.out.println("Timeneeded: " + partsOfLine.get(4));
            writer.println(line);
        }
        writer.close();
    }


    public static ArrayList<String> splitOnSpace(String line){
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }
}

