/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import worldofzuul.interfaces.IFileReader;

/**
 *
 * @author SteamyBlizzard
 */
public class FileReader implements IFileReader {

    File file;
    String path;
    String[] strings;

    public FileReader(String path) {
        this.path = path;
    }

    @Override
    public ArrayList<String> readFile() {
        ArrayList<String> result = new ArrayList<>();
        try {
            File f = new File(path);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                result.add(s.nextLine());
            }
            s.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Nothing found. Returning empty result.");
        }
        return result;
    }

}
