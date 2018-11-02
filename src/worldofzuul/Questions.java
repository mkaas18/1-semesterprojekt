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
public abstract class Questions {
    String question;
    double answer;
    double number1;
    double number2;
    QuestionResults results;
    abstract QuestionResults multiplication();
    abstract QuestionResults division();
    abstract QuestionResults addition();
    abstract QuestionResults subtraction();
    abstract double getRandomNumber();
    
}
