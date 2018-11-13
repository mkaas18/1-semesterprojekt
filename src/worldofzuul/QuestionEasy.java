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
public class QuestionEasy extends Question{
    public QuestionEasy(){}

    @Override
    public QuestionResults addition() {
        number1 = getRandomNumber();
        number2 = getRandomNumber();
        question = "What is " + number1 + " + " + number2 + "?";
        answer = number1 + number2;
        return results = new QuestionResults(question, answer);
    }

    @Override
    public QuestionResults multiplication() {
        number1 = getRandomNumber();
        number2 = getRandomNumber();
        question = "What is " + number1 + " x " + number2 + "?";
        answer = number1 * number2;
        return results = new QuestionResults(question, answer);
    }

    @Override
    public QuestionResults division() {
        while(true){
            number1 = getRandomNumber();
            number2 = getRandomNumber();
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

    @Override
    public double getRandomNumber() {
        return new Random().nextInt(10)+1;
    }


    

   
    
}
