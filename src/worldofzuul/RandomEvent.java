/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author SteamyBlizzard
 */
//This class handles the random events that can occur when going around in the game
public class RandomEvent {

    ArrayList<QuestionResults> events = new ArrayList<>();
    Scanner splitter;
    String filePath;
    //The constructor sets the filePath of the document in which the events is stored.
    public RandomEvent() {
        this.filePath = "randomEvent.csv";
    }
    //THis method pulls the text from the document on the filepath and creates the events.
    public void createEvents() {
        
        try {
            //The events is in four parts. Question, correctAnswer, answer1 and answer2
            //to get them from a string and be able to split them up, a CSV file is used, with a delimiter at ;
            splitter = new Scanner(new File(filePath)).useDelimiter(";"); 

        } catch (FileNotFoundException ex) {
            System.out.println("File not found");;
        }
        //This while loop sets each string to its corresponding value in the CSV file and adds an instans of
        //a QuestResults using the random events constructor.
        while(splitter.hasNext()){
            String question = splitter.next();
            String correctAnswer = splitter.next();
            String answer2 = splitter.next();
            String answer3 = splitter.next();
            events.add(new QuestionResults(question, correctAnswer, answer2, answer3));
        }
    }
    //This method handles the event
    public void triggerEvent() {
        //This ArrayList contains all the answers 
        ArrayList<String> answerList = new ArrayList<>();
        //This ArrayList is used to scramble the output of answer possibilities when the event is triggered
        ArrayList<String> answerCode = new ArrayList<>();
        //This random int is used to get a random event from the events ArrayList
        int random = new Random().nextInt(events.size());
        String question = "";
        events.get(random);
        //Adds the answers to the answerList ArrayList
        answerList.add(events.get(random).getCorrectAnswer());
        answerList.add(events.get(random).getWrongAnswer1());
        answerList.add(events.get(random).getWrongAnswer2());
        question += events.get(random).getQuestion();
        //This for loop prints out the answer possibilities randomly
        for(int i = 0; i < 3; i++){
            //This random instance always gets a random number, but within the index bounds of the answerList ArrayList
            int randomAnswer = new Random().nextInt(answerList.size());
            //The answer posibility is added to the output string and added a index number used for picking the answer.
            question += "\n" + answerList.get(randomAnswer) + "(" + (i+1) + ")";
            //The random answer picked from answerList is added to answerCode and then removed from answerList.
            answerCode.add(answerList.get(randomAnswer));
            answerList.remove(randomAnswer);
        }
        //The splitter scanner is changed to take user input
        splitter = new Scanner(System.in);
        System.out.println(question);
        int answer;
        //While loop to check that the input is an integer
        while(true){
            if(splitter.hasNextInt()){
                answer = splitter.nextInt();
                break;
            } else {
                System.out.println("You need to input a corresponding answer code to answer the question");
                splitter.next();
            }
        }
        //Checks if the index -1, as lists indexes start from 0 and not 1, and if its a match, you win
        if(answerCode.get(answer-1).equals(events.get(random).getCorrectAnswer())){
            System.out.println("You answered correct!");
        } else {
            System.out.println("You answered wrong!");
        }
    }
}
