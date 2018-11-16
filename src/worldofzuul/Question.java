package worldofzuul;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SteamyBlizzard
 */
//Abstract class questions that all questions is instantiated from
public abstract class Question {
    //The question printed
    String question;
    //The answer to the question
    double answer;
    //The two numbers randomly generated
    double number1;
    double number2;
    //A simple class that is returned and contains the question and aswer
    QuestionResults results;
    //Abstract methods for the calculations
    abstract QuestionResults multiplication();
    abstract QuestionResults division();
    abstract QuestionResults addition();
    abstract QuestionResults subtraction();
    //The method that returns a random number. The scope of numbers
    //is different relative to the difficulty
    abstract double getRandomNumber();
    
}
