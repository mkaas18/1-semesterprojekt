/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import worldofzuul.interfaces.IFileReader;
import worldofzuul.persistence.FileReader;
/**
 *
 * @author SteamyBlizzard
 */
public class RandomEvent {

    ArrayList<QuestionResults> events = new ArrayList<>();
    IFileReader file;
    Scanner splitter;
    String filePath;

    public RandomEvent() {
        this.file = new FileReader("randomEvent.txt");
    }

    public void createEvents() {
        ArrayList<String> eventStrings = file.readFile();
        for(String eventString : eventStrings){
            String[] eventSplit = eventString.split(";");
            String question = eventSplit[0];
            String correctAnswer = eventSplit[1];
            String answer2 = eventSplit[2];
            String answer3 = eventSplit[3];
            events.add(new QuestionResults(question, correctAnswer, answer2, answer3));
        }  
    }

    public void triggerEvent() {
        ArrayList<String> answerList = new ArrayList<>();
        ArrayList<String> answerCode = new ArrayList<>();
        int random = new Random().nextInt(events.size());
        String question = "";
        events.get(random);
        answerList.add(events.get(random).getCorrectAnswer());
        answerList.add(events.get(random).getWrongAnswer1());
        answerList.add(events.get(random).getWrongAnswer2());
        question += events.get(random).getQuestion();
        for(int i = 0; i < 3; i++){
            int randomAnswer = new Random().nextInt(answerList.size());
            question += "\n" + answerList.get(randomAnswer) + "(" + (i+1) + ")";
            answerCode.add(answerList.get(randomAnswer));
            answerList.remove(randomAnswer);
        }
        splitter = new Scanner(System.in);
        System.out.println(question);
        int answer;
        while(true){
            if(splitter.hasNextInt()){
                answer = splitter.nextInt();
                break;
            } else {
                System.out.println("You need to input a corresponding answer code to answer the question");
                splitter.next();
            }
        }
        if(answerCode.get(answer-1).equals(events.get(random).getCorrectAnswer())){
            System.out.println("You answered correct!");
        } else {
            System.out.println("You answered wrong!");
        }
    }
}
