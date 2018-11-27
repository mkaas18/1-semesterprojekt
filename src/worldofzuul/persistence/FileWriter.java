package worldofzuul.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
    public String getSavedScore(){
        String test = "";
        for(String string : fileReader.readFile()){
            test += string + "\n";
        }
        return test;
    }
    
    @Override
    public void writeFile(Highscore hs) {
        String input = hs + "\n";
        PrintWriter pw;
        try {
            pw = new PrintWriter(path);
            pw.print(hs);
            pw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("There was an error writing to the file.");
        }
    }
}
