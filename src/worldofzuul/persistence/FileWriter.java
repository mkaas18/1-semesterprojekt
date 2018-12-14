package worldofzuul.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import worldofzuul.interfaces.IFileWriter;
import worldofzuul.logic.Highscore;

public class FileWriter implements IFileWriter {

    File file;
    String path;
    String[] strings;
    FileReader fileReader = new FileReader(path);

    public FileWriter(String path) {
        this.path = path;
    }

    public String getSavedScore() {
        String test = "";
        for (String string : fileReader.readFile()) {
            test += string + "\n";
        }
        return test;
    }

    @Override
    public void writeFile(String input) {
        PrintWriter pw;
        try {
            pw = new PrintWriter(path);
            pw.println(input);
            pw.println("TEST");
            pw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("There was an error writing to the file.");
        }
    }

    
    @Override
    public void writeFile(ArrayList<String> highscoreList) {
        PrintWriter pw;
        try {
            pw = new PrintWriter(path);
            for (String output : highscoreList) {
                pw.println(output);
            }
            pw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("There was an error writing to the file.");
        }
    }
}
