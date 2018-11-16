package worldofzuul;

import java.util.Random;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fredd
 */
public class QuestionNormal extends Question{
    
    public QuestionNormal(){
        
    }
    //
    @Override
    public QuestionResults addition() {
        //Gets two random numbers
        number1 = getRandomNumber();
        number2 = getRandomNumber();    
        //Sets question to the question
        question = "What is " + number1 + " + " + number2 + "?";
        //Solves the question and sets answer to said questions answer
        answer = number1 + number2;
        //Creates an instance of QuestionResults and returns it with the question and answer
        return results = new QuestionResults(question, answer);
    }
    //Same principle in the othwers except division
    @Override
    public QuestionResults multiplication() {
        number1 = getRandomNumber()/10;
        number2 = getRandomNumber();
        question = "What is " + (int)number1 + " x " + number2 + "?";
        answer = number1 * number2;
        return results = new QuestionResults(question, answer);
    }

    @Override
    public QuestionResults division() {
        while(true){
            number1 = getRandomNumber();
            number2 = getRandomNumber()/10.0;
            //Checks if the two numbers have no rest, so the question can be solved in the head.
            if(number1%number2==0 && number1 != 0 && number2 > 1){
                break;
            }
        } 
        question = "What is " + number1 + " / " + number2 + "?";
        answer = number1 / number2;
        return results = new QuestionResults(question, answer);
    }

    @Override
    public QuestionResults subtraction() {
        number1 = getRandomNumber();
        number2 = getRandomNumber();
        question = "What is " + number1 + " - " + number2 + "?";
        answer = number1 - number2;
        return results = new QuestionResults(question, answer);
    }
    //Returns a random number
    @Override
    public double getRandomNumber() {
        return new Random().nextInt(100)+1;
    }

   
    
}
